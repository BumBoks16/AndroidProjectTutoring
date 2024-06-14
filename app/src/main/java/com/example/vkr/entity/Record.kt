package com.example.vkr.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "records")
data class Record(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val fullName: String,
    val description: String,
    val keywords: String,
    val experienceYears: Int
)