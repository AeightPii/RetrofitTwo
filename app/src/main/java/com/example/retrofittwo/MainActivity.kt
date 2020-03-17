package com.example.retrofittwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittwo.adapter.NewsAdapter
import com.example.retrofittwo.api.NewsApiInterface
import com.example.retrofittwo.model.Article
import com.example.retrofittwo.model.News
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNewsA()
    }

    fun getNewsA() {
        var BASE_URL = "http://newsapi.org/v2/"
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(NewsApiInterface::class.java)
        var apiCall = retrofitService.getNews("us", "business", "3dab19420a6d4704859e2182c79b4418")
        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val a = response.body()?.articles
                Log.d("response>>>", a.toString())
                val newAdaper = NewsAdapter(a as ArrayList<Article>)
                recNews.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = newAdaper
                }
            }

        })
    }
}
