package com.example.mvvmwithroomdb.dataBaseSetup

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmwithroomdb.dao.QuotesDao
import com.example.mvvmwithroomdb.entities.Quotes

@Database(entities = [Quotes::class], version = 1,exportSchema = false)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuotesDao

    companion object {
        private var INSTANCE: QuoteDatabase? = null
        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        QuoteDatabase::class.java,
                        "quote_database"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}

