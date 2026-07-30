---
title: "StorageManager"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.storage"
section: "Android / Справочник / com.yandex.mapkit.storage / StorageManager"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/storage/StorageManager.html"
---
# StorageManager

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/storage/StorageManager.html)

**Package** com.yandex.mapkit.storage

`interface StorageManager`

Storage manager.

This is a manager that controls temporary cache storages (for example map tiles).

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `addStorageErrorListener(@NonNull java.lang.ref.WeakReference<StorageErrorListener> errorListener)`<br>Subscribes to storage events. |
| `void` | `removeStorageErrorListener(@NonNull java.lang.ref.WeakReference<StorageErrorListener> errorListener)`<br>Unsubscribes from storage events. |
| `void` | `computeSize(@NonNull SizeListener callback)`<br>Computes storage size in bytes. |
| `void` | `clear(@NonNull ClearListener callback)`<br>Removes all data. |
| `void` | `setMaxTileStorageSize(long limit, @NonNull SizeListener callback)`<br>Sets the maximum tile cache size to limit bytes. |
| `void` | `resetMaxTileStorageSize(@NonNull SizeListener callback)`<br>Resets the tile cache size limit. |
| `void` | `maxTileStorageSize(@NonNull SizeListener callback)`<br>Obtains the current storage size limit in bytes. |
| `boolean` | `isValid()`<br>Tells if this **StorageManager** is valid or not. |

## Methods

### addStorageErrorListener

```java
void addStorageErrorListener(@NonNull java.lang.ref.WeakReference<StorageErrorListener> errorListener)
```

Subscribes to storage events.

The class does not retain the object in the 'errorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeStorageErrorListener

```java
void removeStorageErrorListener(@NonNull java.lang.ref.WeakReference<StorageErrorListener> errorListener)
```

Unsubscribes from storage events.

### computeSize

```java
void computeSize(@NonNull SizeListener callback)
```

Computes storage size in bytes.

### clear

```java
void clear(@NonNull ClearListener callback)
```

Removes all data.

### setMaxTileStorageSize

```java
void setMaxTileStorageSize(long limit,
                           @NonNull SizeListener callback)
```

Sets the maximum tile cache size to limit bytes.

When the limit is reached, old tiles are removed.

### resetMaxTileStorageSize

```java
void resetMaxTileStorageSize(@NonNull SizeListener callback)
```

Resets the tile cache size limit.

### maxTileStorageSize

```java
void maxTileStorageSize(@NonNull SizeListener callback)
```

Obtains the current storage size limit in bytes.

### isValid

```java
boolean isValid()
```

Tells if this **StorageManager** is valid or not.

Any other method (except for this one) called on an invalid **StorageManager** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
