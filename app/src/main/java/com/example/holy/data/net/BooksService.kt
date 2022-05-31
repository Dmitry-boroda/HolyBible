package com.example.holy.data.net

import retrofit2.http.GET


interface BooksService {

    @GET("books")
    suspend fun fetchBooks() : List<BookServerModel>
}
