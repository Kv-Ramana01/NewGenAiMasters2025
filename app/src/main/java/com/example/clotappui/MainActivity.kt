package com.example.clotappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clotappui.ui.theme.ClotAppUITheme
import com.example.clotappui.ui.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           OnboardingSplashScreenPreview()
            //LoginEmailPreview()
            //CreateAccountScreenPreview()
            //LoginPasswordScreenPreview()
            //ForgotPasswordScreenPreview()
            //PasswordResetSentScreenPreview()

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClotAppUITheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAccountScreenPreview() {
    CreateAccountScreen(
        onBack = {}
    )
}

@Preview(showBackground = true)
@Composable
fun OnboardingSplashScreenPreview(){
    OnboardingSplashScreen()
}

@Preview(showBackground = true)
@Composable
fun LoginEmailPreview() {
    LoginEmailScreen()
}
@Preview(showBackground = true)
@Composable
fun LoginPasswordScreenPreview() {
    LoginPasswordScreen()
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen()
}

@Preview(showBackground = true)
@Composable
fun PasswordResetScreenPreview() {
    PasswordResetSentScreen()
}

