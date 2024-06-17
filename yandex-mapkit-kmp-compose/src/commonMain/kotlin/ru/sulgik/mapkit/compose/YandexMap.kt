package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
expect fun YandexMap(
    controller: YandexMapController = rememberYandexMapController(),
    modifier: Modifier = Modifier,
)