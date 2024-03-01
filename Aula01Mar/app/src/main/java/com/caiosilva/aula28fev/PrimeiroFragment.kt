package com.caiosilva.aula28fev

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog

class PrimeiroFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val nomeDoUsuario = arguments?.getString("NomeDoUsuário").orEmpty()

        showDialog(nomeDoUsuario)

        return inflater.inflate(R.layout.fragment_primeiro, container, false)
    }

    private fun showDialog(string: String) {
        val dialog = AlertDialog.Builder(requireContext())

        dialog
            .setMessage(string)
            //Passando o click listener para o método do builder do Dialog
            // Funciona exatamente igual ao método que usamos nos botões do jankenpo.
            .setPositiveButton("Ok", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })
            .setNegativeButton("Oh no", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    //
                }
            })
            .show()
    }
}