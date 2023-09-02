package com.example.memebazzi

import retrofit2.Call
import retrofit2.http.GET

interface api_interface {
    @GET("/gimme")
    fun getdata(): Call<responsedata>
}