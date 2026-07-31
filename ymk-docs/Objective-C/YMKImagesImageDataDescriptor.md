---
title: "YMKImagesImageDataDescriptor"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKImagesImageDataDescriptor"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKImagesImageDataDescriptor.html"
---
# YMKImagesImageDataDescriptor

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKImagesImageDataDescriptor.html)

```objectivec
@interface YMKImagesImageDataDescriptor : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKImagesImageDataDescriptor *)imageDataDescriptorWithImageId:(nonnull NSString *)imageId
                                                            primaryColor:(nullable UIColor *)primaryColor
                                                          secondaryColor:(nullable UIColor *)secondaryColor
                                                           tertiaryColor:(nullable UIColor *)tertiaryColor;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *imageId;
```

```objectivec
@property (nonatomic, readonly, nullable) UIColor *primaryColor;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) UIColor *secondaryColor;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) UIColor *tertiaryColor;
```

Optional field, can be nil

## Class methods

### imageDataDescriptorWithImageId:primaryColor:secondaryColor:tertiaryColor:

```objectivec
+ (nonnull YMKImagesImageDataDescriptor *)imageDataDescriptorWithImageId:(nonnull NSString *)imageId
                                                            primaryColor:(nullable UIColor *)primaryColor
                                                          secondaryColor:(nullable UIColor *)secondaryColor
                                                           tertiaryColor:(nullable UIColor *)tertiaryColor;
```

## Properties

### imageId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *imageId;
```

### primaryColor

```objectivec
@property (nonatomic, readonly, nullable) UIColor *primaryColor;
```

Optional field, can be nil.

### secondaryColor

```objectivec
@property (nonatomic, readonly, nullable) UIColor *secondaryColor;
```

Optional field, can be nil.

### tertiaryColor

```objectivec
@property (nonatomic, readonly, nullable) UIColor *tertiaryColor;
```

Optional field, can be nil.
