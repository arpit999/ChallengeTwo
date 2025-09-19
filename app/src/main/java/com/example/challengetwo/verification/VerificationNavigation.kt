package com.example.challengetwo.verification

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object VerificationDestination

fun NavGraphBuilder.verificationScreen(onNavigateUp: () -> Unit) {
    composable<VerificationDestination> {
        VerificationScreen(onNavigateUp = onNavigateUp)
    }
}

fun NavController.navigateToVerification() {
    navigate(VerificationDestination) {
        popUpTo<VerificationDestination> {
            inclusive = true
        }
    }
}