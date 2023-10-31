package com.example.veterinaria.BaseDeDatos.Controlador

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.veterinaria.BaseDeDatos.Modelos.TRaza
@Dao
interface RazaDao {
    @Insert
    fun insert(tRaza: TRaza):Long
    @Query("SELECT * FROM  ${TRaza.TABLE_NAME}")
    fun traerTodo(): MutableList<TRaza>
    @Query("SELECT * FROM  ${TRaza.TABLE_NAME} WHERE ${TRaza.COL_ID} = :IDED ")
    fun traerId(IDED : Long):TRaza?
    @Update
    fun actualizar(tRaza: TRaza)
    @Delete
    fun eliminar(tRaza: TRaza)
}