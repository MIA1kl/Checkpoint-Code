package com.android.checkpoint.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.checkpoint.model.ItemModel
import com.android.checkpoint.repository.MainRepository

class MainViewModel: ViewModel() {
    private var homeRepository: MainRepository?=null
    var postModelListLiveData : LiveData<List<ItemModel>>?=null

    init {
        homeRepository = MainRepository()
        postModelListLiveData = MutableLiveData()
    }

    fun fetchAllPosts(){
        postModelListLiveData = homeRepository?.fetchAllPosts()
    }
}