package ru.sulgik.liteconsumer

import android.content.Context
import ru.sulgik.mapkit.MapKit

public fun initializeAndroidSmokeMap(context: Context) {
    initializeSmokeMap()
    MapKit.initialize(context)
}
