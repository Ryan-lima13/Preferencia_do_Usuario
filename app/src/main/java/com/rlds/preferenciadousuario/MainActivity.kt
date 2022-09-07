package com.rlds.preferenciadousuario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rlds.preferenciadousuario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.cor1.setOnClickListener {

        }
        binding.cor2.setOnClickListener {

        }
        binding.cor3.setOnClickListener {

        }
        binding.cor4.setOnClickListener {

        }
    }
}