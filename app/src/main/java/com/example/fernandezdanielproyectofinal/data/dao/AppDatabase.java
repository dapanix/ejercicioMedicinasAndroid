package com.example.fernandezdanielproyectofinal.data.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.fernandezdanielproyectofinal.data.dao.Medicamento;
import com.example.fernandezdanielproyectofinal.data.dao.MedicamentoDao;

@Database(entities = {Medicamento.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MedicamentoDao medicamentoDao();
}
