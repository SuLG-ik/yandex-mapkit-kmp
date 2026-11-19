package ru.sulgik.liteconsumer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.sulgik.mapkit.compose.MapEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit

public enum class LiveSearchStatus(public val code: Int) {
    Passed(0),
    Authorization(10),
    ProviderOrNetwork(11),
    WrapperOrShape(12),
    RunnerOrFixture(70),
}

public fun isLiveSearchToken(token: String): Boolean {
    return token.matches(Regex("[0-9]+-[0-9]+"))
}

@Composable
public fun LiveSearchMap(onResult: (LiveSearchStatus) -> Unit) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    YandexMap(modifier = Modifier.fillMaxSize()) {
        MapEffect(Unit) { map ->
            val status = if (map.isValid) {
                probeLiveSearch()
            } else {
                LiveSearchStatus.WrapperOrShape
            }
            onResult(status)
        }
    }
}
