package ru.sulgik.liteconsumer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.search.SearchError
import ru.sulgik.mapkit.search.SearchManager
import ru.sulgik.mapkit.search.SuggestItem
import ru.sulgik.mapkit.search.SuggestListener
import ru.sulgik.mapkit.search.SuggestOptions
import ru.sulgik.mapkit.search.SuggestSession

@Composable
internal fun FullSuggestionsExample(manager: SearchManager, window: BoundingBox) {
    val editor = remember(manager) { SuggestEditor(manager.createSuggestSession()) }
    var query by remember(editor) { mutableStateOf("") }
    var items by remember(editor) { mutableStateOf(emptyList<SuggestItem>()) }
    var failure by remember(editor) { mutableStateOf<SearchError?>(null) }

    DisposableEffect(editor) {
        onDispose { editor.close() }
    }

    Column {
        BasicTextField(
            value = query,
            onValueChange = { text ->
                query = text
                items = emptyList()
                failure = null
                editor.update(text, window, { items = it }, { failure = it })
            },
        )
        failure?.let { BasicText(it.description ?: "MapKit could not load suggestions") }
        for (item in items) {
            BasicText(item.displayText ?: item.title.text)
        }
    }
}

private class SuggestEditor(private val session: SuggestSession) {

    private var generation: Long = 0

    fun update(
        query: String,
        window: BoundingBox,
        onSuggestions: (List<SuggestItem>) -> Unit,
        onFailure: (SearchError) -> Unit,
    ) {
        val current = ++generation
        if (query.isBlank()) {
            session.reset()
            onSuggestions(emptyList())
            return
        }
        session.suggest(
            text = query,
            window = window,
            suggestOptions = SuggestOptions(),
            suggestListener = SuggestListener(
                onResponse = { response -> if (current == generation) onSuggestions(response.items) },
                onError = { failure -> if (current == generation) onFailure(failure) },
            ),
        )
    }

    fun close() {
        generation++
        session.reset()
    }
}
