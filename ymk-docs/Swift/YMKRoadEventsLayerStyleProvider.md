---
title: "YMKRoadEventsLayerStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKRoadEventsLayerStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsLayerStyleProvider.html"
---
# YMKRoadEventsLayerStyleProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsLayerStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKRoadEventsLayerStyleProvider : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func provideStyle(with roadEventStylingProperties: YMKRoadEventsLayerRoadEventStylingProperties,
                                      isNightMode: Bool,
                                      scaleFactor: Float,
                                            style: YMKRoadEventsLayerRoadEventStyle) -> Bool
```

Provide style for given road event

## Instance methods

### provideStyle(with:isNightMode:scaleFactor:style:)

```swift
func provideStyle(with roadEventStylingProperties: YMKRoadEventsLayerRoadEventStylingProperties,
                                      isNightMode: Bool,
                                      scaleFactor: Float,
                                            style: YMKRoadEventsLayerRoadEventStyle) -> Bool
```

Provide style for given road event. Must produce same style for same input arguments.

| Parameters |   |
| --- | --- |
| scaleFactor | Scale factor of a map window displaying this road event. Road event icon image scale factor must match this value. |

**Returns**

`false` if road event must not be displayed at all.
