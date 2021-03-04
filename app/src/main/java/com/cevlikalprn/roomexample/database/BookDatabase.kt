package com.cevlikalprn.roomexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Book::class],
    version = 1
)
abstract class BookDatabase: RoomDatabase() {

    abstract fun getBookDao(): BookDao

    companion object{
        private var instance: BookDatabase? = null

        fun getBookDatabase(context: Context): BookDatabase?{
            if (instance == null){
                instance = Room.databaseBuilder(context,
                    BookDatabase::class.java,
                    "book.db").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}