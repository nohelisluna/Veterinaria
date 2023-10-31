package com.example.veterinaria

import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veterinaria.BaseDeDatos.DB
import com.example.veterinaria.BaseDeDatos.Modelos.TRaza
import com.example.veterinaria.BaseDeDatos.Modelos.TipoMascota
import com.example.veterinaria.BaseDeDatos.adaptador.AdaptadorTipo
import com.example.veterinaria.databinding.ActivityMainBinding
import com.example.veterinaria.databinding.ActivityRazaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class raza : AppCompatActivity() {
    lateinit var binding: ActivityRazaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRazaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        LlenarSpinner()
        LlenarRecycle()
    }

    fun LlenarRecycle(){
        runOnUiThread {
            var lista=DB.obtenerDatos(this@raza).TRaza().traerTodo()
            binding.rcRaza.layoutManager= LinearLayoutManager(this@raza)
            binding.rcRaza.adapter = AdaptadorTipo(lista)
        }

    }
        fun LlenarSpinner(){
            CoroutineScope(Dispatchers.IO).launch {
            var list=DB.obtenerDatos(this@raza).TMascota().traerTodo()
            var count=DB.obtenerDatos(this@raza).TMascota().traerTodo().size
            runOnUiThread {
                var adaptador=ArrayAdapter(this@raza, android.R.layout.simple_spinner_dropdown_item,list)
                binding.spinner3.adapter=adaptador
                binding.spinner3.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    }
                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }
                }
            }
        }
    }
}