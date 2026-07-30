---
title: "YMKMasstransitTransfer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransfer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransfer.html"
---
# YMKMasstransitTransfer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransfer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransfer : NSObject
```

Represents a transfer to another mass transit line or to another stop. For example, transfer from one underground line to another.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransfer *)transferWithConstructions:(nonnull NSArray<YMKMasstransitConstructionSegment *> *)constructions
                                                 transferStop:(nonnull YMKMasstransitTransferStop *)transferStop;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitConstructionSegment *> *constructions;
```

Compressed information about pedestrian constructions along the transfer path

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitTransferStop *transferStop;
```

The stop you need to transfer to

## Class methods

### transferWithConstructions:transferStop:

```objectivec
+ (nonnull YMKMasstransitTransfer *)transferWithConstructions:(nonnull NSArray<YMKMasstransitConstructionSegment *> *)constructions
                                                 transferStop:(nonnull YMKMasstransitTransferStop *)transferStop;
```

## Properties

### constructions

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitConstructionSegment *> *constructions;
```

Compressed information about pedestrian constructions along the transfer path. YMKMasstransitConstructionSegment::subpolyline fields of all segments cover the entire geometry of corresponding section".

### transferStop

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitTransferStop *transferStop;
```

The stop you need to transfer to
