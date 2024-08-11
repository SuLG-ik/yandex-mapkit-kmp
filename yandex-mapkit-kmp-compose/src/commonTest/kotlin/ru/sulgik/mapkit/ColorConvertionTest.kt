package ru.sulgik.mapkit

import androidx.compose.ui.graphics.Color
import ru.sulgik.mapkit.compose.utils.toComposeColor
import ru.sulgik.mapkit.compose.utils.toMapkitColor
import kotlin.test.Test
import kotlin.test.assertEquals
import ru.sulgik.mapkit.Color as MapkitColor

public class ColorConvertionTest {

    @Test
    public fun `mapkit color to compose color should convert correct`() {
        assertEquals(DefaultMapkitColor.toComposeColor(), DefaultComposeColor)
        assertEquals(WhiteMapkitColor.toComposeColor(), WhiteComposeColor)
        assertEquals(BlackMapkitColor.toComposeColor(), BlackComposeColor)
    }

    @Test
    public fun `compose color to mapkit color should convert correct`() {
        assertEquals(DefaultComposeColor.toMapkitColor(), DefaultMapkitColor)
        assertEquals(WhiteComposeColor.toMapkitColor(), WhiteMapkitColor)
        assertEquals(BlackComposeColor.toMapkitColor(), BlackMapkitColor)
    }

    public companion object {
        public val DefaultMapkitColor: MapkitColor = MapkitColor.fromArgb(0xFF0066FF.toInt())
        public val DefaultComposeColor: Color = Color(0xFF0066FF)
        public val WhiteComposeColor: Color = Color(0xFFFFFFFF)
        public val WhiteMapkitColor: MapkitColor = MapkitColor.fromArgb(0xFFFFFFFF.toInt())
        public val BlackComposeColor: Color = Color(0xFF000000)
        public val BlackMapkitColor: MapkitColor = MapkitColor.fromArgb(0xFF000000.toInt())
    }

}