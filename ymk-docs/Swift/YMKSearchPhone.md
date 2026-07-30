---
title: "YMKSearchPhone"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchPhone"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchPhone.html"
---
# YMKSearchPhone

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchPhone.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchPhone : NSObject
```

Organization phone.

## Summary

### Class methods

```swift
 init(type: YMKSearchPhoneType,
 formattedNumber: String,
      info: String?,
   country: String?,
    prefix: String?,
       ext: String?,
    number: String?)
```

### Properties

```swift
var type: YMKSearchPhoneType { get }
```

Phone type

```swift
var formattedNumber: String { get }
```

Full phone number as human readable string

```swift
var info: String? { get }
```

Some additional info to differentiate multiple phones for single organization

```swift
var country: String? { get }
```

Phone country code

```swift
var prefix: String? { get }
```

Phone prefix

```swift
var ext: String? { get }
```

Phone extension

```swift
var number: String? { get }
```

Phone number

## Class methods

### init(type:formattedNumber:info:country:prefix:ext:number:)

```swift
 init(type: YMKSearchPhoneType,
 formattedNumber: String,
      info: String?,
   country: String?,
    prefix: String?,
       ext: String?,
    number: String?)
```

## Properties

### type

```swift
var type: YMKSearchPhoneType { get }
```

Phone type.

### formattedNumber

```swift
var formattedNumber: String { get }
```

Full phone number as human readable string.

### info

```swift
var info: String? { get }
```

Some additional info to differentiate multiple phones for single organization.

Optional field, can be nil.

### country

```swift
var country: String? { get }
```

Phone country code.

Optional field, can be nil.

### prefix

```swift
var prefix: String? { get }
```

Phone prefix.

Optional field, can be nil.

### ext

```swift
var ext: String? { get }
```

Phone extension.

Optional field, can be nil.

### number

```swift
var number: String? { get }
```

Phone number.

Optional field, can be nil.
