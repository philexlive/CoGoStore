package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.ui.theme.CoGoStoreTheme

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
    ModalDrawerSheet(modifier) {
        Header {
            UserSign(
                username = "Username",
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.Center)
            )
        }
        NavigationDrawerItem(
            label = { Text(stringResource(CoGoStoreDestination.Home.title)) },
            selected = currentRoute == CoGoStoreDestination.Home.name,
            onClick = { navigateToHome(); closeDrawer() },
            modifier = drawerItemModifier
        )
        NavigationDrawerItem(
            label = { Text(stringResource(CoGoStoreDestination.Wishlist.title)) },
            selected = currentRoute == CoGoStoreDestination.Wishlist.name,
            onClick = { navigateToWishList(); closeDrawer() },
            modifier = drawerItemModifier
        )
        NavigationDrawerItem(
            label = { Text(stringResource(CoGoStoreDestination.Bag.title)) },
            selected = currentRoute == CoGoStoreDestination.Bag.name,
            onClick = { navigateToBag(); closeDrawer() },
            modifier = drawerItemModifier
        )
        NavigationDrawerItem(
            label = { Text(stringResource(CoGoStoreDestination.Offers.title)) },
            selected = currentRoute == CoGoStoreDestination.Offers.name,
            onClick = { navigateToOffers(); closeDrawer() },
            modifier = drawerItemModifier
        )
        NavigationDrawerItem(
            label = { Text(stringResource(CoGoStoreDestination.Help.title)) },
            selected = currentRoute == CoGoStoreDestination.Help.name,
            onClick = { navigateToHelp(); closeDrawer() },
            modifier = drawerItemModifier
        )
        NavigationDrawerItem(
            label = { Text(stringResource(CoGoStoreDestination.TermsAndPolicy.title)) },
            selected = currentRoute == CoGoStoreDestination.TermsAndPolicy.name,
            onClick = { navigateToTermsAndPolicy(); closeDrawer() },
            modifier = drawerItemModifier
        )
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit = {}) {
    Box(
        modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.header_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(Modifier.fillMaxSize()) {
            content()
        }
    }
}

@Composable
private fun UserSign(username: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Sign(onClick, modifier) {
        Row(Modifier.fillMaxSize()) {
            Surface(
                Modifier
                    .fillMaxHeight()
                    .padding(4.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(50))
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(
                text = username,
                modifier = Modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
private fun LoginSign(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Sign(onClick, modifier) {
        Text(
            text = stringResource(R.string.login),
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Sign(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        modifier = modifier.size(200.dp, 72.dp),
        tonalElevation = 2.dp
    ) {
        Box(Modifier.fillMaxSize()) {
            content()
        }
    }
}


@Preview
@Composable
private fun UserSignPreview() {
    CoGoStoreTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            UserSign("Username", {})
        }
    }
}

@Preview
@Composable
private fun LoginSignPreview() {
    CoGoStoreTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            LoginSign({})
        }
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    CoGoStoreTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Header {

            }
        }
    }
}

@Preview
@Composable
private fun HeaderPreviewDark() {
    CoGoStoreTheme(darkTheme = true) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Header {

            }
        }
    }
}
