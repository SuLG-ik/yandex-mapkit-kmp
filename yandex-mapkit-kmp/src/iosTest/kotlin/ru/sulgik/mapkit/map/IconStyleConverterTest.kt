package ru.sulgik.mapkit.map

import kotlinx.cinterop.useContents
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import ru.sulgik.mapkit.toPointF
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import YandexMapKit.YMKIconStyle as NativeIconStyle
import YandexMapKit.YMKRect as NativeRect

public class IconStyleConverterTest {

    @Test
    public fun `point f keeps x apart from y`() {
        PointF(x = 1.5f, y = -2.5f).toNative().useContents {
            assertEquals(1.5, x)
            assertEquals(-2.5, y)
        }

        val common = PointF(x = 1.5f, y = -2.5f).toNative().useContents { toCommon() }

        assertEquals(1.5f, common.x)
        assertEquals(-2.5f, common.y)
    }

    @Test
    public fun `rect keeps min apart from max`() {
        val native = Rect(min = PointF(0.1f, 0.2f), max = PointF(0.8f, 0.9f)).toNative()

        native.min.useContents {
            assertEquals(0.1f, x.toFloat())
            assertEquals(0.2f, y.toFloat())
        }
        native.max.useContents {
            assertEquals(0.8f, x.toFloat())
            assertEquals(0.9f, y.toFloat())
        }

        val common = NativeRect.rectWithMin(
            PointF(0.1f, 0.2f).toNative(),
            PointF(0.8f, 0.9f).toNative(),
        ).toCommon()

        assertEquals(PointF(0.1f, 0.2f), common.min)
        assertEquals(PointF(0.8f, 0.9f), common.max)
    }

    @Test
    public fun `icon style carries the anchor to the native style`() {
        val native = IconStyle(anchor = PointF(0.25f, 0.75f)).toNative()

        val anchor = assertNotNull(native.anchor).toPointF()

        assertEquals(0.25f, anchor.x)
        assertEquals(0.75f, anchor.y)
    }

    @Test
    public fun `icon style carries the tappable area to the native style`() {
        val native = IconStyle(
            tappableArea = Rect(PointF(0.1f, 0.2f), PointF(0.3f, 0.4f)),
        ).toNative()

        val tappableArea = assertNotNull(native.tappableArea)

        tappableArea.min.useContents { assertEquals(0.1f, x.toFloat()) }
        tappableArea.max.useContents { assertEquals(0.4f, y.toFloat()) }
    }

    @Test
    public fun `icon style keeps every field in its own native field`() {
        val style = IconStyle(
            anchor = PointF(0.25f, 0.75f),
            rotationType = RotationType.ROTATE,
            zIndex = 3f,
            flat = true,
            isVisible = false,
            scale = 2f,
            opacity = 0.5f,
            tappableArea = Rect(PointF(0.1f, 0.2f), PointF(0.3f, 0.4f)),
        )

        val native = style.toNative()

        assertEquals(3f, native.zIndex?.floatValue)
        assertEquals(true, native.flat?.boolValue)
        assertEquals(false, native.visible?.boolValue)
        assertEquals(2f, native.scale?.floatValue)
        assertEquals(0.5f, native.opacity)

        val common = native.toCommon()

        assertEquals(PointF(0.25f, 0.75f), common.anchor)
        assertEquals(RotationType.ROTATE, common.rotationType)
        assertEquals(3f, common.zIndex)
        assertEquals(true, common.flat)
        assertEquals(false, common.isVisible)
        assertEquals(2f, common.scale)
        assertEquals(0.5f, common.opacity)
        assertEquals(PointF(0.1f, 0.2f), common.tappableArea?.min)
        assertEquals(PointF(0.3f, 0.4f), common.tappableArea?.max)
    }

    @Test
    public fun `icon style maps the rotation type without leaning on the declaration order`() {
        assertEquals(RotationType.NO_ROTATION, IconStyle(rotationType = RotationType.NO_ROTATION).toNative().toCommon().rotationType)
        assertEquals(RotationType.ROTATE, IconStyle(rotationType = RotationType.ROTATE).toNative().toCommon().rotationType)
    }

    @Test
    public fun `icon style keeps the optional fields null`() {
        val common = NativeIconStyle.iconStyleWithAnchor(
            anchor = null,
            rotationType = null,
            zIndex = null,
            flat = null,
            visible = null,
            scale = null,
            opacity = 1f,
            tappableArea = null,
        ).toCommon()

        assertEquals(null, common.anchor)
        assertEquals(null, common.rotationType)
        assertEquals(null, common.zIndex)
        assertEquals(null, common.flat)
        assertEquals(null, common.isVisible)
        assertEquals(null, common.scale)
        assertEquals(null, common.tappableArea)
    }
}
