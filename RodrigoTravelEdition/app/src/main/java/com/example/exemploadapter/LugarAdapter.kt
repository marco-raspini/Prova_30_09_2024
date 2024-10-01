package com.example.exemploadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class LugarAdapter (

    private val context: Context,
    private val listaLugares : MutableList<Lugar>) : ArrayAdapter<Lugar>(context, 0, listaLugares) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // Pega a tareda atual do "FOR"
        val lugares = listaLugares.get(position)

        // Aponta qual layout será utulizado
        val view = LayoutInflater.from(context).inflate(R.layout.item_lugar, parent, false)

        // Pega os campos do layout escolhido
        val local = view.findViewById<TextView>(R.id.txtLocal)
        val data = view.findViewById<TextView>(R.id.txtData)
        val valor = view.findViewById<TextView>(R.id.txtCusto)

        // Joga o valor dos lugares para o campo da tela
        local.text = lugares.local
        data.text = lugares.data
        valor.text = lugares.valor

        return view
    }
}