package com.example.lesson5kotlin1.base.data.remote

import com.example.lesson5kotlin1.`object`.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    companion object{
        fun create() : ApiService{

            val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .build()

            val retrofit  = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .client(okHttpClient)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}