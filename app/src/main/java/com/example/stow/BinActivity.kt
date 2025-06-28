package com.example.stow

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class BinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bin)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val threeBarButton = findViewById<Button>(R.id.info)
        threeBarButton.setOnClickListener {
            val intent = Intent(this, ThreeBarActivity::class.java)
            startActivity(intent)
        }

        val problemButton = findViewById<Button>(R.id.problem)
        problemButton.setOnClickListener {
            val intent = Intent(this, ProblemActivity::class.java)
            startActivity(intent)
        }


        val inputField = findViewById<EditText>(R.id.editText)
        val enterButton = findViewById<Button>(R.id.enterButton)
        inputField.setText("")

        enterButton.setOnClickListener {
            val inputText = inputField.text.toString()
            if (inputText.isNotBlank()) {
                val intent = Intent(this, CaseActivity::class.java)
                startActivity(intent)
            }
        }

        //User.rate++

    }
}