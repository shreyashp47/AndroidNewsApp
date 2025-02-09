package com.shreyash.github.androidnewsapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shreyash.github.androidnewsapp.R
import com.shreyash.github.androidnewsapp.data.model.Article
import com.shreyash.github.androidnewsapp.data.model.TopHeadlinesResponse

class TopHeadingAdapter(private val articles: ArrayList<Article>) :
    RecyclerView.Adapter<TopHeadingAdapter.TopHeadingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return TopHeadingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: TopHeadingViewHolder, position: Int) {
        val article = articles[position]
        holder.title.text = article.title
        holder.description.text = article.description
        holder.source.text = article.source.name
        Glide.with(holder.image.context).load(article.url).into(holder.image)

    }


    class TopHeadingViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.textViewTitle)
        val description = itemView.findViewById<TextView>(R.id.textViewDescription)
        val source = itemView.findViewById<TextView>(R.id.textViewSource)
        val image = itemView.findViewById<ImageView>(R.id.imageViewBanner)
    }
}