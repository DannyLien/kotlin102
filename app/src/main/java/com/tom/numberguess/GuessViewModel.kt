package com.tom.numberguess

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class GuessViewModel : ViewModel() {
    var secret = Random().nextInt(10) + 1
    var resultData = MutableLiveData<GameStatus>()

    init {
        println("secret = ${secret}")
        resultData.value = GameStatus.INIT
    }

    var result = GameStatus.INIT
    fun guess(num: Int) {
        if (num > secret) {
            result = GameStatus.SMALLER
        } else if (num < secret) {
            result = GameStatus.BIGGER
        } else {
            result = GameStatus.BINGO
        }
        resultData.value = result
    }

    fun reset() {
        resultData.value = GameStatus.INIT
        secret = Random().nextInt(10) + 1
        println("secret = ${secret}")

    }

}

enum class GameStatus {
    INIT, SMALLER, BIGGER, BINGO
}

