---
title: "AddressBookManager"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.address_book"
section: "Android / Справочник / com.yandex.mapkit.address_book / AddressBookManager"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/address_book/AddressBookManager.html"
---
# AddressBookManager

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/address_book/AddressBookManager.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.address_book

`interface AddressBookManager`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `addListener(@NonNull AddressBookListener addressBookListener)`<br>The class does not retain the object in the 'addressBookListener' parameter. |
| `void` | `removeListener(@NonNull AddressBookListener addressBookListener)`<br>The class does not retain the object in the 'addressBookListener' parameter. |
| `void` | `requestRefresh()`<br>Request to attempt to get address book from server. |
| `AddressBook` | `getAddressBook()` |
| `boolean` | `isValid()`<br>Tells if this **AddressBookManager** is valid or not. |

## Methods

### addListener

```java
void addListener(@NonNull AddressBookListener addressBookListener)
```

The class does not retain the object in the 'addressBookListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener

```java
void removeListener(@NonNull AddressBookListener addressBookListener)
```

The class does not retain the object in the 'addressBookListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### requestRefresh

```java
void requestRefresh()
```

Request to attempt to get address book from server.

Refresh attempts may be throttled and ignored. Immediately after downloading from disk, the first attempt to update will be made automatically.

### getAddressBook

```java
@NonNull
AddressBook getAddressBook()
```

### isValid

```java
boolean isValid()
```

Tells if this **AddressBookManager** is valid or not.

Any other method (except for this one) called on an invalid **AddressBookManager** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
