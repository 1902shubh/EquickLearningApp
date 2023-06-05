package com.equicklearning.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.equicklearning.databinding.PostItemLayoutBinding
import com.equicklearning.models.post.PostModel

class PostAdapter
    (val context : Context,
val list : PostModel) : Adapter<PostAdapter.PostViewHolder>(){

    inner class PostViewHolder(
        val binding : PostItemLayoutBinding
    ) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        return PostViewHolder(
            PostItemLayoutBinding.inflate(
                LayoutInflater.from(context)
            ,parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.binding.title.text = list[position].title.rendered

        holder.itemView.setOnClickListener{
            Toast.makeText(context, list[position].title.rendered, Toast.LENGTH_SHORT).show()

        }


    }

}