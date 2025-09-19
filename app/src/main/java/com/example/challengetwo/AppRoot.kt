package com.example.challengetwo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.challengetwo.verification.navigateToVerification
import com.example.challengetwo.verification.verificationScreen
import com.example.challengetwo.welcome.WelcomeDestination
import com.example.challengetwo.welcome.welcomeScreen

@Composable
fun AppRoot() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WelcomeDestination) {
        welcomeScreen(navigateToVerification = { navController.navigateToVerification() })
        verificationScreen(
            onNavigateUp = { navController.navigateUp() }
        )
    }
}
