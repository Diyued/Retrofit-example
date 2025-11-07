package com.example.retrofit_example.data.network

import com.example.retrofit_example.data.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("pokemon?limit=10")
    suspend fun getPokemons(): Response<PokemonResponse>
}

data class PokemonResponse(val results: List<Pokemon>)
