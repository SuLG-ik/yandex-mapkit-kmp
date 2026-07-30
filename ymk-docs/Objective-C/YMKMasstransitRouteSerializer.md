---
title: "YMKMasstransitRouteSerializer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitRouteSerializer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteSerializer.html"
---
# YMKMasstransitRouteSerializer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteSerializer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitRouteSerializer : NSObject
```

## Summary

### Instance methods

```objectivec
- (nonnull NSData *)saveWithRoute:(nonnull YMKMasstransitRoute *)route;
```

Serializes the route

```objectivec
- (nullable YMKMasstransitRoute *)loadWithData:(nonnull NSData *)data;
```

Deserializes the route

## Instance methods

### saveWithRoute:

```objectivec
- (nonnull NSData *)saveWithRoute:(nonnull YMKMasstransitRoute *)route;
```

Serializes the route.

**Returns**

Route's serialized representation. Empty array in case of any

errors.

### loadWithData:

```objectivec
- (nullable YMKMasstransitRoute *)loadWithData:(nonnull NSData *)data;
```

Deserializes the route.

**Returns**

Deserialized Route. Null in case of any errors.
