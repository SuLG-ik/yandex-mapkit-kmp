package ru.sulgik.liteconsumer

import androidx.compose.ui.window.ComposeUIViewController
import platform.Foundation.NSFileManager
import platform.Foundation.NSLog
import platform.Foundation.NSTemporaryDirectory
import platform.UIKit.UIViewController

public fun suggestionsController(): UIViewController {
    return ComposeUIViewController { SuggestionsScreen() }
}

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
    return liveServiceController(token, apiKey, LiveServiceProbe.Search)
}

public fun liveRoutingController(token: String, apiKey: String): UIViewController {
    return liveServiceController(token, apiKey, LiveServiceProbe.Routing)
}

private fun liveServiceController(token: String, apiKey: String, probe: LiveServiceProbe): UIViewController {
    check(isLiveServiceToken(token))
    val resultName = "$token-${probe.marker}"
    if (apiKey.isBlank()) {
        reportLiveService(resultName, LiveServiceStatus.RunnerOrFixture)
        return ComposeUIViewController {}
    }
    initializeSmokeMap(apiKey)
    return ComposeUIViewController {
        LiveServiceMap(
            probe = probe,
            onModeResult = { mode, status -> reportLiveService("$resultName-$mode", status) },
            onResult = { status -> reportLiveService(resultName, status) },
        )
    }
}

private fun reportLiveService(resultName: String, status: LiveServiceStatus) {
    val temporaryPath = NSTemporaryDirectory().trimEnd('/')
    val path = "$temporaryPath/$resultName-${status.code}"
    check(NSFileManager.defaultManager.createFileAtPath(path, contents = null, attributes = null))
}
