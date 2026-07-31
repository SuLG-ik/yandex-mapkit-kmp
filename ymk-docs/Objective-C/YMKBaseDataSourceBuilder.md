---
title: "YMKBaseDataSourceBuilder"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBaseDataSourceBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBaseDataSourceBuilder.html"
---
# YMKBaseDataSourceBuilder

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBaseDataSourceBuilder.html)

```objectivec
@interface YMKBaseDataSourceBuilder : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)setImageUrlProviderWithUrlProvider:
    (nonnull id<YMKImagesImageUrlProvider>)urlProvider;
```

The class does not retain the object in the 'urlProvider' parameter

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setImageUrlProviderWithUrlProvider:

```objectivec
- (void)setImageUrlProviderWithUrlProvider:
    (nonnull id<YMKImagesImageUrlProvider>)urlProvider;
```

The class does not retain the object in the 'urlProvider' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
