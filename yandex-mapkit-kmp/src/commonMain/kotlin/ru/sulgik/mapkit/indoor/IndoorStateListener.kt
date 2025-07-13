package ru.sulgik.mapkit.indoor

public expect abstract class IndoorStateListener() {
    public abstract fun onActivePlanFocused(activePlan: IndoorPlan)
    public abstract fun onActivePlanLeft()
    public abstract fun onActiveLevelChanged(activeLevelId: String)
}

public inline fun IndoorStateListener(
    crossinline onActivePlanFocused: (activePlan: IndoorPlan) -> Unit,
    crossinline onActivePlanLeft: () -> Unit,
    crossinline onActiveLevelChanged: (activeLevelId: String) -> Unit,
): IndoorStateListener {
    return object : IndoorStateListener() {
        override fun onActivePlanFocused(activePlan: IndoorPlan) {
            onActivePlanFocused.invoke(activePlan)
        }

        override fun onActivePlanLeft() {
            onActivePlanLeft.invoke()
        }

        override fun onActiveLevelChanged(activeLevelId: String) {
            onActiveLevelChanged.invoke(activeLevelId)
        }
    }
}