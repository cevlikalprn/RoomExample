package com.cevlikalprn.roomexample.database

import androidx.room.*

@Dao
interface BookDao {
    @Insert
    fun addBook(book: Book)

    @Query("SELECT * FROM book_table ORDER BY book_id DESC")
    fun getAllBook(): List<Book>

    @Update
    fun update(book: Book)

    @Delete
    fun delete(book: Book)

}