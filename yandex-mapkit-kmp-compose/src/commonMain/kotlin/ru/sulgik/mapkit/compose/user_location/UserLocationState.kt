package ru.sulgik.mapkit.compose.user_location

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ru.sulgik.mapkit.map.CameraPosition

@Composable
public fun rememberUserLocationState(): UserLocationState {
    return remember { UserLocationState() }
}

@Stable
public class UserLocationState(initialCameraPosition: CameraPosition? = null) {

    public var cameraPosition: CameraPosition? by mutableStateOf(initialCameraPosition)
        internal set
}
