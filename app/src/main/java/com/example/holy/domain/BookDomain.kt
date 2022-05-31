package com.example.holy.domain

import com.example.holy.core.Abstract
import com.example.holy.data.net.BookServerModel
import com.example.holy.presentation.BookUi


sealed class BookDomain: Abstract.Object<BookUi, Abstract.Mapper.Empty>(){

    class Success() : BookDomain(){
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }

    }
    class Fail(errorType: Int) : BookDomain(){
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }

    }

}
