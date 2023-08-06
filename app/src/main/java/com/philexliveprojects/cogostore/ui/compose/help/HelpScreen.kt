package com.philexliveprojects.cogostore.ui.compose.help

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.ui.compose.utilities.CoGoStoreCommonScreen

@Composable
fun HelpScreen(onBack: () -> Unit) {
    HelpScreenContent(onBack = onBack)
}

@Composable
fun HelpScreenContent(onBack: () -> Unit) {
    CoGoStoreCommonScreen(title = stringResource(R.string.help), onBack = onBack) {
        /*TODO*/
    }
}