package ru.sulgik.liteconsumer

import ru.sulgik.mapkit.GeoObjectCollection
import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.search.SearchError
import ru.sulgik.mapkit.search.SearchListener
import ru.sulgik.mapkit.search.SearchManager
import ru.sulgik.mapkit.search.SearchOptions
import ru.sulgik.mapkit.search.SearchType
import ru.sulgik.mapkit.search.Session

internal data class SearchPlace(val name: String, val point: Point)

internal class FullTextSearchExample(private val manager: SearchManager) {

    private var session: Session? = null
    private var requestId: Long = 0

    fun submit(
        query: String,
        area: Geometry,
        onPlaces: (List<SearchPlace>) -> Unit,
        onFailure: (SearchError) -> Unit,
    ) {
        cancel()
        val id = requestId
        val next = manager.submit(
            text = query,
            geometry = area,
            searchOptions = SearchOptions(searchTypes = SearchType.BIZ.value, geometry = true),
            searchListener = SearchListener(
                onSearchResponse = { response ->
                    if (id == requestId) {
                        onPlaces(response.collection.namedPlaces())
                    }
                },
                onSearchError = { failure ->
                    if (id == requestId) {
                        onFailure(failure)
                    }
                },
            ),
        )
        if (id == requestId) {
            session = next
        } else {
            next.cancel()
        }
    }

    fun cancel() {
        requestId++
        val previous = session
        session = null
        previous?.cancel()
    }
}

private fun GeoObjectCollection.namedPlaces(): List<SearchPlace> {
    return buildList {
        for (entry in children) {
            val obj = entry.obj
            val name = obj?.name
            val point = obj?.geometry?.firstNotNullOfOrNull { it.point }
            if (name != null && point != null) {
                add(SearchPlace(name, point))
            }
            entry.collection?.let { addAll(it.namedPlaces()) }
        }
    }
}
