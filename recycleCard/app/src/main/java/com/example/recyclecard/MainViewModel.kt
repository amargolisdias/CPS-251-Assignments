package com.example.recyclecard

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel(){
    private val randomNumber = mutableListOf<Int>()

    fun getRandomPos(size: Int){
        if (randomNumber.isEmpty()){
            repeat(size){
                randomNumber.add(Random.nextInt(0, size))
            }
        }
    }

    fun getRandomNumber(position : Int) : Int{
        return randomNumber[position]
    }

}