package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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
    val currentRoute = navBackStackEntry?.destination?.route ?: CoGoStoreDestination.Home.route

    val navDrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            AppDrawer(
                currentRoute = currentRoute,
                navigateToHome = navigationActions.navigateToHome,
                navigateToWishList = navigationActions.navigateToWishList,
                navigateToBag = navigationActions.navigateToBag,
                navigateToOffers = navigationActions.navigateToOffers,
                navigateToHelp = navigationActions.navigateToHelp,
                navigateToTermsAndPolicy = navigationActions.navigateToTermsAndPolicy,
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