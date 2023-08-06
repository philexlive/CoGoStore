package com.philexliveprojects.cogostore.ui.compose.wishlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.ui.compose.utilities.CoGoStoreCommonScreen

@Composable
fun WishlistScreen(onBack: () -> Unit = {}) {
    WishListScreenContent(onBack = onBack)
}

@Composable
private fun WishListScreenContent(onBack: () -> Unit) {
    CoGoStoreCommonScreen(title = stringResource(R.string.wishlist), onBack = onBack) {
        /*TODO*/
    }
}