package com.example.lab4_111360120

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.lab4_111360120.R

class MainActivity : AppCompatActivity() {
    private lateinit var tvMeal: TextView
    private lateinit var btnSelect: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMeal = findViewById(R.id.tv_meal)
        btnSelect = findViewById(R.id.btn_choice)

        val resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == 101) {
                result.data?.extras?.let { bundle ->
                    val drink = bundle.getString("drink")
                    val sugar = bundle.getString("sugar")
                    val ice = bundle.getString("ice")
                    tvMeal.text = "飲料: $drink\n\n甜度: $sugar\n\n冰塊: $ice"
                }
            }
        }

        btnSelect.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            resultLauncher.launch(intent)
        }
    }
}
