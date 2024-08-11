package ru.sulgik.mapkit.map

public expect abstract class CameraListener() {
    public abstract fun onCameraPositionChanged(
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean,
    )
}

public inline fun CameraListener(
    crossinline onCameraPositionChanged: (
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean,
    ) -> Unit,
): CameraListener {
    return object : CameraListener() {
        override fun onCameraPositionChanged(
            map: Map,
            cameraPosition: CameraPosition,
            cameraUpdateReason: CameraUpdateReason,
            finished: Boolean,
        ) {
            onCameraPositionChanged.invoke(map, cameraPosition, cameraUpdateReason, finished)
        }
    }
}