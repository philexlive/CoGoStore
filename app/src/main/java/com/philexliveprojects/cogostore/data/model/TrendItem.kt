package com.philexliveprojects.cogostore.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class TrendItem(
    @StringRes val name: Int,
    @DrawableRes val image: Int
)