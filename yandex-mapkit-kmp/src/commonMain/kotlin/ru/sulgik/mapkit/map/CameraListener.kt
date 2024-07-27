package ru.sulgik.mapkit.map

expect class CameraListener(
    onCameraPositionChanged: (
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean,
    ) -> Unit,
)