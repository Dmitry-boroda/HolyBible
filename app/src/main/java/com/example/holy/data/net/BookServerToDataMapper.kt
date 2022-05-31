package com.example.holy.data.net

import com.example.holy.core.Abstract
import com.example.holy.data.BookData

interface BookServerToDataMapper : Abstract.Mapper {

    fun map(id: Int, name: String): BookData
}