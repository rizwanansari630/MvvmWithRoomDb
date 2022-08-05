package com.example.mvvmwithroomdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class Quotes(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val text: String,
    val author: String
)
