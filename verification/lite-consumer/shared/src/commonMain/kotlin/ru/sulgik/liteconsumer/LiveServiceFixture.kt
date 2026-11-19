package ru.sulgik.liteconsumer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.sulgik.mapkit.compose.MapEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit

public enum class LiveServiceProbe(public val keyFile: String, public val marker: String) {
    Search("live-search-key", "LIVE_SEARCH"),
    Routing("live-routing-key", "LIVE_ROUTING"),
}

public enum class LiveServiceStatus(public val code: Int) {
    Passed(0),
    Authorization(10),
    ProviderOrNetwork(11),
    WrapperOrShape(12),
    ProviderNoRoute(13),
    RunnerOrFixture(70),
}

public fun isLiveServiceToken(token: String): Boolean {
    return token.matches(Regex("[0-9]+-[0-9]+"))
}

@Composable
public fun LiveServiceMap(
    probe: LiveServiceProbe,
    onModeResult: (String, LiveServiceStatus) -> Unit,
    onResult: (LiveServiceStatus) -> Unit,
) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    YandexMap(modifier = Modifier.fillMaxSize()) {
        MapEffect(probe) { map ->
            val status = if (map.isValid) {
                when (probe) {
                    LiveServiceProbe.Search -> probeLiveSearch()
                    LiveServiceProbe.Routing -> probeLiveRouting(map, onModeResult)
                }
            } else {
                LiveServiceStatus.WrapperOrShape
            }
            onResult(status)
        }
    }
}
