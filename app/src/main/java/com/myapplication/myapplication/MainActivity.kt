package com.myapplication.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.myapplication.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonCalculator.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_calculator) {
            calculate()
        }
    }

    private fun isValidate(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrince.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {
        if (isValidate()){
            val distance = binding.editDistance.text.toString().toFloat()
            val prince = binding.editPrince.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * prince) / autonomy
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        } else {
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_LONG).show()
        }
    }
}