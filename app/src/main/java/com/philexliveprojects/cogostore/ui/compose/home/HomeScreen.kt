package com.philexliveprojects.cogostore.ui.compose.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.philexliveprojects.cogostore.R

@Composable
fun HomeScreen(onMenu: () -> Unit) {
    HomeScreenContent(onMenu)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenContent(onMenu: () -> Unit = {}) {
    Scaffold(
        topBar = {
            CoGoStoreAppBar(
                navigationIcon = {
                    IconButton(onMenu) { Icon(Icons.Default.Menu, stringResource(R.string.menu)) }
                }
            )
        }
    ) { paddingValues ->
        Text("Home", Modifier.padding(paddingValues))
    }
}

@Composable
fun CoGoStoreAppBar(
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable (RowScope.() -> Unit) = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shadowElevation = 2.dp
    ) {
        Box(
            Modifier
                .fillMaxWidth()
        ) {
            Box(Modifier.align(Alignment.CenterStart)) { navigationIcon() }
            Image(
                painterResource(R.drawable.logo),
                null,
                Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
            Row(Modifier.align(Alignment.CenterEnd)) {
                actions()
            }
        }
    }
}