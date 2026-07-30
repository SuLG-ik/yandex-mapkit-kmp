---
title: "YMKBalloonGeometry"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBalloonGeometry"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBalloonGeometry.html"
---
# YMKBalloonGeometry

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBalloonGeometry.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKBalloonGeometry : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKBalloonGeometry *)balloonGeometryWithAnchor:(nonnull YMKBalloonAnchor *)anchor
                                                    width:( float)width
                                                   height:( float)height
                                              imageAnchor:( CGPoint)imageAnchor
                                              contentRect:(nonnull YMKRect *)contentRect
                                              balloonRect:(nonnull YMKRect *)balloonRect;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKBalloonAnchor *anchor;
```

```objectivec
@property (nonatomic, readonly) float width;
```

Total balloon image size

```objectivec
@property (nonatomic, readonly) float height;
```

```objectivec
@property (nonatomic, readonly) CGPoint imageAnchor;
```

Anchor inside image rect

```objectivec
@property (nonatomic, readonly, nonnull) YMKRect *contentRect;
```

area with main information, except leg/borders

```objectivec
@property (nonatomic, readonly, nonnull) YMKRect *balloonRect;
```

area with balloon, except leg, shadows, etc

## Class methods

### balloonGeometryWithAnchor:width:height:imageAnchor:contentRect:balloonRect:

```objectivec
+ (nonnull YMKBalloonGeometry *)balloonGeometryWithAnchor:(nonnull YMKBalloonAnchor *)anchor
                                                    width:( float)width
                                                   height:( float)height
                                              imageAnchor:( CGPoint)imageAnchor
                                              contentRect:(nonnull YMKRect *)contentRect
                                              balloonRect:(nonnull YMKRect *)balloonRect;
```

## Properties

### anchor

```objectivec
@property (nonatomic, readonly, nonnull) YMKBalloonAnchor *anchor;
```

### width

```objectivec
@property (nonatomic, readonly) float width;
```

Total balloon image size

### height

```objectivec
@property (nonatomic, readonly) float height;
```

### imageAnchor

```objectivec
@property (nonatomic, readonly) CGPoint imageAnchor;
```

Anchor inside image rect. Coordinates from 0 to 1 are inside the image.

### contentRect

```objectivec
@property (nonatomic, readonly, nonnull) YMKRect *contentRect;
```

area with main information, except leg/borders

### balloonRect

```objectivec
@property (nonatomic, readonly, nonnull) YMKRect *balloonRect;
```

area with balloon, except leg, shadows, etc.
