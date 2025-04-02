package com.devtools.sphere.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devtools.sphere.Model.ModelVendors
import com.devtools.sphere.data.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ViewModel_Vendor (private val  repository: BookRepository) : ViewModel() {


    private  val _vendors = MutableStateFlow<List<ModelVendors>>(emptyList())

    val vendors : StateFlow<List<ModelVendors>> = _vendors



    init {

        loadVendors()

    }

    private fun loadVendors(){

        _vendors.value= BookRepository().getVendors()


    }


    companion object {


        fun provideFactory( repository: BookRepository) : ViewModelProvider.Factory
                = object : ViewModelProvider.Factory {


            @Suppress("UNCHECKED_CAST")
            @Override
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ViewModel_Vendor(repository) as T
            }

        }


    }


}