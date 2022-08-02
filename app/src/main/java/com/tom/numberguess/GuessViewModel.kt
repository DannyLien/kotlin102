package com.tom.numberguess

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class GuessViewModel : ViewModel() {
    companion object {
        val BIGGER = 1
        val SMALLER = -1
        val BINGO = 0
        val INIT = 9
    }

    var secret = Random().nextInt(10) + 1
    var resultData = MutableLiveData<Int>()

    init {
        println("secret = ${secret}")
        resultData.value = INIT
    }

    var result = INIT
    fun guess(num: Int) {
        if (num > secret) {
            result = SMALLER
        } else if (num < secret) {
            result = BIGGER
        } else {
            result = BINGO
        }
        resultData.value = result
    }

    fun reset() {
        resultData.value = INIT
        secret = Random().nextInt(10) + 1
        println("secret = ${secret}")

    }

}