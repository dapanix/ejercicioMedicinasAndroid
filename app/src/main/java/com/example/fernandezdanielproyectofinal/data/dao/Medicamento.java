package com.example.fernandezdanielproyectofinal.data.dao;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medicamentos")
public class Medicamento {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nombre;
    public String dosis;

}
