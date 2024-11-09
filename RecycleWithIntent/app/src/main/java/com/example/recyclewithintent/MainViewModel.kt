package com.example.recyclewithintent

//import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel(){
    private val randomNumber = mutableListOf<Int>()

    fun getRandomPos(size: Int){
        if (randomNumber.isEmpty()){
            repeat(size){
                randomNumber.add(Random.nextInt(0, size))
//                Log.d("MainViewModel", "randomNumberList: $randomNumber ")

            }
            randomNumber.shuffle()
//            Log.d("MainViewModel", "AFTERSHUFFLENumberList: $randomNumber ")
        }
    }

    fun getRandomNumber(position : Int) : Int{
//        Log.d("MainViewModel", "getRandomNumber: $position ")
        return randomNumber[position]


    }

}