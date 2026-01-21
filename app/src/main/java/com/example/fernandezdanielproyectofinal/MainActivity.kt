package com.example.fernandezdanielproyectofinal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.fernandezdanielproyectofinal.data.dao.AppDatabase
import com.example.fernandezdanielproyectofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //codigo para iniciar la base de datos
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "medicinemed_db"
        ).allowMainThreadQueries().build()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //navegacion botones
        binding.btnEditar.setOnClickListener {
            val intent = Intent(this, EditarActivity::class.java)
            startActivity(intent)
        }
        binding.btnEscanear.setOnClickListener {
            val intent = Intent(this, EscanearActivity::class.java)
            startActivity(intent)
        }

        binding.btnConsultar.setOnClickListener {
            val intent = Intent(this, ConsultarActivity::class.java)
            startActivity(intent)
        }

    }
}
