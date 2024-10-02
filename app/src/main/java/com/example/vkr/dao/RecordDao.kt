package com.example.vkr.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.vkr.entity.Record

@Dao
interface RecordDao {

    @Insert
    suspend fun insert(record: Record): Long

    @Query("SELECT * FROM records WHERE keywords LIKE '%' || :searchKeyword || '%'")
    suspend fun searchRecordsByKeyword(searchKeyword: String): List<Record>
}