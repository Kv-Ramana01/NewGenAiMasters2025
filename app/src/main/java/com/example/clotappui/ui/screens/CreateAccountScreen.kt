package com.example.clotappui.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton



@Composable
fun BackArrow(onBack: () -> Unit) {
    IconButton(onClick = onBack) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left2),
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun CreateAccountScreen(onBack: () -> Unit = {},onAccountCreated: () -> Unit = {},onForgotPassword: () -> Unit) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1D182A))
            .padding(horizontal = 32.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 50.dp, bottom = 24.dp)

        ) {

            IconButton(
                onClick = onBack,
                modifier = Modifier.background(Color(0xFF2D2C35), shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left2),
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp).background(Color(0xFF2D2C35), shape = CircleShape)
                )
            }
            Spacer(Modifier.width(8.dp))

        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create Account",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            Spacer(Modifier.width(32.dp))

            TextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("Firstname") },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Green,
                    disabledTextColor = Color.Green,
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    cursorColor = Color.Blue,
                    errorCursorColor = Color.Red,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth().height(56.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Lastname") },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Green,
                    disabledTextColor = Color.Green,
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    cursorColor = Color.Blue,
                    errorCursorColor = Color.Red,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth().height(56.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address") },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Green,
                    disabledTextColor = Color.Green,
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    cursorColor = Color.Blue,
                    errorCursorColor = Color.Red,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth().height(56.dp)
            )


            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Green,
                    disabledTextColor = Color.Green,
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    cursorColor = Color.Blue,
                    errorCursorColor = Color.Red,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth().height(56.dp)
            )

            Spacer(modifier = Modifier.height(52.dp))

            Button(
                onClick = onAccountCreated,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E6CEF)),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Continue", color = Color.White, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(42.dp))

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

            Spacer(modifier = Modifier.height(82.dp))

            Spacer(modifier = Modifier.height(250.dp))

        }
    }


}



@Preview(showBackground = true)
@Composable
fun CreateAccountScreenPreview() {
    CreateAccountScreen(){}
}

