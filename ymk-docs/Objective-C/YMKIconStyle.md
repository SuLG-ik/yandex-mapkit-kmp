---
title: "YMKIconStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKIconStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKIconStyle.html"
---
# YMKIconStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKIconStyle.html)

```objectivec
@interface YMKIconStyle : NSObject
```

The style of created icons.

## Summary

### Class methods

```objectivec
+ (nonnull YMKIconStyle *)iconStyleWithAnchor:(nullable NSValue *)anchor
                                 rotationType:(nullable NSNumber *)rotationType
                                       zIndex:(nullable NSNumber *)zIndex
                                         flat:(nullable NSNumber *)flat
                                      visible:(nullable NSNumber *)visible
                                        scale:(nullable NSNumber *)scale
                                      opacity:( float)opacity
                                 tappableArea:(nullable YMKRect *)tappableArea;
```

### Instance methods

```objectivec
- (nonnull YMKIconStyle *)init;
```

### Properties

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSValue *anchor;
```

An anchor is used to alter image placement

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *rotationType;
```

Icon rotation type

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *zIndex;
```

Z-index of the icon, relative to the placemark's z-index

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *flat;
```

If true, the icon is displayed on the map surface

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *visible;
```

Sets icon visibility

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *scale;
```

Scale of the icon

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float opacity;
```

Opacity of the icon

```objectivec
@property (nonatomic, strong, readwrite, nullable) YMKRect *tappableArea;
```

Tappable area on the icon

## Class methods

### iconStyleWithAnchor:rotationType:zIndex:flat:visible:scale:opacity:tappableArea:

```objectivec
+ (nonnull YMKIconStyle *)iconStyleWithAnchor:(nullable NSValue *)anchor
                                 rotationType:(nullable NSNumber *)rotationType
                                       zIndex:(nullable NSNumber *)zIndex
                                         flat:(nullable NSNumber *)flat
                                      visible:(nullable NSNumber *)visible
                                        scale:(nullable NSNumber *)scale
                                      opacity:( float)opacity
                                 tappableArea:(nullable YMKRect *)tappableArea;
```

## Instance methods

### init

```objectivec
- (nonnull YMKIconStyle *)init;
```

## Properties

### anchor

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSValue *anchor;
```

An anchor is used to alter image placement. Normalized: (0.0f, 0.0f) denotes the top left image corner; (1.0f, 1.0f) denotes bottom right. Default is (0.5f, 0.5f).

Optional field, can be nil.

### rotationType

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *rotationType;
```

Icon rotation type. Default: NoRotation.

Optional field, can be nil.

### zIndex

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *zIndex;
```

Z-index of the icon, relative to the placemark's z-index.

Optional field, can be nil.

### flat

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *flat;
```

If true, the icon is displayed on the map surface. If false, the icon is displayed on the screen surface. Default: false.

Optional field, can be nil.

### visible

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *visible;
```

Sets icon visibility. Default: true.

Optional field, can be nil.

### scale

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *scale;
```

Scale of the icon. Default: 1.0f.

Optional field, can be nil.

### opacity

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float opacity;
```

Opacity of the icon

### tappableArea

```objectivec
@property (nonatomic, strong, readwrite, nullable) YMKRect *tappableArea;
```

Tappable area on the icon. Coordinates are measured the same way as anchor coordinates. If rect is empty or invalid, the icon will not process taps. By default, icons process all taps.

Optional field, can be nil.
