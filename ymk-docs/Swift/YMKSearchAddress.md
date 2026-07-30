---
title: "YMKSearchAddress"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchAddress"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchAddress.html"
---
# YMKSearchAddress

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchAddress.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchAddress : NSObject
```

Contains structured address, formatted address, postal code and country code.

Structured address is an ordered list of components (usually administrative hierarchy). Formatted address is a full address as a single string. Formatted address generally can't be obtained from component names. Some components could be ignored (large administrative region) or absent (office number).

## Summary

### Class methods

```swift
 init(formattedAddress: String,
        additionalInfo: String?,
            postalCode: String?,
           countryCode: String?,
            components: [YMKSearchAddressComponent])
```

### Properties

```swift
var formattedAddress: String { get }
```

Human-readable address

```swift
var additionalInfo: String? { get }
```

Additional address info

```swift
var postalCode: String? { get }
```

Postal/Zip code

```swift
var countryCode: String? { get }
```

Country code in ISO 3166-1 alpha-2 format (two-letter country code)

```swift
var components: [YMKSearchAddressComponent] { get }
```

Address component list, see YMKSearchAddressComponent, may be empty

## Class methods

### init(formattedAddress:additionalInfo:postalCode:countryCode:components:)

```swift
 init(formattedAddress: String,
        additionalInfo: String?,
            postalCode: String?,
           countryCode: String?,
            components: [YMKSearchAddressComponent])
```

## Properties

### formattedAddress

```swift
var formattedAddress: String { get }
```

Human-readable address.

### additionalInfo

```swift
var additionalInfo: String? { get }
```

Additional address info.

Optional field, can be nil.

### postalCode

```swift
var postalCode: String? { get }
```

Postal/Zip code.

Optional field, can be nil.

### countryCode

```swift
var countryCode: String? { get }
```

Country code in ISO 3166-1 alpha-2 format (two-letter country code).

Optional field, can be nil.

### components

```swift
var components: [YMKSearchAddressComponent] { get }
```

Address component list, see YMKSearchAddressComponent, may be empty.
