---
title: "YMKTextStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTextStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTextStyle.html"
---
# YMKTextStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTextStyle.html)

```objectivec
@interface YMKTextStyle : NSObject
```

The style of placemarks's text.

## Summary

### Class methods

```objectivec
+ (nonnull YMKTextStyle *)textStyleWithSize:( float)size
                                      color:(nonnull UIColor *)color
                               outlineWidth:( float)outlineWidth
                               outlineColor:(nonnull UIColor *)outlineColor
                                  placement:( YMKTextStylePlacement)placement
                                     offset:( float)offset
                             offsetFromIcon:( BOOL)offsetFromIcon
                               textOptional:( BOOL)textOptional;
```

### Instance methods

```objectivec
- (nonnull YMKTextStyle *)init;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float size;
```

Text font size in units

```objectivec
@property (nonatomic, strong, readwrite, nonnull) UIColor *color;
```

Text color

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float outlineWidth;
```

Outline width in units

```objectivec
@property (nonatomic, strong, readwrite, nonnull) UIColor *outlineColor;
```

Outline color

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKTextStylePlacement placement;
```

Text placement position

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float offset;
```

Text offset in units

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL offsetFromIcon;
```

When set, YMKTextStyle::offset is a padding between the text and icon edges

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL textOptional;
```

Allow dropping text but keeping icon during conflict resolution default: false

## Class methods

### textStyleWithSize:color:outlineWidth:outlineColor:placement:offset:offsetFromIcon:textOptional:

```objectivec
+ (nonnull YMKTextStyle *)textStyleWithSize:( float)size
                                      color:(nonnull UIColor *)color
                               outlineWidth:( float)outlineWidth
                               outlineColor:(nonnull UIColor *)outlineColor
                                  placement:( YMKTextStylePlacement)placement
                                     offset:( float)offset
                             offsetFromIcon:( BOOL)offsetFromIcon
                               textOptional:( BOOL)textOptional;
```

## Instance methods

### init

```objectivec
- (nonnull YMKTextStyle *)init;
```

## Properties

### size

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float size;
```

Text font size in units. default: 8

### color

```objectivec
@property (nonatomic, strong, readwrite, nonnull) UIColor *color;
```

Text color. default: black

### outlineWidth

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float outlineWidth;
```

Outline width in units. default: 1

### outlineColor

```objectivec
@property (nonatomic, strong, readwrite, nonnull) UIColor *outlineColor;
```

Outline color. default: white

### placement

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKTextStylePlacement placement;
```

Text placement position. default: Center

### offset

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float offset;
```

Text offset in units. Measured either from point or form icon edges, depending on YMKTextStyle::offsetFromIcon value Direction of the offset specified with YMKTextStyle::placement property Ignored when placement is 'Center' default: 0

### offsetFromIcon

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL offsetFromIcon;
```

When set, YMKTextStyle::offset is a padding between the text and icon edges. default: true

### textOptional

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL textOptional;
```

Allow dropping text but keeping icon during conflict resolution default: false
