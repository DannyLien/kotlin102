package com.tom.guess

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.tom.guess.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAG: String = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    var secret: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        secret = newGuessNumber()
        Log.d(TAG, "onCreate:")

    }

    fun guessButton(view: View) {
        val s = binding.number.text.toString()
        if (s.length == 0) {
            // Warning Dialog
            AlertDialog.Builder(this)
                .setTitle("Information")
                .setMessage("Please enter a number (1~10)")
                .setPositiveButton("OK", null)
                .show()
        } else {
            // guess Game
            val num = s.toInt()
            Log.d(TAG, "guessButton: secret = ${secret}, num = ${num}")
            var message: String = ""
            if (num > secret) {
                //Small
                message = "Smaller"
            } else if (num < secret) {
                //Big
                message = "Bigger"
            } else {
                //got it
                message = "Bingo, You got it"
            }

            AlertDialog.Builder(this)
                .setTitle("Information")
                .setMessage(message)
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                    binding.number.text.clear()
                })
                .show()

        }
    }


    fun reset(view: View) {
        Log.d(TAG, "reset: ")
        secret = newGuessNumber()
        binding.number.text.clear()
    }

    fun result(view: View) {
        Log.d(TAG, "result: ")
    }

    fun newGuessNumber(): Int {
        val secret = Random().nextInt(10) + 1
        Log.d(TAG, "newGuessNumber: secret : ${secret}")
        return secret
    }

}
