package com.example.veterinaria.BaseDeDatos.Controlador

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.veterinaria.BaseDeDatos.Modelos.TRaza
import com.example.veterinaria.BaseDeDatos.Modelos.TipoMascota

@Dao
interface MascotaDao {
    @Insert
    fun insert(tMascota: TipoMascota):Long
    @Query("SELECT * FROM  ${TipoMascota.TABLE_NAME}")
    fun traerTodo(): List<TipoMascota>
    @Query("SELECT * FROM  ${TipoMascota.TABLE_NAME} WHERE ${TipoMascota.COL_ID} = :IDED ")
    fun traerId(IDED : Long):TipoMascota?
    @Update
    fun actualizar(tMascota: TipoMascota)
    @Delete
    fun eliminar(tMascota: TipoMascota)

}