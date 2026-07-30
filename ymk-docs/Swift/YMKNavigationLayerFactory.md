---
title: "YMKNavigationLayerFactory"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigationLayerFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationLayerFactory.html"
---
# YMKNavigationLayerFactory

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationLayerFactory.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigationLayerFactory : NSObject
```

## Summary

### Class methods

```swift
class func createNavigationLayer(with mapWindow: YMKMapWindow,
                   roadEventsLayerStyleProvider: any YMKRoadEventsLayerStyleProvider,
                                  styleProvider: any YMKNavigationStyleProvider,
                                     navigation: YMKNavigation) -> YMKNavigationLayer
```

Adds navigation layer on the map

## Class methods

### createNavigationLayer(with:roadEventsLayerStyleProvider:styleProvider:navigation:)

```swift
class func createNavigationLayer(with mapWindow: YMKMapWindow,
                   roadEventsLayerStyleProvider: any YMKRoadEventsLayerStyleProvider,
                                  styleProvider: any YMKNavigationStyleProvider,
                                     navigation: YMKNavigation) -> YMKNavigationLayer
```

Adds navigation layer on the map.

The class maintains a strong reference to the object in the 'roadEventsLayerStyleProvider' parameter until it (the class) is invalidated.

The class maintains a strong reference to the object in the 'styleProvider' parameter until it (the class) is invalidated.
