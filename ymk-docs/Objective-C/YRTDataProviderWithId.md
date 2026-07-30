---
title: "YRTDataProviderWithId"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YRTDataProviderWithId"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTDataProviderWithId.html"
---
# YRTDataProviderWithId

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTDataProviderWithId.html)

```objectivec
@protocol YRTDataProviderWithId <NSObject>
```

Provides any data.

## Summary

### Instance methods

```objectivec
- (nonnull NSString *)providerId;
```

Use the same id for the identical data, to prevent repeated loading of the same data into RAM and VRAM

```objectivec
- (nonnull NSData *)load;
```

Returns data

## Instance methods

### providerId

```objectivec
- (nonnull NSString *)providerId;
```

Use the same id for the identical data, to prevent repeated loading of the same data into RAM and VRAM.

This method may be called on any thread. Its implementation must be thread-safe.

### load

```objectivec
- (nonnull NSData *)load;
```

Returns data.

This method will be called on a background thread.
