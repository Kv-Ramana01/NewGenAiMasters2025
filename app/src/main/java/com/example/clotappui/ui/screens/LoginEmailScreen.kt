package com.example.clotappui.ui.screens



import androidx.compose.foundation.Image
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clotappui.R
import com.example.clotappui.ui.component.SocialButton
import androidx.compose.runtime.*
import androidx.compose.ui.*


@Composable
fun LoginEmailScreen(onNext: () -> Unit,
                     onCreate: () -> Unit){

    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1D182A)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sign in",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )


            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address", color = Color.Gray) },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Green,
                    disabledTextColor = Color.Green,
                    focusedContainerColor = Color.DarkGray,
                    unfocusedContainerColor = Color.DarkGray,
                    cursorColor = Color.Blue,
                    errorCursorColor = Color.Red,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth().height(56.dp)
            )


            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onNext,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E6CEF)),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Continue", color = Color.White, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Don't have an Account? ",
                    fontSize = 12.sp,
                    color = Color.White
                )
                Text(
                    text = "Create One",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.clickable(onClick = onCreate )
                )
            }

            Spacer(modifier = Modifier.height(82.dp))

            SocialButton(
                iconRes = R.drawable.apple_logo,
                txt = "Continue With Apple"
            )
            Spacer(modifier = Modifier.height(12.dp))
            SocialButton(
                iconRes = R.drawable.google_logo,
                txt = "Continue With Google"
            )
            Spacer(modifier = Modifier.height(12.dp))
            SocialButton(
                iconRes = R.drawable.facebook_logo,
                txt = "Continue With Facebook"
            )
            Spacer(modifier = Modifier.height(150.dp))

        }
    }


}



