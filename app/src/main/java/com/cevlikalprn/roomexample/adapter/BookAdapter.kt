package com.cevlikalprn.roomexample.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cevlikalprn.roomexample.R
import com.cevlikalprn.roomexample.database.Book
import com.cevlikalprn.roomexample.view.UpdateAndDeleteActivity


class BookAdapter(var bookList: ArrayList<Book>): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_recycler_row, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val bookName = holder.itemView.findViewById(R.id.book_name_textView) as TextView
        val authorName = holder.itemView.findViewById(R.id.author_name_textView) as TextView
        val row = holder.itemView.findViewById(R.id.row_id_textView) as TextView

        bookName.text = bookList[position].bookName
        authorName.text = bookList[position].authorName
        row.text = (position +1).toString()
        0
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateAndDeleteActivity::class.java)
            intent.putExtra("book_name", bookList[position].bookName)
            intent.putExtra("author_name", bookList[position].authorName)
            intent.putExtra("book_id", bookList[position].bookId)
            println(bookList[position].bookId)
            holder.itemView.context.startActivity(intent)
        }

    }
}