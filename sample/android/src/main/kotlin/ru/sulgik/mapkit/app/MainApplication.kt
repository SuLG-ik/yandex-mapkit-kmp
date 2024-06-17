package ru.sulgik.mapkit.app

import android.app.Application
import ru.sulgik.mapkit.sample.initMapKit

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initMapKit()
    }

}