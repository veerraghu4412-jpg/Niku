package com.veerraghu.niku.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val title: String,
    val description: String? = null,
    val startMillis: Long,
    val endMillis: Long,
    val allDay: Boolean = false,
    val timezone: String? = null,
    val recurrenceRule: String? = null,
    val color: Int? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
