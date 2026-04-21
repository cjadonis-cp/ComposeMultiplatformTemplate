package org.adonis.project.ui.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CounterScreen(viewModel: CounterViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "${state.count}",
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = { viewModel.handleIntent(CounterIntent.Decrement) }) {
                Text("-")
            }

            Spacer(modifier = Modifier.width(16.dp))

            OutlinedButton(onClick = { viewModel.handleIntent(CounterIntent.Reset) }) {
                Text("Reset")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { viewModel.handleIntent(CounterIntent.Increment) }) {
                Text("+")
            }
        }
    }
}
