package com.example.recyclewithintent


import android.net.Uri
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclewithintent.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Main Activity 2"

        val inTitle = intent.getStringExtra("titleView")
        val textView = binding.textView
        textView.text = inTitle

        val inDetails = intent.getStringExtra("detailsView")
        val textView2 = binding.textView2
        textView2.text = inDetails

        val inImage = intent.getStringExtra("imgUri")
        val parsedInImage = Uri.parse(inImage)
        binding.imageView.setImageURI(parsedInImage)


    }
}