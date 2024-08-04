package ru.sulgik.mapkit.compose.utils

import androidx.compose.ui.graphics.toArgb
import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.toArgb
import androidx.compose.ui.graphics.Color as ComposeColor

public fun ComposeColor.toMapkitColor(): Color {
    return Color.fromArgb(toArgb())
}

public fun Color.toComposeColor(): androidx.compose.ui.graphics.Color {
    return ComposeColor(toArgb())
}