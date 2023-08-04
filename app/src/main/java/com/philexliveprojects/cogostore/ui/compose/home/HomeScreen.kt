package com.philexliveprojects.cogostore.ui.compose.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.ui.compose.utils.CoGoStoreAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onMenu: () -> Unit) {
    Scaffold(
        topBar = {
            CoGoStoreAppBar(
                navigationIcon = {
                    val coroutineScope = rememberCoroutineScope()
                    IconButton(
                        onClick = onMenu
                    ) {
                        Icon(Icons.Default.Menu, stringResource(R.string.menu))
                    }
                }
            )
        }
    ) { paddingValues ->
        Text("Home", Modifier.padding(paddingValues))
    }
}