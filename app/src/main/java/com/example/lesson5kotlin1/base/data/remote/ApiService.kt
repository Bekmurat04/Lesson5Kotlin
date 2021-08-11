package com.example.lesson5kotlin1.base.data.remote

import com.example.lesson5kotlin1.model.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("/youtube/v3/playlists")
    fun fetchAllPlayList(
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String
    ): Call<PlayList>


}