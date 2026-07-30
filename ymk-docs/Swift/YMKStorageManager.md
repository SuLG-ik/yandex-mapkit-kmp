---
title: "YMKStorageManager"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKStorageManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKStorageManager.html"
---
# YMKStorageManager

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKStorageManager.html)

```swift
class YMKStorageManager : NSObject
```

Storage manager. This is a manager that controls temporary cache storages (for example map tiles).

## Summary

### Instance methods

```swift
func addStorageErrorListenerWith(_ errorListener: any YMKStorageErrorListener)
```

Subscribes to storage events

```swift
func removeStorageErrorListenerWith(_ errorListener: any YMKStorageErrorListener)
```

Unsubscribes from storage events

```swift
func computeSize(sizeCallback: @escaping YMKStorageManagerSizeCallback)
```

Computes storage size in bytes

```swift
func clear(clearCallback: @escaping YMKStorageManagerClearCallback)
```

Removes all data

```swift
func setMaxTileStorageSizeWithLimit(_ limit: Int64,
                               sizeCallback: @escaping YMKStorageManagerSizeCallback)
```

Sets the maximum tile cache size to limit bytes

```swift
func resetMaxTileStorageSize(sizeCallback: @escaping YMKStorageManagerSizeCallback)
```

Resets the tile cache size limit

```swift
func maxTileStorageSize(sizeCallback: @escaping YMKStorageManagerSizeCallback)
```

Obtains the current storage size limit in bytes

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### addStorageErrorListenerWith(_:)

```swift
func addStorageErrorListenerWith(_ errorListener: any YMKStorageErrorListener)
```

Subscribes to storage events.

The class does not retain the object in the 'errorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeStorageErrorListenerWith(_:)

```swift
func removeStorageErrorListenerWith(_ errorListener: any YMKStorageErrorListener)
```

Unsubscribes from storage events.

### computeSize(sizeCallback:)

```swift
func computeSize(sizeCallback: @escaping YMKStorageManagerSizeCallback)
```

Computes storage size in bytes.

### clear(clearCallback:)

```swift
func clear(clearCallback: @escaping YMKStorageManagerClearCallback)
```

Removes all data.

### setMaxTileStorageSizeWithLimit(_:sizeCallback:)

```swift
func setMaxTileStorageSizeWithLimit(_ limit: Int64,
                               sizeCallback: @escaping YMKStorageManagerSizeCallback)
```

Sets the maximum tile cache size to limit bytes. When the limit is reached, old tiles are removed.

### resetMaxTileStorageSize(sizeCallback:)

```swift
func resetMaxTileStorageSize(sizeCallback: @escaping YMKStorageManagerSizeCallback)
```

Resets the tile cache size limit.

### maxTileStorageSize(sizeCallback:)

```swift
func maxTileStorageSize(sizeCallback: @escaping YMKStorageManagerSizeCallback)
```

Obtains the current storage size limit in bytes.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
