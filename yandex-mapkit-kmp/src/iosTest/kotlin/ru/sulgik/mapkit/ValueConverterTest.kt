package ru.sulgik.mapkit

import kotlinx.cinterop.get
import platform.CoreGraphics.CGColorGetComponents
import platform.UIKit.UIColor
import kotlin.math.roundToInt
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import YandexMapKit.YMKLocalizedValue as NativeLocalizedValue
import YandexMapKit.YMKScreenPoint as NativeScreenPoint
import YandexMapKit.YMKScreenRect as NativeScreenRect
import YandexMapKit.YMKSize2u as NativeSize2u
import YandexMapKit.YMKTileId as NativeTileId
import YandexMapKit.YMKTime as NativeTime
import YandexMapKit.YMKVersion as NativeVersion
import YandexMapKit.YMKZoomRange as NativeZoomRange

public class ValueConverterTest {

    @Test
    public fun `size2u keeps width and height apart`() {
        val native = Size2u(width = 64, height = 128).toNative()

        assertEquals(64UL, native.width)
        assertEquals(128UL, native.height)

        val common = NativeSize2u.size2uWithWidth(64UL, 128UL).toCommon()

        assertEquals(64, common.width)
        assertEquals(128, common.height)
    }

    @Test
    public fun `tile id keeps x y and z apart`() {
        val native = TileId(x = 3, y = 5, z = 11).toNative()

        assertEquals(3UL, native.x)
        assertEquals(5UL, native.y)
        assertEquals(11UL, native.z)

        val common = NativeTileId.tileIdWithX(3UL, 5UL, 11UL).toCommon()

        assertEquals(3, common.x)
        assertEquals(5, common.y)
        assertEquals(11, common.z)
    }

    @Test
    public fun `zoom range keeps the lower and the upper limit apart`() {
        val native = ZoomRange(zMin = 2, zMax = 19).toNative()

        assertEquals(2UL, native.zMin)
        assertEquals(19UL, native.zMax)

        val common = NativeZoomRange.zoomRangeWithZMin(2UL, 19UL).toCommon()

        assertEquals(2, common.zMin)
        assertEquals(19, common.zMax)
    }

    @Test
    public fun `version carries the version string`() {
        assertEquals("4.42.0", Version("4.42.0").toNative().str)
        assertEquals(Version("4.42.0"), NativeVersion.versionWithStr("4.42.0").toCommon())
    }

    @Test
    public fun `time keeps the value the offset and the text apart`() {
        val native = Time(value = 1_700_000_000L, tzOffset = 10_800, text = "18:00").toNative()

        assertEquals(1_700_000_000L, native.value)
        assertEquals(10_800L, native.tzOffset)
        assertEquals("18:00", native.text)

        val common = NativeTime.timeWithValue(1_700_000_000L, 10_800L, "18:00").toCommon()

        assertEquals(1_700_000_000L, common.value)
        assertEquals(10_800, common.tzOffset)
        assertEquals("18:00", common.text)
    }

    @Test
    public fun `localized value keeps the value and the text apart`() {
        val native = LocalizedValue(value = 1250.0, text = "1,25 km").toNative()

        assertEquals(1250.0, native.value)
        assertEquals("1,25 km", native.text)

        val common = NativeLocalizedValue.localizedValueWithValue(1250.0, "1,25 km").toCommon()

        assertEquals(1250.0, common.value)
        assertEquals("1,25 km", common.text)
    }

    @Test
    public fun `screen point keeps x and y apart`() {
        val native = ScreenPoint(x = 12f, y = 34f).toNative()

        assertEquals(12f, native.x)
        assertEquals(34f, native.y)

        val common = NativeScreenPoint.screenPointWithX(12f, 34f).toCommon()

        assertEquals(12f, common.x)
        assertEquals(34f, common.y)
    }

    @Test
    public fun `screen rect keeps the top left and the bottom right apart`() {
        val native = ScreenRect(
            topLeft = ScreenPoint(1f, 2f),
            bottomRight = ScreenPoint(3f, 4f),
        ).toNative()

        assertEquals(1f, native.topLeft.x)
        assertEquals(2f, native.topLeft.y)
        assertEquals(3f, native.bottomRight.x)
        assertEquals(4f, native.bottomRight.y)

        val common = NativeScreenRect.screenRectWithTopLeft(
            NativeScreenPoint.screenPointWithX(1f, 2f),
            NativeScreenPoint.screenPointWithX(3f, 4f),
        ).toCommon()

        assertEquals(ScreenPoint(1f, 2f), common.topLeft)
        assertEquals(ScreenPoint(3f, 4f), common.bottomRight)
    }

    @Test
    public fun `color keeps the argb channels in the right ui color components`() {
        val native = Color.fromArgb(0x80336699.toInt()).toNative()
        val components = assertNotNull(CGColorGetComponents(native.CGColor))

        assertEquals(0x33, (components[0] * 255).roundToInt())
        assertEquals(0x66, (components[1] * 255).roundToInt())
        assertEquals(0x99, (components[2] * 255).roundToInt())
        assertEquals(0x80, (components[3] * 255).roundToInt())
    }

    @Test
    public fun `color reads the argb channels back from a ui color`() {
        val native = UIColor.colorWithRed(
            red = 0x33 / 255.0,
            green = 0x66 / 255.0,
            blue = 0x99 / 255.0,
            alpha = 0x80 / 255.0,
        )

        assertEquals(0x80336699.toInt(), native.toCommon().toArgb())
    }
}
