package ru.sulgik.liteconsumer

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toGeometry
import ru.sulgik.mapkit.runtime.network.ForbiddenError
import ru.sulgik.mapkit.runtime.network.UnauthorizedError
import ru.sulgik.mapkit.search.Search
import ru.sulgik.mapkit.search.SearchError
import ru.sulgik.mapkit.search.SearchListener
import ru.sulgik.mapkit.search.SearchManagerType
import ru.sulgik.mapkit.search.SearchOptions
import ru.sulgik.mapkit.search.SearchType
import ru.sulgik.mapkit.search.Session
import ru.sulgik.mapkit.search.SuggestListener
import ru.sulgik.mapkit.search.SuggestOptions
import ru.sulgik.mapkit.search.SuggestSession
import ru.sulgik.mapkit.search.SuggestType
import kotlin.coroutines.resume

internal suspend fun probeLiveSearch(onModeResult: (String, LiveServiceStatus) -> Unit): LiveServiceStatus {
    val text = probeText()
    onModeResult("text", text)
    if (text == LiveServiceStatus.Authorization) return text

    val suggestions = probeSuggestions()
    onModeResult("suggestions", suggestions)
    return if (text == LiveServiceStatus.Passed) suggestions else text
}

private suspend fun probeText(): LiveServiceStatus {
    var session: Session? = null
    var delivered = false
    return try {
        withTimeoutOrNull(20_000L) {
            suspendCancellableCoroutine<LiveServiceStatus> { continuation ->
                fun complete(classify: () -> LiveServiceStatus) {
                    if (!continuation.isActive) return
                    val status = try {
                        classify()
                    } catch (_: Exception) {
                        LiveServiceStatus.WrapperOrShape
                    }
                    delivered = true
                    continuation.resume(status)
                }
                val manager = Search.getInstance().createSearchManager(SearchManagerType.ONLINE)
                session = manager.submit(
                    text = "кофейня",
                    geometry = BoundingBox(Point(55.70, 37.50), Point(55.82, 37.75)).toGeometry(),
                    searchOptions = SearchOptions(
                        searchTypes = SearchType.BIZ.value,
                        resultPageSize = 10,
                        geometry = true,
                    ),
                    searchListener = SearchListener(
                        onSearchResponse = { response ->
                            complete {
                                val hasPlace = response.collection.namedPlaces().any { place ->
                                    place.name.isNotBlank() &&
                                        place.point.latitude.value in -90.0..90.0 &&
                                        place.point.longitude.value in -180.0..180.0
                                }
                                if (!response.isOffline && hasPlace) {
                                    LiveServiceStatus.Passed
                                } else {
                                    LiveServiceStatus.WrapperOrShape
                                }
                            }
                        },
                        onSearchError = { error ->
                            complete { error.serviceStatus() }
                        },
                    ),
                )
            }
        } ?: LiveServiceStatus.ProviderOrNetwork
    } catch (cancelled: CancellationException) {
        throw cancelled
    } catch (_: Exception) {
        LiveServiceStatus.WrapperOrShape
    } finally {
        if (!delivered) {
            session?.cancel()
        }
    }
}

private suspend fun probeSuggestions(): LiveServiceStatus {
    var session: SuggestSession? = null
    return try {
        withTimeoutOrNull(20_000L) {
            suspendCancellableCoroutine<LiveServiceStatus> { continuation ->
                fun complete(classify: () -> LiveServiceStatus) {
                    if (!continuation.isActive) return
                    val status = try {
                        classify()
                    } catch (_: Exception) {
                        LiveServiceStatus.WrapperOrShape
                    }
                    continuation.resume(status)
                }

                val manager = Search.getInstance().createSearchManager(SearchManagerType.ONLINE)
                val query = manager.createSuggestSession()
                session = query
                query.suggest(
                    text = "кофей",
                    window = BoundingBox(Point(55.70, 37.50), Point(55.82, 37.75)),
                    suggestOptions = SuggestOptions(suggestTypes = SuggestType.BIZ.value or SuggestType.RUBRIC.value),
                    suggestListener = SuggestListener(
                        onResponse = { response ->
                            complete {
                                val usable = response.items.any { item ->
                                    !item.isOffline && item.title.text.isNotBlank() && item.searchText.isNotBlank() &&
                                        item.title.spans.all { it.begin in 0..it.end && it.end <= item.title.text.length }
                                }
                                if (usable) LiveServiceStatus.Passed else LiveServiceStatus.WrapperOrShape
                            }
                        },
                        onError = { error -> complete { error.serviceStatus() } },
                    ),
                )
            }
        } ?: LiveServiceStatus.ProviderOrNetwork
    } catch (cancelled: CancellationException) {
        throw cancelled
    } catch (_: Exception) {
        LiveServiceStatus.WrapperOrShape
    } finally {
        session?.reset()
    }
}

private fun SearchError.serviceStatus(): LiveServiceStatus {
    return when (error) {
        is UnauthorizedError, is ForbiddenError -> LiveServiceStatus.Authorization
        else -> LiveServiceStatus.ProviderOrNetwork
    }
}
