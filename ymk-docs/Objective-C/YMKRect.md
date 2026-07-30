---
title: "YMKRect"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRect"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRect.html"
---
# YMKRect

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRect.html)

```objectivec
@interface YMKRect : NSObject
```

The rectangle to display on the map.

## Summary

### Class methods

```objectivec
+ (nonnull YMKRect *)rectWithMin:( CGPoint)min
                             max:( CGPoint)max;
```

### Properties

```objectivec
@property (nonatomic, readonly) CGPoint min;
```

Minimum rectangle coordinates

```objectivec
@property (nonatomic, readonly) CGPoint max;
```

Maximum rectangle coordinates

## Class methods

### rectWithMin:max:

```objectivec
+ (nonnull YMKRect *)rectWithMin:( CGPoint)min
                             max:( CGPoint)max;
```

## Properties

### min

```objectivec
@property (nonatomic, readonly) CGPoint min;
```

Minimum rectangle coordinates.

### max

```objectivec
@property (nonatomic, readonly) CGPoint max;
```

Maximum rectangle coordinates.
