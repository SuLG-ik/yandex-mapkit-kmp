import SwiftUI
import ComposeApp
import YandexMapsMobile

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
