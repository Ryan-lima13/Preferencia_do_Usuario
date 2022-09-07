package com.rlds.preferenciadousuario

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.rlds.preferenciadousuario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding
    private  var  cor = ""
    companion object{
        const val ARQUIVO_PREFERENCIAS = "arquivoPreferencias"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.cor1.setOnClickListener {
            cor = "#FF03DAC5"
            salvar(cor)


        }
        binding.cor2.setOnClickListener {
            cor = "#FFBB86FC"
            salvar(cor)

        }
        binding.cor3.setOnClickListener {
            cor = "#EC0404"
            salvar(cor)

        }
        binding.cor4.setOnClickListener {
            cor = "#03A9F4"
            salvar(cor)

        }
    }
    private fun salvar(cor:String){
        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        binding.btTrocarFundo.setOnClickListener {view ->
            val preferencias = getSharedPreferences(ARQUIVO_PREFERENCIAS, MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("cor",cor)
            editor.apply()
            snackBar(view)
        }


    }
    private fun snackBar(view:View){
        val snabar = Snackbar.make(view,"Cor de fundo alterada com sucesso!",
            Snackbar.LENGTH_INDEFINITE )
        snabar.setAction("Ok"){

        }
        snabar.setActionTextColor(Color.BLUE)
        snabar.setBackgroundTint(Color.WHITE)
        snabar.setTextColor(Color.BLACK)
        snabar.show()

    }

    override fun onResume() {
        super.onResume()
        val preferencias = getSharedPreferences(ARQUIVO_PREFERENCIAS, MODE_PRIVATE)
        val cor = preferencias.getString("cor", "")
        if(cor!!.isNotEmpty()){
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
    }
}