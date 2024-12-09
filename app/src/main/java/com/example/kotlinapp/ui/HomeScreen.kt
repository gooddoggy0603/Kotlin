package com.yourpackage.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Text(
        text = "Добро пожаловать в мое приложение",
        modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
    )
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
