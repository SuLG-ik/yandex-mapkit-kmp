---
title: "YMKMapInputListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKMapInputListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapInputListener.html"
---
# YMKMapInputListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapInputListener.html)

```objectivec
@protocol YMKMapInputListener <NSObject>
```

Listener for user interactions with the map.

## Summary

### Instance methods

```objectivec
- (void)onMapTapWithMap:(nonnull YMKMap *)map point:(nonnull YMKPoint *)point;
```

Called when a tap occurred unless a tap was handled by geo objects or map objects

```objectivec
- (void)onMapLongTapWithMap:(nonnull YMKMap *)map
                      point:(nonnull YMKPoint *)point;
```

Called when a long tap occurred

## Instance methods

### onMapTapWithMap:point:

```objectivec
- (void)onMapTapWithMap:(nonnull YMKMap *)map point:(nonnull YMKPoint *)point;
```

Called when a tap occurred unless a tap was handled by geo objects or map objects. param@ position absolute screen coordinates

### onMapLongTapWithMap:point:

```objectivec
- (void)onMapLongTapWithMap:(nonnull YMKMap *)map
                      point:(nonnull YMKPoint *)point;
```

Called when a long tap occurred.
