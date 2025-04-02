package com.devtools.sphere.View.Home

import AutoSlidingBanner
import android.provider.CalendarContract.Colors
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devtools.sphere.Components.BookList
import com.devtools.sphere.Components.Texts
import com.devtools.sphere.Components.listAuthor
import com.devtools.sphere.Components.listVendors
import com.devtools.sphere.R
import com.devtools.sphere.ui.theme.SphereTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeView() {


    SphereTheme {


        val text = Texts()
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())



        var selectedItem by remember { mutableIntStateOf(0) }
        val items = listOf("Home", "Category", "Buy", "Perfil")
        val selectedIcons =
            listOf(Icons.Filled.Home, Icons.Filled.AccountBox,Icons.Filled.AccountBox,Icons.Filled.AccountBox)
        val unselectedIcons =
            listOf(
                Icons.Outlined.Home,
                Icons.Outlined.DateRange,
                Icons.Outlined.Clear,
                Icons.Outlined.Phone
            )



        Scaffold(

            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

            topBar = {

                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        scrolledContainerColor =MaterialTheme.colorScheme.tertiary ,
                        titleContentColor = MaterialTheme.colorScheme.secondary,
                    ),
                    title = {

                        Text(
                            "Home",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                    },

                    navigationIcon = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = null,
                                tint = Color(0xFF070707)
                            )
                        }
                    },

                    actions = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.notification),
                                contentDescription = null,
                                tint = Color(0xFF101010)
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,

                    )
            },


            bottomBar = {

                NavigationBar (containerColor = MaterialTheme.colorScheme.primary){

                    items.forEachIndexed { index, item ->

                        NavigationBarItem(
                            modifier = Modifier.background(MaterialTheme.colorScheme.primary),

                            icon = {
                                Icon(
                                    if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                                    contentDescription = item,
                                )
                            },
                            label = { Text(item,color = MaterialTheme.colorScheme.secondary) },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                        )


                    }
                }
            }

        ) { innerPadding ->


            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary)
                    .verticalScroll(rememberScrollState())
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {


                    AutoSlidingBanner()

                    Spacer(modifier = Modifier.padding(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),

                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        text.Text_title("Top of Week")

                        text.Text_body_medium("See all")

                    }

                    BookList()


                    Row(
                        modifier = Modifier.fillMaxWidth(),

                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        text.Text_title("Best Vendors")

                        text.Text_body_medium("See all")

                    }

                    listVendors()


                    Row(
                        modifier = Modifier.fillMaxWidth(),

                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        text.Text_title("Authors")

                        text.Text_body_medium("See all")

                    }

                    listAuthor()


                }


            }


        }


    }


}






