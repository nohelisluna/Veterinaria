package com.example.veterinaria.BaseDeDatos.Modelos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = TipoMascota.TABLE_NAME, indices = [ Index(value = [TipoMascota.COL_NAME], unique = true) ] )
data class TipoMascota(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_ID) var id:Long,
    @ColumnInfo(name = COL_NAME) var Ntipomascota:String)
    {
        companion object {
            const val TABLE_NAME = "TipoDeMascota"
            const val COL_ID = "id"
            const val COL_NAME = "Ntipomascota"
        }

        override fun toString(): String {
            return "$Ntipomascota"
        }
    }
