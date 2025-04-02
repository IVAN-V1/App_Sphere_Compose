package com.devtools.sphere.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devtools.sphere.Model.ModelBook
import com.devtools.sphere.Model.ModelVendors
import com.devtools.sphere.ViewModel.ViewModel_Vendor
import com.devtools.sphere.data.BookRepository
import com.devtools.sphere.ui.theme.SphereTheme

@Composable
@Preview
fun listVendors (){


    val boookRepository= remember { BookRepository() }


    val vendorViewModel: ViewModel_Vendor = viewModel(

        factory = ViewModel_Vendor.provideFactory(boookRepository)
    )

    val bookListState : State<List<ModelVendors>> =vendorViewModel.vendors.collectAsState()

    val listVendors =bookListState.value


    SphereTheme {

        LazyRow {

            items(listVendors.size) { index ->

                VendorItem(listVendors[index])

            }

        }

    }



}


@Composable
fun VendorItem(book_item: ModelVendors) {

    Box(modifier = Modifier.fillMaxWidth().padding(8.dp) ){


        Column(modifier = Modifier.background(MaterialTheme.colorScheme.tertiary,).padding(8.dp)) {



                Image(
                    painter = painterResource(id = book_item.img),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(9.dp)
                        )

                )


            }



        }



}




