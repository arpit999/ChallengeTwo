package com.example.challengetwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.challengetwo.components.VerticalPadding
import com.example.challengetwo.ui.theme.ChallengeTwoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChallengeTwoTheme {
                EntryScreen()
            }
        }
    }
}


@Composable
fun EntryScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(horizontal = 16.dp),) {
            VerticalPadding(16)

            Text("Welcome to Fintrack!", style = MaterialTheme.typography.headlineSmall)
            Text("Let's get you setup", style = MaterialTheme.typography.headlineSmall)

            VerticalPadding(16)
            ActionItem(
                title = "Welcome to Fintrack!",
                subtitle = "Let's get you setup",
                image = R.drawable.digital_electronic_wallet_banking_tool
            )
            VerticalPadding(10)
            ActionItem(
                title = "Link your bank accounts.",
                subtitle = "Link your bank accounts to start tracking your expenses.",
                image = R.drawable.phone_with_coin
            )
            VerticalPadding(10)
            ActionItem(
                title = "Welcome to Fintrack!",
                subtitle = "Let's get you setup",
                image = R.drawable.digital_electronic_wallet_banking_tool
            )
            Spacer(modifier = Modifier.weight(1f))

            Button(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), onClick = {}) {
                Text("Skip for now")
            }

            VerticalPadding(16)
        }
    }
}
@Composable
fun ActionItem(title: String, subtitle: String, image: Int) {
    ElevatedCard {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                VerticalPadding(2)
                Text(subtitle, style = MaterialTheme.typography.bodyMedium)
            }
            Image(
                modifier = Modifier.padding(end = 16.dp),
                painter = painterResource(image),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_9")
@Composable
fun GreetingPreview() {
    ChallengeTwoTheme {
        EntryScreen()
    }
}