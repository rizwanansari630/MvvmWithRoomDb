package com.example.mvvmwithroomdb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmwithroomdb.entities.Quotes

@Dao
interface QuotesDao {

    @Query("SELECT * from quotes")
    fun getQuotes() : LiveData<List<Quotes>>

    @Insert
    suspend fun saveQuote(quotes: Quotes)
}