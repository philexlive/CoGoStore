package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.currentWindowSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.data.ProductsRepository
import com.philexliveprojects.cogostore.ui.compose.wavebottombar.LocalLogoContext
import com.philexliveprojects.cogostore.ui.theme.CoGoStoreTheme

@Composable
fun CoGoStoreApp(windowWidthSizeClass: WindowWidthSizeClass) {
    Surface(color = MaterialTheme.colorScheme.background) {
        CoGoStoreContent(windowWidthSizeClass)
    }
}


@Composable
fun CoGoStoreContent(windowWidthSizeClass: WindowWidthSizeClass) {
    val trendsPagerState = rememberPagerState(
        initialPage = Int.MAX_VALUE / 2,
        pageCount = { Int.MAX_VALUE }
    )
    Box(contentAlignment = Alignment.BottomCenter) {
        Row {
            if (windowWidthSizeClass.isExpanded()) {
                val offerPadding = dimensionResource(R.dimen.padding_medium)
                TrendsVertical(
                    offers = ProductsRepository.getTrends(),
                    pagerState = trendsPagerState,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(
                            start = offerPadding,
                            top = offerPadding,
                            bottom = offerPadding
                        )
                        .weight(1f)
                )
            }

            Box(
                modifier = Modifier.weight(2f),
                contentAlignment = Alignment.BottomCenter
            ) {
                val spaceBetween = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
                val gridPadding = dimensionResource(R.dimen.padding_medium)

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(
                        start = gridPadding,
                        top = gridPadding,
                        end = gridPadding,
                        bottom = LocalLogoContext.current.size.height
                    ),
                    verticalArrangement = spaceBetween,
                    horizontalArrangement = spaceBetween
                ) {
                    if (windowWidthSizeClass.isCompact()) {
                        item(span = { GridItemSpan(2) }) {
                            val offerHeight = with(LocalDensity.current) {
                                (currentWindowSize().height * 0.75f).toDp()
                            }
                            TrendsHorizontal(
                                products = ProductsRepository.getTrends(),
                                pagerState = trendsPagerState,
                                modifier = Modifier.height(offerHeight)
                            )
                        }
                    }

                    items(ProductsRepository.getProductsData().size) { productIndex ->
                        val productHeight = with(LocalDensity.current) {
                            val scale = if (windowWidthSizeClass.isExpanded()) 0.5f else 0.25f
                            (currentWindowSize().height * scale).toDp()
                        }

                        ProductItem(
                            product = ProductsRepository.getProductsData()[productIndex],
                            pagerState = rememberPagerState(
                                initialPage = Int.MAX_VALUE / 2,
                                pageCount = { Int.MAX_VALUE }
                            ),
                            modifier = Modifier.height(productHeight)
                        )
                    }
                }

                if (windowWidthSizeClass.isExpanded()) {
                    CoGoWaveBar(
                        onSearch = { },
                        onLogoClick = { },
                        modifier = Modifier
                            .width(380.dp),
                        animationEnabled = true,
                    )
                }
            }
        }

        if (windowWidthSizeClass.isCompact() || windowWidthSizeClass.isMedium())
            CoGoWaveBar(
                onSearch = { },
                onLogoClick = { },
                animationEnabled = true
            )
    }
}

private fun WindowWidthSizeClass.isExpanded(): Boolean = this == WindowWidthSizeClass.EXPANDED
private fun WindowWidthSizeClass.isCompact(): Boolean = this == WindowWidthSizeClass.COMPACT
private fun WindowWidthSizeClass.isMedium(): Boolean = this == WindowWidthSizeClass.COMPACT

@Preview
@Composable
fun CoGoStoreAppContentPreview() {
    CoGoStoreTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CoGoStoreApp(WindowWidthSizeClass.COMPACT)
        }
    }
}

@Preview(widthDp = 1200)
@Composable
fun CoGoStoreAppContentExpandedPreview() {
    CoGoStoreTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CoGoStoreApp(WindowWidthSizeClass.EXPANDED)
        }
    }
}