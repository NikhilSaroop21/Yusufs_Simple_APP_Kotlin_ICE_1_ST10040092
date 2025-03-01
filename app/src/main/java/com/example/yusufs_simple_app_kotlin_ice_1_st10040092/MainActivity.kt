package com.example.yusufs_simple_app_kotlin_ice_1_st10040092

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var btnClear: Button // Clear button
    private lateinit var etValOne: EditText
    private lateinit var etValTwo: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize UI components
        btnAdd = findViewById(R.id.button)       // Addition button
        btnSubtract = findViewById(R.id.subtract) // Subtraction button
        btnMultiply = findViewById(R.id.multiply) // Multiplication button
        btnDivide = findViewById(R.id.divide)     // Division button
        btnClear = findViewById(R.id.clear) // Initialize the clear button
        etValOne = findViewById(R.id.etValOne)
        etValTwo = findViewById(R.id.etValTwo)
        tvResult = findViewById(R.id.tvResult)

        // 🔥 Attach event listeners to each button
        btnAdd.setOnClickListener { addNumbers() }
        btnSubtract.setOnClickListener { subtractNumbers() }
        btnMultiply.setOnClickListener { multiplyNumbers() }
        btnDivide.setOnClickListener { divideNumbers() }

        // Clear button logic to reset inputs and result
        btnClear.setOnClickListener {
            etValOne.text.clear()
            etValTwo.text.clear()
            tvResult.text = "" // Clear the result
        }
    }



    // ✅ Addition Function
    private fun addNumbers() {
        val num1 = etValOne.text.toString().toDoubleOrNull()
        val num2 = etValTwo.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            tvResult.text = "Result: ${num1 + num2}"
        } else {
            tvResult.text = "Please enter valid numbers"
        }
    }

    // ✅ Subtraction Function
    private fun subtractNumbers() {
        val num1 = etValOne.text.toString().toDoubleOrNull()
        val num2 = etValTwo.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            tvResult.text = "Result: ${num1 - num2}"
        } else {
            tvResult.text = "Please enter valid numbers"
        }
    }

    // ✅ Multiplication Function
    private fun multiplyNumbers() {
        val num1 = etValOne.text.toString().toDoubleOrNull()
        val num2 = etValTwo.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            tvResult.text = "Result: ${num1 * num2}"
        } else {
            tvResult.text = "Please enter valid numbers"
        }
    }

    // ✅ Division Function
    private fun divideNumbers() {
        val num1 = etValOne.text.toString().toDoubleOrNull()
        val num2 = etValTwo.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            if (num2 != 0.0) {
                tvResult.text = "Result: ${num1 / num2}"
            } else {
                tvResult.text = "Cannot divide by zero!"
            }
        } else {
            tvResult.text = "Please enter valid numbers"
        }
    }
}
