package ru.sulgik.mapkit

expect class MapKit {

    companion object {

        fun setLocale(locale: String?)

        fun setApiKey(apiKey: String)

        fun setUserId(userId: String)

        fun getInstance(): MapKit

    }

}