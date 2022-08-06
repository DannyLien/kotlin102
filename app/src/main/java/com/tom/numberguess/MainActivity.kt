package com.tom.numberguess

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.tom.numberguess.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private val TAG: String = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    val myMVVM: GuessViewModel by viewModels()
    val goResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        Log.d(TAG, "CallBackReault = ${it.data?.getIntExtra("ABC", -1)} ")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        Log.d(TAG, "onCreate: ")

        ButtonNumberClear()
        myMVVM.resultData.observe(this, Observer {
            if (it == GuessViewModel.INIT) return@Observer
            val message = when (it) {
                GuessViewModel.BIGGER -> "BIGGER"
                GuessViewModel.SMALLER -> "SMALLER"
                else -> "You get it"
            }
            AlertDialog.Builder(this)
                .setTitle("Game Result")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show()
            ButtonNumberClear()
        })
        binding.contentMain.guess.setOnClickListener {
            val num = binding.contentMain.number.text.toString()
            if (num.length == 0) {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Please Enter 1~10 Number")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                myMVVM.guess(num.toInt())
            }

        }
        binding.contentMain.reset.setOnClickListener {
            myMVVM.reset()
            ButtonNumberClear()
        }

        binding.fab.setOnClickListener { view ->
            val intent = Intent(this, ResultActivity::class.java).putExtras(
                Bundle().apply {
                    putInt("TEST", 123)
                    putString("NAME", "Danny")
                }
            )
//            startActivity(intent)
            goResult.launch(intent)
        }

    }

    private fun ButtonNumberClear() {
        binding.contentMain.number.text.clear()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.startYes -> Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show()
            R.id.stopNo -> Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")

    }
}