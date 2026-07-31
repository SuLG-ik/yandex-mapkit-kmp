---
title: "YMKPanoramaService"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaService"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaService.html"
---
# YMKPanoramaService

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaService.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaService : NSObject
```

The interface that handles panoramas.

## Summary

### Instance methods

```objectivec
- (nonnull YMKPanoramaServiceSearchSession *)
    findNearestWithPosition:(nonnull YMKPoint *)position
              searchHandler:
                  (nonnull YMKPanoramaServiceSearchHandler)searchHandler;
```

Requests the ID of the panorama that is closest to the specified position

## Instance methods

### findNearestWithPosition:searchHandler:

```objectivec
- (nonnull YMKPanoramaServiceSearchSession *)
    findNearestWithPosition:(nonnull YMKPoint *)position
              searchHandler:
                  (nonnull YMKPanoramaServiceSearchHandler)searchHandler;
```

Requests the ID of the panorama that is closest to the specified position.

| Parameters |   |
| --- | --- |
| position | Position to find the nearest panoramaId to. |
| searchListener | Receives the panorama search result. |

**Returns**

Session handle that should be stored until searchListener is

notified.
