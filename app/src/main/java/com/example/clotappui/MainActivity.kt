package com.example.clotappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.clotappui.ui.navigation.ClotNavGraph
import com.example.clotappui.ui.theme.ClotAppUITheme
import com.example.clotappui.ui.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClotAppUITheme {
                val navController = rememberNavController()
                ClotNavGraph(navController = navController)
            }

        }
    }
}
