package com.philexliveprojects.cogostore.ui.compose.bag

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.ui.compose.utilities.CoGoStoreCommonScreen

@Composable
fun BagScreen(onBack: () -> Unit) {
    BagScreenContent(onBack = onBack)
}

@Composable
private fun BagScreenContent(onBack: () -> Unit) {
    CoGoStoreCommonScreen(title = stringResource(R.string.bag), onBack = onBack) {
        /*TODO*/
    }
}