package ru.sulgik.mapkit.search

/** Successful response of a suggest request. An empty [items] list is valid. */
public data class SuggestResponse(val items: List<SuggestItem>)
