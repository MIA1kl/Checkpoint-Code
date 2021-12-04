package com.android.checkpoint.api

import com.android.checkpoint.model.ItemModel
import retrofit2.Call
import retrofit2.http.GET

interface RestInterface {
    @GET("ncafe/products/county")
    fun fetchAllPosts(): Call<List<ItemModel>>
}