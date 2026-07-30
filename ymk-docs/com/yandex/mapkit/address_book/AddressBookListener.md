---
title: "AddressBookListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.address_book"
section: "Android / Справочник / com.yandex.mapkit.address_book / AddressBookListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/address_book/AddressBookListener.html"
---
# AddressBookListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/address_book/AddressBookListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.address_book

`interface AddressBookListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onLoaded(boolean hasAddressBook)`<br>Called when local address book copy id loaded from disk. |
| `void` | `onDropped()`<br>Called when address book was dropped, usually after account changed |
| `void` | `onRefreshSuccess(boolean changed)`<br>Called after refresh successfull attempt |
| `void` | `onRefreshError(@NonNull Error error)`<br>Called if error occured on refresh attempt. |

## Methods

### onLoaded

```java
@UiThread
void onLoaded(boolean hasAddressBook)
```

Called when local address book copy id loaded from disk.

Called immediatly for listeners added after loading.

### onDropped

```java
@UiThread
void onDropped()
```

Called when address book was dropped, usually after account changed

### onRefreshSuccess

```java
@UiThread
void onRefreshSuccess(boolean changed)
```

Called after refresh successfull attempt

### onRefreshError

```java
@UiThread
void onRefreshError(@NonNull Error error)
```

Called if error occured on refresh attempt.

This may throw subclasses of NetworkError during network loading, as well as other exceptions.
