package com.example.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmiapp.databinding.ActivityMainBinding
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.resultBtn.setOnClickListener {
            if (binding.weightEditText.text.isNotBlank() &&
                binding.heightEditText.text.isNotBlank()
            ) {
                /* val intent = Intent (this,ResultActivity::class.java)
            intent.putExtra("weight",binding.weightEditText.text.toString().toFloat())
            intent.putExtra("height",binding.heightEditText.text.toString().toFloat()) */

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("weight", binding.weightEditText.text.toString().toFloat())
                    putExtra("height", binding.heightEditText.text.toString().toFloat())
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
