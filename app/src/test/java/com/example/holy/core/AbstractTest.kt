package com.example.holy.core

import junit.framework.Assert.assertTrue
import org.junit.Test
import java.io.IOException
import java.lang.Exception

class AbstractTest{
    @Test
    fun test_success(){
        val dataObject = TestDataObject.Success("a", "b")
        val domainObject = dataObject.map(DataToDomainMapper.Base())
        assertTrue((domainObject is DomainObject.Success))
    }
    @Test
    fun test_fail(){
        val dataObject = TestDataObject.Fail(IOException())
        val domainObject = dataObject.map(DataToDomainMapper.Base())
        assertTrue((domainObject is DomainObject.Fail))
    }
    private sealed class TestDataObject : Abstract.Object<DomainObject, DataToDomainMapper>(){

        abstract override fun map(mapper: DataToDomainMapper): DomainObject

        class Success(private val texOne:String,private val texTow:String): TestDataObject(){
            override fun map(mapper: DataToDomainMapper): DomainObject {
                return mapper.map(texOne,texTow)

            }
        }
        class Fail(private val exception: Exception): TestDataObject(){
            override fun map(mapper: DataToDomainMapper): DomainObject {
                return mapper.map(exception)
            }
        }
    }
    private interface DataToDomainMapper : Abstract.Mapper{
        fun map(texOne: String,texTow: String): DomainObject
        fun map(exception: Exception): DomainObject
        class Base: DataToDomainMapper{
            override fun map(texOne: String, texTow: String): DomainObject {
                return DomainObject.Success("$texOne $texTow")
            }

            override fun map(exception: Exception): DomainObject {
                return DomainObject.Fail()
            }

        }
    }
    private sealed class DomainObject: Abstract.Object<UiObject, DomainToUiMapper>(){
        class Success(private val textCombined:String):DomainObject(){
            override fun map(mapper: DomainToUiMapper): UiObject {
                TODO("Not yet implemented")
            }
        }
        class Fail:DomainObject(){
            override fun map(mapper: DomainToUiMapper): UiObject {
                TODO("Not yet implemented")
            }
        }
    }
    private interface DomainToUiMapper: Abstract.Mapper
    private sealed class UiObject : Abstract.Object<Unit,Abstract.Mapper.Empty>(){

    }


}