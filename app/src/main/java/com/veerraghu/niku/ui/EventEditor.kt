package com.veerraghu.niku.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.veerraghu.niku.data.Event
import com.veerraghu.niku.notifications.ReminderScheduler
import com.veerraghu.niku.viewmodel.EventViewModel
import java.util.*

@Composable
fun EventEditor(onSaved: () -> Unit) {
    val context = LocalContext.current
    val viewModel: EventViewModel = hiltViewModel()

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val calendar = Calendar.getInstance()
    var startMillis by remember { mutableStateOf(calendar.timeInMillis) }
    var endMillis by remember { mutableStateOf(calendar.timeInMillis + 60 * 60 * 1000) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Title") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("Description") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { pickDateTime(context) { startMillis = it } }) { Text("Set start") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { pickDateTime(context) { endMillis = it } }) { Text("Set end") }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val event = Event(title = title, description = description, startMillis = startMillis, endMillis = endMillis)
            viewModel.addEvent(event)
            // Schedule default reminder 10 minutes before
            val reminderTime = startMillis - 10 * 60 * 1000
            ReminderScheduler.scheduleReminder(context, event.title, reminderTime)
            onSaved()
        }, modifier = Modifier.align(Alignment.End)) {
            Text("Save")
        }
    }
}

private fun pickDateTime(context: Context, onResult: (Long) -> Unit) {
    val cal = Calendar.getInstance()
    DatePickerDialog(context, { _, year, month, day ->
        cal.set(Calendar.YEAR, year)
        cal.set(Calendar.MONTH, month)
        cal.set(Calendar.DAY_OF_MONTH, day)
        TimePickerDialog(context, { _, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            cal.set(Calendar.SECOND, 0)
            onResult(cal.timeInMillis)
        }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
    }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
}
