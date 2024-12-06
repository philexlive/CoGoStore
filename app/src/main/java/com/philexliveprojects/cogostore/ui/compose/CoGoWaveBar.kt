package com.philexliveprojects.cogostore.ui.compose

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.FloatState
import androidx.compose.runtime.asFloatState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.philexliveprojects.cogostore.R
import com.philexliveprojects.cogostore.ui.compose.wavebottombar.Logo
import com.philexliveprojects.cogostore.ui.compose.wavebottombar.WaveBottomBar


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoGoWaveBar(
    onSearch: () -> Unit,
    onLogoClick: () -> Unit,
    modifier: Modifier = Modifier.Companion,
    animationEnabled: Boolean = false,
) {

    val waveState = if (animationEnabled) {
        rememberInfiniteTransition(label = "").animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(1200, 1500),
                repeatMode = RepeatMode.Reverse
            ),
            label = "Wave Animation"
        ).asFloatState()
    } else {
        object : FloatState {
            override val floatValue: Float
                get() = 0f
        }
    }

    var pressed by remember { mutableStateOf(false) }

    val padding by animateDpAsState(
        targetValue = if (pressed) {
            dimensionResource(R.dimen.padding_medium)
        } else {
            dimensionResource(R.dimen.padding_small)
        },
        animationSpec = tween(250),
        label = ""
    )

    val cornerRadius by animateDpAsState(
        targetValue = if (pressed) {
            dimensionResource(R.dimen.corner_large)
        } else {
            dimensionResource(R.dimen.corner_small)
        },
        animationSpec = tween(250),
        label = ""
    )

    val shadowElevation by animateDpAsState(
        targetValue = if (pressed) {
            dimensionResource(R.dimen.focused_shadow_elevation)
        } else {
            dimensionResource(R.dimen.primary_shadow_elevation)
        },
        animationSpec = tween(250),
        label = ""
    )

    val tonalElevation by animateDpAsState(
        targetValue = if (pressed) {
            dimensionResource(R.dimen.focused_tonal_elevation)
        } else {
            dimensionResource(R.dimen.primary_tonal_elevation)
        },
        animationSpec = tween(250),
        label = ""
    )


    WaveBottomBar(
        logo = {
            Logo(
                painter = painterResource(R.drawable.logo),
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .clickable(enabled = true, onClick = { onLogoClick() })
            )
        },
        title = {
            Text(stringResource(R.string.app_name))
        },
        actions = {
            Search(onSearch)
        },
        modifier = modifier
            .pointerInput(Unit) {
                detectDragGesturesAfterLongPress(
                    onDragStart = { pressed = true },
                    onDragEnd = { pressed = false }
                ) { _, dragAmount ->
                }
            }
            .fillMaxWidth()
            .padding(padding),
        wavePosition = waveState,
        waveAmplitude = dimensionResource(R.dimen.wave_amplitude),
        color = MaterialTheme.colorScheme.surface,
        elevation = shadowElevation,
        tonalElevation = tonalElevation,
        cornerRadius = DpSize(cornerRadius, cornerRadius)
    )
}

@Composable
fun Search(onSearch: () -> Unit) {
    IconButton({}) {
        Icon(
            Icons.Default.Search,
            contentDescription = "Search"
        )
    }
}