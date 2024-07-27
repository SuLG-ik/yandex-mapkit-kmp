
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKCameraPosition as NativeCameraPosition

fun CameraPosition.toNative(): NativeCameraPosition {
    return NativeCameraPosition.cameraPositionWithTarget(target.toNative(), zoom, azimuth, tilt)
}

fun NativeCameraPosition.toCommon(): CameraPosition {
    return CameraPosition(target.toCommon(), zoom, azimuth, tilt)
}