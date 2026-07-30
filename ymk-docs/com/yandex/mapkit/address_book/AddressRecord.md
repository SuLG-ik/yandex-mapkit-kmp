---
title: "AddressRecord"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.address_book"
section: "Android / Справочник / com.yandex.mapkit.address_book / AddressRecord"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/address_book/AddressRecord.html"
---
# AddressRecord

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/address_book/AddressRecord.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.address_book

java.lang.Object
↳ com.yandex.mapkit.address_book.AddressRecord

`class AddressRecord implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
AddressRecord()
```

Use constructor with parameters in your code.

```java
AddressRecord(@NonNull java.lang.String title,
              @Nullable java.lang.String description,
              @Nullable java.lang.String comment,
              @Nullable java.lang.String address,
              @Nullable Geometry geometry,
              @Nullable java.lang.String uri)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getTitle()` |
| `synchronized java.lang.String` | `getDescription()`<br>Optional field, can be null. |
| `synchronized java.lang.String` | `getComment()`<br>Optional field, can be null. |
| `synchronized java.lang.String` | `getAddress()`<br>Optional field, can be null. |
| `synchronized Geometry` | `getGeometry()`<br>Optional field, can be null. |
| `synchronized java.lang.String` | `getUri()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### AddressRecord

```java
AddressRecord()
```

Use constructor with parameters in your code.

This one is for serialization only!

### AddressRecord

```java
AddressRecord(@NonNull java.lang.String title,
              @Nullable java.lang.String description,
              @Nullable java.lang.String comment,
              @Nullable java.lang.String address,
              @Nullable Geometry geometry,
              @Nullable java.lang.String uri)
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

### getComment

```java
@Nullable
java.lang.String getComment()
```

Optional field, can be null.

### getAddress

```java
@Nullable
java.lang.String getAddress()
```

Optional field, can be null.

### getGeometry

```java
@Nullable
Geometry getGeometry()
```

Optional field, can be null.

### getUri

```java
@Nullable
java.lang.String getUri()
```

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
