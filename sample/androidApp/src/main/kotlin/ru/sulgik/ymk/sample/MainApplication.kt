package ru.sulgik.ymk.sample

import android.app.Application
import ru.sulgik.mapkit.sample.initMapKit

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initMapKit()
    }

}