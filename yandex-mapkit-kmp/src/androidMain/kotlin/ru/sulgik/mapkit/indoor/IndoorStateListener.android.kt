package ru.sulgik.mapkit.indoor

import com.yandex.mapkit.indoor.IndoorPlan as NativeIndoorPlan
import com.yandex.mapkit.indoor.IndoorStateListener as NativeIndoorStateListener

public actual abstract class IndoorStateListener actual constructor() {

    private val nativeListener = object : NativeIndoorStateListener {
        override fun onActivePlanFocused(p0: NativeIndoorPlan) {
            this@IndoorStateListener.onActivePlanFocused(p0.toCommon())
        }

        override fun onActivePlanLeft() {
            this@IndoorStateListener.onActivePlanLeft()
        }

        override fun onActiveLevelChanged(p0: String) {
            this@IndoorStateListener.onActiveLevelChanged(p0)
        }
    }

    public fun toNative(): NativeIndoorStateListener {
        return nativeListener
    }

    public actual abstract fun onActivePlanFocused(activePlan: IndoorPlan)
    public actual abstract fun onActivePlanLeft()
    public actual abstract fun onActiveLevelChanged(activeLevelId: String)
}