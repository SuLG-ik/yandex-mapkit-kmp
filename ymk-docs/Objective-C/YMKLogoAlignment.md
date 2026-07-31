---
title: "YMKLogoAlignment"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLogoAlignment"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLogoAlignment.html"
---
# YMKLogoAlignment

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLogoAlignment.html)

```objectivec
@interface YMKLogoAlignment : NSObject
```

Logo alignment class.

## Summary

### Class methods

```objectivec
+ (nonnull YMKLogoAlignment *)alignmentWithHorizontalAlignment:( YMKLogoHorizontalAlignment)horizontalAlignment
                                             verticalAlignment:( YMKLogoVerticalAlignment)verticalAlignment;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKLogoHorizontalAlignment horizontalAlignment;
```

Defines horizontal alignment

```objectivec
@property (nonatomic, readonly) YMKLogoVerticalAlignment verticalAlignment;
```

Defines vertical alignment

## Class methods

### alignmentWithHorizontalAlignment:verticalAlignment:

```objectivec
+ (nonnull YMKLogoAlignment *)alignmentWithHorizontalAlignment:( YMKLogoHorizontalAlignment)horizontalAlignment
                                             verticalAlignment:( YMKLogoVerticalAlignment)verticalAlignment;
```

## Properties

### horizontalAlignment

```objectivec
@property (nonatomic, readonly) YMKLogoHorizontalAlignment horizontalAlignment;
```

Defines horizontal alignment.

### verticalAlignment

```objectivec
@property (nonatomic, readonly) YMKLogoVerticalAlignment verticalAlignment;
```

Defines vertical alignment.
