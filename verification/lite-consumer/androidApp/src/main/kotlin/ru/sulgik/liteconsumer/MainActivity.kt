package ru.sulgik.liteconsumer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

internal class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val token = intent.getStringExtra("smokeToken") ?: "manual"
        initializeAndroidSmokeMap(this)
        setContent {
            SmokeMap {
                Log.i("MapKitLiteConsumer", "$token MAP_READY")
            }
        }
    }
}
