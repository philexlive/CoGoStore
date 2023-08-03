package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.ui.compose.home.HomeScreen
import com.philexliveprojects.cogostore.ui.compose.wishlist.WishlistScreen
import com.philexliveprojects.cogostore.ui.theme.CoGoStoreTheme
import kotlinx.coroutines.launch

@Composable
fun CoGoStoreApp() {
    CoGoStoreAppContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CoGoStoreAppContent() {
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        CoGoStoreNavigationActions(navController)
    }

    val coroutineScope = rememberCoroutineScope()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: CoGoStoreDestination.HOME

    val navDrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            AppDrawer(
                currentRoute = currentRoute,
                navigateToHome = navigationActions.navigateToHome,
                navigateToWishList = navigationActions.navigateToWishList,
                closeDrawer = { coroutineScope.launch { navDrawerState.close() } }
            )
        },
        drawerState = navDrawerState
    ) {
        CoGoStoreNavGraph(
            navController = navController,
            openDrawer = { coroutineScope.launch { navDrawerState.open() } }
        )
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
            Icon(
                painterResource(R.drawable.ic_launcher_foreground),
                null,
                Modifier
                    .align(Alignment.Center)
                    .padding(start = 12.dp)
            )
            Row(Modifier.align(Alignment.CenterEnd)) {
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