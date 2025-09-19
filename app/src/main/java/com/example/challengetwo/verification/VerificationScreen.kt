package com.example.challengetwo.verification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
        }
    }

}

@Preview
@Composable
private fun PreviewVerificationScreen() {
    VerificationScreen(
        onNavigateUp = {},
    )
}