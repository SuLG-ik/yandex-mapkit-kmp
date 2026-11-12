package ru.sulgik.mapkit.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.v2.runComposeUiTest
import ru.sulgik.mapkit.MapKit
import kotlin.test.Test
import kotlin.test.assertNotNull

@OptIn(ExperimentalTestApi::class)
public class NativeYandexMapLifecycleTest {

    @Test
    public fun activityCanCloseWithMapInComposition() {
        runComposeUiTest {
            runOnUiThread { MapKit.setApiKey("00000000-0000-0000-0000-000000000000") }
            var controller: YandexMapController? = null
            setContent {
                rememberAndInitializeMapKit().bindToLifecycleOwner()
                val mapController = rememberYandexMapController()
                controller = mapController
                YandexMap(controller = mapController, modifier = Modifier.fillMaxSize())
            }
            runOnIdle {
                assertNotNull(controller?.mapWindow)
            }
        }
    }
}
