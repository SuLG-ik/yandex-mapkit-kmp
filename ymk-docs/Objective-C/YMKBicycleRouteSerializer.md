---
title: "YMKBicycleRouteSerializer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleRouteSerializer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleRouteSerializer.html"
---
# YMKBicycleRouteSerializer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleRouteSerializer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleRouteSerializer : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull NSData *)saveWithRoute:(nonnull YMKBicycleRoute *)route;
```

Returns a route's serialized representation

```objectivec
+ (nonnull YMKBicycleRoute *)loadWithData:(nonnull NSData *)data;
```

Returns a deserialized route

## Class methods

### saveWithRoute:

```objectivec
+ (nonnull NSData *)saveWithRoute:(nonnull YMKBicycleRoute *)route;
```

Returns a route's serialized representation. Returns an empty array if there are any errors.

### loadWithData:

```objectivec
+ (nonnull YMKBicycleRoute *)loadWithData:(nonnull NSData *)data;
```

Returns a deserialized route. Returns null on error.
