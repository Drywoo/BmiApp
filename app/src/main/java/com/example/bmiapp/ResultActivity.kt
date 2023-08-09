package com.example.bmiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bmiapp.databinding.ActivityResultBinding
import kotlin.math.pow


class ResultActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val height = intent.getFloatExtra("height",0f)
        val weight = intent.getFloatExtra("weight",0f)

        var bmi = weight / (height / 100.0f).pow(2.0f)

        when {
             bmi >= 35 -> binding.resultTextView.text = "고도비만"
             bmi >= 30 -> binding.resultTextView.text = "2단계 비만"
             bmi >= 25 -> binding.resultTextView.text = "1단계 비만"
             bmi >= 23 -> binding.resultTextView.text = "과체중"
             bmi >= 18.5 -> binding.resultTextView.text = "정상"
             else -> binding.resultTextView.text = "저체중"
        }

        when {
             bmi >= 23 -> binding.imageView.setImageResource(
                 R.drawable.baseline_sentiment_very_dissatisfied_24)

             bmi >= 18.5 -> binding.imageView.setImageResource(
                 R.drawable.baseline_sentiment_satisfied_alt_24)
            else -> binding.imageView.setImageResource(
                R.drawable.baseline_sentiment_satisfied_alt_24)
        }
        Toast.makeText(this,"$bmi,$weight, $height",Toast.LENGTH_LONG).show()
    }
}