---
title: "Phone"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Phone"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Phone.html"
---
# Phone

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Phone.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Phone

`class Phone implements Serializable`

Organization phone.

## Summary

### Constructors

**Signature and Description**

```java
Phone(@NonNull PhoneType type,
      @NonNull java.lang.String formattedNumber,
      @Nullable java.lang.String info,
      @Nullable java.lang.String country,
      @Nullable java.lang.String prefix,
      @Nullable java.lang.String ext,
      @Nullable java.lang.String number)
```

```java
Phone()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PhoneType` | `getType()`<br>Phone type. |
| `java.lang.String` | `getFormattedNumber()`<br>Full phone number as human readable string. |
| `java.lang.String` | `getInfo()`<br>Some additional info to differentiate multiple phones for single organization. |
| `java.lang.String` | `getCountry()`<br>Phone country code. |
| `java.lang.String` | `getPrefix()`<br>Phone prefix. |
| `java.lang.String` | `getExt()`<br>Phone extension. |
| `java.lang.String` | `getNumber()`<br>Phone number. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Phone

```java
Phone(@NonNull PhoneType type,
      @NonNull java.lang.String formattedNumber,
      @Nullable java.lang.String info,
      @Nullable java.lang.String country,
      @Nullable java.lang.String prefix,
      @Nullable java.lang.String ext,
      @Nullable java.lang.String number)
```

### Phone

```java
Phone()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getType

```java
@NonNull
PhoneType getType()
```

Phone type.

### getFormattedNumber

```java
@NonNull
java.lang.String getFormattedNumber()
```

Full phone number as human readable string.

### getInfo

```java
@Nullable
java.lang.String getInfo()
```

Some additional info to differentiate multiple phones for single organization.

Optional field, can be null.

### getCountry

```java
@Nullable
java.lang.String getCountry()
```

Phone country code.

Optional field, can be null.

### getPrefix

```java
@Nullable
java.lang.String getPrefix()
```

Phone prefix.

Optional field, can be null.

### getExt

```java
@Nullable
java.lang.String getExt()
```

Phone extension.

Optional field, can be null.

### getNumber

```java
@Nullable
java.lang.String getNumber()
```

Phone number.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
