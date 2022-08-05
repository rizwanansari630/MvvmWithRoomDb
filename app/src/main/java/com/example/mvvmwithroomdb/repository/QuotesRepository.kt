package com.example.mvvmwithroomdb.repository

import androidx.lifecycle.LiveData
import com.example.mvvmwithroomdb.dao.QuotesDao
import com.example.mvvmwithroomdb.entities.Quotes

class QuotesRepository(var dao: QuotesDao) {

    fun getQuotes(): LiveData<List<Quotes>>{
        return dao.getQuotes()
    }

    suspend fun addQuote(quotes: Quotes){
        dao.saveQuote(quotes)
    }
}