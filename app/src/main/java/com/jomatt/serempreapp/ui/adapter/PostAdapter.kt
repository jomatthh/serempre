package com.jomatt.serempreapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jomatt.serempreapp.R
import com.jomatt.serempreapp.core.BaseViewHolder
import com.jomatt.serempreapp.databinding.RowPostBinding
import com.jomatt.serempreapp.domain.model.Post

class PostAdapter(
    private var list: List<Post>
) : RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_post, parent, false)
        )
    }

    fun update(newList: List<Post>){
        list = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PostViewHolder-> holder.bind(list[position], position)
        }
    }

    override fun getItemCount(): Int  = list.size

    inner class PostViewHolder(itemView: View): BaseViewHolder<Post>(itemView){
        private val binding = RowPostBinding.bind(itemView)
        override fun bind(item: Post, position: Int) {
            binding.tvTitle.text = item.title
            binding.tvDescription.text = item.description
        }
    }
}