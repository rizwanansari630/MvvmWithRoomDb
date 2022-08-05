package com.example.mvvmwithroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithroomdb.dataBaseSetup.QuoteDatabase
import com.example.mvvmwithroomdb.databinding.ActivityMainBinding
import com.example.mvvmwithroomdb.entities.Quotes
import com.example.mvvmwithroomdb.repository.QuotesRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = QuotesRepository(dao)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.getQuotes().observe(this, Observer {
            binding.allQuotes.text = it.toString()
        })
        binding.saveQuote.setOnClickListener {
            mainViewModel.saveQuote(Quotes(0,binding.edQuote.text.toString(),binding.edAuthor.text.toString()))
        }
    }
}