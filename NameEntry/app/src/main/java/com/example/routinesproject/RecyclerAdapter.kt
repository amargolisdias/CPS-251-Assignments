package com.example.coroutinesproject

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import com.example.coroutinesproject.databinding.CardLayoutBinding


class RecyclerAdapter(private val names: MutableList<MainViewModel.nameAndNumber>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        private val coroutineScope = CoroutineScope(Dispatchers.Main)

        fun bind(nameAndNumber: MainViewModel.nameAndNumber) {

            coroutineScope.launch {
                binding.nameAndTime.text = "name and delay time loading"

                val fullString = "The name is ${nameAndNumber.name} and the delay was ${nameAndNumber.delayNumber}"
                Log.d("RecyclerAdapter", "Starting Delay for ${nameAndNumber.name}")
                Log.d("RecyclerAdapter", "Starting Delay for ${nameAndNumber.delayNumber}")
                delay(nameAndNumber.delayNumber)
                Log.d("RecyclerAdapter", "Starting Delay for ${nameAndNumber.name}")
                Log.d("RecyclerAdapter", "Finishing Delay for ${nameAndNumber.delayNumber}")
                binding.nameAndTime.text = fullString
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val nameAndNumber = names[position]
        holder.bind(nameAndNumber)
    }

    override fun getItemCount(): Int = names.size
}