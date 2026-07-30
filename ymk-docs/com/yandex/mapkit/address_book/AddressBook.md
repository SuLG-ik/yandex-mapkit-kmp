---
title: "AddressBook"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.address_book"
section: "Android / Справочник / com.yandex.mapkit.address_book / AddressBook"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/address_book/AddressBook.html"
---
# AddressBook

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/address_book/AddressBook.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.address_book

java.lang.Object
↳ com.yandex.mapkit.address_book.AddressBook

`class AddressBook implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
AddressBook()
```

Use constructor with parameters in your code.

```java
AddressBook(@Nullable AddressRecord home,
            @Nullable AddressRecord work,
            @NonNull java.util.List<AddressRecord> favorites,
            @NonNull java.util.List<AddressCollection> customCollections)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized AddressRecord` | `getHome()`<br>Optional field, can be null. |
| `synchronized AddressRecord` | `getWork()`<br>Optional field, can be null. |
| `synchronized java.util.List<AddressRecord>` | `getFavorites()` |
| `synchronized java.util.List<AddressCollection>` | `getCustomCollections()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### AddressBook

```java
AddressBook()
```

Use constructor with parameters in your code.

This one is for serialization only!

### AddressBook

```java
AddressBook(@Nullable AddressRecord home,
            @Nullable AddressRecord work,
            @NonNull java.util.List<AddressRecord> favorites,
            @NonNull java.util.List<AddressCollection> customCollections)
```

## Methods

### getHome

```java
@Nullable
AddressRecord getHome()
```

Optional field, can be null.

### getWork

```java
@Nullable
AddressRecord getWork()
```

Optional field, can be null.

### getFavorites

```java
@NonNull
java.util.List<AddressRecord> getFavorites()
```

### getCustomCollections

```java
@NonNull
java.util.List<AddressCollection> getCustomCollections()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
