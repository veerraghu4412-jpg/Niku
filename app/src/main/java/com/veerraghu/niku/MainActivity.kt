package com.veerraghu.niku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.veerraghu.niku.ui.MonthView
import com.veerraghu.niku.ui.EventEditor
import com.veerraghu.niku.ui.theme.NikuTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.foundation.layout.fillMaxSize

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NikuTheme {
                Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
                    AppContent()
                }
            }
        }
    }
}

@Composable
fun AppContent() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "month") {
        composable("month") {
            MonthView()
        }
        composable("editor") {
            EventEditor(onSaved = { nav.popBackStack() })
        }
    }
}
