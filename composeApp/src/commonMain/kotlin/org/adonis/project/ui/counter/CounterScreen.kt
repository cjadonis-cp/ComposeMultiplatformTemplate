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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.adonis.project.ui.theme.AppTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CounterScreen(viewModel: CounterViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()
    CounterContent(state = state, onIntent = viewModel::handleIntent)
}

@Composable
fun CounterContent(state: CounterState, onIntent: (CounterIntent) -> Unit) {
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
            Button(onClick = { onIntent(CounterIntent.Decrement) }) {
                Text("-")
            }

            Spacer(modifier = Modifier.width(16.dp))

            OutlinedButton(onClick = { onIntent(CounterIntent.Reset) }) {
                Text("Reset")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { onIntent(CounterIntent.Increment) }) {
                Text("+")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    AppTheme {
        CounterContent(state = CounterState(count = 0), onIntent = {})
    }
}
