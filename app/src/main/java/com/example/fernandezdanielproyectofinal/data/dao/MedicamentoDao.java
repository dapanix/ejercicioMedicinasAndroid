package com.example.fernandezdanielproyectofinal.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MedicamentoDao {

    @Insert
    void insertar(Medicamento medicamento);

    @Query("SELECT * FROM medicamentos")
    List<Medicamento> obtenerTodos();

    //eliminar por id
    @Query("DELETE FROM medicamentos WHERE id = :id")
    void eliminarPorId(int id);
}
