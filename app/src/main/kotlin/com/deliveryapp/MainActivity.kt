package com.deliveryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.deliveryapp.ui.screens.HomeScreen
import com.deliveryapp.ui.theme.DeliveryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    DeliveryAppTheme {
        Surface {
            HomeScreen()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App()
}
