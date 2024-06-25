package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal expect fun NativeYandexMap(
    controller: YandexMapController,
    modifier: Modifier,
)