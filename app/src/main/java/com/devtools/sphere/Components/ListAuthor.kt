package com.devtools.sphere.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devtools.sphere.Model.ModelAuthors
import com.devtools.sphere.ViewModel.ViewModelAuthor
import com.devtools.sphere.data.BookRepository
import com.devtools.sphere.ui.theme.SphereTheme

@Composable
@Preview
fun listAuthor (){


    val boookRepository= remember { BookRepository() }


    val vendorViewModel: ViewModelAuthor = viewModel(

        factory = ViewModelAuthor.provideFactory(boookRepository)
    )

    val bookListState : State<List<ModelAuthors>> =vendorViewModel.authors.collectAsState()

    val bookAuthors =bookListState.value


    SphereTheme {

        LazyRow {

            items(bookAuthors.size) { index ->

                AuthorItem(bookAuthors[index])

            }

        }

    }



}


@Composable
fun AuthorItem(AuthorItem: ModelAuthors) {


    Box(modifier = Modifier.fillMaxWidth().padding(8.dp) ){


        Column(modifier = Modifier.background(MaterialTheme.colorScheme.primary,).padding(8.dp)) {



                Image(
                    painter = painterResource(id = AuthorItem.img),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(102.dp)
                        .height(102.dp)
                        .clip(
                            CircleShape
                        )

                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = AuthorItem.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = AuthorItem.work,
                    fontSize = 14.sp,
                    color = Color.Gray
                )


            }



        }



}




