---
title: "YMKLogo"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLogo"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLogo.html"
---
# YMKLogo

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLogo.html)

```objectivec
@interface YMKLogo : NSObject
```

The object that allows to control logo display properties.

## Summary

### Instance methods

```objectivec
- (void)setAlignmentWithAlignment:(nonnull YMKLogoAlignment *)alignment;
```

Set logo alignment in the container

```objectivec
- (void)setPaddingWithPadding:(nonnull YMKLogoPadding *)padding;
```

Set logo padding relative to the left/right and top/bottom edges

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setAlignmentWithAlignment:

```objectivec
- (void)setAlignmentWithAlignment:(nonnull YMKLogoAlignment *)alignment;
```

Set logo alignment in the container.

### setPaddingWithPadding:

```objectivec
- (void)setPaddingWithPadding:(nonnull YMKLogoPadding *)padding;
```

Set logo padding relative to the left/right and top/bottom edges. Values must be positive.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
