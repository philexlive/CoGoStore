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
    startDestination: String = CoGoStoreDestination.Home.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(CoGoStoreDestination.Home.route) {
            HomeScreen(openDrawer)
        }

        composable(CoGoStoreDestination.Wishlist.route) {
            WishlistScreen(onBack = { navController.navigateUp() })
        }

        composable(CoGoStoreDestination.Bag.route) {
            BagScreen(onBack = { navController.navigateUp() })
        }

        composable(CoGoStoreDestination.Offers.route) {
            OffersScreen(onBack = { navController.navigateUp() })
        }

        composable(CoGoStoreDestination.Help.route) {
            HelpScreen(onBack = { navController.navigateUp() })
        }

        composable(CoGoStoreDestination.TermsAndPolicy.route) {
            TermsAndPolicyScreen(onBack = { navController.navigateUp() })
        }
    }
}