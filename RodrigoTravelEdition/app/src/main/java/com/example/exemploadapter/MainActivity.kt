package com.example.exemploadapter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private val listaDeLugares = mutableListOf<Lugar>()
    //private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Busca as variáveis de acordo com o ID setado em tela.

        val txtDestino = findViewById<EditText>(R.id.txtLocalViagem);
        val txtData = findViewById<EditText>(R.id.txtDataViagem)
        val txtValor = findViewById<EditText>(R.id.txtValorGasto)


        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val listViewLugares = findViewById<ListView>(R.id.listViewLugares)


        // Criando uma porte e usando o Layout do Android
        //adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDeTarefas)


        val adapter = LugarAdapter(this, listaDeLugares)


        // Vinculando o meu adapter com a minha view
        listViewLugares.adapter = adapter

        btnCadastrar.setOnClickListener{

            val destino = txtDestino.text.toString()
            val dataViagem = txtData.text.toString()
            val valorGasto = txtValor.text.toString()

            if(destino.isNotEmpty()){

                val novoLocal = Lugar(destino , dataViagem, valorGasto)

                listaDeLugares.add(novoLocal)
                adapter.notifyDataSetChanged()


                txtDestino.text.clear()
                txtData.text.clear()
                txtValor.text.clear()
            }
        }
    }
}