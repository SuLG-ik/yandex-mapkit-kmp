package ru.sulgik.mapkit.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runComposeUiTest
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.useContents
import ru.sulgik.mapkit.map.ImageProvider
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@OptIn(ExperimentalTestApi::class, YandexMapsComposeExperimentalApi::class)
public class ComposeMapObjectRendererIosTest {

    @Test
    public fun contentIsRenderedWithIntrinsicSizeInPoints(): Unit = runComposeUiTest {
        var image: ImageProvider? = null
        setContent {
            CompositionLocalProvider(LocalDensity provides Density(density = 3f)) {
                ComposeMapObjectRendererHost {
                    image = imageProvider {
                        Box(Modifier.size(width = 20.dp, height = 10.dp).background(Color.Red))
                    }
                }
            }
        }
        waitUntil { image != null }

        val size = assertNotNull(image).toNative().size
        assertEquals(20.0, size.useContents { width })
        assertEquals(10.0, size.useContents { height })
    }

    @Test
    public fun contentSizeFollowsScreenScale(): Unit = runComposeUiTest {
        var contentWidth by mutableStateOf(20.dp)
        var image: ImageProvider? = null
        setContent {
            CompositionLocalProvider(LocalDensity provides Density(density = 2f)) {
                ComposeMapObjectRendererHost {
                    image = imageProvider {
                        Box(Modifier.size(width = contentWidth, height = 10.dp).background(Color.Red))
                    }
                }
            }
        }
        waitUntil { image != null }

        contentWidth = 40.dp
        waitUntil { assertNotNull(image).toNative().size.useContents { width } == 40.0 }
    }
}
