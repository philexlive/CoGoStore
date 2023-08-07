package com.philexliveprojects.cogostore.ui.compose

import androidx.annotation.StringRes
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.philexliveprojects.cogostore.R

/**
 * Navigation destinations constants
 */
enum class CoGoStoreDestination(
    @StringRes val title: Int,
    val route: String
) {
    Home(R.string.home, "home"),
    Wishlist(R.string.wishlist, "wishlist"),
    Bag(R.string.bag, "bag"),
    Offers(R.string.offers, "offers"),
    Help(R.string.help, "help"),
    TermsAndPolicy(R.string.terms_and_policy, "terms_and_policy"),
}

/**
 * Navigation actions
 */
class CoGoStoreNavigationActions(navController: NavController) {
    /*
    Navigation lambda functions
     */
    val navigateToHome = { navigateTo(navController, CoGoStoreDestination.Home.route) }
    val navigateToWishList = { navigateTo(navController, CoGoStoreDestination.Wishlist.route) }
    val navigateToBag = { navigateTo(navController, CoGoStoreDestination.Bag.route) }
    val navigateToOffers = { navigateTo(navController, CoGoStoreDestination.Offers.route) }
    val navigateToHelp = { navigateTo(navController, CoGoStoreDestination.Help.route) }
    val navigateToTermsAndPolicy =
        { navigateTo(navController, CoGoStoreDestination.TermsAndPolicy.route) }

    /*
    Common navigation function
     */
    private fun navigateTo(navController: NavController, destination: String) {
        navController.navigate(destination) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
