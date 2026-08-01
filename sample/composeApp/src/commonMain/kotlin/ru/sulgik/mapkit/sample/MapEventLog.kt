package ru.sulgik.mapkit.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MapEventLog {

    val entries = mutableStateListOf<String>()

    fun add(entry: String) {
        entries.add(0, entry)
        while (entries.size > MaxEntries) {
            entries.removeAt(entries.lastIndex)
        }
    }

    fun clear() {
        entries.clear()
    }

    fun runAndLog(name: String, action: () -> Unit) {
        try {
            action()
            add(name)
        } catch (error: Throwable) {
            add("$name FAILED: $error")
            println("MapEventLog: $name failed\n${error.stackTraceToString()}")
        }
    }
}

@Composable
fun rememberMapEventLog(): MapEventLog {
    return remember { MapEventLog() }
}

@Composable
fun MapEventLogPanel(
    log: MapEventLog,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.widthIn(max = 320.dp).heightIn(max = 220.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f),
        ),
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()).padding(8.dp),
        ) {
            if (log.entries.isEmpty()) {
                Text("No events yet", fontSize = 11.sp)
            }
            log.entries.forEach {
                Text(it, fontSize = 11.sp)
            }
        }
    }
}

private const val MaxEntries = 40
