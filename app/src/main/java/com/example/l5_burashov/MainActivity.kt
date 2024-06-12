// пакет приложения
package com.example.l5_burashov

// импорт необходимых классов
import android.content.Intent  // Класс для передачи данных между активити
import android.os.Bundle       // Класс для хранения данных состояния активности
import android.widget.Button  // Класс для кнопки
import android.widget.EditText // Класс для поля ввода текста
import android.widget.RadioGroup // Класс для группы радиокнопок
import androidx.appcompat.app.AppCompatActivity // Базовый класс для активити в Android

// Класс описывает главную активность приложения
class MainActivity : AppCompatActivity() {

    // Поля для хранения ссылок на элементы интерфейса
    // инициализируются позже
    private lateinit var editTextHours: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonCalculate: Button

    //  метод вызывается при создании активности
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Установить макет для активности

        // Инициализация полей ссылками на элементы интерфейса
        editTextHours = findViewById(R.id.editTextHours)
        radioGroup = findViewById(R.id.radioGroup)
        buttonCalculate = findViewById(R.id.buttonCalculate)

        // Обработчик нажатия на кнопку "buttonCalculate"
        buttonCalculate.setOnClickListener {
            calculateCost() // Вызвать метод подсчета стоимости
        }
    }

    // Метод для подсчета стоимости аренды
    private fun calculateCost() {
        // Получить текст из поля ввода часов
        val hoursStr = editTextHours.text.toString()

        // Проверка ввода пользователем количества часов
        if (hoursStr.isEmpty()) {
            editTextHours.error = "Введите количество часов"  // Отобразить сообщение об ошибке
            return  // Завершить выполнение метода, если ввод пустой
        }

        // Преобразовать введенное количество часов из строки в число
        val hours = hoursStr.toInt()

        // Переменная для хранения стоимости в час
        var costPerHour = 0

        // Определение стоимости в час в зависимости от выбранного типа транспорта
        when (radioGroup.checkedRadioButtonId) {
            R.id.radioCar -> costPerHour = 2000  // Легковой автомобиль - 2000 рублей/час
            R.id.radioMinivan -> costPerHour = 2500  // Минивен - 2500 рублей/час
            R.id.radioBus -> costPerHour = 3500  // Автобус - 3500 рублей/час
        }

        // Рассчитать общую стоимость аренды (количество часов * стоимость в час)
        val totalCost = hours * costPerHour

        // Создать новый Intent для запуска активности результата
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("totalCost", totalCost) // Добавить данные о общей стоимости в Intent
        }

        // Запустить активность результата с передачей данных
        startActivity(intent)
    }
}
