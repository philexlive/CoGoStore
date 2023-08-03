package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.philexliveprojects.cogostore.ui.compose.home.HomeScreen
import com.philexliveprojects.cogostore.ui.compose.wishlist.WishlistScreen

@Composable
fun CoGoStoreNavGraph(
    navController: NavHostController = rememberNavController(),
    openDrawer: () -> Unit = {},
    startDestination: String = CoGoStoreDestination.HOME
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = CoGoStoreDestination.HOME) {
            HomeScreen(openDrawer)
        }
        composable(route = CoGoStoreDestination.WISHLIST) {
            WishlistScreen()
        }
    }
}