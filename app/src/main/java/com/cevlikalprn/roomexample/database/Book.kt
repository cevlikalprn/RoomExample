package com.cevlikalprn.roomexample.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(

    @ColumnInfo(name = "book_name")
    val bookName:String,

    @ColumnInfo(name = "author_name")
    val authorName:String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    var bookId:Int = 0
}