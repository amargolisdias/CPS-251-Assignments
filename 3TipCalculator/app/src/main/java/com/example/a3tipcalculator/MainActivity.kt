package com.example.a3tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a3tipcalculator.databinding.ActivityMainBinding
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tipAmountOutput = binding.tipAmounts


        binding.calculateTipBtn.setOnClickListener{
            if(binding.editTextNumberDecimal.text.isNotEmpty()){
            val strTotal = binding.editTextNumberDecimal.text.toString()
            val dblTotal = strTotal.toDouble()
            val decimalFormatter = DecimalFormat("#,###.00")

            val billTen = dblTotal * .10
            val billFifteen = dblTotal * .15
            val billTwenty = dblTotal * .2
            tipAmountOutput.text = getString(R.string.tipAmountsRes,
                decimalFormatter.format(billTen),
                decimalFormatter.format(billFifteen),
                decimalFormatter.format(billTwenty))
        }else{
            tipAmountOutput.text = getString(R.string.tipAmountsError)
            }
        }
   }
}