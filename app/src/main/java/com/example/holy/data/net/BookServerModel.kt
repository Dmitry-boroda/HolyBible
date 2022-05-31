package com.example.holy.data.net

import com.example.holy.core.Abstract
import com.example.holy.data.BookData
import com.google.gson.annotations.SerializedName

data class BookServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String
) : Abstract.Object<BookData, BookServerToDataMapper>(){

    override fun map(mapper: BookServerToDataMapper): BookData {
        return mapper.map(id,name)
    }

}