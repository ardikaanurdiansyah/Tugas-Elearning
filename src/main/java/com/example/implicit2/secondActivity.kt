package com.example.implicit2
import android.widget.TextView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val acceptText: TextView = findViewById(R.id.txt_second)
        val receivedText: String? = intent.getStringExtra("INI DIKIRIM")
        acceptText.text = receivedText
    }
}