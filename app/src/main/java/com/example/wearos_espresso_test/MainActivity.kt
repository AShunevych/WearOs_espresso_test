package com.example.wearos_espresso_test

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import com.example.wearos_espresso_test.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCounterAtZero()
        clickOnCounter()
        toNextActivity()
    }

    private fun setCounterAtZero() {
        binding.counter.text = "0"
    }

    @SuppressLint("SetTextI18n")
    private fun clickOnCounter() {
        binding.count.setOnClickListener {
            val counterValue = binding.counter.text.toString().toInt()
            binding.counter.text = "${counterValue+1}"
        }
    }

    private fun toNextActivity() {
        binding.activityNext.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                NextActivity::class.java
            )
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this@MainActivity).toBundle()
            )
        }
    }
}