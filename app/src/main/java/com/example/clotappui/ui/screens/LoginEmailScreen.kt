package com.example.clotappui.ui.screens

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.clotappui.R
import com.example.clotappui.ui.component.SocialButton
import com.example.clotappui.ui.navigation.Screen
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun LoginEmailScreen(navController: NavController, onCreate: () -> Unit) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Auth", "Google sign-in successful")

                        navController.navigate("home") {
                            popUpTo("login_email") { inclusive = true }
                        }
                    } else {
                        Toast.makeText(context, "Firebase sign-in failed", Toast.LENGTH_SHORT).show()
                    }
                }
        } catch (e: ApiException) {
            Toast.makeText(context, "Google sign-in failed: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("543999363082-ke1pihf20majkc1912hb87kl2tvbudid.apps.googleusercontent.com")
        .requestEmail()
        .build()

    val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(context, gso)

    var email by remember { mutableStateOf("") }

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
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address", color = Color.Gray) },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedContainerColor = Color.DarkGray,
                unfocusedContainerColor = Color.DarkGray,
                cursorColor = Color.Blue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth().height(56.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Screen.LoginPassword.route + "?email=$email") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E6CEF)),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Continue", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text("Don't have an Account? ", fontSize = 12.sp, color = Color.White)
            Text(
                "Create One",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.clickable(onClick = onCreate)
            )
        }

        Spacer(modifier = Modifier.height(82.dp))

        SocialButton(iconRes = R.drawable.apple_logo, txt = "Continue With Apple")

        Spacer(modifier = Modifier.height(12.dp))
        SocialButton(iconRes = R.drawable.google_logo, txt = "Continue With Google",
            onClick = {
                val signInIntent: Intent = googleSignInClient.signInIntent
                launcher.launch(signInIntent)
            })

        Spacer(modifier = Modifier.height(12.dp))
        SocialButton(iconRes = R.drawable.facebook_logo, txt = "Continue With Facebook")
    }
}
