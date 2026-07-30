---
title: "YMKMapKit(Factory)"
kind: "Extension"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Extensions / YMKMapKit(Factory)"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapKit(Factory).html"
---
# YMKMapKit(Factory)

`IOS` · `Swift` · `Extension` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapKit(Factory).html)

extension *[YMKMapKit](YMKMapKit.md)*

## Summary

### Class methods

```swift
class func sharedInstance() -> Self
```

```swift
class func setApiKey(_ apiKey: String)
```

Sets the API key for MapKit SDK

```swift
class func setUserId(_ id: String)
```

Sets the user id for MapKit SDK

```swift
class func setLocale(_ locale: String?)
```

Sets locale for MapKit SDK

### Instance methods

```swift
func setCompletionHandler(_ completionHandler: @escaping () -> Void,
           forBackgroundURLSession identifier: String)
```

Sets completion handler for background URL session

## Class methods

### sharedInstance()

```swift
class func sharedInstance() -> Self
```

### setApiKey(_:)

```swift
class func setApiKey(_ apiKey: String)
```

Sets the API key for MapKit SDK. Call this before [YMKMapKit mapKit] and [YMKMapKit sharedInstance]

### setUserId(_:)

```swift
class func setUserId(_ id: String)
```

Sets the user id for MapKit SDK. Call this before [YMKMapKit mapKit] and [YMKMapKit sharedInstance]

### setLocale(_:)

```swift
class func setLocale(_ locale: String?)
```

Sets locale for MapKit SDK. Call this before [YMKMapKit mapKit] and [YMKMapKit sharedInstance]

## Instance methods

### setCompletionHandler(_:forBackgroundURLSession:)

```swift
func setCompletionHandler(_ completionHandler: @escaping () -> Void,
           forBackgroundURLSession identifier: String)
```

Sets completion handler for background URL session.
