package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.BAG
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.HELP
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.HOME
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.OFFERS
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.TERMS_AND_POLICY
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.WISHLIST
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
    startDestination: String = CoGoStoreDestination.HOME
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(HOME) {
            HomeScreen(openDrawer)
        }

        composable(WISHLIST) {
            WishlistScreen(onBack = { navController.navigateUp() })
        }

        composable(BAG) {
            BagScreen(onBack = { navController.navigateUp() })
        }

        composable(OFFERS) {
            OffersScreen(onBack = { navController.navigateUp() })
        }

        composable(HELP) {
            HelpScreen(onBack = { navController.navigateUp() })
        }

        composable(TERMS_AND_POLICY) {
            TermsAndPolicyScreen(onBack = { navController.navigateUp() })
        }
    }
}