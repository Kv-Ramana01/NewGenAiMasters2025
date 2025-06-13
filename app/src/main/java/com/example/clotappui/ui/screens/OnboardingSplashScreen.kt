package com.example.clotappui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.clotappui.R


@Composable
fun OnboardingSplashScreen(){
   Column(modifier = Modifier.fillMaxSize().background(Color(0xFF9B70FF)).padding(16.dp),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally){
       Image(
           painter = painterResource(id = R.drawable.clot_logo),
           contentDescription = "CLot Logo",
           modifier = Modifier.size(width = 175.dp, height = 80.dp)
       )

   }
}

@Preview(showBackground = true)
@Composable
fun OnboardingSplashScreenPreview(){
    OnboardingSplashScreen()
}