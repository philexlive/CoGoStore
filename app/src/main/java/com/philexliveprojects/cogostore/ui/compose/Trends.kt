package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.data.model.TrendItem


@Composable
fun TrendsHorizontal(
    products: List<TrendItem>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    TrendsLayout(modifier) {
        HorizontalPager(pagerState) { offerId ->
            Image(
                painter = painterResource(products[offerId % products.size].image),
                contentDescription = "Some Offer",
                contentScale = ContentScale.Companion.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun TrendsVertical(offers: List<TrendItem>, pagerState: PagerState, modifier: Modifier = Modifier) {
    TrendsLayout(modifier) {
        VerticalPager(pagerState) { offerId ->
            Image(
                painter = painterResource(offers[offerId % offers.size].image),
                contentDescription = "Some Offer",
                contentScale = ContentScale.Companion.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Composable
private fun TrendsLayout(modifier: Modifier = Modifier, content: @Composable () -> Unit) {


    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier.clip(RoundedCornerShape(dimensionResource(R.dimen.corner_small)))
    ) {
        content()
        Text(
            "🔥",
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_large)),
            fontSize = 14.sp
        )
    }
}

