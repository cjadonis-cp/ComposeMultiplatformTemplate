package org.adonis.project.ui.counter

data class CounterState(val count: Int = 0)

sealed class CounterIntent {
    data object Increment : CounterIntent()
    data object Decrement : CounterIntent()
    data object Reset : CounterIntent()
}
