package com.sandip.hiltdagger

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

interface One{
    fun getMain()
}

class Implement @Inject constructor(private val fname:String,private val lname:String):One{
    override fun getMain(){
        Log.d("main","my name is $fname $lname")
    }
}

class Main @Inject constructor(private val one: One){
    fun geTmain(){
        one.getMain()
    }
}

//
//@Module
//@InstallIn(ActivityComponent::class)
//abstract class AppModule{
//
//    @Binds
//    abstract fun binding(implement: Implement):One
//
//}

@Module
@InstallIn(ActivityComponent::class)
class AppModule{

    @Provides
    @FName
    fun firstName():String = "Sandip"

    @Provides
    @LName
    fun lastname():String = "Saha"

    @Provides
    fun binding(@FName firstname: String, @LName lastname: String):One = Implement(firstname,lastname)

}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FName


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LName


