package com.example.veterinaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.veterinaria.BaseDeDatos.DB
import com.example.veterinaria.BaseDeDatos.Modelos.TRaza
import com.example.veterinaria.BaseDeDatos.Modelos.TipoMascota
import com.example.veterinaria.databinding.ActivityMainBinding
import com.example.veterinaria.databinding.ActivityRegistroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class registro : AppCompatActivity() {
    lateinit var binding: ActivityRegistroBinding
    private lateinit var razaa: TRaza
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnraza.setOnClickListener {
            startActivity(Intent(this@registro, raza::class.java ))
        }
        binding.tipomascota.setOnClickListener {
            startActivity(Intent(this@registro,registrartipomascota::class.java))
        }
//        binding.apply {
////                btnAgRaza.setOnClickListener {
////                    try {
////                        razaa=TRaza(0,textRaza.text.toString().trim(),edtTipo.text.toString().trim())
////                        agregarRaza(razaa)
////                        Toast.makeText(this@registro, "Agregado Exitosamente", Toast.LENGTH_SHORT).show()
////                    }catch (e:Exception){
////                        Toast.makeText(this@registro, "no se agrego${e.message}", Toast.LENGTH_SHORT).show()
////                    }
////                }
////            btnLeer.setOnClickListener {
////                CoroutineScope(Dispatchers.IO).launch {
////                    var cuentaderaza = DB.obtenerDatos(this@registro).TRaza().traerTodo().size
////                    runOnUiThread {
////                        Toast.makeText(this@registro, "numero de datos en raza $cuentaderaza", Toast.LENGTH_SHORT).show()
////                    }
////                }
////            }
//        }
    }
//    fun agregarRaza(raza: TRaza){
//        CoroutineScope(Dispatchers.IO).launch {
//            DB.obtenerDatos(this@registro).TRaza().insert(raza)
//        }
//    }
}