package com.devtools.sphere.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devtools.sphere.Model.ModelAuthors
import com.devtools.sphere.Model.ModelVendors
import com.devtools.sphere.data.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ViewModelAuthor (private val repository: BookRepository): ViewModel() {


    private  val _authors = MutableStateFlow<List<ModelAuthors>>(emptyList())

    val authors : StateFlow<List<ModelAuthors>> = _authors


    init {

        loadAuthors()

    }

    private fun loadAuthors(){

        _authors.value= BookRepository().getAuthors()


    }


    companion object {


        fun provideFactory( repository: BookRepository) : ViewModelProvider.Factory
                = object : ViewModelProvider.Factory {


            @Suppress("UNCHECKED_CAST")
            @Override
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ViewModelAuthor(repository) as T
            }

        }


    }




}