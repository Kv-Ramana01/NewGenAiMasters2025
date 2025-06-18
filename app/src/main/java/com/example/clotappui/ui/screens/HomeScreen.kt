package com.example.clotappui.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val firebaseAuth = FirebaseAuth.getInstance()

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("543999363082-ke1pihf20majkc1912hb87kl2tvbudid.apps.googleusercontent.com")
        .requestEmail()
        .build()

    val googleSignInClient = GoogleSignIn.getClient(context, gso)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to Clot App Home!",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                googleSignInClient.signOut().addOnCompleteListener {
                    firebaseAuth.signOut()
                    Toast.makeText(context, "Signed out successfully", Toast.LENGTH_SHORT).show()
                    navController.navigate("login_email") {
                        Log.d("Auth", "Signed out successfully")
                        popUpTo("home") { inclusive = true }
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text("Sign Out", color = Color.White)
        }
    }
}
