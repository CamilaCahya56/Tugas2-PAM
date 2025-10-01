package com.example.perpustakaan_tugas2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val username = intent.getStringExtra("username") ?: ""
        val jabatan = intent.getStringExtra("jabatan") ?: ""
        val gender = intent.getStringExtra("gender") ?: ""
        val email = intent.getStringExtra("email") ?: ""

        setContent {
            ResultScreen(username, jabatan, gender, email)
        }
    }
}

@Composable
fun ResultScreen(username: String, jabatan: String, gender: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Profile Icon",
            modifier = Modifier.size(160.dp).padding(bottom = 24.dp)
        )

        Text(text = "Username: $username", fontSize = 18.sp, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "Jabatan: $jabatan", fontSize = 18.sp, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "Jenis Kelamin: $gender", fontSize = 18.sp, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "Email: $email", fontSize = 18.sp, modifier = Modifier.padding(bottom = 16.dp))
    }
}
