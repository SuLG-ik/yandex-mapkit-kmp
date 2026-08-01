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
import YandexMapKit.YMKCameraPosition as NativeCameraPosition
import YandexMapKit.YMKLocationSubscriptionSettings as NativeSubscriptionSettings
import YandexMapKit.YMKLogoAlignment as NativeAlignment
import YandexMapKit.YMKLogoHorizontalAlignment as NativeHorizontalAlignment
import YandexMapKit.YMKLogoPadding as NativePadding
import YandexMapKit.YMKLogoVerticalAlignment as NativeVerticalAlignment
import YandexMapKit.YMKModelStyle as NativeModelStyle
import YandexMapKit.YMKModelStyleRenderMode as NativeRenderMode
import YandexMapKit.YMKModelStyleUnitType as NativeUnitType
import YandexMapKit.YMKPoint as NativePoint
import YandexMapKit.YMKPurpose as NativeLocationPurpose
import YandexMapKit.YMKTextStylePlacement as NativeTextStylePlacement
import YandexMapKit.YMKViewArea as NativeViewArea
import YandexMapKit.YRTCanonicalUnit as NativeCanonicalUnit
import YandexMapKit.YRTI18nPrefs as NativeI18nPrefs
import YandexMapKit.YRTSystemOfMeasurement as NativeSystemOfMeasurement
import YandexMapKit.YRTTimeFormat as NativeTimeFormat

public class StructConverterTest {

    @Test
    public fun `camera position keeps zoom azimuth and tilt apart`() {
        val native = CameraPosition(
            target = Point(55.75, 37.61),
            zoom = 14f,
            azimuth = 30f,
            tilt = 45f,
        ).toNative()

        assertEquals(55.75, native.target.latitude)
        assertEquals(37.61, native.target.longitude)
        assertEquals(14f, native.zoom)
        assertEquals(30f, native.azimuth)
        assertEquals(45f, native.tilt)

        val common = NativeCameraPosition.cameraPositionWithTarget(
            NativePoint.pointWithLatitude(55.75, 37.61),
            14f,
            30f,
            45f,
        ).toCommon()

        assertEquals(14f, common.zoom)
        assertEquals(30f, common.azimuth)
        assertEquals(45f, common.tilt)
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

        assertEquals(1.0, native.topLeft.latitude)
        assertEquals(2.0, native.topLeft.longitude)
        assertEquals(3.0, native.topRight.latitude)
        assertEquals(5.0, native.bottomLeft.latitude)
        assertEquals(7.0, native.bottomRight.latitude)

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

        assertEquals(12f, native.size)
        assertEquals(Color.fromArgb(0xFF112233.toInt()), native.color.toCommon())
        assertEquals(3f, native.outlineWidth)
        assertEquals(Color.fromArgb(0xFF445566.toInt()), native.outlineColor.toCommon())
        assertEquals(NativeTextStylePlacement.YMKTextStylePlacementBottomLeft, native.placement)
        assertEquals(7f, native.offset)
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

        assertEquals(2.5f, native.scale)
        assertEquals(NativeUnitType.YMKModelStyleUnitTypeMeter, native.unitType)
        assertEquals(NativeRenderMode.YMKModelStyleRenderModeBuilding, native.renderMode)
        assertEquals("variant", native.variantName)

        assertEquals(style, native.toCommon())
    }

    @Test
    public fun `model style keeps a null variant name null`() {
        val common = NativeModelStyle.modelStyleWithScale(
            scale = 1f,
            unitType = NativeUnitType.YMKModelStyleUnitTypeUnit,
            renderMode = NativeRenderMode.YMKModelStyleRenderModeUserModel,
            variantName = null,
        ).toCommon()

        assertEquals(null, common.variantName)
    }

    @Test
    public fun `view area keeps lengthwise and transverse apart`() {
        val native = ViewArea(lengthwise = 120.0, transverse = 30.0).toNative()

        assertEquals(120.0, native.lengthwise)
        assertEquals(30.0, native.transverse)

        val common = NativeViewArea.viewAreaWithLengthwise(120.0, 30.0).toCommon()

        assertEquals(120.0, common.lengthwise)
        assertEquals(30.0, common.transverse)
    }

    @Test
    public fun `subscription settings keeps the background flag and the purpose apart`() {
        val native = SubscriptionSettings(
            useInBackground = UseInBackground.DISALLOW,
            purpose = LocationPurpose.SCOOTER_NAVIGATION,
        ).toNative()

        assertEquals(UseInBackground.DISALLOW, native.useInBackground.toCommon())
        assertEquals(NativeLocationPurpose.YMKPurposeScooterNavigation, native.purpose)

        val common = native.toCommon()

        assertEquals(UseInBackground.DISALLOW, common.useInBackground)
        assertEquals(LocationPurpose.SCOOTER_NAVIGATION, common.purpose)
    }

    @Test
    public fun `logo alignment keeps the horizontal and the vertical part apart`() {
        val native = LogoAlignment(
            horizontalAlignment = LogoHorizontalAlignment.RIGHT,
            verticalAlignment = LogoVerticalAlignment.TOP,
        ).toNative()

        assertEquals(NativeHorizontalAlignment.YMKLogoHorizontalAlignmentRight, native.horizontalAlignment)
        assertEquals(NativeVerticalAlignment.YMKLogoVerticalAlignmentTop, native.verticalAlignment)

        val common = NativeAlignment.alignmentWithHorizontalAlignment(
            NativeHorizontalAlignment.YMKLogoHorizontalAlignmentLeft,
            NativeVerticalAlignment.YMKLogoVerticalAlignmentBottom,
        ).toCommon()

        assertEquals(LogoHorizontalAlignment.LEFT, common.horizontalAlignment)
        assertEquals(LogoVerticalAlignment.BOTTOM, common.verticalAlignment)
    }

    @Test
    public fun `logo padding keeps the horizontal and the vertical part apart`() {
        val native = LogoPadding(horizontalPadding = 16, verticalPadding = 8).toNative()

        assertEquals(16UL, native.horizontalPadding)
        assertEquals(8UL, native.verticalPadding)

        val common = NativePadding.paddingWithHorizontalPadding(16UL, 8UL).toCommon()

        assertEquals(16, common.horizontalPadding)
        assertEquals(8, common.verticalPadding)
    }

    @Test
    public fun `i18n prefs keeps the system of measurement and the time format apart`() {
        val native = I18nPrefs(
            som = SystemOfMeasurement.IMPERIAL,
            timeFormat = TimeFormat.H12,
        ).toNative()

        assertEquals(NativeSystemOfMeasurement.YRTSystemOfMeasurementImperial, native.som)
        assertEquals(NativeTimeFormat.YRTTimeFormatH12, native.timeFormat)

        val common = NativeI18nPrefs.i18nPrefsWithSom(
            NativeSystemOfMeasurement.YRTSystemOfMeasurementMetric,
            NativeTimeFormat.YRTTimeFormatH24,
        ).toCommon()

        assertEquals(SystemOfMeasurement.METRIC, common.som)
        assertEquals(TimeFormat.H24, common.timeFormat)
    }

    @Test
    public fun `canonical unit keeps the unit and the value apart`() {
        val native = CanonicalUnit(unit = "km", value = 12.5).toNative()

        assertEquals("km", native.unit)
        assertEquals(12.5, native.value)

        val common = NativeCanonicalUnit.canonicalUnitWithUnit("mi", 3.5).toCommon()

        assertEquals("mi", common.unit)
        assertEquals(3.5, common.value)
    }
}
