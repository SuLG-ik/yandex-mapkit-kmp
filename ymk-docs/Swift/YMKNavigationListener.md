---
title: "YMKNavigationListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKNavigationListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationListener.html"
---
# YMKNavigationListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
protocol YMKNavigationListener : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func onRoutesRequested(with points: [YMKRequestPoint])
```

```swift
func onAlternativesRequested(withCurrentRoute currentRoute: YMKDrivingRoute)
```

Calls when a user requested alternatives for the current route

```swift
func onUriResolvingRequested(withUri uri: String)
```

```swift
func onMatchRouteResolvingRequested()
```

```swift
func onRoutesBuilt()
```

Calls when routes, alternatives, or URI request succeeds After alternatives request Navigation

```swift
func onRoutesRequestErrorWithError(_ error: any Error)
```

Will be called when an error occurs during routes, alternatives or uri request

```swift
func onResetRoutes()
```

## Instance methods

### onRoutesRequested(with:)

```swift
func onRoutesRequested(with points: [YMKRequestPoint])
```

### onAlternativesRequested(withCurrentRoute:)

```swift
func onAlternativesRequested(withCurrentRoute currentRoute: YMKDrivingRoute)
```

Calls when a user requested alternatives for the current route. After this callback Navigation will have the current route and fastest alternative route (if available) in Navigation.routes()

### onUriResolvingRequested(withUri:)

```swift
func onUriResolvingRequested(withUri uri: String)
```

### onMatchRouteResolvingRequested()

```swift
func onMatchRouteResolvingRequested()
```

### onRoutesBuilt()

```swift
func onRoutesBuilt()
```

Calls when routes, alternatives, or URI request succeeds After alternatives request Navigation.routes() will have current route and fastest alternative for the request moment along with received alternatives.

### onRoutesRequestErrorWithError(_:)

```swift
func onRoutesRequestErrorWithError(_ error: any Error)
```

Will be called when an error occurs during routes, alternatives or uri request

### onResetRoutes()

```swift
func onResetRoutes()
```
