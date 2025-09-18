package com.example.challengetwo.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalPadding(int: Int) {
    Spacer(modifier = Modifier.padding(vertical = int.dp))
}

@Composable
fun HorizontalPadding(int: Int) {
    Spacer(modifier = Modifier.padding(horizontal = int.dp))
}