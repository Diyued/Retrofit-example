package com.example.retrofit_example

import com.example.retrofit_example.data.network.RetrofitClient
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*

class ApiTest {

    @Test
    fun testGetPokemons() = runBlocking {
        // Llamada a la API
        val response = RetrofitClient.instance.getPokemons()

        // Verifica que la respuesta fue exitosa
        assertTrue("La respuesta no fue exitosa", response.isSuccessful)

        // Obtiene el cuerpo de la respuesta
        val body = response.body()

        // Verifica que la lista de pokemones no sea nula ni vacía
        assertNotNull("El cuerpo de la respuesta es nulo", body)
        assertTrue("No se obtuvieron pokemones", body!!.results.isNotEmpty())

        // Imprime los nombres (opcional, solo para verlos en la consola)
        println("Pokemones obtenidos:")
        body.results.forEach { println(it.name) }
    }
}