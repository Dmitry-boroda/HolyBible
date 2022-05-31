package com.example.holy.data

import com.example.holy.data.net.BookServerModel
import com.example.holy.data.net.BooksService

interface BooksCloudDataSource {

    suspend fun fetchBooks() : List<BookServerModel>

    class Base(private val service: BooksService) : BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookServerModel> {
            return service.fetchBooks()
        }
    }
}