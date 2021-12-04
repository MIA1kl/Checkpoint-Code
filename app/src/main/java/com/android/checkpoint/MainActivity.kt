package com.android.checkpoint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.checkpoint.adapter.MainAdapter
import com.android.checkpoint.model.ItemModel
import com.android.checkpoint.repository.MainRepository
import com.android.checkpoint.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : MainAdapter
    lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[MainViewModel::class.java]
//        val  mainRepository = MainRepository()
        main_RV.layoutManager=LinearLayoutManager(this)
        adapter = MainAdapter()
        main_RV.adapter = adapter

        vm.fetchAllPosts()

        vm.postModelListLiveData?.observe(this, Observer {
            if (it!=null){
                main_RV.visibility = View.VISIBLE
                adapter.swapData(it as ArrayList<ItemModel>)
            }else{
                Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
            }
        })

    }
}