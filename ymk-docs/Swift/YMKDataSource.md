---
title: "YMKDataSource"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDataSource"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDataSource.html"
---
# YMKDataSource

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDataSource.html)

```swift
class YMKDataSource : YMKBaseDataSource
```

## Summary

### Instance methods

```swift
func setDataWith(_ data: Data)
```

Updates all data

## Instance methods

### setDataWith(_:)

```swift
func setDataWith(_ data: Data)
```

Updates all data. This method works synchronously and blocks UI thread. It is intended for passing not more than 500kB of data; otherwise, it will affect the responsiveness of UI and map.
