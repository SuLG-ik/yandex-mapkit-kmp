package ru.sulgik.liteconsumer

import ru.sulgik.mapkit.search.Search
import ru.sulgik.mapkit.search.SearchManagerType

internal fun verifySearchManager() {
    val search = Search.getInstance()
    check(search.isValid)
    val manager = search.createSearchManager(SearchManagerType.ONLINE)
    manager.createSuggestSession().reset()
}
