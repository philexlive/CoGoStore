package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.BAG
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.HELP
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.HOME
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.OFFERS
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.TERMS_AND_POLICY
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreDestination.WISHLIST

@OptIn(ExperimentalMaterial3Api::class)
private val drawerItemModifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToWishList: () -> Unit,
    navigateToBag: () -> Unit,
    navigateToOffers: () -> Unit,
    navigateToHelp: () -> Unit,
    navigateToTermsAndPolicy: () -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val coroutineScope = rememberCoroutineScope()

    ModalDrawerSheet(modifier) {
        Header()
        NavigationDrawerItem(
            label = { Text(HOME) },
            selected = currentRoute == HOME,
            onClick = { navigateToHome(); closeDrawer() },
            modifier = drawerItemModifier
        )
        NavigationDrawerItem(
            label = { Text(WISHLIST) },
            selected = currentRoute == WISHLIST,
            onClick = { navigateToWishList(); closeDrawer() },
            modifier = drawerItemModifier
        )
        NavigationDrawerItem(
            label = { Text(BAG) },
            selected = currentRoute == BAG,
            onClick = { navigateToBag(); closeDrawer() },
            modifier = drawerItemModifier
        )
        NavigationDrawerItem(
            label = { Text(OFFERS) },
            selected = currentRoute == OFFERS,
            onClick = { navigateToOffers(); closeDrawer() },
            modifier = drawerItemModifier
        )
        NavigationDrawerItem(
            label = { Text(HELP) },
            selected = currentRoute == HELP,
            onClick = { navigateToHelp(); closeDrawer() },
            modifier = drawerItemModifier
        )
        NavigationDrawerItem(
            label = { Text(TERMS_AND_POLICY) },
            selected = currentRoute == TERMS_AND_POLICY,
            onClick = { navigateToTermsAndPolicy(); closeDrawer() },
            modifier = drawerItemModifier
        )
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .background(Color.Cyan)
    ) {
        /* TODO */
    }
}