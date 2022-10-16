package com.example.wearos_espresso_test

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import com.example.wearos_espresso_test.databinding.ActivityMainBinding
import com.example.wearos_espresso_test.databinding.NextActivityBinding

class NextActivity : Activity() {

    private lateinit var binding: NextActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = NextActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        previousActivity()
    }

    @SuppressLint("SetTextI18n")
    private fun previousActivity() {
        binding.prevAct.setOnClickListener {
            finish()
            super.onBackPressed()
        }
    }
}