package com.cevlikalprn.roomexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cevlikalprn.roomexample.R
import com.cevlikalprn.roomexample.adapter.BookAdapter
import com.cevlikalprn.roomexample.database.Book
import com.cevlikalprn.roomexample.database.BookDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShowBooksActivity : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var btnDone: FloatingActionButton
    private lateinit var bookList: ArrayList<Book>
    private lateinit var bookDatabase: BookDatabase
    private lateinit var bookAdapter: BookAdapter

    private fun init(){
        recyclerview = findViewById(R.id.recyclerView)
        btnDone = findViewById(R.id.btn_done)
        bookList = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_books)
        init()

        bookDatabase = BookDatabase.getBookDatabase(this)!!

        recyclerview.layoutManager = LinearLayoutManager(this)
        bookAdapter = BookAdapter(bookList)
        recyclerview.adapter = bookAdapter

        read()

        btnDone.setOnClickListener {
            done()
        }

    }

    private fun read(){
        bookList.clear()

        val list = bookDatabase.getBookDao().getAllBook()
        for (it in list){
            bookList.add(it)
        }

        bookAdapter.notifyDataSetChanged()
    }

    private fun done(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}