package com.example.retrofittwo.api

import com.example.retrofittwo.model.Article
import com.example.retrofittwo.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {

    @GET("top-headlines")
    fun getNews(
    @Query("country") country:String,
    @Query("category") category:String,
    @Query("apiKey") apiKey:String): Call<News>
}