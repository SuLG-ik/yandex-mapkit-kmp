---
title: "YMKSize"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSize"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSize.html"
---
# YMKSize

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSize.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSize : NSObject
```

Size of the icon

## Summary

### Class methods

```objectivec
+ (nonnull YMKSize *)sizeWithWidth:( double)width
                            height:( double)height;
```

### Properties

```objectivec
@property (nonatomic, readonly) double width;
```

Width

```objectivec
@property (nonatomic, readonly) double height;
```

Height

## Class methods

### sizeWithWidth:height:

```objectivec
+ (nonnull YMKSize *)sizeWithWidth:( double)width
                            height:( double)height;
```

## Properties

### width

```objectivec
@property (nonatomic, readonly) double width;
```

Width.

### height

```objectivec
@property (nonatomic, readonly) double height;
```

Height.
