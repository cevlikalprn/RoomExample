package com.cevlikalprn.roomexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.cevlikalprn.roomexample.R
import com.cevlikalprn.roomexample.database.Book
import com.cevlikalprn.roomexample.database.BookDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UpdateAndDeleteActivity : AppCompatActivity() {
    private lateinit var bookName: EditText
    private lateinit var authorName: EditText
    private lateinit var btnUpdate: FloatingActionButton
    private lateinit var btnDelete: FloatingActionButton

    private lateinit var bookDatabase: BookDatabase
    private lateinit var oldBook: Book
    private var id: Int = 0

    private fun init(){
        bookName = findViewById(R.id.et_bookName)
        authorName = findViewById(R.id.et_authorName)
        btnUpdate = findViewById(R.id.btn_update)
        btnDelete = findViewById(R.id.btn_delete)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_and_delete)
        init()
        bookDatabase = BookDatabase.getBookDatabase(this)!!

        val intent = intent
        id = intent.getIntExtra("book_id",0)
        val book = intent.getStringExtra("book_name")
        val author = intent.getStringExtra("author_name")
        bookName.setText(book)
        authorName.setText(author)

        btnUpdate.setOnClickListener {
            update()
        }

        btnDelete.setOnClickListener {
            delete()
        }

    }

    private fun update(){

        oldBook = Book(bookName.text.toString(), authorName.text.toString())
        oldBook.bookId = id
        bookDatabase.getBookDao().update(oldBook)
        Toast.makeText(this, "updated", Toast.LENGTH_LONG).show()
        val intent = Intent(this, ShowBooksActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun delete(){
        oldBook = Book(bookName.text.toString(), authorName.text.toString())
        oldBook.bookId = id
        bookDatabase.getBookDao().delete(oldBook)
        Toast.makeText(this, "deleted", Toast.LENGTH_LONG).show()
        val intent = Intent(this, ShowBooksActivity::class.java)
        startActivity(intent)
        finish()
    }
}