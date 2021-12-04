package com.android.checkpoint.model

 data class ItemModel (
     val id: Int,
     val title:String,
     val description:String,
     val category_name: String,
     val image: String,
     val isPopular: Boolean,
     val price : Int,
     val county:Int,
 )