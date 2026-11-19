package ru.sulgik.ymk.sample

import android.app.Application
import android.content.pm.ApplicationInfo
import ru.sulgik.mapkit.sample.initMapKit
import ru.sulgik.mapkit.sample.initMapKitForReturnBenchmark
import java.io.File

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val credential = File(filesDir, "return-map-benchmark-key")
        if ((applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0 && credential.isFile) {
            val key = try {
                credential.readText()
            } finally {
                check(credential.delete()) { "Could not remove the benchmark credential handoff." }
            }
            check(key.isNotBlank()) { "The benchmark credential handoff is empty." }
            val metrics = File(filesDir, "return-map-benchmark.metrics")
            initMapKitForReturnBenchmark(key) { row -> metrics.appendText("$row\n") }
        } else {
            initMapKit()
        }
    }
}
