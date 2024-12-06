package com.philexliveprojects.cogostore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import com.philexliveprojects.cogostore.ui.compose.CoGoStoreApp
import com.philexliveprojects.cogostore.ui.theme.CoGoStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoGoStoreTheme {
                val windowWidthSizeClass = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
                CoGoStoreApp(windowWidthSizeClass)
            }
        }
    }
}