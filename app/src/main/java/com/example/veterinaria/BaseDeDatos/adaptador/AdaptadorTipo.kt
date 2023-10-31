package com.example.veterinaria.BaseDeDatos.adaptador

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinaria.BaseDeDatos.DB
import com.example.veterinaria.BaseDeDatos.Modelos.TRaza
import com.example.veterinaria.BaseDeDatos.Modelos.TipoMascota
import com.example.veterinaria.databinding.LaymostrarrazaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdaptadorTipo(var list: MutableList<TRaza>):RecyclerView.Adapter<AdaptadorTipo.ViewTipo>() {
    inner class ViewTipo(var binding: LaymostrarrazaBinding):RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewTipo {
            return ViewTipo(LaymostrarrazaBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun getItemCount(): Int =list.size
    override fun onBindViewHolder(holder: ViewTipo, position: Int) {

        var raza = list[position]
        var binding= holder.binding
        raza.apply {
            binding.apply {
                textRaza.text =  TRaza.COL_NAME
                txttipo.text= TRaza.COL_TIPO
                btndelet.setOnClickListener {
                    AlertDialog.Builder(binding.root.context).setMessage("Desea Eliminar el campo ${TRaza.COL_NAME}").setPositiveButton("Aceptar"){view,b->
                        CoroutineScope(Dispatchers.IO).launch {
                            DB.obtenerDatos(binding.root.context).TRaza().eliminar(raza)
                        }
                        list.remove(raza)
                        this@AdaptadorTipo.notifyItemRemoved(position)
                    }
                        .setNegativeButton("Cancelar"){_,_ ->
                            Toast.makeText(binding.root.context, "Se Canceló", Toast.LENGTH_SHORT)
                                .show()
                        }.create().show()
                }
            }
        }
    }
}