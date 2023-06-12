package com.example.nofights

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class options : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
        findViewById<Button>(R.id.grpaddmember).setOnClickListener()
        {
            val intent = Intent(this, AddMember::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<Button>(R.id.grpaddexpense).setOnClickListener()
        {
            val intent = Intent(this, AddExpense::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<Button>(R.id.viewgroup).setOnClickListener()
        {
            val intent = Intent(this, Eleven::class.java)
            startActivity(intent)
            finish()
        }
        /*findViewById<Button>(R.id.goptions).setOnClickListener()
        {
            val intent = Intent(this, options::class.java)
            startActivity(intent)
            finish()
        }*/
    }
}