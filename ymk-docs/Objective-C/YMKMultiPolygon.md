---
title: "YMKMultiPolygon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMultiPolygon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMultiPolygon.html"
---
# YMKMultiPolygon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMultiPolygon.html)

```objectivec
@interface YMKMultiPolygon : NSObject
```

An area consisting of multiple external polygons.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMultiPolygon *)multiPolygonWithPolygons:(nonnull NSArray<YMKPolygon *> *)polygons;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKPolygon *> *polygons;
```

## Class methods

### multiPolygonWithPolygons:

```objectivec
+ (nonnull YMKMultiPolygon *)multiPolygonWithPolygons:(nonnull NSArray<YMKPolygon *> *)polygons;
```

## Properties

### polygons

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKPolygon *> *polygons;
```
