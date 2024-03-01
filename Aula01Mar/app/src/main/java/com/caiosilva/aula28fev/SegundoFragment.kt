package com.caiosilva.aula28fev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf

class SegundoFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val nomeDeUsuario = arguments?.getString("NomeDoUsuário").orEmpty()
        println("O nome do usuário no Segundo Fragmento é: $nomeDeUsuario")
        return inflater.inflate(R.layout.fragment_segundo, container, false)
    }

    fun newInstance(nomeDeUsuario: String) = SegundoFragment().apply {
        val arguments = bundleOf("NomeDoUsuário" to nomeDeUsuario)
        this.arguments = arguments
    }
}