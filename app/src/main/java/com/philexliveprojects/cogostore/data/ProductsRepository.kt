package com.philexliveprojects.cogostore.data

import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.data.model.ProductItem
import com.philexliveprojects.cogostore.data.model.TrendItem

object ProductsRepository {
    fun getProductsData() = listOf(
        ProductItem(
            name = R.string.hoodie,
            images = listOf(
                R.drawable.hoodie_1,
                R.drawable.hoodie_2,
                R.drawable.hoodie_3,
                R.drawable.hoodie_4
            )
        ),
        ProductItem(
            name = R.string.jacket,
            images = listOf(
                R.drawable.jacket_1,
                R.drawable.jacket_2,
                R.drawable.jacket_3,
                R.drawable.jacket_4
            )
        ),
        ProductItem(
            name = R.string.t_shirt,
            images = listOf(
                R.drawable.t_shirt_1,
                R.drawable.t_shirt_2,
                R.drawable.t_shirt_3,
                R.drawable.t_shirt_4,
            )
        )
    )

    fun getTrends() = getProductsData().map { TrendItem(it.name, it.images[0]) }.subList(0, 3)
}