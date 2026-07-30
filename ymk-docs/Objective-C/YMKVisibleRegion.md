---
title: "YMKVisibleRegion"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKVisibleRegion"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKVisibleRegion.html"
---
# YMKVisibleRegion

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKVisibleRegion.html)

```objectivec
@interface YMKVisibleRegion : NSObject
```

Defines the visible region.

## Summary

### Class methods

```objectivec
+ (nonnull YMKVisibleRegion *)visibleRegionWithTopLeft:(nonnull YMKPoint *)topLeft
                                              topRight:(nonnull YMKPoint *)topRight
                                            bottomLeft:(nonnull YMKPoint *)bottomLeft
                                           bottomRight:(nonnull YMKPoint *)bottomRight;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *topLeft;
```

Top-left of the visible region

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *topRight;
```

Top-right of the visible region

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *bottomLeft;
```

Bottom-left of the visible region

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *bottomRight;
```

Bottom-right of the visible region

## Class methods

### visibleRegionWithTopLeft:topRight:bottomLeft:bottomRight:

```objectivec
+ (nonnull YMKVisibleRegion *)visibleRegionWithTopLeft:(nonnull YMKPoint *)topLeft
                                              topRight:(nonnull YMKPoint *)topRight
                                            bottomLeft:(nonnull YMKPoint *)bottomLeft
                                           bottomRight:(nonnull YMKPoint *)bottomRight;
```

## Properties

### topLeft

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *topLeft;
```

Top-left of the visible region.

### topRight

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *topRight;
```

Top-right of the visible region.

### bottomLeft

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *bottomLeft;
```

Bottom-left of the visible region.

### bottomRight

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *bottomRight;
```

Bottom-right of the visible region.
