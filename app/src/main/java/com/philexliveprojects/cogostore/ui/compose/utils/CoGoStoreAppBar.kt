package com.philexliveprojects.cogostore.ui.compose.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.philexliveprojects.cogostore.R

@Composable
fun CoGoStoreAppBar(
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable (RowScope.() -> Unit) = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shadowElevation = 2.dp
    ) {
        Box(
            Modifier
                .fillMaxWidth()
        ) {
            Box(Modifier.align(Alignment.CenterStart)) { navigationIcon() }
            Image(
                painterResource(R.drawable.logo),
                null,
                Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
                    .padding(start = 12.dp)
            )
            Row(Modifier.align(Alignment.CenterEnd)) {
                actions()
            }
        }
    }
}