package ru.sulgik.liteconsumer

import androidx.compose.ui.window.ComposeUIViewController
import platform.Foundation.NSFileManager
import platform.Foundation.NSLog
import platform.Foundation.NSTemporaryDirectory
import platform.UIKit.UIViewController

public fun smokeController(token: String): UIViewController {
    initializeSmokeMap()
    return ComposeUIViewController {
        SmokeMap {
            val files = NSFileManager.defaultManager
            val temporaryPath = NSTemporaryDirectory().trimEnd('/')
            check(files.createFileAtPath("$temporaryPath/$token-MAP_READY", contents = null, attributes = null))
            NSLog("%@ MAP_READY", token)
        }
    }
}

public fun liveSearchController(token: String, apiKey: String): UIViewController {
    check(isLiveSearchToken(token))
    if (apiKey.isBlank()) {
        reportLiveSearch(token, LiveSearchStatus.RunnerOrFixture)
        return ComposeUIViewController {}
    }
    initializeSmokeMap(apiKey)
    return ComposeUIViewController {
        LiveSearchMap { status -> reportLiveSearch(token, status) }
    }
}

private fun reportLiveSearch(token: String, status: LiveSearchStatus) {
    val temporaryPath = NSTemporaryDirectory().trimEnd('/')
    val path = "$temporaryPath/$token-LIVE_SEARCH-${status.code}"
    check(NSFileManager.defaultManager.createFileAtPath(path, contents = null, attributes = null))
}
