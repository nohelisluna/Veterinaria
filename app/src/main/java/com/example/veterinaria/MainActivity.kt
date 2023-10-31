package com.example.veterinaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.veterinaria.BaseDeDatos.DB
import com.example.veterinaria.BaseDeDatos.Modelos.TRaza
import com.example.veterinaria.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
          timer()
          binding.calendario.animate()
              .setDuration(5000)
              .scaleY(2f)
              .scaleX(2f)
      }
    fun timer(){
        var time=  7
        var tiempo = object : CountDownTimer(7000,1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.txtTiempo.text="$time"
                time--
            }
            override fun onFinish() {
                startActivity(Intent(this@MainActivity, registro::class.java))
            }
        }
        tiempo.start()
    }
}