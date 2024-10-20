package com.example.nameentry
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var nameList = mutableListOf<String>()

    fun addNames(userInput: String){
        if(userInput.isNotEmpty()){
            nameList.add(userInput)
        } else{
            return
        }
    }

    fun getNameList(): MutableList<String> {
        return nameList
    }



}