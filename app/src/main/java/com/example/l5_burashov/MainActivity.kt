package com.example.l5_burashov

// импорт необходимых классов
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextHours: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextHours = findViewById(R.id.editTextHours)
        radioGroup = findViewById(R.id.radioGroup)
        buttonCalculate = findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            calculateCost()
        }
    }

    // Метод для подсчета стоимости аренды
    private fun calculateCost() {
        val hoursStr = editTextHours.text.toString()
        if (hoursStr.isEmpty()) {
            editTextHours.error = "Введите количество часов"
            return
        }

        val hours = hoursStr.toInt()
        var costPerHour = 0

        when (radioGroup.checkedRadioButtonId) {
            R.id.radioCar -> costPerHour = 2000
            R.id.radioMinivan -> costPerHour = 2500
            R.id.radioBus -> costPerHour = 3500
        }

        val totalCost = hours * costPerHour
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("totalCost", totalCost)
        }
        startActivity(intent)
    }
}