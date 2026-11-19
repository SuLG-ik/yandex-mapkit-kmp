package ru.sulgik.liteconsumer

import ru.sulgik.mapkit.map.Map

internal suspend fun probeLiveRouting(
    @Suppress("UNUSED_PARAMETER") map: Map,
    @Suppress("UNUSED_PARAMETER") onModeResult: (String, LiveServiceStatus) -> Unit,
): LiveServiceStatus {
    return LiveServiceStatus.RunnerOrFixture
}
