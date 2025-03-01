package ru.sulgik.mapkit.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import ru.sulgik.mapkit.compose.Placemark
import ru.sulgik.mapkit.compose.YandexMapsComposeExperimentalApi
import ru.sulgik.mapkit.compose.imageProvider
import ru.sulgik.mapkit.compose.rememberPlacemarkState
import ru.sulgik.mapkit.geometry.Point

data class User(
    val avatar: String,
    val point: Point,
)

val testUser = User(
    avatar = "https://api.dicebear.com/9.x/icons/png",
    point = Point(59.939095, 30.338655)
)

@OptIn(YandexMapsComposeExperimentalApi::class)
@Composable
fun CoilPlacemark(
    user: User = testUser,
    onUserClick: (User) -> Unit = { },
) {
    val placemarkState = rememberPlacemarkState(
        geometry = Point(user.point.latitude, user.point.longitude),
    )

    SideEffect {
        placemarkState.geometry = user.point
    }

    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalPlatformContext.current)
            .data(user.avatar)
            .allowHardware(false)
            .build()
    )

    val imageProvider = imageProvider(
        size = DpSize(40.dp, 40.dp),
        key1 = painter.state.collectAsState().value,
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
    }

    Placemark(
        state = placemarkState,
        icon = imageProvider,
        onTap = {
            onUserClick(user)
            true
        },
        visible = true,
        draggable = false,
        opacity = 1f
    )
}