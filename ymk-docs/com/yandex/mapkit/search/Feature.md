---
title: "Feature"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Feature"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Feature.html"
---
# Feature

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Feature.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Feature

`class Feature implements Serializable`

Describes some common feature of organizations.

Can be of three types:

- boolean (like on/off switch, as for free Wi-Fi availability).
- enumerated (can have multiple values at once, like cuisine types in a cafe).
- text (like enumerated but with any strings instead of predefined values).

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [FeatureEnumValue](Feature_FeatureEnumValue.md) | Value for enumerated features. |
| `static` | [BooleanValue](Feature_BooleanValue.md) |   |
| `static` | [VariantValue](Feature_VariantValue.md) | A variant combining possible feature values. |

## Summary

### Constructors

**Signature and Description**

```java
Feature()
```

Use constructor with parameters in your code.

```java
Feature(@NonNull java.lang.String id,
        @NonNull VariantValue value,
        @Nullable java.lang.String name,
        @Nullable java.lang.String aref,
        @Nullable Image iconLight,
        @Nullable Image iconDark)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getId()`<br>Machine readable feature identifier. |
| `synchronized VariantValue` | `getValue()`<br>Feature value (depends on feature type). |
| `synchronized java.lang.String` | `getName()`<br>Human readable localized representation. |
| `synchronized java.lang.String` | `getAref()`<br>Reference to information source providing given feature (see [mapkit.Attribution](../Attribution.md))<br>Optional field, can be null. |
| `synchronized Image` | `getIconLight()`<br>Optional field, can be null. |
| `synchronized Image` | `getIconDark()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Feature

```java
Feature()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Feature

```java
Feature(@NonNull java.lang.String id,
        @NonNull VariantValue value,
        @Nullable java.lang.String name,
        @Nullable java.lang.String aref,
        @Nullable Image iconLight,
        @Nullable Image iconDark)
```

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Machine readable feature identifier.

### getValue

```java
@NonNull
VariantValue getValue()
```

Feature value (depends on feature type).

### getName

```java
@Nullable
java.lang.String getName()
```

Human readable localized representation.

Optional field, can be null.

### getAref

```java
@Nullable
java.lang.String getAref()
```

Reference to information source providing given feature (see [mapkit.Attribution](../Attribution.md))

Optional field, can be null.

### getIconLight

```java
@Nullable
Image getIconLight()
```

Optional field, can be null.

### getIconDark

```java
@Nullable
Image getIconDark()
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
