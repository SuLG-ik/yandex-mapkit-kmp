package ru.sulgik.mapkit.sample

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AdvancedMapState {
    var isTrafficEnabled by mutableStateOf(false)
    var isTileLayerEnabled by mutableStateOf(false)
    var isObjectLayerEnabled by mutableStateOf(false)
    var isGroupVisible by mutableStateOf(true)
    var groupZIndex by mutableStateOf(0f)
}

@Composable
fun rememberAdvancedMapState(): AdvancedMapState {
    return remember { AdvancedMapState() }
}

@Composable
fun AdvancedMapActions(
    actions: List<Pair<String, () -> Unit>>,
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier, color = MaterialTheme.colorScheme.surface) {
        Column(
            modifier = Modifier.heightIn(max = 230.dp).verticalScroll(rememberScrollState())
                .padding(vertical = 6.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            actions.chunked(ActionsPerRow).forEach { row ->
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    row.forEach { (title, onClick) ->
                        OutlinedButton(
                            onClick = onClick,
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp),
                        ) {
                            Text(title, fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}

private const val ActionsPerRow = 5
