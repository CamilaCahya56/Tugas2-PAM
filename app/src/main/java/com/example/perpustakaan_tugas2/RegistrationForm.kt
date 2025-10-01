package com.example.perpustakaan_tugas2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegistrationForm(onSave: (String, String, String, String) -> Unit) {
    var username by remember { mutableStateOf("") }
    var jabatan by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

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
            modifier = Modifier.size(120.dp).padding(bottom = 24.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = jabatan,
            onValueChange = { jabatan = it },
            label = { Text("Jabatan") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        Row(modifier = Modifier.padding(bottom = 16.dp)) {
            RadioButton(selected = gender == "Laki-laki", onClick = { gender = "Laki-laki" })
            Text("Laki-laki", modifier = Modifier.align(Alignment.CenterVertically).padding(end = 16.dp))
            RadioButton(selected = gender == "Perempuan", onClick = { gender = "Perempuan" })
            Text("Perempuan", modifier = Modifier.align(Alignment.CenterVertically))
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
        )

        Button(
            onClick = { onSave(username, jabatan, gender, email) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationFormPreview() {
    RegistrationForm { _, _, _, _ -> }
}
