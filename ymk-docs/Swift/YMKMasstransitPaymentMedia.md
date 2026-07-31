---
title: "YMKMasstransitPaymentMedia"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitPaymentMedia"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitPaymentMedia.html"
---
# YMKMasstransitPaymentMedia

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitPaymentMedia.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitPaymentMedia : NSObject
```

## Summary

### Class methods

```swift
 init(id: String, name: String?, type: YMKMasstransitPaymentMediaMediaType)
```

### Properties

```swift
var id: String { get }
```

string which identifies the current media, can be used to select icons im maps application

```swift
var name: String? { get }
```

Localized name of the media, which is used for payment

```swift
var type: YMKMasstransitPaymentMediaMediaType { get }
```

Type of media, which is used for payment

## Class methods

### init(id:name:type:)

```swift
 init(id: String, name: String?, type: YMKMasstransitPaymentMediaMediaType)
```

## Properties

### id

```swift
var id: String { get }
```

string which identifies the current media, can be used to select icons im maps application.

### name

```swift
var name: String? { get }
```

Localized name of the media, which is used for payment.

Optional field, can be nil.

### type

```swift
var type: YMKMasstransitPaymentMediaMediaType { get }
```

Type of media, which is used for payment.
