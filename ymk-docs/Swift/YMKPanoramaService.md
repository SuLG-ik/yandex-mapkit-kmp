---
title: "YMKPanoramaService"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaService"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaService.html"
---
# YMKPanoramaService

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaService.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaService : NSObject
```

The interface that handles panoramas.

## Summary

### Instance methods

```swift
func findNearest(withPosition position: YMKPoint,
                         searchHandler: @escaping YMKPanoramaServiceSearchHandler) -> YMKPanoramaServiceSearchSession
```

Requests the ID of the panorama that is closest to the specified position

## Instance methods

### findNearest(withPosition:searchHandler:)

```swift
func findNearest(withPosition position: YMKPoint,
                         searchHandler: @escaping YMKPanoramaServiceSearchHandler) -> YMKPanoramaServiceSearchSession
```

Requests the ID of the panorama that is closest to the specified position.

| Parameters |   |
| --- | --- |
| position | Position to find the nearest panoramaId to. |
| searchListener | Receives the panorama search result. |

**Returns**

Session handle that should be stored until searchListener is

notified.
