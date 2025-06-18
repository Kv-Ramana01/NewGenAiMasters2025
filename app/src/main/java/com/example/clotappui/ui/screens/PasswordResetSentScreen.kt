package com.example.clotappui.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.example.clotappui.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun PasswordResetSentScreen(onBackToLogin: () -> Unit = {}){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1D182A)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.image_logo),
            contentDescription = "Email Logo",
            modifier = Modifier.size(width = 100.dp, height = 100.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "We Sent you an Email to reset",
            fontSize = 26.sp,
            color = Color.White,
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = "your password.",
            fontSize = 26.sp,
            color = Color.White,
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center, modifier = Modifier.padding(vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onBackToLogin,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9A76F0)),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.height(50.dp)
        ) {
            Text("Return to Login", color = Color.White, fontSize = 16.sp)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PasswordResetSentScreenPreview() {
    PasswordResetSentScreen(){}
}
