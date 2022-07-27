package com.tom.numberguess

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class GuessViewModel : ViewModel() {
    var min = MutableLiveData<Int>()
    var max = MutableLiveData<Int>()
    val secret = Random().nextInt(100) + 1
    var bingo = MutableLiveData<Boolean>()

    init {
        min.value = 1
        max.value = 100
        bingo.value = false
        println("secret = ${secret}")
    }

    fun guess(num: Int) {
        if (num == secret) {
            bingo.value = true
        } else if (num > secret) {
            max.value = num
        } else {
            min.value = num
        }
    }

    fun add() {
        var n = min.value
        n?.plus(1)
        min.value = n
    }

}