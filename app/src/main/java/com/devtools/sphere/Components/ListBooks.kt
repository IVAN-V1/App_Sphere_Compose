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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devtools.sphere.Model.ModelBook
import com.devtools.sphere.R
import com.devtools.sphere.ViewModel.ViewModel_Book
import com.devtools.sphere.data.BookRepository
import com.devtools.sphere.ui.theme.SphereTheme


@Preview
@Composable
fun BookList() {


    val boookRepository= remember { BookRepository() }


    val bookViewmodel: ViewModel_Book = viewModel(

        factory = ViewModel_Book.provideFactory(boookRepository)
    )

    val bookListState : State<List<ModelBook>> =bookViewmodel.book.collectAsState()

    val bookList =bookListState.value


    SphereTheme {

        LazyRow {

            items(bookList.size) { index ->

                if (bookList.isNotEmpty()) {

                    BookItem(bookList[index])


                }

                else {
                    Text(text = "No hay libros disponibles.")
                }

            }

        }

    }

}


@Composable
fun BookItem(book_item: ModelBook) {


    Box(modifier = Modifier.fillMaxWidth().padding(8.dp) ){

                Column(modifier = Modifier.background(MaterialTheme.colorScheme.primary,).padding(8.dp)) {


                    Image(
                        painter = painterResource(id = book_item.img),
                        contentDescription = book_item.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(150.dp)
                            .width(127.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = book_item.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = book_item.price,
                        fontSize = 14.sp,
                        color = Color.Black
                    )

                }








    }


}















