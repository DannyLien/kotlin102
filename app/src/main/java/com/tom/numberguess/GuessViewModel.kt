package com.tom.numberguess

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessViewModel : ViewModel() {
    val min by lazy { MutableLiveData<Int>() }

    init {
        min.value = 1
    }
}