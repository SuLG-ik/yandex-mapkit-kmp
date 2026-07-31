---
title: "YMKCarparksLayer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKCarparksLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCarparksLayer.html"
---
# YMKCarparksLayer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCarparksLayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKCarparksLayer : NSObject
```

## Summary

### Instance methods

```objectivec
- (BOOL)isVisible;
```

Indicates whether the layer is displayed on a map

```objectivec
- (void)setVisibleWithOn:(BOOL)on;
```

Display or hide the layer on a map

```objectivec
- (BOOL)setCarparksStyleWithStyle:(nonnull NSString *)style;
```

Applies JSON style transformations to the carparks layer

```objectivec
- (BOOL)setCarparksStyleWithId:(NSInteger)id style:(nonnull NSString *)style;
```

Applies JSON style transformations to the carparks layer

```objectivec
- (void)resetCarparksStyles;
```

Resets all JSON style transformations applied to the carparks layer

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### isVisible

```objectivec
- (BOOL)isVisible;
```

Indicates whether the layer is displayed on a map.

### setVisibleWithOn:

```objectivec
- (void)setVisibleWithOn:(BOOL)on;
```

Display or hide the layer on a map.

### setCarparksStyleWithStyle:

```objectivec
- (BOOL)setCarparksStyleWithStyle:(nonnull NSString *)style;
```

Applies JSON style transformations to the carparks layer. Same as setCarparksStyle(0, style). Set to empty string to clear previous styling. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current carparks style remains unchanged.

### setCarparksStyleWithId:style:

```objectivec
- (BOOL)setCarparksStyleWithId:(NSInteger)id style:(nonnull NSString *)style;
```

Applies JSON style transformations to the carparks layer. Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current carparks style remains unchanged.

### resetCarparksStyles

```objectivec
- (void)resetCarparksStyles;
```

Resets all JSON style transformations applied to the carparks layer.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
