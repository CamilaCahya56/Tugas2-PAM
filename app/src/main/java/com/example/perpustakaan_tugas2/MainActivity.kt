package com.example.perpustakaan_tugas2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RegistrationForm { username, jabatan, gender, email ->
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("jabatan", jabatan)
                intent.putExtra("gender", gender)
                intent.putExtra("email", email)
                startActivity(intent)
            }
        }
    }
}
