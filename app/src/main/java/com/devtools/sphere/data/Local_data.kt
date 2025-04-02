package com.devtools.sphere.data

import com.devtools.sphere.Model.ModelAuthors
import com.devtools.sphere.Model.ModelBook
import com.devtools.sphere.Model.ModelVendors
import com.devtools.sphere.R

class Local_data {

    val listBooks = listOf(

        ModelBook(R.drawable.kite, "The Kite Runner", "$14.99"),
        ModelBook(R.drawable.the_subtle, "The Kite Runner", "$20.99"),
        ModelBook(R.drawable.kite, "The Art of War", "$14.99"),
        ModelBook(R.drawable.nerts, "Nertst Garnn", "$14.99"),
        ModelBook(R.drawable.eldoria, "The Charncles of Doria", "$14.99"),

        )


    var listVendors = listOf(

        ModelVendors(R.drawable.ws),
        ModelVendors(R.drawable.kuromi),
        ModelVendors(R.drawable.gooday),
        ModelVendors(R.drawable.crane),



        )



    var listAuthor = listOf(

        ModelAuthors(R.drawable.john,"John Freeman", "write"),
        ModelAuthors(R.drawable.tess,"Tess Gunty","Novelist"),
        ModelAuthors(R.drawable.richart,"Richard Perston","Writer"),

        )



}