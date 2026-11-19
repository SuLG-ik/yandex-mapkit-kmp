package ru.sulgik.liteconsumer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.search.Search
import ru.sulgik.mapkit.search.SearchManagerType

private val suggestionsWindow = BoundingBox(Point(55.65, 37.49), Point(55.87, 37.83))
private var suggestionsKeyConfigured = false

@Composable
internal fun EditionSuggestionsScreen() {
    var configured by remember { mutableStateOf(suggestionsKeyConfigured) }
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).safeDrawingPadding().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (configured) {
            rememberAndInitializeMapKit().bindToLifecycleOwner()
            var editorOpen by remember { mutableStateOf(true) }
            BasicText(
                text = if (editorOpen) "Close editor" else "Open editor",
                modifier = Modifier.clickable(role = Role.Button) { editorOpen = !editorOpen }.padding(8.dp),
            )
            if (editorOpen) {
                val manager = remember { Search.getInstance().createSearchManager(SearchManagerType.ONLINE) }
                BasicText("Search suggestions for the Moscow viewport")
                FullSuggestionsExample(manager, suggestionsWindow)
            }
        } else {
            SuggestionsKeyPrompt {
                suggestionsKeyConfigured = true
                configured = true
            }
        }
    }
}

@Composable
private fun SuggestionsKeyPrompt(onConfigured: () -> Unit) {
    var key by remember { mutableStateOf("") }
    BasicText("Enter a MapKit Full API key")
    BasicTextField(
        value = key,
        onValueChange = { key = it },
        modifier = Modifier.fillMaxWidth().border(1.dp, Color.Gray).padding(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
    )
    BasicText(
        text = "Open editor",
        modifier = Modifier.clickable(enabled = key.isNotBlank(), role = Role.Button) {
            MapKit.setApiKey(key.trim())
            key = ""
            onConfigured()
        }.padding(8.dp),
    )
}
