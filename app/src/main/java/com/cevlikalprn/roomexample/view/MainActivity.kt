package com.cevlikalprn.roomexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import com.cevlikalprn.roomexample.R
import com.cevlikalprn.roomexample.database.Book
import com.cevlikalprn.roomexample.database.BookDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var bookName: EditText
    private lateinit var authorName: EditText
    private lateinit var btnAdd: FloatingActionButton
    private lateinit var bookDatabase: BookDatabase

    private fun init(){
        bookName = findViewById(R.id.et_book_name)
        authorName = findViewById(R.id.et_author_name)
        btnAdd = findViewById(R.id.btn_add)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        bookDatabase = BookDatabase.getBookDatabase(this)!!
        btnAdd.setOnClickListener {
            add()
        }
    }

    private fun add(){
        val book = bookName.text.toString()
        val author = authorName.text.toString()
        if(book != "" || author != ""){
            bookDatabase.getBookDao().addBook(Book(book, author))
            Toast.makeText(this, "added", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ShowBooksActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.show_books_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.show_book_item){
            val intent = Intent(this, ShowBooksActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}