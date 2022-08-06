package com.tom.numberguess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import com.tom.numberguess.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.result.text = "abc123"
        binding.name.text = "Hank"

        val result = intent.getIntExtra("TEST", -1)
        val name = intent.getStringExtra("NAME")
        binding.result.text = result.toString()
        binding.name.text = name

        binding.button.setOnClickListener {
            intent.putExtra("ABC", 456)
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}