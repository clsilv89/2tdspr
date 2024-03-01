package com.caiosilva.aula28fev

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.caiosilva.aula28fev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        abrePrimeiroFragment()
        abreSegundoFragment()
    }

    private fun abrePrimeiroFragment() {
        val primeiroFragmento = PrimeiroFragment()

//        Passando onClickListener como interface para o método da classe View
//        binding.primeiroFragment.setOnClickListener(object : OnClickListener {
//            override fun onClick(v: View?) {
//
//            }
//        })

        val arguments = bundleOf("NomeDoUsuário" to "Caio")
        primeiroFragmento.arguments = arguments

        supportFragmentManager
            .beginTransaction()
            .replace(binding.primeiroFragment.id, primeiroFragmento)
            .commit()
    }

    private fun abreSegundoFragment() {
        val segundoFragment = SegundoFragment().newInstance("Caio Luz")

        supportFragmentManager
            .beginTransaction()
            .replace(binding.segundoFragment.id, segundoFragment)
            .commit()
    }
}
