package com.philexliveprojects.cogostore.ui.compose

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

/**
 * Navigation destinations constants
 */
object CoGoStoreDestination {
    const val HOME = "home"
    const val WISHLIST = "wishlist"
    const val BAG = "bag"
    const val HIT = "hit"
    const val OFFERS = "offers"
    const val CATEGORY = "category"
    const val PRODUCT = "product"
    const val PURCHASE = "purchase"
    const val SEARCH = "search"
    const val USER = "user"
    const val HELP = "help"
    const val TERMS_AND_POLICY = "terms_and_policy"
}

/**
 * Navigation actions
 */
class CoGoStoreNavigationActions(navController: NavController) {
    /*
    Navigation lambda functions
     */
    val navigateToHome = { navigateTo(navController, CoGoStoreDestination.HOME) }
    val navigateToWishList = { navigateTo(navController, CoGoStoreDestination.WISHLIST) }
    val navigateToBag = { navigateTo(navController, CoGoStoreDestination.BAG) }
    val navigateToHit = { navigateTo(navController, CoGoStoreDestination.HIT) }
    val navigateToOffers = { navigateTo(navController, CoGoStoreDestination.OFFERS) }
    val navigateToCategory = { navigateTo(navController, CoGoStoreDestination.CATEGORY) }
    val navigateToProduct = { navigateTo(navController, CoGoStoreDestination.PRODUCT) }
    val navigateToPurchase = { navigateTo(navController, CoGoStoreDestination.PURCHASE) }
    val navigateToSearch = { navigateTo(navController, CoGoStoreDestination.SEARCH) }
    val navigateToUser = { navigateTo(navController, CoGoStoreDestination.USER) }
    val navigateToHelp = { navigateTo(navController, CoGoStoreDestination.HELP) }
    val navigateToTermsAndPolicy =
        { navigateTo(navController, CoGoStoreDestination.TERMS_AND_POLICY) }

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
