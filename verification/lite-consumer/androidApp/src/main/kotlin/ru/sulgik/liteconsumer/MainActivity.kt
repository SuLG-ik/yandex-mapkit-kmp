package ru.sulgik.liteconsumer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import java.io.File

internal class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val token = intent.getStringExtra("smokeToken") ?: "manual"
        if (intent.getBooleanExtra("liveSearch", false)) {
            launchLiveSearch(token)
            return
        }
        initializeSmokeMap()
        setContent {
            SmokeMap {
                Log.i("MapKitLiteConsumer", "$token MAP_READY")
            }
        }
    }

    private fun launchLiveSearch(token: String) {
        if (!isLiveSearchToken(token)) return
        val outcome = File(filesDir, "$token-LIVE_SEARCH")
        val keyFile = File(filesDir, "live-search-key")
        val key = try {
            keyFile.readText()
        } catch (_: java.io.IOException) {
            ""
        } finally {
            keyFile.delete()
        }
        if (key.isBlank()) {
            outcome.writeText(LiveSearchStatus.RunnerOrFixture.code.toString())
            return
        }
        initializeSmokeMap(key)
        setContent {
            LiveSearchMap { status -> outcome.writeText(status.code.toString()) }
        }
    }
}
