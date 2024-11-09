package com.example.recyclewithintent

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclewithintent.databinding.CardLayoutBinding

class RecyclerAdapter(private val data: Data, private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener { v ->
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(itemView.context, SecondActivity::class.java)
                    val randomIndex = viewModel.getRandomNumber(position)
                    val imageUri = Uri.parse("android.resource://${itemView.context.packageName}/${data.images[randomIndex]}")
                    intent.putExtra("titleView", data.titles[randomIndex])
                    intent.putExtra("detailsView", data.details[randomIndex])
                    intent.putExtra("imgUri",imageUri.toString())
                    Log.d("RecyclerAdapter ", "the random index: $position")

                    itemView.context.startActivity(intent)
                }
            }
        }

        fun bind(title: String, detail: String, imageResId: Int) {
//            Log.d("RecyclerAdapter", "Binding title: $title, detail: $detail, imageResId: $imageResId")
            binding.itemImage.setImageResource(imageResId)
            binding.itemTitle.text = title
            binding.itemDetail.text = detail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val randomIndex = viewModel.getRandomNumber(position)
        holder.bind(data.titles[randomIndex], data.details[randomIndex], data.images[randomIndex])

    }

    override fun getItemCount(): Int {
        return data.titles.size
    }
}