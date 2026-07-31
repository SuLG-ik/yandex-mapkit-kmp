package ru.sulgik.mapkit.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runComposeUiTest
import androidx.compose.ui.unit.dp
import ru.sulgik.mapkit.map.ImageProvider
import kotlin.test.Test
import kotlin.test.assertNotNull

@OptIn(ExperimentalTestApi::class, YandexMapsComposeExperimentalApi::class)
public class ComposeMapObjectRendererTest {

    @Test
    public fun contentIsRendered(): Unit = runComposeUiTest {
        var image: ImageProvider? = null
        setContent {
            ComposeMapObjectRendererHost {
                image = imageProvider {
                    Box(Modifier.size(width = 20.dp, height = 10.dp).background(Color.Red))
                }
            }
        }

        waitUntil(timeoutMillis = 10_000) { image != null }
    }

    @Test
    public fun contentIsRerenderedOnStateChange(): Unit = runComposeUiTest {
        var contentWidth by mutableStateOf(20.dp)
        var image: ImageProvider? = null
        setContent {
            ComposeMapObjectRendererHost {
                image = imageProvider {
                    Box(Modifier.size(width = contentWidth, height = 10.dp).background(Color.Red))
                }
            }
        }
        waitUntil(timeoutMillis = 10_000) { image != null }
        val rendered = assertNotNull(image)

        contentWidth = 40.dp

        waitUntil(timeoutMillis = 10_000) { image !== rendered }
    }

}
