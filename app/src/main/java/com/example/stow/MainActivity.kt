package com.example.stow

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val threeBarButton = findViewById<Button>(R.id.threeBar)
        threeBarButton.setOnClickListener {
            val intent = Intent(this, ThreeBarActivity::class.java)
            startActivity(intent)
        }

        val problemButton = findViewById<Button>(R.id.button2)
        problemButton.setOnClickListener {
            val intent = Intent(this, ProblemActivity::class.java)
            startActivity(intent)
        }


    }
}