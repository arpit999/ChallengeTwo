package com.example.challengetwo.verification

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.delete
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challengetwo.R
import com.example.challengetwo.components.VerticalPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationScreen(onNavigateUp: () -> Unit, modifier: Modifier = Modifier) {

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Create your password",
                textAlign = TextAlign.Center
            )
        }, navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Back"
                )
            }
        })
    }) { innerPadding ->

        Column(modifier = modifier.padding(innerPadding)) {
            Text(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 20.dp),
                text = "For a more secure and convenient way to view your account, create a 4-digit passcode now.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )

            OTPInput()
        }
    }

}

@Composable
fun OTPInput() {
    val otpState = rememberTextFieldState()

    Column {
        VerticalPadding(10)

        BasicTextField(
            state = otpState,
            modifier = Modifier
                .semantics { contentType = ContentType.SmsOtpCode }
                .widthIn(max = 600.dp),
            inputTransformation = InputTransformation.maxLength(4),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            lineLimits = TextFieldLineLimits.SingleLine,
            decorator = {
                val otpText = otpState.text.toString()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    repeat(4) { index ->
                        Digit(
                            char = otpText.getOrElse(index) { '0' },
                            highlights = index == otpState.text.length,
                        )
                    }
                }
            }
        )

        VerticalPadding(20)

        NumberPad(onDigitClick = { digit -> // Pass the lambda to NumberPad
            if (otpState.text.length < 4) {
                otpState.edit {
                    append(digit)
                }
            }
        }, onDeleteClick = { // Add this for backspace functionality
            if (otpState.text.isNotEmpty()) {
                otpState.edit {
                    delete(otpState.text.length - 1, otpState.text.length)
                }
            }
        })
    }
}

@Composable
fun NumberPad(onDigitClick: (String) -> Unit, onDeleteClick: () -> Unit) {
    val buttons = listOf(
        "1", "2", "3",
        "4", "5", "6",
        "7", "8", "9",
        ".", "0", "DEL" // Using "DEL" for delete/backspace
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        buttons.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                rowItems.forEach { item ->
                    NumberPadButton(
                        text = item,
                        onClick = {
                            if (item == "DEL") {
                                onDeleteClick()
                            } else if (item != ".") { // Assuming we don't want the dot for OTP
                                onDigitClick(item)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
                // If a row has less than 3 items (like the last row), add spacers
                repeat(3 - rowItems.size) {
                    Box(modifier = Modifier.weight(1f)) {}
                }
            }
        }
    }
}

@Composable
fun NumberPadButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1.5f) // Adjust aspect ratio as needed for button shape
            .background(
                if (text == "." || text == "DEL") Color.Transparent else MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = onClick)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        when (text) {
            "DEL" -> {
                Icon(
                    painterResource(R.drawable.ic_delete), // Or your preferred backspace icon
//                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Delete",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            "." -> {
                // You can leave this empty or add a different visual for the dot if needed
            }

            else -> {
                Text(
                    text = text,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}


@Composable
private fun Digit(char: Char, highlights: Boolean = false) {
    val borderSize by animateDpAsState(
        targetValue = if (highlights) 1.dp else 0.5.dp
    )
    val boarderColor by animateColorAsState(
        targetValue = if (highlights) Color.Black else Color.LightGray
    )
    Box(
        modifier = Modifier
            .size(55.dp)
            .border(borderSize, boarderColor, RoundedCornerShape(4.dp))
            .background(MaterialTheme.colorScheme.background, RoundedCornerShape(4.dp))
    ) {
        Text(
            style = if (highlights) LocalTextStyle.current else LocalTextStyle.current.copy(color = Color.LightGray),
            text = char.toString(),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun PreviewVerificationScreen() {
    VerificationScreen(
        onNavigateUp = {},
    )
}