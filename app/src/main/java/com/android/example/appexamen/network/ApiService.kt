package com.android.example.appexamen.network

import com.android.example.appexamen.model.Category
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val Base_URL = "https://api.chucknorris.io/jokes/"

private  val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(Base_URL).build()

interface ApiInterface{



    @GET("categories")
    suspend fun getListCategories(): List<String>

    @GET("random")
    suspend fun getCategory(@Query("category") nameCategory: String) : Category


}

object ApiObject{
    val retrofitService : ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

}




