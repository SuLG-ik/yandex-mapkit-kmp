---
title: "YMKMasstransitTransport"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransport"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransport.html"
---
# YMKMasstransitTransport

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransport.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransport : NSObject
```

Contains information about the mass transit ride section of a YMKMasstransitRoute for a specific mass transit YMKMasstransitLine.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransport *)transportWithLine:(nonnull YMKMasstransitLine *)line
                                            transports:(nonnull NSArray<YMKMasstransitTransportTransportThread *> *)transports
                                     transportContours:(nonnull NSArray<YMKMasstransitTransportContour *> *)transportContours;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitLine *line;
```

Mass transit line

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransportTransportThread *> *transports;
```

Collection of mass transit threads of the specified line suitable for the constructed route

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransportContour *> *transportContours;
```

Describes YMKMasstransitTransportContour in borders of which this block is located

## Class methods

### transportWithLine:transports:transportContours:

```objectivec
+ (nonnull YMKMasstransitTransport *)transportWithLine:(nonnull YMKMasstransitLine *)line
                                            transports:(nonnull NSArray<YMKMasstransitTransportTransportThread *> *)transports
                                     transportContours:(nonnull NSArray<YMKMasstransitTransportContour *> *)transportContours;
```

## Properties

### line

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitLine *line;
```

Mass transit line.

### transports

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransportTransportThread *> *transports;
```

Collection of mass transit threads of the specified line suitable for the constructed route.

### transportContours

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransportContour *> *transportContours;
```

Describes YMKMasstransitTransportContour in borders of which this block is located
