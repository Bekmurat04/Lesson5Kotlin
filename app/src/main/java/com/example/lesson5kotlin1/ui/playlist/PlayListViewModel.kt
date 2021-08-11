package com.example.lesson5kotlin1.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lesson5kotlin1.`object`.Constant
import com.example.lesson5kotlin1.base.BaseViewModel
import com.example.lesson5kotlin1.base.data.remote.ApiService
import com.example.lesson5kotlin1.base.data.remote.RetrofitClient
import com.example.lesson5kotlin1.model.PlayList
import retrofit2.Callback
import retrofit2.Response

class PlayListViewModel : BaseViewModel() {

    fun  fetchPlayList(): LiveData<PlayList> {
        return fetchYouTubeApiPlayList()

    }

    private var  apiService: ApiService? = null

    private fun fetchYouTubeApiPlayList(): LiveData<PlayList> {
        apiService = RetrofitClient.create()

        val data = MutableLiveData<PlayList>()

        apiService?.fetchAllPlayList(Constant.API_KEY,Constant.PART,Constant.CHANNEL_ID)?.
        enqueue(object:Callback<PlayList>{
            override fun onResponse(call: retrofit2.Call<PlayList>, response: Response<PlayList>) {
                data.value = response.body()

            }

            override fun onFailure(call: retrofit2.Call<PlayList>, t: Throwable) {
                data.value = null

            }

        })

        return data
    }




}