package com.example.nameentry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.nameentry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button.setOnClickListener {
            viewModel.addNames(binding.editText.text.toString())
            if(binding.editText.text.isEmpty()){
                binding.textView.text = getString(R.string.errorMessage)
            }else{
            val names = viewModel.getNameList()
            val formattedStringList = names.joinToString("\n")
            binding.textView.text = formattedStringList
            binding.editText.text.clear()}

        }
        if(viewModel.getNameList().isEmpty()){
            binding.textView.text = getString(R.string.defaultMessage)
        }else {
            val names = viewModel.getNameList()
            val formattedStringList = names.joinToString("\n")
            binding.textView.text = formattedStringList
        }
    }
}
