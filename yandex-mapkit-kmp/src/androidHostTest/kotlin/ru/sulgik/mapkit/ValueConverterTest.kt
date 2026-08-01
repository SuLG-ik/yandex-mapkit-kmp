package ru.sulgik.mapkit

import kotlin.test.Test
import kotlin.test.assertEquals
import com.yandex.mapkit.LocalizedValue as NativeLocalizedValue
import com.yandex.mapkit.ScreenPoint as NativeScreenPoint
import com.yandex.mapkit.ScreenRect as NativeScreenRect
import com.yandex.mapkit.Size2u as NativeSize2u
import com.yandex.mapkit.TileId as NativeTileId
import com.yandex.mapkit.Time as NativeTime
import com.yandex.mapkit.Version as NativeVersion
import com.yandex.mapkit.ZoomRange as NativeZoomRange

public class ValueConverterTest {

    @Test
    public fun `size2u keeps width and height apart`() {
        val native = Size2u(width = 64, height = 128).toNative()

        assertEquals(64, native.width)
        assertEquals(128, native.height)

        val common = NativeSize2u(64, 128).toCommon()

        assertEquals(64, common.width)
        assertEquals(128, common.height)
    }

    @Test
    public fun `tile id keeps x y and z apart`() {
        val native = TileId(x = 3, y = 5, z = 11).toNative()

        assertEquals(3, native.x)
        assertEquals(5, native.y)
        assertEquals(11, native.z)

        val common = NativeTileId(3, 5, 11).toCommon()

        assertEquals(3, common.x)
        assertEquals(5, common.y)
        assertEquals(11, common.z)
    }

    @Test
    public fun `zoom range keeps the lower and the upper limit apart`() {
        val native = ZoomRange(zMin = 2, zMax = 19).toNative()

        assertEquals(2, native.zMin)
        assertEquals(19, native.zMax)

        val common = NativeZoomRange(2, 19).toCommon()

        assertEquals(2, common.zMin)
        assertEquals(19, common.zMax)
    }

    @Test
    public fun `version carries the version string`() {
        assertEquals("4.42.0", Version("4.42.0").toNative().str)
        assertEquals(Version("4.42.0"), NativeVersion("4.42.0").toCommon())
    }

    @Test
    public fun `time keeps the value the offset and the text apart`() {
        val native = Time(value = 1_700_000_000L, tzOffset = 10_800, text = "18:00").toNative()

        assertEquals(1_700_000_000L, native.value)
        assertEquals(10_800, native.tzOffset)
        assertEquals("18:00", native.text)

        val common = NativeTime(1_700_000_000L, 10_800, "18:00").toCommon()

        assertEquals(1_700_000_000L, common.value)
        assertEquals(10_800, common.tzOffset)
        assertEquals("18:00", common.text)
    }

    @Test
    public fun `localized value keeps the value and the text apart`() {
        val native = LocalizedValue(value = 1250.0, text = "1,25 km").toNative()

        assertEquals(1250.0, native.value, 0.0)
        assertEquals("1,25 km", native.text)

        val common = NativeLocalizedValue(1250.0, "1,25 km").toCommon()

        assertEquals(1250.0, common.value, 0.0)
        assertEquals("1,25 km", common.text)
    }

    @Test
    public fun `screen point keeps x and y apart`() {
        val native = ScreenPoint(x = 12f, y = 34f).toNative()

        assertEquals(12f, native.x, 0f)
        assertEquals(34f, native.y, 0f)

        val common = NativeScreenPoint(12f, 34f).toCommon()

        assertEquals(12f, common.x, 0f)
        assertEquals(34f, common.y, 0f)
    }

    @Test
    public fun `screen rect keeps the top left and the bottom right apart`() {
        val native = ScreenRect(
            topLeft = ScreenPoint(1f, 2f),
            bottomRight = ScreenPoint(3f, 4f),
        ).toNative()

        assertEquals(1f, native.topLeft.x, 0f)
        assertEquals(2f, native.topLeft.y, 0f)
        assertEquals(3f, native.bottomRight.x, 0f)
        assertEquals(4f, native.bottomRight.y, 0f)

        val common = NativeScreenRect(NativeScreenPoint(1f, 2f), NativeScreenPoint(3f, 4f)).toCommon()

        assertEquals(ScreenPoint(1f, 2f), common.topLeft)
        assertEquals(ScreenPoint(3f, 4f), common.bottomRight)
    }

    @Test
    public fun `color keeps the argb channels in place`() {
        val color = Color.fromArgb(0x80336699.toInt())

        assertEquals(0x80336699.toInt(), color.toArgb())
    }
}
