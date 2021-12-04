package com.android.checkpoint.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.checkpoint.api.ApiClient
import com.android.checkpoint.api.RestInterface
import com.android.checkpoint.model.ItemModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository  {
    fun fetchAllPosts(): LiveData<List<ItemModel>> {
        val data = MutableLiveData<List<ItemModel>>()
//        ApiClient.getApiClient().fetchAllPosts()
        ApiClient.getApiClient()?.fetchAllPosts()?.enqueue(object : Callback<List<ItemModel>> {

            override fun onFailure(call: Call<List<ItemModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<ItemModel>>,
                response: Response<List<ItemModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }
            }
        })
        return data
    }
}