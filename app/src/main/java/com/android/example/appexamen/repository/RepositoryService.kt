package com.android.example.appexamen.repository

import com.android.example.appexamen.model.Category
import com.android.example.appexamen.network.ApiObject

class RepositoryService {

    suspend fun getListCategories():List<String>{
       return ApiObject.retrofitService.getListCategories()

    }

    suspend fun getCategory(nameCategory: String):Category{
        return ApiObject.retrofitService.getCategory(nameCategory)
    }
}