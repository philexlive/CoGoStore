package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.data.ProductsRepository
import com.philexliveprojects.cogostore.data.model.ProductItem

@Composable
fun ProductItem(
    product: ProductItem,
    pagerState: PagerState,
    modifier: Modifier = Modifier.Companion
) {
    Box(modifier = modifier.clip(RoundedCornerShape(dimensionResource(R.dimen.padding_medium)))) {
        HorizontalPager(
            state = pagerState,
            beyondViewportPageCount = 1
        ) { imageId ->
            Image(
                painter = painterResource(product.images[imageId % product.images.size]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Companion.Crop
            )
        }
        Text(
            text = stringResource(product.name),
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(RoundedCornerShape(dimensionResource(R.dimen.corner_small)))
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(dimensionResource(R.dimen.padding_small))
        )
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    val product = ProductsRepository.getProductsData()[0]
    ProductItem(
        name = product.name,
        images = product.images
    )
}