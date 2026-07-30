---
title: "YMKAddressBookManager"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKAddressBookManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAddressBookManager.html"
---
# YMKAddressBookManager

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAddressBookManager.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKAddressBookManager : NSObject
```

## Summary

### Instance methods

```swift
func addListener(with addressBookListener: any YMKAddressBookListener)
```

The class does not retain the object in the 'addressBookListener' parameter

```swift
func removeListener(with addressBookListener: any YMKAddressBookListener)
```

The class does not retain the object in the 'addressBookListener' parameter

```swift
func requestRefresh()
```

Request to attempt to get address book from server

### Properties

```swift
var addressBook: YMKAddressBook { get }
```

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### addListener(with:)

```swift
func addListener(with addressBookListener: any YMKAddressBookListener)
```

The class does not retain the object in the 'addressBookListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener(with:)

```swift
func removeListener(with addressBookListener: any YMKAddressBookListener)
```

The class does not retain the object in the 'addressBookListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### requestRefresh()

```swift
func requestRefresh()
```

Request to attempt to get address book from server. Refresh attempts may be throttled and ignored. Immediately after downloading from disk, the first attempt to update will be made automatically.

## Properties

### addressBook

```swift
var addressBook: YMKAddressBook { get }
```

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
