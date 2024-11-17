package com.example.coroutinesproject

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    val namesList = mutableListOf<nameAndNumber>()

    @SuppressLint("SuspiciousIndentation")
    fun addName(name: String) {
        val randomNumber = Random.nextInt(1000, 10000).toLong()
        namesList.add(nameAndNumber(name, randomNumber))
    }

    data class nameAndNumber(val name: String, val delayNumber: Long)
}