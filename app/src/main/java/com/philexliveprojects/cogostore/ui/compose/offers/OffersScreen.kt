package com.philexliveprojects.cogostore.ui.compose.offers

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.ui.compose.utilities.CoGoStoreCommonScreen

@Composable
fun OffersScreen(onBack: () -> Unit) {
    OffersScreenContent(onBack)
}

@Composable
private fun OffersScreenContent(onBack: () -> Unit) {
    CoGoStoreCommonScreen(title = stringResource(R.string.offers), onBack = onBack) {
        /*TODO*/
    }
}