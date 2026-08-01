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
import ru.sulgik.mapkit.map.RotationType
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
import com.yandex.mapkit.Animation as NativeAnimation
import com.yandex.mapkit.ConflictResolutionMode as NativeConflictResolutionMode
import com.yandex.mapkit.RawTile as NativeRawTile
import com.yandex.mapkit.geometry.geo.PolylineIndex as NativePolylineIndex
import com.yandex.mapkit.layers.OverzoomMode as NativeOverzoomMode
import com.yandex.mapkit.layers.TileFormat as NativeTileFormat
import com.yandex.mapkit.location.DummyLocationQuality as NativeDummyLocationQuality
import com.yandex.mapkit.location.LocationStatus as NativeLocationStatus
import com.yandex.mapkit.location.Purpose as NativeLocationPurpose
import com.yandex.mapkit.location.UseInBackground as NativeUseInBackground
import com.yandex.mapkit.logo.HorizontalAlignment as NativeHorizontalAlignment
import com.yandex.mapkit.logo.VerticalAlignment as NativeVerticalAlignment
import com.yandex.mapkit.map.CameraUpdateReason as NativeCameraUpdateReason
import com.yandex.mapkit.map.GestureFocusPointMode as NativeGestureFocusPointMode
import com.yandex.mapkit.map.MapMode as NativeMapMode
import com.yandex.mapkit.map.MapType as NativeMapType
import com.yandex.mapkit.map.ModelStyle as NativeModelStyle
import com.yandex.mapkit.map.PointOfView as NativePointOfView
import com.yandex.mapkit.map.RotationType as NativeRotationType
import com.yandex.mapkit.map.TextStyle as NativeTextStyle
import com.yandex.mapkit.offline_cache.RegionState as NativeRegionState
import com.yandex.mapkit.traffic.TrafficColor as NativeTrafficColor
import com.yandex.mapkit.user_location.UserLocationAnchorType as NativeUserLocationAnchorType
import com.yandex.mapkit.user_location.UserLocationIconType as NativeUserLocationIconType
import com.yandex.runtime.i18n.SystemOfMeasurement as NativeSystemOfMeasurement
import com.yandex.runtime.i18n.TimeFormat as NativeTimeFormat
import com.yandex.runtime.logging.LogMessage as NativeLogMessage

public class EnumConverterTest {

    @Test
    public fun `map type maps every constant`() {
        assertEquals(NativeMapType.NONE, MapType.NONE.toNative())
        assertEquals(NativeMapType.MAP, MapType.MAP.toNative())
        assertEquals(NativeMapType.SATELLITE, MapType.SATELLITE.toNative())
        assertEquals(NativeMapType.HYBRID, MapType.HYBRID.toNative())
        assertEquals(NativeMapType.VECTOR_MAP, MapType.VECTOR_MAP.toNative())

        assertEquals(MapType.NONE, NativeMapType.NONE.toCommon())
        assertEquals(MapType.MAP, NativeMapType.MAP.toCommon())
        assertEquals(MapType.SATELLITE, NativeMapType.SATELLITE.toCommon())
        assertEquals(MapType.HYBRID, NativeMapType.HYBRID.toCommon())
        assertEquals(MapType.VECTOR_MAP, NativeMapType.VECTOR_MAP.toCommon())

        assertEquals(MapType.entries.size, MapType.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `map mode maps every constant`() {
        assertEquals(NativeMapMode.MAP, MapMode.MAP.toNative())
        assertEquals(NativeMapMode.TRANSIT, MapMode.TRANSIT.toNative())
        assertEquals(NativeMapMode.DRIVING, MapMode.DRIVING.toNative())
        assertEquals(NativeMapMode.ADMIN, MapMode.ADMIN.toNative())
        assertEquals(NativeMapMode.LEGACY_MAP, MapMode.LEGACY_MAP.toNative())
        assertEquals(NativeMapMode.FUTURE_MAP, MapMode.FUTURE_MAP.toNative())
        assertEquals(NativeMapMode.HYBRID, MapMode.HYBRID.toNative())

        assertEquals(MapMode.MAP, NativeMapMode.MAP.toCommon())
        assertEquals(MapMode.TRANSIT, NativeMapMode.TRANSIT.toCommon())
        assertEquals(MapMode.DRIVING, NativeMapMode.DRIVING.toCommon())
        assertEquals(MapMode.ADMIN, NativeMapMode.ADMIN.toCommon())
        assertEquals(MapMode.LEGACY_MAP, NativeMapMode.LEGACY_MAP.toCommon())
        assertEquals(MapMode.FUTURE_MAP, NativeMapMode.FUTURE_MAP.toCommon())
        assertEquals(MapMode.HYBRID, NativeMapMode.HYBRID.toCommon())

        assertEquals(MapMode.entries.size, MapMode.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `point of view maps every constant`() {
        assertEquals(NativePointOfView.SCREEN_CENTER, PointOfView.SCREEN_CENTER.toNative())
        assertEquals(NativePointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY, PointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY.toNative())

        assertEquals(PointOfView.SCREEN_CENTER, NativePointOfView.SCREEN_CENTER.toCommon())
        assertEquals(PointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY, NativePointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY.toCommon())

        assertEquals(PointOfView.entries.size, PointOfView.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `gesture focus point mode maps every constant`() {
        assertEquals(NativeGestureFocusPointMode.AFFECTS_TAP_GESTURES, GestureFocusPointMode.AFFECTS_TAP_GESTURES.toNative())
        assertEquals(NativeGestureFocusPointMode.AFFECTS_ALL_GESTURES, GestureFocusPointMode.AFFECTS_ALL_GESTURES.toNative())

        assertEquals(GestureFocusPointMode.AFFECTS_TAP_GESTURES, NativeGestureFocusPointMode.AFFECTS_TAP_GESTURES.toCommon())
        assertEquals(GestureFocusPointMode.AFFECTS_ALL_GESTURES, NativeGestureFocusPointMode.AFFECTS_ALL_GESTURES.toCommon())

        assertEquals(GestureFocusPointMode.entries.size, GestureFocusPointMode.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `camera update reason maps every constant`() {
        assertEquals(NativeCameraUpdateReason.GESTURES, CameraUpdateReason.GESTURES.toNative())
        assertEquals(NativeCameraUpdateReason.APPLICATION, CameraUpdateReason.APPLICATION.toNative())

        assertEquals(CameraUpdateReason.GESTURES, NativeCameraUpdateReason.GESTURES.toCommon())
        assertEquals(CameraUpdateReason.APPLICATION, NativeCameraUpdateReason.APPLICATION.toCommon())

        assertEquals(CameraUpdateReason.entries.size, CameraUpdateReason.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `rotation type maps every constant`() {
        assertEquals(NativeRotationType.NO_ROTATION, RotationType.NO_ROTATION.toNative())
        assertEquals(NativeRotationType.ROTATE, RotationType.ROTATE.toNative())

        assertEquals(RotationType.NO_ROTATION, NativeRotationType.NO_ROTATION.toCommon())
        assertEquals(RotationType.ROTATE, NativeRotationType.ROTATE.toCommon())

        assertEquals(RotationType.entries.size, RotationType.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `conflict resolution mode maps every constant`() {
        assertEquals(NativeConflictResolutionMode.MINOR, ConflictResolutionMode.MINOR.toNative())
        assertEquals(NativeConflictResolutionMode.EQUAL, ConflictResolutionMode.EQUAL.toNative())
        assertEquals(NativeConflictResolutionMode.MAJOR, ConflictResolutionMode.MAJOR.toNative())
        assertEquals(NativeConflictResolutionMode.IGNORE, ConflictResolutionMode.IGNORE.toNative())

        assertEquals(ConflictResolutionMode.MINOR, NativeConflictResolutionMode.MINOR.toCommon())
        assertEquals(ConflictResolutionMode.EQUAL, NativeConflictResolutionMode.EQUAL.toCommon())
        assertEquals(ConflictResolutionMode.MAJOR, NativeConflictResolutionMode.MAJOR.toCommon())
        assertEquals(ConflictResolutionMode.IGNORE, NativeConflictResolutionMode.IGNORE.toCommon())

        assertEquals(ConflictResolutionMode.entries.size, ConflictResolutionMode.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `tile format maps every constant`() {
        assertEquals(NativeTileFormat.PNG, TileFormat.PNG.toNative())
        assertEquals(NativeTileFormat.JPG, TileFormat.JPG.toNative())
        assertEquals(NativeTileFormat.VECTOR2, TileFormat.VECTOR2.toNative())
        assertEquals(NativeTileFormat.VECTOR3, TileFormat.VECTOR3.toNative())
        assertEquals(NativeTileFormat.GEO_JSON, TileFormat.GEO_JSON.toNative())

        assertEquals(TileFormat.PNG, NativeTileFormat.PNG.toCommon())
        assertEquals(TileFormat.JPG, NativeTileFormat.JPG.toCommon())
        assertEquals(TileFormat.VECTOR2, NativeTileFormat.VECTOR2.toCommon())
        assertEquals(TileFormat.VECTOR3, NativeTileFormat.VECTOR3.toCommon())
        assertEquals(TileFormat.GEO_JSON, NativeTileFormat.GEO_JSON.toCommon())

        assertEquals(TileFormat.entries.size, TileFormat.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `overzoom mode maps every constant`() {
        assertEquals(NativeOverzoomMode.DISABLED, OverzoomMode.DISABLED.toNative())
        assertEquals(NativeOverzoomMode.ENABLED, OverzoomMode.ENABLED.toNative())
        assertEquals(NativeOverzoomMode.WITH_PREFETCH, OverzoomMode.WITH_PREFETCH.toNative())

        assertEquals(OverzoomMode.DISABLED, NativeOverzoomMode.DISABLED.toCommon())
        assertEquals(OverzoomMode.ENABLED, NativeOverzoomMode.ENABLED.toCommon())
        assertEquals(OverzoomMode.WITH_PREFETCH, NativeOverzoomMode.WITH_PREFETCH.toCommon())

        assertEquals(OverzoomMode.entries.size, OverzoomMode.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `traffic color maps every constant`() {
        assertEquals(NativeTrafficColor.RED, TrafficColor.RED.toNative())
        assertEquals(NativeTrafficColor.YELLOW, TrafficColor.YELLOW.toNative())
        assertEquals(NativeTrafficColor.GREEN, TrafficColor.GREEN.toNative())

        assertEquals(TrafficColor.RED, NativeTrafficColor.RED.toCommon())
        assertEquals(TrafficColor.YELLOW, NativeTrafficColor.YELLOW.toCommon())
        assertEquals(TrafficColor.GREEN, NativeTrafficColor.GREEN.toCommon())

        assertEquals(TrafficColor.entries.size, TrafficColor.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `region state maps every constant`() {
        assertEquals(NativeRegionState.AVAILABLE, RegionState.AVAILABLE.toNative())
        assertEquals(NativeRegionState.DOWNLOADING, RegionState.DOWNLOADING.toNative())
        assertEquals(NativeRegionState.PAUSED, RegionState.PAUSED.toNative())
        assertEquals(NativeRegionState.COMPLETED, RegionState.COMPLETED.toNative())
        assertEquals(NativeRegionState.OUTDATED, RegionState.OUTDATED.toNative())
        assertEquals(NativeRegionState.UNSUPPORTED, RegionState.UNSUPPORTED.toNative())
        assertEquals(NativeRegionState.NEED_UPDATE, RegionState.NEED_UPDATE.toNative())

        assertEquals(RegionState.AVAILABLE, NativeRegionState.AVAILABLE.toCommon())
        assertEquals(RegionState.DOWNLOADING, NativeRegionState.DOWNLOADING.toCommon())
        assertEquals(RegionState.PAUSED, NativeRegionState.PAUSED.toCommon())
        assertEquals(RegionState.COMPLETED, NativeRegionState.COMPLETED.toCommon())
        assertEquals(RegionState.OUTDATED, NativeRegionState.OUTDATED.toCommon())
        assertEquals(RegionState.UNSUPPORTED, NativeRegionState.UNSUPPORTED.toCommon())
        assertEquals(RegionState.NEED_UPDATE, NativeRegionState.NEED_UPDATE.toCommon())

        assertEquals(RegionState.entries.size, RegionState.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `log level maps every constant`() {
        assertEquals(NativeLogMessage.LogLevel.ERROR, LogMessage.LogLevel.ERROR.toNative())
        assertEquals(NativeLogMessage.LogLevel.WARNING, LogMessage.LogLevel.WARNING.toNative())
        assertEquals(NativeLogMessage.LogLevel.INFO, LogMessage.LogLevel.INFO.toNative())
        assertEquals(NativeLogMessage.LogLevel.DEBUG, LogMessage.LogLevel.DEBUG.toNative())

        assertEquals(LogMessage.LogLevel.ERROR, NativeLogMessage.LogLevel.ERROR.toCommon())
        assertEquals(LogMessage.LogLevel.WARNING, NativeLogMessage.LogLevel.WARNING.toCommon())
        assertEquals(LogMessage.LogLevel.INFO, NativeLogMessage.LogLevel.INFO.toCommon())
        assertEquals(LogMessage.LogLevel.DEBUG, NativeLogMessage.LogLevel.DEBUG.toCommon())

        assertEquals(LogMessage.LogLevel.entries.size, LogMessage.LogLevel.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `system of measurement maps every constant`() {
        assertEquals(NativeSystemOfMeasurement.DEFAULT, SystemOfMeasurement.DEFAULT.toNative())
        assertEquals(NativeSystemOfMeasurement.METRIC, SystemOfMeasurement.METRIC.toNative())
        assertEquals(NativeSystemOfMeasurement.IMPERIAL, SystemOfMeasurement.IMPERIAL.toNative())

        assertEquals(SystemOfMeasurement.DEFAULT, NativeSystemOfMeasurement.DEFAULT.toCommon())
        assertEquals(SystemOfMeasurement.METRIC, NativeSystemOfMeasurement.METRIC.toCommon())
        assertEquals(SystemOfMeasurement.IMPERIAL, NativeSystemOfMeasurement.IMPERIAL.toCommon())

        assertEquals(SystemOfMeasurement.entries.size, SystemOfMeasurement.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `time format maps every constant`() {
        assertEquals(NativeTimeFormat.DEFAULT, TimeFormat.DEFAULT.toNative())
        assertEquals(NativeTimeFormat.H24, TimeFormat.H24.toNative())
        assertEquals(NativeTimeFormat.H12, TimeFormat.H12.toNative())

        assertEquals(TimeFormat.DEFAULT, NativeTimeFormat.DEFAULT.toCommon())
        assertEquals(TimeFormat.H24, NativeTimeFormat.H24.toCommon())
        assertEquals(TimeFormat.H12, NativeTimeFormat.H12.toCommon())

        assertEquals(TimeFormat.entries.size, TimeFormat.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `location purpose maps every constant`() {
        assertEquals(NativeLocationPurpose.GENERAL, LocationPurpose.GENERAL.toNative())
        assertEquals(NativeLocationPurpose.AUTOMOTIVE_NAVIGATION, LocationPurpose.AUTOMOTIVE_NAVIGATION.toNative())
        assertEquals(NativeLocationPurpose.PEDESTRIAN_NAVIGATION, LocationPurpose.PEDESTRIAN_NAVIGATION.toNative())
        assertEquals(NativeLocationPurpose.BICYCLE_NAVIGATION, LocationPurpose.BICYCLE_NAVIGATION.toNative())
        assertEquals(NativeLocationPurpose.SCOOTER_NAVIGATION, LocationPurpose.SCOOTER_NAVIGATION.toNative())
        assertEquals(NativeLocationPurpose.STATIC_DISPLAY_LOCATION, LocationPurpose.STATIC_DISPLAY_LOCATION.toNative())

        assertEquals(LocationPurpose.GENERAL, NativeLocationPurpose.GENERAL.toCommon())
        assertEquals(LocationPurpose.AUTOMOTIVE_NAVIGATION, NativeLocationPurpose.AUTOMOTIVE_NAVIGATION.toCommon())
        assertEquals(LocationPurpose.PEDESTRIAN_NAVIGATION, NativeLocationPurpose.PEDESTRIAN_NAVIGATION.toCommon())
        assertEquals(LocationPurpose.BICYCLE_NAVIGATION, NativeLocationPurpose.BICYCLE_NAVIGATION.toCommon())
        assertEquals(LocationPurpose.SCOOTER_NAVIGATION, NativeLocationPurpose.SCOOTER_NAVIGATION.toCommon())
        assertEquals(LocationPurpose.STATIC_DISPLAY_LOCATION, NativeLocationPurpose.STATIC_DISPLAY_LOCATION.toCommon())

        assertEquals(LocationPurpose.entries.size, LocationPurpose.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `use in background maps every constant`() {
        assertEquals(NativeUseInBackground.ALLOW, UseInBackground.ALLOW.toNative())
        assertEquals(NativeUseInBackground.DISALLOW, UseInBackground.DISALLOW.toNative())

        assertEquals(UseInBackground.ALLOW, NativeUseInBackground.ALLOW.toCommon())
        assertEquals(UseInBackground.DISALLOW, NativeUseInBackground.DISALLOW.toCommon())

        assertEquals(UseInBackground.entries.size, UseInBackground.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `location status maps every constant`() {
        assertEquals(NativeLocationStatus.NOT_AVAILABLE, LocationStatus.NOT_AVAILABLE.toNative())
        assertEquals(NativeLocationStatus.AVAILABLE, LocationStatus.AVAILABLE.toNative())
        assertEquals(NativeLocationStatus.RESET, LocationStatus.RESET.toNative())

        assertEquals(LocationStatus.NOT_AVAILABLE, NativeLocationStatus.NOT_AVAILABLE.toCommon())
        assertEquals(LocationStatus.AVAILABLE, NativeLocationStatus.AVAILABLE.toCommon())
        assertEquals(LocationStatus.RESET, NativeLocationStatus.RESET.toCommon())

        assertEquals(LocationStatus.entries.size, LocationStatus.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `dummy location quality maps every constant`() {
        assertEquals(NativeDummyLocationQuality.HIGH, DummyLocationQuality.HIGH.toNative())
        assertEquals(NativeDummyLocationQuality.LOW, DummyLocationQuality.LOW.toNative())

        assertEquals(DummyLocationQuality.HIGH, NativeDummyLocationQuality.HIGH.toCommon())
        assertEquals(DummyLocationQuality.LOW, NativeDummyLocationQuality.LOW.toCommon())

        assertEquals(DummyLocationQuality.entries.size, DummyLocationQuality.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `user location anchor type maps every constant`() {
        assertEquals(NativeUserLocationAnchorType.NORMAL, UserLocationAnchorType.NORMAL.toNative())
        assertEquals(NativeUserLocationAnchorType.COURSE, UserLocationAnchorType.COURSE.toNative())

        assertEquals(UserLocationAnchorType.NORMAL, NativeUserLocationAnchorType.NORMAL.toCommon())
        assertEquals(UserLocationAnchorType.COURSE, NativeUserLocationAnchorType.COURSE.toCommon())

        assertEquals(UserLocationAnchorType.entries.size, UserLocationAnchorType.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `user location icon type maps every constant`() {
        assertEquals(NativeUserLocationIconType.ARROW, UserLocationIconType.ARROW.toNative())
        assertEquals(NativeUserLocationIconType.PIN, UserLocationIconType.PIN.toNative())

        assertEquals(UserLocationIconType.ARROW, NativeUserLocationIconType.ARROW.toCommon())
        assertEquals(UserLocationIconType.PIN, NativeUserLocationIconType.PIN.toCommon())

        assertEquals(UserLocationIconType.entries.size, UserLocationIconType.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `logo horizontal alignment maps every constant`() {
        assertEquals(NativeHorizontalAlignment.LEFT, LogoHorizontalAlignment.LEFT.toNative())
        assertEquals(NativeHorizontalAlignment.CENTER, LogoHorizontalAlignment.CENTER.toNative())
        assertEquals(NativeHorizontalAlignment.RIGHT, LogoHorizontalAlignment.RIGHT.toNative())

        assertEquals(LogoHorizontalAlignment.LEFT, NativeHorizontalAlignment.LEFT.toCommon())
        assertEquals(LogoHorizontalAlignment.CENTER, NativeHorizontalAlignment.CENTER.toCommon())
        assertEquals(LogoHorizontalAlignment.RIGHT, NativeHorizontalAlignment.RIGHT.toCommon())

        assertEquals(LogoHorizontalAlignment.entries.size, LogoHorizontalAlignment.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `logo vertical alignment maps every constant`() {
        assertEquals(NativeVerticalAlignment.TOP, LogoVerticalAlignment.TOP.toNative())
        assertEquals(NativeVerticalAlignment.BOTTOM, LogoVerticalAlignment.BOTTOM.toNative())

        assertEquals(LogoVerticalAlignment.TOP, NativeVerticalAlignment.TOP.toCommon())
        assertEquals(LogoVerticalAlignment.BOTTOM, NativeVerticalAlignment.BOTTOM.toCommon())

        assertEquals(LogoVerticalAlignment.entries.size, LogoVerticalAlignment.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `text style placement maps every constant`() {
        assertEquals(NativeTextStyle.Placement.CENTER, TextStyle.Placement.CENTER.toNative())
        assertEquals(NativeTextStyle.Placement.LEFT, TextStyle.Placement.LEFT.toNative())
        assertEquals(NativeTextStyle.Placement.RIGHT, TextStyle.Placement.RIGHT.toNative())
        assertEquals(NativeTextStyle.Placement.TOP, TextStyle.Placement.TOP.toNative())
        assertEquals(NativeTextStyle.Placement.BOTTOM, TextStyle.Placement.BOTTOM.toNative())
        assertEquals(NativeTextStyle.Placement.TOP_LEFT, TextStyle.Placement.TOP_LEFT.toNative())
        assertEquals(NativeTextStyle.Placement.TOP_RIGHT, TextStyle.Placement.TOP_RIGHT.toNative())
        assertEquals(NativeTextStyle.Placement.BOTTOM_LEFT, TextStyle.Placement.BOTTOM_LEFT.toNative())
        assertEquals(NativeTextStyle.Placement.BOTTOM_RIGHT, TextStyle.Placement.BOTTOM_RIGHT.toNative())

        assertEquals(TextStyle.Placement.CENTER, NativeTextStyle.Placement.CENTER.toCommon())
        assertEquals(TextStyle.Placement.LEFT, NativeTextStyle.Placement.LEFT.toCommon())
        assertEquals(TextStyle.Placement.RIGHT, NativeTextStyle.Placement.RIGHT.toCommon())
        assertEquals(TextStyle.Placement.TOP, NativeTextStyle.Placement.TOP.toCommon())
        assertEquals(TextStyle.Placement.BOTTOM, NativeTextStyle.Placement.BOTTOM.toCommon())
        assertEquals(TextStyle.Placement.TOP_LEFT, NativeTextStyle.Placement.TOP_LEFT.toCommon())
        assertEquals(TextStyle.Placement.TOP_RIGHT, NativeTextStyle.Placement.TOP_RIGHT.toCommon())
        assertEquals(TextStyle.Placement.BOTTOM_LEFT, NativeTextStyle.Placement.BOTTOM_LEFT.toCommon())
        assertEquals(TextStyle.Placement.BOTTOM_RIGHT, NativeTextStyle.Placement.BOTTOM_RIGHT.toCommon())

        assertEquals(TextStyle.Placement.entries.size, TextStyle.Placement.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `model style unit type maps every constant`() {
        assertEquals(NativeModelStyle.UnitType.UNIT, ModelStyle.UnitType.UNIT.toNative())
        assertEquals(NativeModelStyle.UnitType.NORMALIZED, ModelStyle.UnitType.NORMALIZED.toNative())
        assertEquals(NativeModelStyle.UnitType.METER, ModelStyle.UnitType.METER.toNative())

        assertEquals(ModelStyle.UnitType.UNIT, NativeModelStyle.UnitType.UNIT.toCommon())
        assertEquals(ModelStyle.UnitType.NORMALIZED, NativeModelStyle.UnitType.NORMALIZED.toCommon())
        assertEquals(ModelStyle.UnitType.METER, NativeModelStyle.UnitType.METER.toCommon())

        assertEquals(ModelStyle.UnitType.entries.size, ModelStyle.UnitType.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `model style render mode maps every constant`() {
        assertEquals(NativeModelStyle.RenderMode.BUILDING, ModelStyle.RenderMode.BUILDING.toNative())
        assertEquals(NativeModelStyle.RenderMode.USER_MODEL, ModelStyle.RenderMode.USER_MODEL.toNative())

        assertEquals(ModelStyle.RenderMode.BUILDING, NativeModelStyle.RenderMode.BUILDING.toCommon())
        assertEquals(ModelStyle.RenderMode.USER_MODEL, NativeModelStyle.RenderMode.USER_MODEL.toCommon())

        assertEquals(ModelStyle.RenderMode.entries.size, ModelStyle.RenderMode.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `animation type maps every constant`() {
        assertEquals(NativeAnimation.Type.SMOOTH, Animation.Type.SMOOTH.toNative())
        assertEquals(NativeAnimation.Type.LINEAR, Animation.Type.LINEAR.toNative())

        assertEquals(Animation.Type.SMOOTH, NativeAnimation.Type.SMOOTH.toCommon())
        assertEquals(Animation.Type.LINEAR, NativeAnimation.Type.LINEAR.toCommon())

        assertEquals(Animation.Type.entries.size, Animation.Type.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `raw tile use cache maps every constant`() {
        assertEquals(NativeRawTile.UseCache.YES, RawTile.UseCache.YES.toNative())
        assertEquals(NativeRawTile.UseCache.NO, RawTile.UseCache.NO.toNative())

        assertEquals(RawTile.UseCache.YES, NativeRawTile.UseCache.YES.toCommon())
        assertEquals(RawTile.UseCache.NO, NativeRawTile.UseCache.NO.toCommon())

        assertEquals(RawTile.UseCache.entries.size, RawTile.UseCache.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `raw tile state maps every constant`() {
        assertEquals(NativeRawTile.State.OK, RawTile.State.OK.toNative())
        assertEquals(NativeRawTile.State.NOT_MODIFIED, RawTile.State.NOT_MODIFIED.toNative())
        assertEquals(NativeRawTile.State.ERROR, RawTile.State.ERROR.toNative())

        assertEquals(RawTile.State.OK, NativeRawTile.State.OK.toCommon())
        assertEquals(RawTile.State.NOT_MODIFIED, NativeRawTile.State.NOT_MODIFIED.toCommon())
        assertEquals(RawTile.State.ERROR, NativeRawTile.State.ERROR.toCommon())

        assertEquals(RawTile.State.entries.size, RawTile.State.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }

    @Test
    public fun `polyline index priority maps every constant`() {
        assertEquals(NativePolylineIndex.Priority.CLOSEST_TO_RAW_POINT, Priority.CLOSEST_TO_RAW_POINT.toNative())
        assertEquals(NativePolylineIndex.Priority.CLOSEST_TO_START, Priority.CLOSEST_TO_START.toNative())

        assertEquals(Priority.CLOSEST_TO_RAW_POINT, NativePolylineIndex.Priority.CLOSEST_TO_RAW_POINT.toCommon())
        assertEquals(Priority.CLOSEST_TO_START, NativePolylineIndex.Priority.CLOSEST_TO_START.toCommon())

        assertEquals(Priority.entries.size, Priority.entries.mapTo(mutableSetOf()) { it.toNative() }.size)
    }
}
