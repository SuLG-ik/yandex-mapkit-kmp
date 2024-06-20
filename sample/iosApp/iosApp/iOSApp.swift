import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    
    
    init() {
        AppKt.doInitMapKit()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
    
}
