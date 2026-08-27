package com.veerraghu.niku.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MonthView() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Month View", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))
        // Simple placeholder grid 7 columns x 5 rows
        for (row in 0 until 5) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                for (col in 1..7) {
                    Box(modifier = Modifier
                        .weight(1f)
                        .height(56.dp)
                        .background(Color(0xFFF1F3F4))
                        .clickable { /* TODO: open day view */ }, contentAlignment = Alignment.Center) {
                        Text(text = "${row * 7 + col}")
                    }
                }
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}
