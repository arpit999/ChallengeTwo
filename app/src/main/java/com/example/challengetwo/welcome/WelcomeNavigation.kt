package com.example.challengetwo.welcome

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object WelcomeDestination

fun NavGraphBuilder.welcomeScreen(navigateToVerification: () -> Unit) {
    composable<WelcomeDestination> {
        WelcomeScreen(navigateToVerification = navigateToVerification)
    }
}

fun NavController.navigateToWelcome() {
    navigate(WelcomeDestination) {
        popUpTo<WelcomeDestination> {
            inclusive = true
        }
    }
}