package com.philexliveprojects.cogostore.ui.compose.termsandpolicy

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.ui.compose.utilities.CoGoStoreCommonScreen

@Composable
fun TermsAndPolicyScreen(onBack: () -> Unit) {
    TermsAndPolicyScreenContent(onBack = onBack)
}

@Composable
private fun TermsAndPolicyScreenContent(onBack: () -> Unit) {
    CoGoStoreCommonScreen(
        title = stringResource(R.string.terms_and_policy),
        onBack = onBack
    ) {
        /*TODO*/
    }
}