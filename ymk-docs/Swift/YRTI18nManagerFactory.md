---
title: "YRTI18nManagerFactory"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YRTI18nManagerFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTI18nManagerFactory.html"
---
# YRTI18nManagerFactory

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTI18nManagerFactory.html)

```swift
class YRTI18nManagerFactory : NSObject
```

## Summary

### Class methods

```swift
class func getLocale() -> String
```

Returns the locale currently used by the runtime

```swift
class func setLocaleWithLocale(_ locale: String?)
```

Sets the application's locale

```swift
class func getI18nManagerInstance() -> YRTI18nManager
```

Gets the internationalization manager interface

## Class methods

### getLocale()

```swift
class func getLocale() -> String
```

Returns the locale currently used by the runtime. Should be called only after locale has been set.

### setLocaleWithLocale(_:)

```swift
class func setLocaleWithLocale(_ locale: String?)
```

Sets the application's locale. Useful only if MapKit is not used by the application. Otherwise, use {``` mapkit.MapKitFactory.setLocale()}. Also useless if someone else has already set the locale (produses warning and does nothing). Can be set to none, in this case system locale will be used.

### getI18nManagerInstance()

```swift
class func getI18nManagerInstance() -> YRTI18nManager
```

Gets the internationalization manager interface.
