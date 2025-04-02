package com.devtools.sphere.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devtools.sphere.Model.ModelBook
import com.devtools.sphere.data.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ViewModel_Book (private val  repository: BookRepository) : ViewModel() {

    private  val _books = MutableStateFlow<List<ModelBook>>(emptyList())

    val book : StateFlow<List<ModelBook>> = _books

    init {


        LoadBooks()

    }


   private fun LoadBooks(){

    _books.value= BookRepository().getBooks()


    }


    companion object {

        fun  provideFactory( repository: BookRepository) : ViewModelProvider.Factory
        = object : ViewModelProvider.Factory {


            @Suppress("UNCHECKED_CAST")
            @Override
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ViewModel_Book(repository) as T
            }

        }


    }


}