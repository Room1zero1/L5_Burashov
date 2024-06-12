package com.example.l5_burashov


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewResult = findViewById(R.id.textViewResult)

        val totalCost = intent.getIntExtra("totalCost", 0)
        textViewResult.text = "Оплатить = $totalCost рублей"
    }
}