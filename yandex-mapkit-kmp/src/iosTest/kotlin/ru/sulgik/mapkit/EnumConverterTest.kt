package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.geo.Priority
import ru.sulgik.mapkit.geometry.geo.toCommon
import ru.sulgik.mapkit.geometry.geo.toNative
import ru.sulgik.mapkit.layers.OverzoomMode
import ru.sulgik.mapkit.layers.TileFormat
import ru.sulgik.mapkit.layers.toCommon
import ru.sulgik.mapkit.layers.toNative
import ru.sulgik.mapkit.location.DummyLocationQuality
import ru.sulgik.mapkit.location.LocationPurpose
import ru.sulgik.mapkit.location.LocationStatus
import ru.sulgik.mapkit.location.UseInBackground
import ru.sulgik.mapkit.location.toCommon
import ru.sulgik.mapkit.location.toNative
import ru.sulgik.mapkit.logo.LogoHorizontalAlignment
import ru.sulgik.mapkit.logo.LogoVerticalAlignment
import ru.sulgik.mapkit.logo.toCommon
import ru.sulgik.mapkit.logo.toNative
import ru.sulgik.mapkit.map.CameraUpdateReason
import ru.sulgik.mapkit.map.GestureFocusPointMode
import ru.sulgik.mapkit.map.MapMode
import ru.sulgik.mapkit.map.MapType
import ru.sulgik.mapkit.map.ModelStyle
import ru.sulgik.mapkit.map.PointOfView
import ru.sulgik.mapkit.map.TextStyle
import ru.sulgik.mapkit.map.toCommon
import ru.sulgik.mapkit.map.toNative
import ru.sulgik.mapkit.offline_cache.RegionState
import ru.sulgik.mapkit.offline_cache.toCommon
import ru.sulgik.mapkit.offline_cache.toNative
import ru.sulgik.mapkit.runtime.i18n.SystemOfMeasurement
import ru.sulgik.mapkit.runtime.i18n.TimeFormat
import ru.sulgik.mapkit.runtime.i18n.toCommon
import ru.sulgik.mapkit.runtime.i18n.toNative
import ru.sulgik.mapkit.runtime.logging.LogMessage
import ru.sulgik.mapkit.runtime.logging.toCommon
import ru.sulgik.mapkit.runtime.logging.toNative
import ru.sulgik.mapkit.traffic.TrafficColor
import ru.sulgik.mapkit.traffic.toCommon
import ru.sulgik.mapkit.traffic.toNative
import ru.sulgik.mapkit.user_location.UserLocationAnchorType
import ru.sulgik.mapkit.user_location.UserLocationIconType
import ru.sulgik.mapkit.user_location.toCommon
import ru.sulgik.mapkit.user_location.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import YandexMapKit.YMKCameraUpdateReason as NativeCameraUpdateReason
import YandexMapKit.YMKConflictResolutionMode as NativeConflictResolutionMode
import YandexMapKit.YMKDummyLocationQuality as NativeDummyLocationQuality
import YandexMapKit.YMKGestureFocusPointMode as NativeGestureFocusPointMode
import YandexMapKit.YMKLocationStatus as NativeLocationStatus
import YandexMapKit.YMKLocationUseInBackground as NativeUseInBackground
import YandexMapKit.YMKLogoHorizontalAlignment as NativeHorizontalAlignment
import YandexMapKit.YMKLogoVerticalAlignment as NativeVerticalAlignment
import YandexMapKit.YMKMapMode as NativeMapMode
import YandexMapKit.YMKMapType as NativeMapType
import YandexMapKit.YMKModelStyleRenderMode as NativeRenderMode
import YandexMapKit.YMKModelStyleUnitType as NativeUnitType
import YandexMapKit.YMKOfflineCacheRegionState as NativeRegionState
import YandexMapKit.YMKOverzoomMode as NativeOverzoomMode
import YandexMapKit.YMKPointOfView as NativePointOfView
import YandexMapKit.YMKPolylineIndexPriority as NativePriority
import YandexMapKit.YMKPurpose as NativeLocationPurpose
import YandexMapKit.YMKRawTileState as NativeState
import YandexMapKit.YMKRawTileUseCache as NativeUseCache
import YandexMapKit.YMKTextStylePlacement as NativeTextStylePlacement
import YandexMapKit.YMKTileFormat as NativeTileFormat
import YandexMapKit.YMKTrafficColor as NativeTrafficColor
import YandexMapKit.YMKUserLocationAnchorType as NativeUserLocationAnchorType
import YandexMapKit.YMKUserLocationIconType as NativeUserLocationIconType
import YandexMapKit.YRTLogMessageLogLevel as NativeLogLevel
import YandexMapKit.YRTSystemOfMeasurement as NativeSystemOfMeasurement
import YandexMapKit.YRTTimeFormat as NativeTimeFormat

public class EnumConverterTest {

    @Test
    public fun `map type maps every constant`() {
        assertEquals(NativeMapType.YMKMapTypeNone, MapType.NONE.toNative())
        assertEquals(NativeMapType.YMKMapTypeMap, MapType.MAP.toNative())
        assertEquals(NativeMapType.YMKMapTypeSatellite, MapType.SATELLITE.toNative())
        assertEquals(NativeMapType.YMKMapTypeHybrid, MapType.HYBRID.toNative())
        assertEquals(NativeMapType.YMKMapTypeVectorMap, MapType.VECTOR_MAP.toNative())

        assertEquals(MapType.NONE, NativeMapType.YMKMapTypeNone.toCommon())
        assertEquals(MapType.MAP, NativeMapType.YMKMapTypeMap.toCommon())
        assertEquals(MapType.SATELLITE, NativeMapType.YMKMapTypeSatellite.toCommon())
        assertEquals(MapType.HYBRID, NativeMapType.YMKMapTypeHybrid.toCommon())
        assertEquals(MapType.VECTOR_MAP, NativeMapType.YMKMapTypeVectorMap.toCommon())

        assertEquals(MapType.entries.size, MapType.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `map mode maps every constant`() {
        assertEquals(NativeMapMode.YMKMapModeMap, MapMode.MAP.toNative())
        assertEquals(NativeMapMode.YMKMapModeTransit, MapMode.TRANSIT.toNative())
        assertEquals(NativeMapMode.YMKMapModeDriving, MapMode.DRIVING.toNative())
        assertEquals(NativeMapMode.YMKMapModeAdmin, MapMode.ADMIN.toNative())
        assertEquals(NativeMapMode.YMKMapModeLegacyMap, MapMode.LEGACY_MAP.toNative())
        assertEquals(NativeMapMode.YMKMapModeFutureMap, MapMode.FUTURE_MAP.toNative())
        assertEquals(NativeMapMode.YMKMapModeHybrid, MapMode.HYBRID.toNative())

        assertEquals(MapMode.MAP, NativeMapMode.YMKMapModeMap.toCommon())
        assertEquals(MapMode.TRANSIT, NativeMapMode.YMKMapModeTransit.toCommon())
        assertEquals(MapMode.DRIVING, NativeMapMode.YMKMapModeDriving.toCommon())
        assertEquals(MapMode.ADMIN, NativeMapMode.YMKMapModeAdmin.toCommon())
        assertEquals(MapMode.LEGACY_MAP, NativeMapMode.YMKMapModeLegacyMap.toCommon())
        assertEquals(MapMode.FUTURE_MAP, NativeMapMode.YMKMapModeFutureMap.toCommon())
        assertEquals(MapMode.HYBRID, NativeMapMode.YMKMapModeHybrid.toCommon())

        assertEquals(MapMode.entries.size, MapMode.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `point of view maps every constant`() {
        assertEquals(NativePointOfView.YMKPointOfViewScreenCenter, PointOfView.SCREEN_CENTER.toNative())
        assertEquals(NativePointOfView.YMKPointOfViewAdaptToFocusPointHorizontally, PointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY.toNative())

        assertEquals(PointOfView.SCREEN_CENTER, NativePointOfView.YMKPointOfViewScreenCenter.toCommon())
        assertEquals(PointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY, NativePointOfView.YMKPointOfViewAdaptToFocusPointHorizontally.toCommon())

        assertEquals(PointOfView.entries.size, PointOfView.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `gesture focus point mode maps every constant`() {
        assertEquals(NativeGestureFocusPointMode.YMKGestureFocusPointModeAffectsTapGestures, GestureFocusPointMode.AFFECTS_TAP_GESTURES.toNative())
        assertEquals(NativeGestureFocusPointMode.YMKGestureFocusPointModeAffectsAllGestures, GestureFocusPointMode.AFFECTS_ALL_GESTURES.toNative())

        assertEquals(GestureFocusPointMode.AFFECTS_TAP_GESTURES, NativeGestureFocusPointMode.YMKGestureFocusPointModeAffectsTapGestures.toCommon())
        assertEquals(GestureFocusPointMode.AFFECTS_ALL_GESTURES, NativeGestureFocusPointMode.YMKGestureFocusPointModeAffectsAllGestures.toCommon())

        assertEquals(GestureFocusPointMode.entries.size, GestureFocusPointMode.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `camera update reason maps every constant`() {
        assertEquals(NativeCameraUpdateReason.YMKCameraUpdateReasonGestures, CameraUpdateReason.GESTURES.toNative())
        assertEquals(NativeCameraUpdateReason.YMKCameraUpdateReasonApplication, CameraUpdateReason.APPLICATION.toNative())

        assertEquals(CameraUpdateReason.GESTURES, NativeCameraUpdateReason.YMKCameraUpdateReasonGestures.toCommon())
        assertEquals(CameraUpdateReason.APPLICATION, NativeCameraUpdateReason.YMKCameraUpdateReasonApplication.toCommon())

        assertEquals(CameraUpdateReason.entries.size, CameraUpdateReason.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `conflict resolution mode maps every constant`() {
        assertEquals(NativeConflictResolutionMode.YMKConflictResolutionModeMinor, ConflictResolutionMode.MINOR.toNative())
        assertEquals(NativeConflictResolutionMode.YMKConflictResolutionModeEqual, ConflictResolutionMode.EQUAL.toNative())
        assertEquals(NativeConflictResolutionMode.YMKConflictResolutionModeMajor, ConflictResolutionMode.MAJOR.toNative())
        assertEquals(NativeConflictResolutionMode.YMKConflictResolutionModeIgnore, ConflictResolutionMode.IGNORE.toNative())

        assertEquals(ConflictResolutionMode.MINOR, NativeConflictResolutionMode.YMKConflictResolutionModeMinor.toCommon())
        assertEquals(ConflictResolutionMode.EQUAL, NativeConflictResolutionMode.YMKConflictResolutionModeEqual.toCommon())
        assertEquals(ConflictResolutionMode.MAJOR, NativeConflictResolutionMode.YMKConflictResolutionModeMajor.toCommon())
        assertEquals(ConflictResolutionMode.IGNORE, NativeConflictResolutionMode.YMKConflictResolutionModeIgnore.toCommon())

        assertEquals(ConflictResolutionMode.entries.size, ConflictResolutionMode.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `tile format maps every constant`() {
        assertEquals(NativeTileFormat.YMKTileFormatPng, TileFormat.PNG.toNative())
        assertEquals(NativeTileFormat.YMKTileFormatJpg, TileFormat.JPG.toNative())
        assertEquals(NativeTileFormat.YMKTileFormatVector2, TileFormat.VECTOR2.toNative())
        assertEquals(NativeTileFormat.YMKTileFormatVector3, TileFormat.VECTOR3.toNative())
        assertEquals(NativeTileFormat.YMKTileFormatGeoJson, TileFormat.GEO_JSON.toNative())

        assertEquals(TileFormat.PNG, NativeTileFormat.YMKTileFormatPng.toCommon())
        assertEquals(TileFormat.JPG, NativeTileFormat.YMKTileFormatJpg.toCommon())
        assertEquals(TileFormat.VECTOR2, NativeTileFormat.YMKTileFormatVector2.toCommon())
        assertEquals(TileFormat.VECTOR3, NativeTileFormat.YMKTileFormatVector3.toCommon())
        assertEquals(TileFormat.GEO_JSON, NativeTileFormat.YMKTileFormatGeoJson.toCommon())

        assertEquals(TileFormat.entries.size, TileFormat.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `overzoom mode maps every constant`() {
        assertEquals(NativeOverzoomMode.YMKOverzoomModeDisabled, OverzoomMode.DISABLED.toNative())
        assertEquals(NativeOverzoomMode.YMKOverzoomModeEnabled, OverzoomMode.ENABLED.toNative())
        assertEquals(NativeOverzoomMode.YMKOverzoomModeWithPrefetch, OverzoomMode.WITH_PREFETCH.toNative())

        assertEquals(OverzoomMode.DISABLED, NativeOverzoomMode.YMKOverzoomModeDisabled.toCommon())
        assertEquals(OverzoomMode.ENABLED, NativeOverzoomMode.YMKOverzoomModeEnabled.toCommon())
        assertEquals(OverzoomMode.WITH_PREFETCH, NativeOverzoomMode.YMKOverzoomModeWithPrefetch.toCommon())

        assertEquals(OverzoomMode.entries.size, OverzoomMode.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `traffic color maps every constant`() {
        assertEquals(NativeTrafficColor.YMKTrafficColorRed, TrafficColor.RED.toNative())
        assertEquals(NativeTrafficColor.YMKTrafficColorYellow, TrafficColor.YELLOW.toNative())
        assertEquals(NativeTrafficColor.YMKTrafficColorGreen, TrafficColor.GREEN.toNative())

        assertEquals(TrafficColor.RED, NativeTrafficColor.YMKTrafficColorRed.toCommon())
        assertEquals(TrafficColor.YELLOW, NativeTrafficColor.YMKTrafficColorYellow.toCommon())
        assertEquals(TrafficColor.GREEN, NativeTrafficColor.YMKTrafficColorGreen.toCommon())

        assertEquals(TrafficColor.entries.size, TrafficColor.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `region state maps every constant`() {
        assertEquals(NativeRegionState.YMKOfflineCacheRegionStateAvailable, RegionState.AVAILABLE.toNative())
        assertEquals(NativeRegionState.YMKOfflineCacheRegionStateDownloading, RegionState.DOWNLOADING.toNative())
        assertEquals(NativeRegionState.YMKOfflineCacheRegionStatePaused, RegionState.PAUSED.toNative())
        assertEquals(NativeRegionState.YMKOfflineCacheRegionStateCompleted, RegionState.COMPLETED.toNative())
        assertEquals(NativeRegionState.YMKOfflineCacheRegionStateOutdated, RegionState.OUTDATED.toNative())
        assertEquals(NativeRegionState.YMKOfflineCacheRegionStateUnsupported, RegionState.UNSUPPORTED.toNative())
        assertEquals(NativeRegionState.YMKOfflineCacheRegionStateNeedUpdate, RegionState.NEED_UPDATE.toNative())

        assertEquals(RegionState.AVAILABLE, NativeRegionState.YMKOfflineCacheRegionStateAvailable.toCommon())
        assertEquals(RegionState.DOWNLOADING, NativeRegionState.YMKOfflineCacheRegionStateDownloading.toCommon())
        assertEquals(RegionState.PAUSED, NativeRegionState.YMKOfflineCacheRegionStatePaused.toCommon())
        assertEquals(RegionState.COMPLETED, NativeRegionState.YMKOfflineCacheRegionStateCompleted.toCommon())
        assertEquals(RegionState.OUTDATED, NativeRegionState.YMKOfflineCacheRegionStateOutdated.toCommon())
        assertEquals(RegionState.UNSUPPORTED, NativeRegionState.YMKOfflineCacheRegionStateUnsupported.toCommon())
        assertEquals(RegionState.NEED_UPDATE, NativeRegionState.YMKOfflineCacheRegionStateNeedUpdate.toCommon())

        assertEquals(RegionState.entries.size, RegionState.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `log level maps every constant`() {
        assertEquals(NativeLogLevel.YRTLogMessageLogLevelError, LogMessage.LogLevel.ERROR.toNative())
        assertEquals(NativeLogLevel.YRTLogMessageLogLevelWarning, LogMessage.LogLevel.WARNING.toNative())
        assertEquals(NativeLogLevel.YRTLogMessageLogLevelInfo, LogMessage.LogLevel.INFO.toNative())
        assertEquals(NativeLogLevel.YRTLogMessageLogLevelDebug, LogMessage.LogLevel.DEBUG.toNative())

        assertEquals(LogMessage.LogLevel.ERROR, NativeLogLevel.YRTLogMessageLogLevelError.toCommon())
        assertEquals(LogMessage.LogLevel.WARNING, NativeLogLevel.YRTLogMessageLogLevelWarning.toCommon())
        assertEquals(LogMessage.LogLevel.INFO, NativeLogLevel.YRTLogMessageLogLevelInfo.toCommon())
        assertEquals(LogMessage.LogLevel.DEBUG, NativeLogLevel.YRTLogMessageLogLevelDebug.toCommon())

        assertEquals(LogMessage.LogLevel.entries.size, LogMessage.LogLevel.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `system of measurement maps every constant`() {
        assertEquals(NativeSystemOfMeasurement.YRTSystemOfMeasurementDefault, SystemOfMeasurement.DEFAULT.toNative())
        assertEquals(NativeSystemOfMeasurement.YRTSystemOfMeasurementMetric, SystemOfMeasurement.METRIC.toNative())
        assertEquals(NativeSystemOfMeasurement.YRTSystemOfMeasurementImperial, SystemOfMeasurement.IMPERIAL.toNative())

        assertEquals(SystemOfMeasurement.DEFAULT, NativeSystemOfMeasurement.YRTSystemOfMeasurementDefault.toCommon())
        assertEquals(SystemOfMeasurement.METRIC, NativeSystemOfMeasurement.YRTSystemOfMeasurementMetric.toCommon())
        assertEquals(SystemOfMeasurement.IMPERIAL, NativeSystemOfMeasurement.YRTSystemOfMeasurementImperial.toCommon())

        assertEquals(SystemOfMeasurement.entries.size, SystemOfMeasurement.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `time format maps every constant`() {
        assertEquals(NativeTimeFormat.YRTTimeFormatDefault, TimeFormat.DEFAULT.toNative())
        assertEquals(NativeTimeFormat.YRTTimeFormatH24, TimeFormat.H24.toNative())
        assertEquals(NativeTimeFormat.YRTTimeFormatH12, TimeFormat.H12.toNative())

        assertEquals(TimeFormat.DEFAULT, NativeTimeFormat.YRTTimeFormatDefault.toCommon())
        assertEquals(TimeFormat.H24, NativeTimeFormat.YRTTimeFormatH24.toCommon())
        assertEquals(TimeFormat.H12, NativeTimeFormat.YRTTimeFormatH12.toCommon())

        assertEquals(TimeFormat.entries.size, TimeFormat.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `location purpose maps every constant`() {
        assertEquals(NativeLocationPurpose.YMKPurposeGeneral, LocationPurpose.GENERAL.toNative())
        assertEquals(NativeLocationPurpose.YMKPurposeAutomotiveNavigation, LocationPurpose.AUTOMOTIVE_NAVIGATION.toNative())
        assertEquals(NativeLocationPurpose.YMKPurposePedestrianNavigation, LocationPurpose.PEDESTRIAN_NAVIGATION.toNative())
        assertEquals(NativeLocationPurpose.YMKPurposeBicycleNavigation, LocationPurpose.BICYCLE_NAVIGATION.toNative())
        assertEquals(NativeLocationPurpose.YMKPurposeScooterNavigation, LocationPurpose.SCOOTER_NAVIGATION.toNative())
        assertEquals(NativeLocationPurpose.YMKPurposeStaticDisplayLocation, LocationPurpose.STATIC_DISPLAY_LOCATION.toNative())

        assertEquals(LocationPurpose.GENERAL, NativeLocationPurpose.YMKPurposeGeneral.toCommon())
        assertEquals(LocationPurpose.AUTOMOTIVE_NAVIGATION, NativeLocationPurpose.YMKPurposeAutomotiveNavigation.toCommon())
        assertEquals(LocationPurpose.PEDESTRIAN_NAVIGATION, NativeLocationPurpose.YMKPurposePedestrianNavigation.toCommon())
        assertEquals(LocationPurpose.BICYCLE_NAVIGATION, NativeLocationPurpose.YMKPurposeBicycleNavigation.toCommon())
        assertEquals(LocationPurpose.SCOOTER_NAVIGATION, NativeLocationPurpose.YMKPurposeScooterNavigation.toCommon())
        assertEquals(LocationPurpose.STATIC_DISPLAY_LOCATION, NativeLocationPurpose.YMKPurposeStaticDisplayLocation.toCommon())

        assertEquals(LocationPurpose.entries.size, LocationPurpose.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `use in background maps every constant`() {
        assertEquals(NativeUseInBackground.YMKLocationUseInBackgroundAllow, UseInBackground.ALLOW.toNative())
        assertEquals(NativeUseInBackground.YMKLocationUseInBackgroundDisallow, UseInBackground.DISALLOW.toNative())

        assertEquals(UseInBackground.ALLOW, NativeUseInBackground.YMKLocationUseInBackgroundAllow.toCommon())
        assertEquals(UseInBackground.DISALLOW, NativeUseInBackground.YMKLocationUseInBackgroundDisallow.toCommon())

        assertEquals(UseInBackground.entries.size, UseInBackground.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `location status maps every constant`() {
        assertEquals(NativeLocationStatus.YMKLocationStatusNotAvailable, LocationStatus.NOT_AVAILABLE.toNative())
        assertEquals(NativeLocationStatus.YMKLocationStatusAvailable, LocationStatus.AVAILABLE.toNative())
        assertEquals(NativeLocationStatus.YMKLocationStatusReset, LocationStatus.RESET.toNative())

        assertEquals(LocationStatus.NOT_AVAILABLE, NativeLocationStatus.YMKLocationStatusNotAvailable.toCommon())
        assertEquals(LocationStatus.AVAILABLE, NativeLocationStatus.YMKLocationStatusAvailable.toCommon())
        assertEquals(LocationStatus.RESET, NativeLocationStatus.YMKLocationStatusReset.toCommon())

        assertEquals(LocationStatus.entries.size, LocationStatus.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `dummy location quality maps every constant`() {
        assertEquals(NativeDummyLocationQuality.YMKDummyLocationQualityHigh, DummyLocationQuality.HIGH.toNative())
        assertEquals(NativeDummyLocationQuality.YMKDummyLocationQualityLow, DummyLocationQuality.LOW.toNative())

        assertEquals(DummyLocationQuality.HIGH, NativeDummyLocationQuality.YMKDummyLocationQualityHigh.toCommon())
        assertEquals(DummyLocationQuality.LOW, NativeDummyLocationQuality.YMKDummyLocationQualityLow.toCommon())

        assertEquals(DummyLocationQuality.entries.size, DummyLocationQuality.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `user location anchor type maps every constant`() {
        assertEquals(NativeUserLocationAnchorType.YMKUserLocationAnchorTypeNormal, UserLocationAnchorType.NORMAL.toNative())
        assertEquals(NativeUserLocationAnchorType.YMKUserLocationAnchorTypeCourse, UserLocationAnchorType.COURSE.toNative())

        assertEquals(UserLocationAnchorType.NORMAL, NativeUserLocationAnchorType.YMKUserLocationAnchorTypeNormal.toCommon())
        assertEquals(UserLocationAnchorType.COURSE, NativeUserLocationAnchorType.YMKUserLocationAnchorTypeCourse.toCommon())

        assertEquals(UserLocationAnchorType.entries.size, UserLocationAnchorType.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `user location icon type maps every constant`() {
        assertEquals(NativeUserLocationIconType.YMKUserLocationIconTypeArrow, UserLocationIconType.ARROW.toNative())
        assertEquals(NativeUserLocationIconType.YMKUserLocationIconTypePin, UserLocationIconType.PIN.toNative())

        assertEquals(UserLocationIconType.ARROW, NativeUserLocationIconType.YMKUserLocationIconTypeArrow.toCommon())
        assertEquals(UserLocationIconType.PIN, NativeUserLocationIconType.YMKUserLocationIconTypePin.toCommon())

        assertEquals(UserLocationIconType.entries.size, UserLocationIconType.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `logo horizontal alignment maps every constant`() {
        assertEquals(NativeHorizontalAlignment.YMKLogoHorizontalAlignmentLeft, LogoHorizontalAlignment.LEFT.toNative())
        assertEquals(NativeHorizontalAlignment.YMKLogoHorizontalAlignmentCenter, LogoHorizontalAlignment.CENTER.toNative())
        assertEquals(NativeHorizontalAlignment.YMKLogoHorizontalAlignmentRight, LogoHorizontalAlignment.RIGHT.toNative())

        assertEquals(LogoHorizontalAlignment.LEFT, NativeHorizontalAlignment.YMKLogoHorizontalAlignmentLeft.toCommon())
        assertEquals(LogoHorizontalAlignment.CENTER, NativeHorizontalAlignment.YMKLogoHorizontalAlignmentCenter.toCommon())
        assertEquals(LogoHorizontalAlignment.RIGHT, NativeHorizontalAlignment.YMKLogoHorizontalAlignmentRight.toCommon())

        assertEquals(LogoHorizontalAlignment.entries.size, LogoHorizontalAlignment.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `logo vertical alignment maps every constant`() {
        assertEquals(NativeVerticalAlignment.YMKLogoVerticalAlignmentTop, LogoVerticalAlignment.TOP.toNative())
        assertEquals(NativeVerticalAlignment.YMKLogoVerticalAlignmentBottom, LogoVerticalAlignment.BOTTOM.toNative())

        assertEquals(LogoVerticalAlignment.TOP, NativeVerticalAlignment.YMKLogoVerticalAlignmentTop.toCommon())
        assertEquals(LogoVerticalAlignment.BOTTOM, NativeVerticalAlignment.YMKLogoVerticalAlignmentBottom.toCommon())

        assertEquals(LogoVerticalAlignment.entries.size, LogoVerticalAlignment.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `text style placement maps every constant`() {
        assertEquals(NativeTextStylePlacement.YMKTextStylePlacementCenter, TextStyle.Placement.CENTER.toNative())
        assertEquals(NativeTextStylePlacement.YMKTextStylePlacementLeft, TextStyle.Placement.LEFT.toNative())
        assertEquals(NativeTextStylePlacement.YMKTextStylePlacementRight, TextStyle.Placement.RIGHT.toNative())
        assertEquals(NativeTextStylePlacement.YMKTextStylePlacementTop, TextStyle.Placement.TOP.toNative())
        assertEquals(NativeTextStylePlacement.YMKTextStylePlacementBottom, TextStyle.Placement.BOTTOM.toNative())
        assertEquals(NativeTextStylePlacement.YMKTextStylePlacementTopLeft, TextStyle.Placement.TOP_LEFT.toNative())
        assertEquals(NativeTextStylePlacement.YMKTextStylePlacementTopRight, TextStyle.Placement.TOP_RIGHT.toNative())
        assertEquals(NativeTextStylePlacement.YMKTextStylePlacementBottomLeft, TextStyle.Placement.BOTTOM_LEFT.toNative())
        assertEquals(NativeTextStylePlacement.YMKTextStylePlacementBottomRight, TextStyle.Placement.BOTTOM_RIGHT.toNative())

        assertEquals(TextStyle.Placement.CENTER, NativeTextStylePlacement.YMKTextStylePlacementCenter.toCommon())
        assertEquals(TextStyle.Placement.LEFT, NativeTextStylePlacement.YMKTextStylePlacementLeft.toCommon())
        assertEquals(TextStyle.Placement.RIGHT, NativeTextStylePlacement.YMKTextStylePlacementRight.toCommon())
        assertEquals(TextStyle.Placement.TOP, NativeTextStylePlacement.YMKTextStylePlacementTop.toCommon())
        assertEquals(TextStyle.Placement.BOTTOM, NativeTextStylePlacement.YMKTextStylePlacementBottom.toCommon())
        assertEquals(TextStyle.Placement.TOP_LEFT, NativeTextStylePlacement.YMKTextStylePlacementTopLeft.toCommon())
        assertEquals(TextStyle.Placement.TOP_RIGHT, NativeTextStylePlacement.YMKTextStylePlacementTopRight.toCommon())
        assertEquals(TextStyle.Placement.BOTTOM_LEFT, NativeTextStylePlacement.YMKTextStylePlacementBottomLeft.toCommon())
        assertEquals(TextStyle.Placement.BOTTOM_RIGHT, NativeTextStylePlacement.YMKTextStylePlacementBottomRight.toCommon())

        assertEquals(TextStyle.Placement.entries.size, TextStyle.Placement.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `model style unit type maps every constant`() {
        assertEquals(NativeUnitType.YMKModelStyleUnitTypeUnit, ModelStyle.UnitType.UNIT.toNative())
        assertEquals(NativeUnitType.YMKModelStyleUnitTypeNormalized, ModelStyle.UnitType.NORMALIZED.toNative())
        assertEquals(NativeUnitType.YMKModelStyleUnitTypeMeter, ModelStyle.UnitType.METER.toNative())

        assertEquals(ModelStyle.UnitType.UNIT, NativeUnitType.YMKModelStyleUnitTypeUnit.toCommon())
        assertEquals(ModelStyle.UnitType.NORMALIZED, NativeUnitType.YMKModelStyleUnitTypeNormalized.toCommon())
        assertEquals(ModelStyle.UnitType.METER, NativeUnitType.YMKModelStyleUnitTypeMeter.toCommon())

        assertEquals(ModelStyle.UnitType.entries.size, ModelStyle.UnitType.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `model style render mode maps every constant`() {
        assertEquals(NativeRenderMode.YMKModelStyleRenderModeBuilding, ModelStyle.RenderMode.BUILDING.toNative())
        assertEquals(NativeRenderMode.YMKModelStyleRenderModeUserModel, ModelStyle.RenderMode.USER_MODEL.toNative())

        assertEquals(ModelStyle.RenderMode.BUILDING, NativeRenderMode.YMKModelStyleRenderModeBuilding.toCommon())
        assertEquals(ModelStyle.RenderMode.USER_MODEL, NativeRenderMode.YMKModelStyleRenderModeUserModel.toCommon())

        assertEquals(ModelStyle.RenderMode.entries.size, ModelStyle.RenderMode.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `raw tile use cache maps every constant`() {
        assertEquals(NativeUseCache.YMKRawTileUseCacheYes, RawTile.UseCache.YES.toNative())
        assertEquals(NativeUseCache.YMKRawTileUseCacheNo, RawTile.UseCache.NO.toNative())

        assertEquals(RawTile.UseCache.YES, NativeUseCache.YMKRawTileUseCacheYes.toCommon())
        assertEquals(RawTile.UseCache.NO, NativeUseCache.YMKRawTileUseCacheNo.toCommon())

        assertEquals(RawTile.UseCache.entries.size, RawTile.UseCache.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `raw tile state maps every constant`() {
        assertEquals(NativeState.YMKRawTileStateOk, RawTile.State.OK.toNative())
        assertEquals(NativeState.YMKRawTileStateNotModified, RawTile.State.NOT_MODIFIED.toNative())
        assertEquals(NativeState.YMKRawTileStateError, RawTile.State.ERROR.toNative())

        assertEquals(RawTile.State.OK, NativeState.YMKRawTileStateOk.toCommon())
        assertEquals(RawTile.State.NOT_MODIFIED, NativeState.YMKRawTileStateNotModified.toCommon())
        assertEquals(RawTile.State.ERROR, NativeState.YMKRawTileStateError.toCommon())

        assertEquals(RawTile.State.entries.size, RawTile.State.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `polyline index priority maps every constant`() {
        assertEquals(NativePriority.YMKPolylineIndexPriorityClosestToRawPoint, Priority.CLOSEST_TO_RAW_POINT.toNative())
        assertEquals(NativePriority.YMKPolylineIndexPriorityClosestToStart, Priority.CLOSEST_TO_START.toNative())

        assertEquals(Priority.CLOSEST_TO_RAW_POINT, NativePriority.YMKPolylineIndexPriorityClosestToRawPoint.toCommon())
        assertEquals(Priority.CLOSEST_TO_START, NativePriority.YMKPolylineIndexPriorityClosestToStart.toCommon())

        assertEquals(Priority.entries.size, Priority.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }
}
