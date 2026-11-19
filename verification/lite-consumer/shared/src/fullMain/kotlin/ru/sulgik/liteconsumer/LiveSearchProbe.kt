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
import ru.sulgik.mapkit.search.SearchListener
import ru.sulgik.mapkit.search.SearchManagerType
import ru.sulgik.mapkit.search.SearchOptions
import ru.sulgik.mapkit.search.SearchType
import ru.sulgik.mapkit.search.Session
import kotlin.coroutines.resume

internal suspend fun probeLiveSearch(): LiveServiceStatus {
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
                            complete {
                                when (error.error) {
                                    is UnauthorizedError, is ForbiddenError -> LiveServiceStatus.Authorization
                                    else -> LiveServiceStatus.ProviderOrNetwork
                                }
                            }
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
