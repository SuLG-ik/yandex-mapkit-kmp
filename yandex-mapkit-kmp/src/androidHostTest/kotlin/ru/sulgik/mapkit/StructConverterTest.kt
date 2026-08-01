package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.location.LocationPurpose
import ru.sulgik.mapkit.location.SubscriptionSettings
import ru.sulgik.mapkit.location.UseInBackground
import ru.sulgik.mapkit.location.ViewArea
import ru.sulgik.mapkit.location.toCommon
import ru.sulgik.mapkit.location.toNative
import ru.sulgik.mapkit.logo.LogoAlignment
import ru.sulgik.mapkit.logo.LogoHorizontalAlignment
import ru.sulgik.mapkit.logo.LogoPadding
import ru.sulgik.mapkit.logo.LogoVerticalAlignment
import ru.sulgik.mapkit.logo.toCommon
import ru.sulgik.mapkit.logo.toNative
import ru.sulgik.mapkit.map.CameraPosition
import ru.sulgik.mapkit.map.LineStyle
import ru.sulgik.mapkit.map.ModelStyle
import ru.sulgik.mapkit.map.TextStyle
import ru.sulgik.mapkit.map.VisibleRegion
import ru.sulgik.mapkit.map.toCommon
import ru.sulgik.mapkit.map.toNative
import ru.sulgik.mapkit.runtime.i18n.CanonicalUnit
import ru.sulgik.mapkit.runtime.i18n.I18nPrefs
import ru.sulgik.mapkit.runtime.i18n.SystemOfMeasurement
import ru.sulgik.mapkit.runtime.i18n.TimeFormat
import ru.sulgik.mapkit.runtime.i18n.toCommon
import ru.sulgik.mapkit.runtime.i18n.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import com.yandex.mapkit.geometry.Point as NativePoint
import com.yandex.mapkit.location.Purpose as NativeLocationPurpose
import com.yandex.mapkit.location.SubscriptionSettings as NativeSubscriptionSettings
import com.yandex.mapkit.location.UseInBackground as NativeUseInBackground
import com.yandex.mapkit.location.ViewArea as NativeViewArea
import com.yandex.mapkit.logo.Alignment as NativeAlignment
import com.yandex.mapkit.logo.HorizontalAlignment as NativeHorizontalAlignment
import com.yandex.mapkit.logo.Padding as NativePadding
import com.yandex.mapkit.logo.VerticalAlignment as NativeVerticalAlignment
import com.yandex.mapkit.map.CameraPosition as NativeCameraPosition
import com.yandex.mapkit.map.ModelStyle as NativeModelStyle
import com.yandex.mapkit.map.TextStyle as NativeTextStyle
import com.yandex.runtime.i18n.CanonicalUnit as NativeCanonicalUnit
import com.yandex.runtime.i18n.I18nPrefs as NativeI18nPrefs
import com.yandex.runtime.i18n.SystemOfMeasurement as NativeSystemOfMeasurement
import com.yandex.runtime.i18n.TimeFormat as NativeTimeFormat

public class StructConverterTest {

    @Test
    public fun `camera position keeps zoom azimuth and tilt apart`() {
        val native = CameraPosition(
            target = Point(55.75, 37.61),
            zoom = 14f,
            azimuth = 30f,
            tilt = 45f,
        ).toNative()

        assertEquals(55.75, native.target.latitude, 0.0)
        assertEquals(37.61, native.target.longitude, 0.0)
        assertEquals(14f, native.zoom, 0f)
        assertEquals(30f, native.azimuth, 0f)
        assertEquals(45f, native.tilt, 0f)

        val common = NativeCameraPosition(NativePoint(55.75, 37.61), 14f, 30f, 45f).toCommon()

        assertEquals(14f, common.zoom, 0f)
        assertEquals(30f, common.azimuth, 0f)
        assertEquals(45f, common.tilt, 0f)
        assertEquals(Point(55.75, 37.61), common.target)
    }

    @Test
    public fun `visible region keeps every corner in its own native field`() {
        val region = VisibleRegion(
            topLeft = Point(1.0, 2.0),
            topRight = Point(3.0, 4.0),
            bottomLeft = Point(5.0, 6.0),
            bottomRight = Point(7.0, 8.0),
        )

        val native = region.toNative()

        assertEquals(1.0, native.topLeft.latitude, 0.0)
        assertEquals(2.0, native.topLeft.longitude, 0.0)
        assertEquals(3.0, native.topRight.latitude, 0.0)
        assertEquals(5.0, native.bottomLeft.latitude, 0.0)
        assertEquals(7.0, native.bottomRight.latitude, 0.0)

        assertEquals(region, native.toCommon())
    }

    @Test
    public fun `text style keeps the two colors and the two widths apart`() {
        val style = TextStyle(
            size = 12f,
            color = Color.fromArgb(0xFF112233.toInt()),
            outlineWidth = 3f,
            outlineColor = Color.fromArgb(0xFF445566.toInt()),
            placement = TextStyle.Placement.BOTTOM_LEFT,
            offset = 7f,
            offsetFromIcon = false,
            textOptional = true,
        )

        val native = style.toNative()

        assertEquals(12f, native.size, 0f)
        assertEquals(0xFF112233.toInt(), native.color)
        assertEquals(3f, native.outlineWidth, 0f)
        assertEquals(0xFF445566.toInt(), native.outlineColor)
        assertEquals(NativeTextStyle.Placement.BOTTOM_LEFT, native.placement)
        assertEquals(7f, native.offset, 0f)
        assertEquals(false, native.offsetFromIcon)
        assertEquals(true, native.textOptional)

        assertEquals(style, native.toCommon())
    }

    @Test
    public fun `model style keeps scale unit type render mode and variant apart`() {
        val style = ModelStyle(
            scale = 2.5f,
            unitType = ModelStyle.UnitType.METER,
            renderMode = ModelStyle.RenderMode.BUILDING,
            variantName = "variant",
        )

        val native = style.toNative()

        assertEquals(2.5f, native.scale, 0f)
        assertEquals(NativeModelStyle.UnitType.METER, native.unitType)
        assertEquals(NativeModelStyle.RenderMode.BUILDING, native.renderMode)
        assertEquals("variant", native.variantName)

        assertEquals(style, native.toCommon())
    }

    @Test
    public fun `model style keeps a null variant name null`() {
        val common = NativeModelStyle(
            1f,
            NativeModelStyle.UnitType.UNIT,
            NativeModelStyle.RenderMode.USER_MODEL,
            null,
        ).toCommon()

        assertEquals(null, common.variantName)
    }

    @Test
    public fun `line style keeps every width the radius and the outline color apart`() {
        val style = LineStyle(
            strokeWidth = 2f,
            gradientLength = 3f,
            outlineColor = Color.fromArgb(0xFF778899.toInt()),
            outlineWidth = 4f,
            innerOutlineEnabled = true,
            turnRadius = 5f,
            arcApproximationStep = 6f,
            dashLength = 7f,
            gapLength = 8f,
            dashOffset = 9f,
        )

        val native = style.toNative()

        assertEquals(2f, native.strokeWidth, 0f)
        assertEquals(3f, native.gradientLength, 0f)
        assertEquals(0xFF778899.toInt(), native.outlineColor)
        assertEquals(4f, native.outlineWidth, 0f)
        assertEquals(true, native.innerOutlineEnabled)
        assertEquals(5f, native.turnRadius, 0f)
        assertEquals(6f, native.arcApproximationStep, 0f)
        assertEquals(7f, native.dashLength, 0f)
        assertEquals(8f, native.gapLength, 0f)
        assertEquals(9f, native.dashOffset, 0f)

        assertEquals(style, native.toCommon())
    }

    @Test
    public fun `view area keeps lengthwise and transverse apart`() {
        val native = ViewArea(lengthwise = 120.0, transverse = 30.0).toNative()

        assertEquals(120.0, native.lengthwise, 0.0)
        assertEquals(30.0, native.transverse, 0.0)

        val common = NativeViewArea(120.0, 30.0).toCommon()

        assertEquals(120.0, common.lengthwise, 0.0)
        assertEquals(30.0, common.transverse, 0.0)
    }

    @Test
    public fun `subscription settings keeps the background flag and the purpose apart`() {
        val native = SubscriptionSettings(
            useInBackground = UseInBackground.DISALLOW,
            purpose = LocationPurpose.SCOOTER_NAVIGATION,
        ).toNative()

        assertEquals(NativeUseInBackground.DISALLOW, native.useInBackground)
        assertEquals(NativeLocationPurpose.SCOOTER_NAVIGATION, native.purpose)

        val common = NativeSubscriptionSettings(
            NativeUseInBackground.ALLOW,
            NativeLocationPurpose.BICYCLE_NAVIGATION,
        ).toCommon()

        assertEquals(UseInBackground.ALLOW, common.useInBackground)
        assertEquals(LocationPurpose.BICYCLE_NAVIGATION, common.purpose)
    }

    @Test
    public fun `logo alignment keeps the horizontal and the vertical part apart`() {
        val native = LogoAlignment(
            horizontalAlignment = LogoHorizontalAlignment.RIGHT,
            verticalAlignment = LogoVerticalAlignment.TOP,
        ).toNative()

        assertEquals(NativeHorizontalAlignment.RIGHT, native.horizontalAlignment)
        assertEquals(NativeVerticalAlignment.TOP, native.verticalAlignment)

        val common = NativeAlignment(NativeHorizontalAlignment.LEFT, NativeVerticalAlignment.BOTTOM).toCommon()

        assertEquals(LogoHorizontalAlignment.LEFT, common.horizontalAlignment)
        assertEquals(LogoVerticalAlignment.BOTTOM, common.verticalAlignment)
    }

    @Test
    public fun `logo padding keeps the horizontal and the vertical part apart`() {
        val native = LogoPadding(horizontalPadding = 16, verticalPadding = 8).toNative()

        assertEquals(16, native.horizontalPadding)
        assertEquals(8, native.verticalPadding)

        val common = NativePadding(16, 8).toCommon()

        assertEquals(16, common.horizontalPadding)
        assertEquals(8, common.verticalPadding)
    }

    @Test
    public fun `i18n prefs keeps the system of measurement and the time format apart`() {
        val native = I18nPrefs(
            som = SystemOfMeasurement.IMPERIAL,
            timeFormat = TimeFormat.H12,
        ).toNative()

        assertEquals(NativeSystemOfMeasurement.IMPERIAL, native.som)
        assertEquals(NativeTimeFormat.H12, native.timeFormat)

        val common = NativeI18nPrefs(NativeSystemOfMeasurement.METRIC, NativeTimeFormat.H24).toCommon()

        assertEquals(SystemOfMeasurement.METRIC, common.som)
        assertEquals(TimeFormat.H24, common.timeFormat)
    }

    @Test
    public fun `canonical unit keeps the unit and the value apart`() {
        val native = CanonicalUnit(unit = "km", value = 12.5).toNative()

        assertEquals("km", native.unit)
        assertEquals(12.5, native.value, 0.0)

        val common = NativeCanonicalUnit("mi", 3.5).toCommon()

        assertEquals("mi", common.unit)
        assertEquals(3.5, common.value, 0.0)
    }
}
