package com.example.stow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.room.Room
import com.example.stow.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var UserDAO: UserDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = Room.databaseBuilder (
            applicationContext,
            AppDatabase::class.java,
            "my-database"
        ).build()

        UserDAO =db.UserDAO()

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            //Create a instance of a class User
            val loginInput = findViewById<EditText>(R.id.loginText)
            val name = loginInput.text.toString()

            //Creates User
            val user = User(name, 0)

            lifecycleScope.launch {
                val intent = Intent(this@LoginActivity, DropzoneActivity::class.java)
                UserDAO.insertUser(user)
                startActivity(intent)
            }
        }

        val createButton = findViewById<Button>(R.id.createButton)
        createButton.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }

    }
}