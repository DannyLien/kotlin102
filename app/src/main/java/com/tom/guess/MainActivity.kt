package com.tom.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tom.guess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.message.text = "Hello Kotlin102"

        binding.enter.setOnClickListener {
            binding.message.text = "What??"
        }

        binding.reset.setOnClickListener {
            binding.message.text = "Hello Kotlin102"
        }

    }
}