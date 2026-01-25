package com.example.fernandezdanielproyectofinal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fernandezdanielproyectofinal.databinding.ActivityConsultarBinding

class ConsultarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConsultarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConsultarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}