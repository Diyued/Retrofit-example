package com.example.retrofit_example

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.retrofit_example.data.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)
        textView.textSize = 18f
        textView.text = "Cargando pokemones..."
        setContentView(textView)

        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.instance.getPokemons()
            if (response.isSuccessful) {
                val pokemons = response.body()?.results
                runOnUiThread {
                    textView.text = pokemons?.joinToString("\n") { it.name }
                }
            } else {
                runOnUiThread {
                    textView.text = "Error al obtener datos"
                }
            }
        }
    }
}