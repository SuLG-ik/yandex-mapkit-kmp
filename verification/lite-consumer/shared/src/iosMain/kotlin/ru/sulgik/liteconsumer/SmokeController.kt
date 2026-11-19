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
