---
title: "YMKPanoramaSpanChangeDelegate"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKPanoramaSpanChangeDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaSpanChangeDelegate.html"
---
# YMKPanoramaSpanChangeDelegate

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaSpanChangeDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKPanoramaSpanChangeDelegate <NSObject>
```

Listener to handle the change in panorama span.

## Summary

### Instance methods

```objectivec
- (void)onPanoramaSpanChangedWithPlayer:(nonnull YMKPanoramaPlayer *)player;
```

Called if the user changed the zoom level or the span has been changed by the setSpan() method

## Instance methods

### onPanoramaSpanChangedWithPlayer:

```objectivec
- (void)onPanoramaSpanChangedWithPlayer:(nonnull YMKPanoramaPlayer *)player;
```

Called if the user changed the zoom level or the span has been changed by the setSpan() method.

| Parameters |   |
| --- | --- |
| player | Panorama player that sent the event. |
