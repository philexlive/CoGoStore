package com.philexliveprojects.cogostore.ui.compose

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

object CoGoStoreDestination {
    const val HOME = "home"
    const val WISHLIST = "wishlist"
}

class CoGoStoreNavigationActions(navController: NavController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(CoGoStoreDestination.HOME) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToWishList: () -> Unit = {
        navController.navigate(CoGoStoreDestination.WISHLIST) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
