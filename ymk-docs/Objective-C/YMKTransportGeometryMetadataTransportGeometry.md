---
title: "YMKTransportGeometryMetadataTransportGeometry"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTransportGeometryMetadataTransportGeometry"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTransportGeometryMetadataTransportGeometry.html"
---
# YMKTransportGeometryMetadataTransportGeometry

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTransportGeometryMetadataTransportGeometry.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKTransportGeometryMetadataTransportGeometry : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKTransportGeometryMetadataTransportGeometry *)transportGeometryWithThreadIds:(nonnull NSArray<NSString *> *)threadIds
                                                                                 geometry:(nonnull YMKPolyline *)geometry;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *threadIds;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

## Class methods

### transportGeometryWithThreadIds:geometry:

```objectivec
+ (nonnull YMKTransportGeometryMetadataTransportGeometry *)transportGeometryWithThreadIds:(nonnull NSArray<NSString *> *)threadIds
                                                                                 geometry:(nonnull YMKPolyline *)geometry;
```

## Properties

### threadIds

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *threadIds;
```

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```
