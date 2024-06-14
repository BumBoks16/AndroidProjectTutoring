package com.example.vkr.di

import android.app.Application
import androidx.room.Room
import com.example.vkr.database.MainDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideMainDb(VKR: Application): MainDb {
        return Room.databaseBuilder(
           VKR,
            MainDb::class.java,
            "info.db"
        ).build()
    }
}