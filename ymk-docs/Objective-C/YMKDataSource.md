---
title: "YMKDataSource"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDataSource"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDataSource.html"
---
# YMKDataSource

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDataSource.html)

```objectivec
@interface YMKDataSource : YMKBaseDataSource
```

## Summary

### Instance methods

```objectivec
- (void)setDataWithData:(nonnull NSData *)data;
```

Updates all data

## Instance methods

### setDataWithData:

```objectivec
- (void)setDataWithData:(nonnull NSData *)data;
```

Updates all data. This method works synchronously and blocks UI thread. It is intended for passing not more than 500kB of data; otherwise, it will affect the responsiveness of UI and map.
