package com.example.retrofittwo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofittwo.R
import com.example.retrofittwo.model.Article
import com.example.retrofittwo.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(var newsArray: ArrayList<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       //var img:ImageView=itemView.findViewById(R.id.img_news)
        fun bind(news: Article) {
            itemView.txt_title.text = news.title
            itemView.txt_content.text = news.content
            itemView.txt_author.text = news.author
            Glide.with(itemView).load(news.urlToImage).into(itemView.img_news)
           //Picasso.get().load(news.urlToImage).into(itemView.img_news)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsArray.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsArray[position])
    }
}