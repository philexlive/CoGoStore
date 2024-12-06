package com.philexliveprojects.cogostore.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ProductItem(
    @StringRes val name: Int,
    @DrawableRes val images: List<Int>
)