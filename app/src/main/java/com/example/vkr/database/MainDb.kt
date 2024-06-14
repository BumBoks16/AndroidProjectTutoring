package com.example.vkr.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vkr.dao.RecordDao
import com.example.vkr.entity.Record

@Database(entities = [Record::class], version = 1, exportSchema = false)
abstract class MainDb : RoomDatabase() {
    abstract val dao: RecordDao
}