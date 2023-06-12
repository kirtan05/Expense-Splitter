package com.example.nofights

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddExpense : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)
        findViewById<Button>(R.id.btAdd).setOnClickListener {
            val intent = Intent(this, Eleven::class.java)
            startActivity(intent)
            finish()

        }

    }
}