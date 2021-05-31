package com.jomatt.serempreapp.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.jomatt.serempreapp.R
import com.jomatt.serempreapp.core.BaseViewHolder
import com.jomatt.serempreapp.databinding.RowPostBinding
import com.jomatt.serempreapp.domain.model.Post

class PostAdapter(
    private val context: Context,
    private var list: List<Post>,
    private val listener: OnPostListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        const val MAX_BLUE = 20
    }

    interface OnPostListener {
        fun onItemClick(item: Post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return PostViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_post, parent, false)
        )
    }

    fun update(newList: List<Post>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is PostViewHolder -> holder.bind(list[position], position)
        }
    }

    override fun getItemCount(): Int = list.size

    inner class PostViewHolder(itemView: View) : BaseViewHolder<Post>(itemView) {
        private val binding = RowPostBinding.bind(itemView)
        override fun bind(item: Post, position: Int) {
            binding.tvTitle.text = item.title
            binding.tvDescription.text = item.description
            binding.root.setOnClickListener {
                listener.onItemClick(item)
            }
            if (position < MAX_BLUE) {
                binding.root.background =
                    ContextCompat.getDrawable(context, R.color.colorBlue)
            } else {
                binding.root.background =
                    ContextCompat.getDrawable(context, R.color.white)
            }
            binding.imgFavorite.isVisible = item.isFavorite
        }
    }
}