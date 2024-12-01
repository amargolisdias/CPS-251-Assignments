package com.example.stopwatchbound

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stopwatchbound.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var isBound = false
    private lateinit var binding: ActivityMainBinding

//    private fun updateElapsedTime() {
//        binding.timeTextView.postDelayed({
//            if (isBound && stopwatchService != null) {
//                // Retrieve the elapsed time from the service
//                val elapsedTime = stopwatchService?.getElapsedTime() ?: 0L
//                // Calculate hours, minutes, and seconds from elapsed time
//                val seconds = (elapsedTime / 1000) % 60
//                val minutes = (elapsedTime / (1000 * 60)) % 60
//                val hours = (elapsedTime / (1000 * 60 * 60)) % 24
//                // Update the UI with the formatted time
//                binding.timeTextView.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
//            }
//            // Re-run updateElapsedTime every second
//            updateElapsedTime()
//        }, 1000)
//    }

    //prefab code from the site
//    private val updateRunnable = object : Runnable {
//        override fun run() {
//            if (running) {
//                val timeNow = SystemClock.elapsedRealtime()
//                elapsedTime = timeNow - startTime
//                handler.postDelayed(this, 100)
//            }
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
    }


}