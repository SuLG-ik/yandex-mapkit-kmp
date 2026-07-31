---
title: "YMKMasstransitConnector"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitConnector"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitConnector.html"
---
# YMKMasstransitConnector

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitConnector.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitConnector : NSObject
```

Connectors connect two floors, indoor and outdoor, two indoor plans. Connectors do not have single level id and name but still are considered a part of the indoor plan. Examples: stairs, elevators, escalators, travolators, transitions, route segment that goes from outdoor to indoor (through the entrance) and vica versa.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitConnector *)connectorWithFrom:(nullable YMKMasstransitIndoorLevel *)from
                                                    to:(nullable YMKMasstransitIndoorLevel *)to;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitIndoorLevel *from;
```

A level (floor) where the connector begins

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitIndoorLevel *to;
```

A level (floor) where the connector ends

## Class methods

### connectorWithFrom:to:

```objectivec
+ (nonnull YMKMasstransitConnector *)connectorWithFrom:(nullable YMKMasstransitIndoorLevel *)from
                                                    to:(nullable YMKMasstransitIndoorLevel *)to;
```

## Properties

### from

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitIndoorLevel *from;
```

A level (floor) where the connector begins. Null means outdoor.

Optional field, can be nil.

### to

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitIndoorLevel *to;
```

A level (floor) where the connector ends. Null means outdoor.

Optional field, can be nil.
