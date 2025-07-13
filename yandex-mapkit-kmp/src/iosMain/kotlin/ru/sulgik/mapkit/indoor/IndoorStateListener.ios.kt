package ru.sulgik.mapkit.indoor

import YandexMapKit.YMKIndoorPlan
import platform.darwin.NSObject
import YandexMapKit.YMKIndoorStateListenerProtocol as NativeIndoorStateListenerProtocol

public actual abstract class IndoorStateListener actual constructor() {

    private val nativeListener = object: NativeIndoorStateListenerProtocol, NSObject() {
        override fun onActiveLevelChangedWithActiveLevelId(activeLevelId: String) {
            this@IndoorStateListener.onActiveLevelChanged(activeLevelId)
        }

        override fun onActivePlanFocusedWithActivePlan(activePlan: YMKIndoorPlan) {
            this@IndoorStateListener.onActivePlanFocused(activePlan.toCommon())
        }

        override fun onActivePlanLeft() {
            this@IndoorStateListener.onActivePlanLeft()
        }
    }

    public fun toNative(): NativeIndoorStateListenerProtocol {
        return nativeListener
    }

    public actual abstract fun onActivePlanFocused(activePlan: IndoorPlan)
    public actual abstract fun onActivePlanLeft()
    public actual abstract fun onActiveLevelChanged(activeLevelId: String)
}