---
title: "StorageErrorListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.storage"
section: "Android / Справочник / com.yandex.mapkit.storage / StorageErrorListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/storage/StorageErrorListener.html"
---
# StorageErrorListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/storage/StorageErrorListener.html)

**Package** com.yandex.mapkit.storage

`interface StorageErrorListener`

Storage error listener.

This is a listener to subscribe to storage errors in managers that control some type of storage.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onStorageError(@NonNull LocalError error)`<br>Possible error types: - [runtime.DiskCorruptError](../../runtime/DiskCorruptError.md): Called if local storage is corrupted. |

## Methods

### onStorageError

```java
@UiThread
void onStorageError(@NonNull LocalError error)
```

Possible error types: - [runtime.DiskCorruptError](../../runtime/DiskCorruptError.md): Called if local storage is corrupted.

- [runtime.DiskFullError](../../runtime/DiskFullError.md): Called if local storage is full. - [runtime.DiskWriteAccessError](../../runtime/DiskWriteAccessError.md): Called if the application cannot get write access to local storage.
