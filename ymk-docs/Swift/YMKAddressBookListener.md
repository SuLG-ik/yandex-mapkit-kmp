---
title: "YMKAddressBookListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKAddressBookListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAddressBookListener.html"
---
# YMKAddressBookListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAddressBookListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
protocol YMKAddressBookListener : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func onLoaded(withHasAddressBook hasAddressBook: Bool)
```

Called when local address book copy id loaded from disk

```swift
func onDropped()
```

Called when address book was dropped, usually after account changed

```swift
func onRefreshSuccess(withChanged changed: Bool)
```

Called after refresh successfull attempt

```swift
func onRefreshErrorWithError(_ error: any Error)
```

Called if error occured on refresh attempt

## Instance methods

### onLoaded(withHasAddressBook:)

```swift
func onLoaded(withHasAddressBook hasAddressBook: Bool)
```

Called when local address book copy id loaded from disk. Called immediatly for listeners added after loading.

### onDropped()

```swift
func onDropped()
```

Called when address book was dropped, usually after account changed

### onRefreshSuccess(withChanged:)

```swift
func onRefreshSuccess(withChanged changed: Bool)
```

Called after refresh successfull attempt

### onRefreshErrorWithError(_:)

```swift
func onRefreshErrorWithError(_ error: any Error)
```

Called if error occured on refresh attempt. This may throw subclasses of NetworkError during network loading, as well as other exceptions.
