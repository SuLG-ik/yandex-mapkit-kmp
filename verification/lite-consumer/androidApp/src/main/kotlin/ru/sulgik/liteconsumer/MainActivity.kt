package ru.sulgik.liteconsumer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import java.io.File

internal class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val showSuggestions = intent.getBooleanExtra("suggestions", false)
        val liveSearch = intent.getBooleanExtra("liveSearch", false)
        val liveRouting = intent.getBooleanExtra("liveRouting", false)
        if ((showSuggestions && (liveSearch || liveRouting)) || (liveSearch && liveRouting)) return
        if (showSuggestions) {
            setContent { SuggestionsScreen() }
            return
        }

        val token = intent.getStringExtra("smokeToken") ?: "manual"
        if (liveSearch || liveRouting) {
            val probe = if (liveSearch) LiveServiceProbe.Search else LiveServiceProbe.Routing
            launchLiveService(token, probe)
            return
        }
        initializeSmokeMap()
        setContent {
            SmokeMap {
                Log.i("MapKitLiteConsumer", "$token MAP_READY")
            }
        }
    }

    private fun launchLiveService(token: String, probe: LiveServiceProbe) {
        if (!isLiveServiceToken(token)) return
        val resultName = "$token-${probe.marker}"
        val outcome = File(filesDir, resultName)
        val keyFile = File(filesDir, probe.keyFile)
        val key = try {
            keyFile.readText()
        } catch (_: java.io.IOException) {
            ""
        } finally {
            keyFile.delete()
        }
        if (key.isBlank()) {
            outcome.writeText(LiveServiceStatus.RunnerOrFixture.code.toString())
            return
        }
        initializeSmokeMap(key)
        setContent {
            LiveServiceMap(
                probe = probe,
                onModeResult = { mode, status -> File(filesDir, "$resultName-$mode").writeText(status.code.toString()) },
                onResult = { status -> outcome.writeText(status.code.toString()) },
            )
        }
    }
}
