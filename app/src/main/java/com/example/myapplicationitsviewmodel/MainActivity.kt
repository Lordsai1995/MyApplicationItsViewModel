package com.example.myapplicationitsviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterScreen()
            }
        }
    }


@Composable
fun CounterScreen(
    viewModel: CounterViewModel = viewModel()
) {
    val count by viewModel.counter.collectAsState()
    Column {
        Text(
            text = "Count: $count",
            style = MaterialTheme.typography.bodyLarge
        )
        Row {
            Button(
                onClick = {
                    viewModel.increment()
                }
            ) {
                Text("Increment")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    viewModel.decrement()
                }
            ) {
                Text("Decrement")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    CounterScreen()
}
