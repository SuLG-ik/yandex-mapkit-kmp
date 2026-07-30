---
title: "YMKPanoramaErrorDelegate"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKPanoramaErrorDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaErrorDelegate.html"
---
# YMKPanoramaErrorDelegate

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaErrorDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKPanoramaErrorDelegate <NSObject>
```

Listener to handle possible errors.

## Summary

### Instance methods

```objectivec
- (void)onPanoramaOpenErrorWithPlayer:(nonnull YMKPanoramaPlayer *)player
                                error:(nonnull NSError *)error;
```

Error notification listener for the panoramaOpen class

## Instance methods

### onPanoramaOpenErrorWithPlayer:error:

```objectivec
- (void)onPanoramaOpenErrorWithPlayer:(nonnull YMKPanoramaPlayer *)player
                                error:(nonnull NSError *)error;
```

Error notification listener for the panoramaOpen class. Called if the panorama could not be opened.
