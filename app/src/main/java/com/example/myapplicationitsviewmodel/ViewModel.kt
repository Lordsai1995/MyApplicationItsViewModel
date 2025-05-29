package com.example.myapplicationitsviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel : ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

    fun increment() { _counter.value++ }
    fun decrement() { _counter.value-- }
}