package com.example.holy.data

interface BooksRepository {
    suspend fun fetchBooks() : BookData

    class Base(private val cloudDataSource: BooksCloudDataSource) : BooksRepository{
        override suspend fun fetchBooks(): BookData {
            return try {
                BookData.Success(cloudDataSource.fetchBooks())
            }catch (e: Exception){
                BookData.Fail(e)
            }
        }
    }
}