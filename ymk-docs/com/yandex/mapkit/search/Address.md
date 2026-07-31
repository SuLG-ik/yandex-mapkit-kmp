---
title: "Address"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Address"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Address.html"
---
# Address

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Address.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Address

`class Address implements Serializable`

Contains structured address, formatted address, postal code and country code.

Structured address is an ordered list of components (usually administrative hierarchy). Formatted address is a full address as a single string. Formatted address generally can't be obtained from component names. Some components could be ignored (large administrative region) or absent (office number).

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [Component](Address_Component.md) | Single address component.<br>Component represents a single entry in the administrative hierarchy of the address. |

## Summary

### Constructors

**Signature and Description**

```java
Address()
```

Use constructor with parameters in your code.

```java
Address(@NonNull java.lang.String formattedAddress,
        @Nullable java.lang.String additionalInfo,
        @Nullable java.lang.String postalCode,
        @Nullable java.lang.String countryCode,
        @NonNull java.util.List<Component> components)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getFormattedAddress()`<br>Human-readable address. |
| `synchronized java.lang.String` | `getAdditionalInfo()`<br>Additional address info. |
| `synchronized java.lang.String` | `getPostalCode()`<br>Postal/Zip code. |
| `synchronized java.lang.String` | `getCountryCode()`<br>Country code in ISO 3166-1 alpha-2 format (two-letter country code). |
| `synchronized java.util.List<Component>` | `getComponents()`<br>Address component list, see [mapkit.search.Address.Component](Address_Component.md), may be empty. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Address

```java
Address()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Address

```java
Address(@NonNull java.lang.String formattedAddress,
        @Nullable java.lang.String additionalInfo,
        @Nullable java.lang.String postalCode,
        @Nullable java.lang.String countryCode,
        @NonNull java.util.List<Component> components)
```

## Methods

### getFormattedAddress

```java
@NonNull
java.lang.String getFormattedAddress()
```

Human-readable address.

### getAdditionalInfo

```java
@Nullable
java.lang.String getAdditionalInfo()
```

Additional address info.

Optional field, can be null.

### getPostalCode

```java
@Nullable
java.lang.String getPostalCode()
```

Postal/Zip code.

Optional field, can be null.

### getCountryCode

```java
@Nullable
java.lang.String getCountryCode()
```

Country code in ISO 3166-1 alpha-2 format (two-letter country code).

Optional field, can be null.

### getComponents

```java
@NonNull
java.util.List<Component> getComponents()
```

Address component list, see [mapkit.search.Address.Component](Address_Component.md), may be empty.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
