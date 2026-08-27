package com.veerraghu.niku.di

import android.content.Context
import androidx.room.Room
import com.veerraghu.niku.data.AppDatabase
import com.veerraghu.niku.data.EventDao
import com.veerraghu.niku.repository.EventRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "niku-db").build()
    }

    @Provides
    fun provideEventDao(db: AppDatabase): EventDao = db.eventDao()

    @Provides
    @Singleton
    fun provideRepository(dao: EventDao): EventRepository = EventRepository(dao)
}
