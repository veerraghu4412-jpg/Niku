package com.veerraghu.niku.repository

import com.veerraghu.niku.data.Event
import com.veerraghu.niku.data.EventDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventRepository @Inject constructor(private val dao: EventDao) {
    fun getAll(): Flow<List<Event>> = dao.getAll()

    suspend fun getById(id: Long): Event? = dao.getById(id)

    suspend fun insert(event: Event): Long = dao.insert(event)

    suspend fun update(event: Event) = dao.update(event)

    suspend fun delete(event: Event) = dao.delete(event)
}
