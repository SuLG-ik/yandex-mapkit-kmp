---
title: "YMKImagesImageUrlProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKImagesImageUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKImagesImageUrlProvider.html"
---
# YMKImagesImageUrlProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKImagesImageUrlProvider.html)

```objectivec
@protocol YMKImagesImageUrlProvider <NSObject>
```

## Summary

### Instance methods

```objectivec
- (nonnull NSString *)formatUrlWithDescriptor:
    (nonnull YMKImagesImageDataDescriptor *)descriptor;
```

Generates an URL that is used to load described image

## Instance methods

### formatUrlWithDescriptor:

```objectivec
- (nonnull NSString *)formatUrlWithDescriptor:
    (nonnull YMKImagesImageDataDescriptor *)descriptor;
```

Generates an URL that is used to load described image.

This method may be called on any thread. Its implementation must be thread-safe.
