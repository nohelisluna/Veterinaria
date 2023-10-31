package com.example.veterinaria.BaseDeDatos.Modelos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName =  Vacunas.TABLE_NAME , indices = [ Index(value = [Vacunas.COL_NAME], unique = true) ] )
data class Vacunas(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_ID) var Id:Long,
    @ColumnInfo(name = COL_NAME) var Nombre_Vacuna:String
)
{
    companion object {
        const val TABLE_NAME = "Vacunas"
        const val COL_ID = "Id"
        const val COL_NAME = "Nombre_Vacuna"
    }
}
