package com.example.clotappui.ui.screens

import android.util.Log
import android.widget.Toast
import com.example.clotappui.data.HashUtil
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

@Composable
fun LoginPasswordScreen(

    email: String,onForgotPassword: () -> Unit, onLoginSuccess: () -> Unit
) {

    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()

    val db = Firebase.firestore

    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1D182A))
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign in",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                disabledTextColor = Color.Black,
                focusedContainerColor = Color.DarkGray,
                unfocusedContainerColor = Color.LightGray,
                cursorColor = Color.Blue,
                errorCursorColor = Color.Red,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick =  {
                if (password.length < 6) {
                    Toast.makeText(context, "Password too short", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                val hashed = HashUtil.sha256(password)

                db.collection("users").
                    whereEqualTo("email",email)
                    .get()
                    .addOnSuccessListener { docs->
                        if (!docs.isEmpty){
                            val doc = docs.first()
                            val stored = doc.getString("password")
                            if (stored == hashed){
                                Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()

                                onLoginSuccess()
                            }else{
                                Toast.makeText(context, "Incorrect password", Toast.LENGTH_SHORT).show()
                            }
                        }else {
                            Toast.makeText(context, "No user found", Toast.LENGTH_SHORT).show()
                        }
                    }.addOnFailureListener {
                        Toast.makeText(context, "Login error: ${it.message}", Toast.LENGTH_SHORT).show()
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9A76F0))
        ) {
            Text("Sign In", color = Color.White, fontSize = 16.sp)
        }

        Spacer(Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Forgot password?",
                fontSize = 12.sp,
                color = Color.White
            )
            Text(
                text = " Reset",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.clickable(onClick = onForgotPassword )
            )
        }
        Spacer(Modifier.height(400.dp))

    }
}

