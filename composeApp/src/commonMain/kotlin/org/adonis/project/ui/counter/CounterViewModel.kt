package org.adonis.project.ui.counter

import org.adonis.project.core.mvi.BaseViewModelSimple

class CounterViewModel : BaseViewModelSimple<CounterState, CounterIntent>(CounterState()) {

    override fun processIntent(intent: CounterIntent, currentState: CounterState): CounterState {
        return when (intent) {
            CounterIntent.Increment -> currentState.copy(count = currentState.count + 1)
            CounterIntent.Decrement -> currentState.copy(count = currentState.count - 1)
            CounterIntent.Reset -> currentState.copy(count = 0)
        }
    }
}
