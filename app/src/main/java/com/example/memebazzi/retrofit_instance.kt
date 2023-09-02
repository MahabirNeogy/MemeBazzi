package com.example.memebazzi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit_instance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://meme-api.com").addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiInterface by lazy {
        retrofit.create(api_interface::class.java)
    }
}