---
title: "AddressCollection"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.address_book"
section: "Android / Справочник / com.yandex.mapkit.address_book / AddressCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/address_book/AddressCollection.html"
---
# AddressCollection

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/address_book/AddressCollection.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.address_book

java.lang.Object
↳ com.yandex.mapkit.address_book.AddressCollection

`class AddressCollection implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
AddressCollection()
```

Use constructor with parameters in your code.

```java
AddressCollection(@NonNull java.lang.String title,
                  @Nullable java.lang.String description,
                  @NonNull java.util.List<AddressRecord> records)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getTitle()` |
| `synchronized java.lang.String` | `getDescription()`<br>Optional field, can be null. |
| `synchronized java.util.List<AddressRecord>` | `getRecords()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### AddressCollection

```java
AddressCollection()
```

Use constructor with parameters in your code.

This one is for serialization only!

### AddressCollection

```java
AddressCollection(@NonNull java.lang.String title,
                  @Nullable java.lang.String description,
                  @NonNull java.util.List<AddressRecord> records)
```

## Methods

### getTitle

```java
@NonNull
java.lang.String getTitle()
```

### getDescription

```java
@Nullable
java.lang.String getDescription()
```

Optional field, can be null.

### getRecords

```java
@NonNull
java.util.List<AddressRecord> getRecords()
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
