package com.example.clotappui.ui.screens


import androidx.compose.material3.TextFieldDefaults
import androidx.compose.foundation.background
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
fun ForgotPasswordScreen(
    onBack: () -> Unit,
    onResetSent: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }

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

            IconButton(onClick = onBack, modifier = Modifier.background(Color(0xFF2D2C35), shape = CircleShape)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left2),
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp).background(Color(0xFF2D2C35), shape = CircleShape)
                )
            }
            Spacer(Modifier.width(8.dp))

        }

        Text(
            text = "Forgot Password",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(16.dp))

        Spacer(Modifier.height(24.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Enter Email Address") },
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
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onResetSent ,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9A76F0)),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Continue", color = Color.White, fontSize = 16.sp)
        }
    }
}

