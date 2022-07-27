package com.tom.numberguess

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.tom.numberguess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG: String = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: ")

        setSupportActionBar(binding.toolbar)


        //Basic Activity get layout id
//        binding.contentMain.min.text = "1"
//        binding.contentMain.max.text = "100"
//        val number = binding.contentMain.number.text.toString()
//        binding.contentMain.guess.setOnClickListener {
//            Log.d(TAG, "onCreate: guessButton = ${number}")
//        }

        val viewModel: GuessViewModel by viewModels()
        viewModel.min.observe(this, {
            binding.contentMain.min.text = it.toString()
        })
        viewModel.max.observe(this, Observer {
            binding.contentMain.max.text = it.toString()
        })
        viewModel.bingo.observe(this, Observer {
            if (it) {
                AlertDialog.Builder(this)
                    .setTitle("Game result")
                    .setMessage("You get it")
                    .setPositiveButton("OK", null)
                    .show()
            }
        })
        binding.contentMain.guess.setOnClickListener {
//            viewModel.add()
            val num = binding.contentMain.number.text.toString().toInt()
            viewModel.guess(num)
            binding.contentMain.number.text.clear()
        }

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

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