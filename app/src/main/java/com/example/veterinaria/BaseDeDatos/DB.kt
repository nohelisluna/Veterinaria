package com.example.veterinaria.BaseDeDatos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.veterinaria.BaseDeDatos.Controlador.MascotaDao
import com.example.veterinaria.BaseDeDatos.Controlador.RazaDao
import com.example.veterinaria.BaseDeDatos.Modelos.TRaza
import com.example.veterinaria.BaseDeDatos.Modelos.TipoMascota
import com.example.veterinaria.BaseDeDatos.Modelos.Vacunas

@Database( entities = [TRaza::class,TipoMascota::class,Vacunas::class], version = 2, exportSchema = true)
abstract class DB:RoomDatabase(){
    abstract fun TMascota():MascotaDao
    abstract fun TRaza():RazaDao
    abstract fun TVacunas():Vacunas
    companion object{
        @Volatile
            private var Instancia: DB? = null
            fun obtenerDatos(context: Context):DB{
                if (Instancia!= null){
                    return Instancia!!
                }
                    Instancia = Room.databaseBuilder(
                        context.applicationContext,
                        DB::class.java,
                        "BaseMascotas"
                    ).build()
                return Instancia!!
            }

    }

}