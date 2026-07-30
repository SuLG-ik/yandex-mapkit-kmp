---
title: "YMKNavigationRouteViewStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKNavigationRouteViewStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationRouteViewStyleProvider.html"
---
# YMKNavigationRouteViewStyleProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationRouteViewStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
protocol YMKNavigationRouteViewStyleProvider : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func provideJamStyle(with flags: YMKDrivingFlags,
                     isSelected: Bool,
                    isNightMode: Bool,
            navigationLayerMode: YMKNavigationLayerMode,
                       jamStyle: YMKNavigationJamStyle)
```

```swift
func providePolylineStyle(with flags: YMKDrivingFlags,
                          isSelected: Bool,
                         isNightMode: Bool,
                 navigationLayerMode: YMKNavigationLayerMode,
                       polylineStyle: YMKPolylineStyle)
```

```swift
func provideManoeuvreStyle(with flags: YMKDrivingFlags,
                           isSelected: Bool,
                          isNightMode: Bool,
                  navigationLayerMode: YMKNavigationLayerMode,
                           arrowStyle: YMKArrowStyle)
```

```swift
func provideRouteStyle(with flags: YMKDrivingFlags,
                       isSelected: Bool,
                      isNightMode: Bool,
              navigationLayerMode: YMKNavigationLayerMode,
                       routeStyle: YMKNavigationRouteStyle)
```

## Instance methods

### provideJamStyle(with:isSelected:isNightMode:navigationLayerMode:jamStyle:)

```swift
func provideJamStyle(with flags: YMKDrivingFlags,
                     isSelected: Bool,
                    isNightMode: Bool,
            navigationLayerMode: YMKNavigationLayerMode,
                       jamStyle: YMKNavigationJamStyle)
```

### providePolylineStyle(with:isSelected:isNightMode:navigationLayerMode:polylineStyle:)

```swift
func providePolylineStyle(with flags: YMKDrivingFlags,
                          isSelected: Bool,
                         isNightMode: Bool,
                 navigationLayerMode: YMKNavigationLayerMode,
                       polylineStyle: YMKPolylineStyle)
```

### provideManoeuvreStyle(with:isSelected:isNightMode:navigationLayerMode:arrowStyle:)

```swift
func provideManoeuvreStyle(with flags: YMKDrivingFlags,
                           isSelected: Bool,
                          isNightMode: Bool,
                  navigationLayerMode: YMKNavigationLayerMode,
                           arrowStyle: YMKArrowStyle)
```

### provideRouteStyle(with:isSelected:isNightMode:navigationLayerMode:routeStyle:)

```swift
func provideRouteStyle(with flags: YMKDrivingFlags,
                       isSelected: Bool,
                      isNightMode: Bool,
              navigationLayerMode: YMKNavigationLayerMode,
                       routeStyle: YMKNavigationRouteStyle)
```
