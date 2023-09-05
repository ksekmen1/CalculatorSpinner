package com.example.calculator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculator1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)


        binding.button.setOnClickListener {
            calculate()
        }


    }
    private fun calculate(){

        val nr1str =binding.textView.text.toString().trim()
        val nr2str =binding.textView2.text.toString().trim()
        var error = false
        if (nr1str.isEmpty()) {
            binding.textView.error = "No number"
            error = true


        }
        if (nr2str.isEmpty()) {
            binding.textView2.error = "No number"
            error = true

        }
        if (error) return
        val number1 = nr1str.toDouble()
        val number2 = nr2str.toDouble()
        var result = 0.0
        val operation: String = binding.spinner.selectedItem as String

        when (operation) {
            "+" -> result = number1 + number2
            "-" -> result = number1 - number2
            "*" -> result = number1 * number2
            "/" -> result = number1 / number2
        }
        val resultStr = result.toString()
        binding.textView4.text = resultStr



    }




}