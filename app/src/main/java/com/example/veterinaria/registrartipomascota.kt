package com.example.veterinaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.veterinaria.BaseDeDatos.DB
import com.example.veterinaria.BaseDeDatos.Modelos.TipoMascota
import com.example.veterinaria.databinding.ActivityRazaBinding
import com.example.veterinaria.databinding.ActivityRegistrartipomascotaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class registrartipomascota : AppCompatActivity() {
    lateinit var tipo: TipoMascota
    lateinit var binding: ActivityRegistrartipomascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistrartipomascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnGuardar.setOnClickListener {
                try{
                    tipo = TipoMascota(0,edtTipo.text.toString().trim())
                    aggTipoMascota(tipo)
                    Toast.makeText(this@registrartipomascota, "Agregado Exitosamente", Toast.LENGTH_SHORT).show()
                }catch (e:Exception)
                {
                    Toast.makeText(this@registrartipomascota, "no se agrego${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun aggTipoMascota(tipo:TipoMascota){
        CoroutineScope(Dispatchers.IO).launch {
            DB.obtenerDatos(this@registrartipomascota).TMascota().insert(tipo)
        }

    }
}