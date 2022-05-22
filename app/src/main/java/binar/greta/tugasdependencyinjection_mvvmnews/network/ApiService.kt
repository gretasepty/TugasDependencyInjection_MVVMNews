package binar.greta.tugasdependencyinjection_mvvmnews.network

import binar.greta.tugasdependencyinjection_mvvmnews.model.GetAllNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    suspend fun getAllNews() : List<GetAllNewsItem>
}