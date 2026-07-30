---
title: "YMKStorageManager"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKStorageManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKStorageManager.html"
---
# YMKStorageManager

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKStorageManager.html)

```objectivec
@interface YMKStorageManager : NSObject
```

Storage manager. This is a manager that controls temporary cache storages (for example map tiles).

## Summary

### Instance methods

```objectivec
- (void)addStorageErrorListenerWithErrorListener:
    (nonnull id<YMKStorageErrorListener>)errorListener;
```

Subscribes to storage events

```objectivec
- (void)removeStorageErrorListenerWithErrorListener:
    (nonnull id<YMKStorageErrorListener>)errorListener;
```

Unsubscribes from storage events

```objectivec
- (void)computeSizeWithSizeCallback:
    (nonnull YMKStorageManagerSizeCallback)sizeCallback;
```

Computes storage size in bytes

```objectivec
- (void)clearWithClearCallback:
    (nonnull YMKStorageManagerClearCallback)clearCallback;
```

Removes all data

```objectivec
- (void)setMaxTileStorageSizeWithLimit:(long long)limit
                          sizeCallback:(nonnull YMKStorageManagerSizeCallback)
                                           sizeCallback;
```

Sets the maximum tile cache size to limit bytes

```objectivec
- (void)resetMaxTileStorageSizeWithSizeCallback:
    (nonnull YMKStorageManagerSizeCallback)sizeCallback;
```

Resets the tile cache size limit

```objectivec
- (void)maxTileStorageSizeWithSizeCallback:
    (nonnull YMKStorageManagerSizeCallback)sizeCallback;
```

Obtains the current storage size limit in bytes

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### addStorageErrorListenerWithErrorListener:

```objectivec
- (void)addStorageErrorListenerWithErrorListener:
    (nonnull id<YMKStorageErrorListener>)errorListener;
```

Subscribes to storage events.

The class does not retain the object in the 'errorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeStorageErrorListenerWithErrorListener:

```objectivec
- (void)removeStorageErrorListenerWithErrorListener:
    (nonnull id<YMKStorageErrorListener>)errorListener;
```

Unsubscribes from storage events.

### computeSizeWithSizeCallback:

```objectivec
- (void)computeSizeWithSizeCallback:
    (nonnull YMKStorageManagerSizeCallback)sizeCallback;
```

Computes storage size in bytes.

### clearWithClearCallback:

```objectivec
- (void)clearWithClearCallback:
    (nonnull YMKStorageManagerClearCallback)clearCallback;
```

Removes all data.

### setMaxTileStorageSizeWithLimit:sizeCallback:

```objectivec
- (void)setMaxTileStorageSizeWithLimit:(long long)limit
                          sizeCallback:(nonnull YMKStorageManagerSizeCallback)
                                           sizeCallback;
```

Sets the maximum tile cache size to limit bytes. When the limit is reached, old tiles are removed.

### resetMaxTileStorageSizeWithSizeCallback:

```objectivec
- (void)resetMaxTileStorageSizeWithSizeCallback:
    (nonnull YMKStorageManagerSizeCallback)sizeCallback;
```

Resets the tile cache size limit.

### maxTileStorageSizeWithSizeCallback:

```objectivec
- (void)maxTileStorageSizeWithSizeCallback:
    (nonnull YMKStorageManagerSizeCallback)sizeCallback;
```

Obtains the current storage size limit in bytes.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
