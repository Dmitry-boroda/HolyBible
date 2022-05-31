package com.example.holy.data

import com.example.holy.core.Abstract
import com.example.holy.data.net.BookServerModel
import com.example.holy.domain.BookDomain
import java.lang.Exception


sealed class BookData: Abstract.Object<BookDomain,BooksDateToDomainMapper>() {
    class Success(private val books: List<BookServerModel>) : BookData() {
        override fun map(mapper: BooksDateToDomainMapper): BookDomain {
            return mapper.map(books)
        }

    }
    class Fail(private val e: Exception) : BookData(){
        override fun map(mapper: BooksDateToDomainMapper): BookDomain {
            return mapper.map(e)
        }

    }



    //class Success(private val books: List<BookServerModel>) : BookData

}