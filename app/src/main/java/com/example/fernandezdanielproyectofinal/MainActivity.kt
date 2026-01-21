package com.example.fernandezdanielproyectofinal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fernandezdanielproyectofinal.databinding.ActivityMainBinding

//Dani justifica tus faltas
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEditar.setOnClickListener{
            //val intent = Intent(this, ::class.java)
            startActivity(intent)
        }
    }
}
