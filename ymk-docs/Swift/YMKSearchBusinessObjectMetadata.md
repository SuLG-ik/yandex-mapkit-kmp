---
title: "YMKSearchBusinessObjectMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchBusinessObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessObjectMetadata.html"
---
# YMKSearchBusinessObjectMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchBusinessObjectMetadata : NSObject, YMKBaseMetadata
```

Extended information about company.

## Summary

### Class methods

```swift
 init(oid: String,
     name: String,
  address: YMKSearchAddress,
 categories: [YMKSearchCategory],
   phones: [YMKSearchPhone],
 workingHours: YMKSearchWorkingHours?,
 precision: NSNumber?,
 features: [YMKSearchFeature],
 importantFeatures: YMKSearchFeatureSet?,
    links: [YMKSearchLink],
 distance: YMKLocalizedValue?,
   chains: [YMKSearchChain],
   closed: NSNumber?,
 unreliable: NSNumber?,
  seoname: String?,
 shortName: String?,
 properties: YMKSearchProperties?,
 featureGroups: [YMKSearchFeatureGroup],
 indoorLevel: String?)
```

### Properties

```swift
var oid: String { get }
```

Permanent company id

```swift
var name: String { get }
```

Company name

```swift
var address: YMKSearchAddress { get }
```

Company address

```swift
var categories: [YMKSearchCategory] { get }
```

List of categories associated with the company

```swift
var phones: [YMKSearchPhone] { get }
```

List of phone numbers for the company

```swift
var workingHours: YMKSearchWorkingHours? { get }
```

Open hours for the company

```swift
var precision: NSNumber? { get }
```

Address precision for the company

```swift
var features: [YMKSearchFeature] { get }
```

List of features for the company

```swift
var importantFeatures: YMKSearchFeatureSet? { get }
```

Collection of features that probably are of utmost interest to the user

```swift
var links: [YMKSearchLink] { get }
```

List of links for the company

```swift
var distance: YMKLocalizedValue? { get }
```

Optional distance to the company from geometry provided in request

```swift
var chains: [YMKSearchChain] { get }
```

List of chains associated with the company

```swift
var closed: NSNumber? { get }
```

Company status, present if it is closed

```swift
var unreliable: NSNumber? { get }
```

If true, company information is not reliable

```swift
var seoname: String? { get }
```

Technical field for SEO (transliterated and simplified company name)

```swift
var shortName: String? { get }
```

Short company name

```swift
var properties: YMKSearchProperties? { get }
```

Additional company properties

```swift
var featureGroups: [YMKSearchFeatureGroup] { get }
```

List of feature groups for the company

```swift
var indoorLevel: String? { get }
```

Indoor level id (obsolete)

## Class methods

### init(oid:name:address:categories:phones:workingHours:precision:features:importantFeatures:links:distance:chains:closed:unreliable:seoname:shortName:properties:featureGroups:indoorLevel:)

```swift
 init(oid: String,
     name: String,
  address: YMKSearchAddress,
 categories: [YMKSearchCategory],
   phones: [YMKSearchPhone],
 workingHours: YMKSearchWorkingHours?,
 precision: NSNumber?,
 features: [YMKSearchFeature],
 importantFeatures: YMKSearchFeatureSet?,
    links: [YMKSearchLink],
 distance: YMKLocalizedValue?,
   chains: [YMKSearchChain],
   closed: NSNumber?,
 unreliable: NSNumber?,
  seoname: String?,
 shortName: String?,
 properties: YMKSearchProperties?,
 featureGroups: [YMKSearchFeatureGroup],
 indoorLevel: String?)
```

## Properties

### oid

```swift
var oid: String { get }
```

Permanent company id.

### name

```swift
var name: String { get }
```

Company name.

### address

```swift
var address: YMKSearchAddress { get }
```

Company address.

### categories

```swift
var categories: [YMKSearchCategory] { get }
```

List of categories associated with the company.

### phones

```swift
var phones: [YMKSearchPhone] { get }
```

List of phone numbers for the company.

### workingHours

```swift
var workingHours: YMKSearchWorkingHours? { get }
```

Open hours for the company.

Optional field, can be nil.

### precision

```swift
var precision: NSNumber? { get }
```

Address precision for the company.

Optional field, can be nil.

### features

```swift
var features: [YMKSearchFeature] { get }
```

List of features for the company.

### importantFeatures

```swift
var importantFeatures: YMKSearchFeatureSet? { get }
```

Collection of features that probably are of utmost interest to the user.

Optional field, can be nil.

### links

```swift
var links: [YMKSearchLink] { get }
```

List of links for the company.

### distance

```swift
var distance: YMKLocalizedValue? { get }
```

Optional distance to the company from geometry provided in request.

Optional field, can be nil.

### chains

```swift
var chains: [YMKSearchChain] { get }
```

List of chains associated with the company.

### closed

```swift
var closed: NSNumber? { get }
```

Company status, present if it is closed.

Optional field, can be nil.

### unreliable

```swift
var unreliable: NSNumber? { get }
```

If true, company information is not reliable.

Optional field, can be nil.

### seoname

```swift
var seoname: String? { get }
```

Technical field for SEO (transliterated and simplified company name).

Optional field, can be nil.

### shortName

```swift
var shortName: String? { get }
```

Short company name.

Optional field, can be nil.

### properties

```swift
var properties: YMKSearchProperties? { get }
```

Additional company properties.

Optional field, can be nil.

### featureGroups

```swift
var featureGroups: [YMKSearchFeatureGroup] { get }
```

List of feature groups for the company.

### indoorLevel

```swift
var indoorLevel: String? { get }
```

Indoor level id (obsolete).

Optional field, can be nil.
