package com.example.mvvmwithroomdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithroomdb.entities.Quotes
import com.example.mvvmwithroomdb.repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(var quotesRepository: QuotesRepository) : ViewModel() {

    fun getQuotes(): LiveData<List<Quotes>>{
       return quotesRepository.getQuotes()
    }

    fun saveQuote(quotes: Quotes){
        viewModelScope.launch(Dispatchers.IO) {
            quotesRepository.addQuote(quotes)
        }
    }
}