package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.ui.compose.home.HomeScreen
import com.philexliveprojects.cogostore.ui.theme.CoGoStoreTheme
import kotlinx.coroutines.launch

const val Home = "home"

@Composable
fun CoGoStoreApp() {
    CoGoStoreAppContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CoGoStoreAppContent() {
    val navDrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = { DrawerContent() },
        drawerState = navDrawerState
    ) {
        Scaffold(
            topBar = {
                CoGoStoreAppBar(
                    navigationIcon = {
                        val coroutineScope = rememberCoroutineScope()
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    navDrawerState.snapTo(DrawerValue.Open)
                                }
                            }
                        ) {
                            Icon(Icons.Default.Menu, stringResource(R.string.menu))
                        }
                    }
                )
            }
        ) { paddingValues ->
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Home) {
                composable(route = Home) {
                    HomeScreen(Modifier.padding(paddingValues))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DrawerContent() {
    ModalDrawerSheet {
        Header()
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .background(Color.Cyan)
    ) {
        /* TODO */
    }
}

@Composable
fun CoGoStoreAppBar(
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable (RowScope.() -> Unit) = {}
) {
    Surface(modifier.fillMaxWidth(), shadowElevation = 2.dp) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Box(Modifier.align(Alignment.TopStart)) { navigationIcon() }
            Icon(
                painterResource(R.drawable.ic_launcher_foreground),
                null,
                Modifier.align(Alignment.TopCenter)
            )
            Row(Modifier.align(Alignment.TopEnd)) {
                actions()
            }
        }
    }
}

@Preview
@Composable
fun CoGoStoreAppContentPreview() {
    CoGoStoreTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CoGoStoreAppContent()
        }
    }
}