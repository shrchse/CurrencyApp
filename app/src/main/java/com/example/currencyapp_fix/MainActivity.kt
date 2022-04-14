package com.example.currencyapp_fix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyapp_fix.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.konversi.setOnClickListener { convert() }
    }

    private fun convert(){
        val stringInTextField = binding.moneyValue.text.toString()
        val input = stringInTextField.toDoubleOrNull()
            if(input == null) {
                binding.result.text = ""
                return
            }
        val currency = when (binding.moneyCurrency.checkedRadioButtonId) {
            R.id.US -> 14500
            R.id.EU -> 15500
            R.id.Jpn -> 115
            R.id.EAU -> 3800
            else -> 1
        }
        val indonesia = Locale ("in", "ID")
        val current = currency * input
        val formattedOut = NumberFormat.getCurrencyInstance(indonesia).format(current)
        binding.result.text = getString(R.string.count, formattedOut)
    }
}

