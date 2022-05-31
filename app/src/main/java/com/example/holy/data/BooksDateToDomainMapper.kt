package com.example.holy.data

import com.example.holy.core.Abstract
import com.example.holy.data.net.BookServerModel
import com.example.holy.domain.BookDomain
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

interface BooksDateToDomainMapper : Abstract.Mapper {
    fun map(books: List<BookServerModel>): BookDomain
    fun map(e: Exception): BookDomain

    class Base : BooksDateToDomainMapper{
        override fun map(books: List<BookServerModel>) : BookDomain {
            //todo
            return BookDomain.Success()

        }

        override fun map(e: Exception): BookDomain {
            val errorType = when(e){
                is UnknownHostException -> 0
                is HttpException -> 1
                else -> 2
            }
            return BookDomain.Fail(errorType)
        }

    }
}