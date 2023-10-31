package com.example.veterinaria.BaseDeDatos.Modelos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = TRaza.TABLE_NAME, indices = [Index(value = [TRaza.COL_NAME], unique = true)])
data class TRaza(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_ID) var Id: Long,
    @ColumnInfo(name = COL_NAME) var Nombre_Raza: String,
    @ColumnInfo(name = COL_TIPO) var tipo_Mascota: String
) {
    companion object {
        const val TABLE_NAME = "Raza"
        const val COL_ID = "Id"
        const val COL_NAME = "Nombre_Raza"
        const val COL_TIPO = "tipo"
    }
}
