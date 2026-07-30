---
title: "YMKMapSizeChangedListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKMapSizeChangedListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapSizeChangedListener.html"
---
# YMKMapSizeChangedListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapSizeChangedListener.html)

```objectivec
@protocol YMKMapSizeChangedListener <NSObject>
```

Listener for MapWindow size changes.

## Summary

### Instance methods

```objectivec
- (void)onMapWindowSizeChangedWithMapWindow:(nonnull YMKMapWindow *)mapWindow
                                   newWidth:(NSInteger)newWidth
                                  newHeight:(NSInteger)newHeight;
```

Called when MapWindow handles the platform SizeChanged event

## Instance methods

### onMapWindowSizeChangedWithMapWindow:newWidth:newHeight:

```objectivec
- (void)onMapWindowSizeChangedWithMapWindow:(nonnull YMKMapWindow *)mapWindow
                                   newWidth:(NSInteger)newWidth
                                  newHeight:(NSInteger)newHeight;
```

Called when MapWindow handles the platform SizeChanged event. param@ absolute Screen coordinates.
