---
title: "YMKImage"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKImage"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKImage.html"
---
# YMKImage

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKImage.html)

```objectivec
@interface YMKImage : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKImage *)imageWithUrlTemplate:(nonnull NSString *)urlTemplate
                                     sizes:(nonnull NSArray<YMKImageSize *> *)sizes
                                      tags:(nonnull NSArray<NSString *> *)tags;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *urlTemplate;
```

urlTemplate for the image

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKImageSize *> *sizes;
```

Image sizes

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

Image tags

## Class methods

### imageWithUrlTemplate:sizes:tags:

```objectivec
+ (nonnull YMKImage *)imageWithUrlTemplate:(nonnull NSString *)urlTemplate
                                     sizes:(nonnull NSArray<YMKImageSize *> *)sizes
                                      tags:(nonnull NSArray<NSString *> *)tags;
```

## Properties

### urlTemplate

```objectivec
@property (nonatomic, readonly, nonnull) NSString *urlTemplate;
```

urlTemplate for the image.

### sizes

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKImageSize *> *sizes;
```

Image sizes.

### tags

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

Image tags.
