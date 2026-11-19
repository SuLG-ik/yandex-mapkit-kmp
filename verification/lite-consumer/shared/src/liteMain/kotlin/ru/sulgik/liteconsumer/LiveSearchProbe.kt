package ru.sulgik.liteconsumer

internal suspend fun probeLiveSearch(
    @Suppress("UNUSED_PARAMETER") onModeResult: (String, LiveServiceStatus) -> Unit,
): LiveServiceStatus {
    return LiveServiceStatus.RunnerOrFixture
}
