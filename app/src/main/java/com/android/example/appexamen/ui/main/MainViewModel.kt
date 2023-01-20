package com.android.example.appexamen.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.appexamen.model.Category
import com.android.example.appexamen.repository.RepositoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel : ViewModel() {

    val repository : RepositoryService by lazy { RepositoryService() }

    private var _listCategories = MutableLiveData<List<String>>()
    val lisCategory: LiveData<List<String>>
        get() = _listCategories


    private val _category = MutableLiveData<Category>()
    val category : LiveData<Category>
        get() = _category

    var categorySelected : String = ""


    fun getListCategories(){

        viewModelScope.launch(Dispatchers.IO)
        {
            try {
                val result = repository.getListCategories()
                _listCategories.postValue(result)
            }catch (e:HttpException){
                _listCategories.postValue(listOf("Error"))
            }
        }
    }

    fun getCategory(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getCategory(categorySelected)
                _category.postValue(result)

            }catch (e:HttpException){
                Log.i("viewModel","Error")
            }
        }

    }

}