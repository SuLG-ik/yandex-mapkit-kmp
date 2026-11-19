package ru.sulgik.mapkit.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.v2.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertNotNull

@OptIn(ExperimentalTestApi::class)
public class NativeYandexMapLifecycleTest {

    @Test
    public fun activityCanCloseWithMapInComposition() {
        runComposeUiTest {
            runOnUiThread { setDeviceTestMapKitApiKey() }
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
