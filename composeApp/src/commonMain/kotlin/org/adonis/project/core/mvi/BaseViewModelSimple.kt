package org.adonis.project.core.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModelSimple<State, Intent>(initialState: State) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    fun handleIntent(intent: Intent) {
        _state.value = processIntent(intent, _state.value)
    }

    protected abstract fun processIntent(intent: Intent, currentState: State): State
}
