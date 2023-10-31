package com.example.veterinaria.BaseDeDatos.Controlador

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.veterinaria.BaseDeDatos.Modelos.TRaza
import com.example.veterinaria.BaseDeDatos.Modelos.Vacunas
@Dao
interface VacunasDao{
    @Insert
    fun insert(vacunas: Vacunas):Long
    @Query("SELECT * FROM  ${Vacunas.TABLE_NAME}")
    fun traerTodo(): MutableList<Vacunas>
    @Query("SELECT * FROM  ${Vacunas.TABLE_NAME} WHERE ${Vacunas.COL_ID} = :Ide ")
    fun traerId(Ide : Long): Vacunas?
    @Update
    fun actualizar(vacunas: Vacunas)
    @Delete
    fun eliminar(vacunas: Vacunas)
}