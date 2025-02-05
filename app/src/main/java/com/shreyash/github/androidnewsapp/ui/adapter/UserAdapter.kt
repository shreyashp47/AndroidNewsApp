package com.shreyash.github.androidnewsapp.ui.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shreyash.github.androidnewsapp.R
import com.shreyash.github.androidnewsapp.data.APIUsers

class UserAdapter(private val userList: ArrayList<APIUsers>) :
    RecyclerView.Adapter<UserAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val ItemsViewModel = userList[position]
        holder.name.text = ItemsViewModel.name
        holder.email.text = ItemsViewModel.email
        Glide.with(holder.avtar.context).load(ItemsViewModel.avtar).into(holder.avtar)
    }

    fun addData(list: List<APIUsers>){
        userList.addAll(list)
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val email: TextView = itemView.findViewById(R.id.textViewUserEmail)
        val name: TextView = itemView.findViewById(R.id.textViewUserName)
        val avtar: ImageView = itemView.findViewById(R.id.imageViewAvatar)

    }
}