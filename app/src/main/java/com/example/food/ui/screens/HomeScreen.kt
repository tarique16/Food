package com.example.food.ui.screens

import android.app.Activity
import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(name: String, modifier: Modifier = Modifier) {
    var showExitDialog by remember { mutableStateOf(false) }
    BackHandler(true) { showExitDialog = true }
    val context: Context = LocalContext.current
    when (showExitDialog) {
        true -> {
            AlertDialog(
                onDismissRequest = { showExitDialog = false },
                confirmButton = {
                    Button(onClick = {
                        showExitDialog = false
                        (context as? Activity)?.finish()
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    Button(onClick = { showExitDialog = false }) {
                        Text("Cancel")
                    }
                },
                title = { Text("Exit App?") },
            )
        }

        else -> {}
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $name",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen("HomeScreen")
}