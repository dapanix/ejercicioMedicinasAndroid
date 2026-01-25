package com.example.fernandezdanielproyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.fernandezdanielproyectofinal.data.dao.AppDatabase
import com.example.fernandezdanielproyectofinal.data.dao.Medicamento
import com.example.fernandezdanielproyectofinal.databinding.ActivityEditarBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class EditarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarBinding
    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "medicinemed_db"
        ).allowMainThreadQueries().build()

        binding = ActivityEditarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAnadir.setOnClickListener {

            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.dialog_anadir_medicina, null)

            dialog.setContentView(view)
            dialog.show()
        }
        binding.btnAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



        binding.btnRetirar.setOnClickListener {


            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.dialog_retirar_medicina, null)
            dialog.setContentView(view)

            val listView = view.findViewById<ListView>(R.id.listMedicinas)
            val btnEliminar = view.findViewById<Button>(R.id.btnEliminar)

            val medicinas = db.medicamentoDao().obtenerTodos()
            var seleccionada: Medicamento? = null

            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_single_choice,
                medicinas.map { it.nombre }
            )

            listView.adapter = adapter
            listView.choiceMode = ListView.CHOICE_MODE_SINGLE

            listView.setOnItemClickListener { _, _, position, _ ->
                seleccionada = medicinas[position]
            }

            btnEliminar.setOnClickListener {
                seleccionada?.let {
                    db.medicamentoDao().eliminarPorId(it.id)
                    dialog.dismiss()
                }
            }

            dialog.show()
        }
    }
}
