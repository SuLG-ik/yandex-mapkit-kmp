---
title: "YMKMasstransitConstructionMask"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitConstructionMask"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitConstructionMask.html"
---
# YMKMasstransitConstructionMask

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitConstructionMask.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitConstructionMask : NSObject
```

Constructions that can be found on pedestrian, bicycle paths or on mass transit transfers.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitConstructionMask *)constructionMaskWithStairs:(nullable YMKMasstransitStairs *)stairs
                                                                  pass:(nullable NSNumber *)pass
                                                             crosswalk:( BOOL)crosswalk
                                                               binding:( BOOL)binding
                                                            transition:( BOOL)transition
                                                                tunnel:( BOOL)tunnel
                                                            travolator:(nullable NSNumber *)travolator
                                                                indoor:( BOOL)indoor
                                                                spiral:( BOOL)spiral
                                                             escalator:(nullable NSNumber *)escalator
                                                              elevator:(nullable NSNumber *)elevator;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitStairs *stairs;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *pass;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly) BOOL crosswalk;
```

Crossing that is not an underground tunnel or a bridge

```objectivec
@property (nonatomic, readonly) BOOL binding;
```

Edge connecting the route endpoint to the route network

```objectivec
@property (nonatomic, readonly) BOOL transition;
```

Transfer

```objectivec
@property (nonatomic, readonly) BOOL tunnel;
```

Tunnel that is not a crossing

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *travolator;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly) BOOL indoor;
```

Air-conditioned place

```objectivec
@property (nonatomic, readonly) BOOL spiral;
```

Spiral object, e

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *escalator;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *elevator;
```

Optional field, can be nil

## Class methods

### constructionMaskWithStairs:pass:crosswalk:binding:transition:tunnel:travolator:indoor:spiral:escalator:elevator:

```objectivec
+ (nonnull YMKMasstransitConstructionMask *)constructionMaskWithStairs:(nullable YMKMasstransitStairs *)stairs
                                                                  pass:(nullable NSNumber *)pass
                                                             crosswalk:( BOOL)crosswalk
                                                               binding:( BOOL)binding
                                                            transition:( BOOL)transition
                                                                tunnel:( BOOL)tunnel
                                                            travolator:(nullable NSNumber *)travolator
                                                                indoor:( BOOL)indoor
                                                                spiral:( BOOL)spiral
                                                             escalator:(nullable NSNumber *)escalator
                                                              elevator:(nullable NSNumber *)elevator;
```

## Properties

### stairs

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitStairs *stairs;
```

Optional field, can be nil.

### pass

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *pass;
```

Optional field, can be nil.

### crosswalk

```objectivec
@property (nonatomic, readonly) BOOL crosswalk;
```

Crossing that is not an underground tunnel or a bridge.

### binding

```objectivec
@property (nonatomic, readonly) BOOL binding;
```

Edge connecting the route endpoint to the route network.

### transition

```objectivec
@property (nonatomic, readonly) BOOL transition;
```

Transfer. For example, transfer from one underground line to another or transfer from an underground station to an exit from it.

### tunnel

```objectivec
@property (nonatomic, readonly) BOOL tunnel;
```

Tunnel that is not a crossing.

### travolator

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *travolator;
```

Optional field, can be nil.

### indoor

```objectivec
@property (nonatomic, readonly) BOOL indoor;
```

Air-conditioned place. Can be a covered gallery, a mall or any other climate-static edges.

### spiral

```objectivec
@property (nonatomic, readonly) BOOL spiral;
```

Spiral object, e.g. stairs

### escalator

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *escalator;
```

Optional field, can be nil.

### elevator

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *elevator;
```

Optional field, can be nil.
