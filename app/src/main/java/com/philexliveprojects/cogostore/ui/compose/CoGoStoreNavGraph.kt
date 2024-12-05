package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.philexliveprojects.cogostore.ui.compose.bag.BagScreen
import com.philexliveprojects.cogostore.ui.compose.help.HelpScreen
import com.philexliveprojects.cogostore.ui.compose.home.HomeScreen
import com.philexliveprojects.cogostore.ui.compose.offers.OffersScreen
import com.philexliveprojects.cogostore.ui.compose.termsandpolicy.TermsAndPolicyScreen
import com.philexliveprojects.cogostore.ui.compose.wishlist.WishlistScreen

@Composable
fun CoGoStoreNavGraph(
    navController: NavHostController = rememberNavController(),
    openDrawer: () -> Unit = {},
    startDestination: String = CoGoStoreDestination.Home.name
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(CoGoStoreDestination.Home.name) {
            HomeScreen(openDrawer)
        }

        composable(CoGoStoreDestination.Wishlist.name) {
            WishlistScreen(onBack = { navController.navigateUp() })
        }

        composable(CoGoStoreDestination.Bag.name) {
            BagScreen(onBack = { navController.navigateUp() })
        }

        composable(CoGoStoreDestination.Offers.name) {
            OffersScreen(onBack = { navController.navigateUp() })
        }

        composable(CoGoStoreDestination.Help.name) {
            HelpScreen(onBack = { navController.navigateUp() })
        }

        composable(CoGoStoreDestination.TermsAndPolicy.name) {
            TermsAndPolicyScreen(onBack = { navController.navigateUp() })
        }
    }
}