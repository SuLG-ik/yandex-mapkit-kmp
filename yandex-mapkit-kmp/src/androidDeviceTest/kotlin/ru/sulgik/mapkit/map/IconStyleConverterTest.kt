package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.MapKitRuntime
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import android.graphics.PointF as NativePointF
import com.yandex.mapkit.map.IconStyle as NativeIconStyle
import com.yandex.mapkit.map.Rect as NativeRect
import com.yandex.mapkit.map.RotationType as NativeRotationType

public class IconStyleConverterTest {

    @BeforeTest
    public fun setUp() {
        MapKitRuntime.ensureLoaded()
    }

    @Test
    public fun point_f_keeps_x_apart_from_y() {
        val native = PointF(x = 1.5f, y = -2.5f).toNative()

        assertEquals(1.5f, native.x, 0f)
        assertEquals(-2.5f, native.y, 0f)

        val common = NativePointF(1.5f, -2.5f).toCommon()

        assertEquals(1.5f, common.x, 0f)
        assertEquals(-2.5f, common.y, 0f)
    }

    @Test
    public fun rect_keeps_min_apart_from_max() {
        val native = Rect(min = PointF(0.1f, 0.2f), max = PointF(0.8f, 0.9f)).toNative()

        assertEquals(0.1f, native.min.x, 0f)
        assertEquals(0.2f, native.min.y, 0f)
        assertEquals(0.8f, native.max.x, 0f)
        assertEquals(0.9f, native.max.y, 0f)

        val common = NativeRect(NativePointF(0.1f, 0.2f), NativePointF(0.8f, 0.9f)).toCommon()

        assertEquals(PointF(0.1f, 0.2f), common.min)
        assertEquals(PointF(0.8f, 0.9f), common.max)
    }

    @Test
    public fun icon_style_carries_the_anchor_to_the_native_style() {
        val native = IconStyle(anchor = PointF(0.25f, 0.75f)).toNative()

        val anchor = assertNotNull(native.anchor)
        assertEquals(0.25f, anchor.x, 0f)
        assertEquals(0.75f, anchor.y, 0f)
    }

    @Test
    public fun icon_style_carries_the_tappable_area_to_the_native_style() {
        val native = IconStyle(
            tappableArea = Rect(PointF(0.1f, 0.2f), PointF(0.3f, 0.4f)),
        ).toNative()

        val tappableArea = assertNotNull(native.tappableArea)
        assertEquals(0.1f, tappableArea.min.x, 0f)
        assertEquals(0.4f, tappableArea.max.y, 0f)
    }

    @Test
    public fun icon_style_keeps_every_field_in_its_own_native_field() {
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

        assertEquals(NativeRotationType.ROTATE, native.rotationType)
        assertEquals(3f, native.zIndex)
        assertEquals(true, native.flat)
        assertEquals(false, native.visible)
        assertEquals(2f, native.scale)
        assertEquals(0.5f, native.opacity, 0f)

        val common = native.toCommon()

        assertEquals(PointF(0.25f, 0.75f), common.anchor)
        assertEquals(RotationType.ROTATE, common.rotationType)
        assertEquals(3f, common.zIndex)
        assertEquals(true, common.flat)
        assertEquals(false, common.isVisible)
        assertEquals(2f, common.scale)
        assertEquals(0.5f, common.opacity, 0f)
        assertEquals(PointF(0.1f, 0.2f), common.tappableArea?.min)
        assertEquals(PointF(0.3f, 0.4f), common.tappableArea?.max)
    }

    @Test
    public fun icon_style_keeps_the_optional_fields_null() {
        val common = NativeIconStyle(null, null, null, null, null, null, 1f, null).toCommon()

        assertEquals(null, common.anchor)
        assertEquals(null, common.rotationType)
        assertEquals(null, common.zIndex)
        assertEquals(null, common.flat)
        assertEquals(null, common.isVisible)
        assertEquals(null, common.scale)
        assertEquals(null, common.tappableArea)
    }
}
