package org.adonis.project.ui

import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.adonis.project.ui.counter.CounterScreen
import org.adonis.project.ui.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        Scaffold(modifier = Modifier.safeContentPadding()) { _ ->
            CounterScreen()
        }
    }
}
