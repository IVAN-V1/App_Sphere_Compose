package com.devtools.sphere.data

import com.devtools.sphere.Model.ModelAuthors
import com.devtools.sphere.Model.ModelBook
import com.devtools.sphere.Model.ModelVendors
import com.devtools.sphere.R

class BookRepository {


    fun getBooks(): List<ModelBook> {

        return Local_data().listBooks

    }


    fun getVendors(): List<ModelVendors> {
        return Local_data().listVendors
    }


    fun getAuthors(): List<ModelAuthors> {

        return Local_data().listAuthor

    }


}