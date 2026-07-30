---
title: "YMKMasstransitThread"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitThread"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitThread.html"
---
# YMKMasstransitThread

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitThread.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitThread : NSObject, YMKBaseMetadata
```

Describes a public transport thread. A thread is one of the YMKMasstransitLine variants. For example, one line can have two threads: direct and return.

## Summary

### Class methods

```swift
 init(id: String,
 essentialStops: [YMKMasstransitEssentialStop],
 description: String?,
 category: [NSNumber],
 comfortClass: String?)
```

### Properties

```swift
var id: String { get }
```

Thread ID

```swift
var essentialStops: [YMKMasstransitEssentialStop] { get }
```

List of important stops on the thread, such as the first and last stops

```swift
var description: String? { get }
```

'Description' is a specific thread name which must be used in addition to the corresponding YMKMasstransitLine name

```swift
var category: [NSNumber] { get }
```

List of categories describing important traits of the thread

```swift
var comfortClass: String? { get }
```

Comfort class of transport, e

## Class methods

### init(id:essentialStops:description:category:comfortClass:)

```swift
 init(id: String,
 essentialStops: [YMKMasstransitEssentialStop],
 description: String?,
 category: [NSNumber],
 comfortClass: String?)
```

## Properties

### id

```swift
var id: String { get }
```

Thread ID.

### essentialStops

```swift
var essentialStops: [YMKMasstransitEssentialStop] { get }
```

List of important stops on the thread, such as the first and last stops.

### description

```swift
var description: String? { get }
```

'Description' is a specific thread name which must be used in addition to the corresponding YMKMasstransitLine name.

For example, line "bus 34" has two thread with descriptions: "short" and "long". To get full thread name you should combine line name and thread description. After this, you get two threads name: "bus 34 short" and "bus 34 long".

Optional field, can be nil.

### category

```swift
var category: [NSNumber] { get }
```

List of categories describing important traits of the thread. For example, "primary", "secondary", "to_depot"

### comfortClass

```swift
var comfortClass: String? { get }
```

Comfort class of transport, e.g. "Standart plus", "Lastochka" for trains.

Optional field, can be nil.
