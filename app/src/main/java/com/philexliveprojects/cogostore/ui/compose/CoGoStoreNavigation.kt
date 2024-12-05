package com.philexliveprojects.cogostore.ui.compose

import androidx.annotation.StringRes
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.philexliveprojects.cogostore.R

/**
 * Navigation destinations constants
 */
enum class CoGoStoreDestination(@StringRes val title: Int) {
    Home(R.string.home),
    Wishlist(R.string.wishlist),
    Bag(R.string.bag),
    Offers(R.string.offers),
    Help(R.string.help),
    TermsAndPolicy(R.string.terms_and_policy),
}

/**
 * Class for to handle navigation.
 * CoGoStoreDestination.<Page>.name represents a concrete route for the page.
 * */
class CoGoStoreNavigationActions(navController: NavController) {
    /* Navigation lambda functions */

    val navigateToHome = { navigateTo(navController, CoGoStoreDestination.Home.name) }

    val navigateToWishList = { navigateTo(navController, CoGoStoreDestination.Wishlist.name) }

    val navigateToBag = { navigateTo(navController, CoGoStoreDestination.Bag.name) }

    val navigateToOffers = { navigateTo(navController, CoGoStoreDestination.Offers.name) }

    val navigateToHelp = { navigateTo(navController, CoGoStoreDestination.Help.name) }

    val navigateToTermsAndPolicy =
        { navigateTo(navController, CoGoStoreDestination.TermsAndPolicy.name) }

    /**
     * Function to navigate to the destination.
     * */
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
