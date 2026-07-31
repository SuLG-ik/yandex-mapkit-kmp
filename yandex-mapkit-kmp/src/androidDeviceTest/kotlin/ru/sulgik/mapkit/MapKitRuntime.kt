package ru.sulgik.mapkit

import androidx.test.platform.app.InstrumentationRegistry
import com.yandex.runtime.Runtime

internal object MapKitRuntime {

    private var initialized = false

    fun ensureLoaded() {
        if (initialized) {
            return
        }
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        instrumentation.runOnMainSync { Runtime.init(instrumentation.targetContext) }
        initialized = true
    }
}
