---
title: "VariantValue"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Feature_VariantValue"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Feature_VariantValue.html"
---
# VariantValue

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Feature_VariantValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Feature.VariantValue

`static class VariantValue implements Serializable`

A variant combining possible feature values.

## Summary

### Constructors

**Signature and Description**

```java
VariantValue()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static VariantValue` | `fromBooleanValue(@NonNull BooleanValue booleanValue)` |
| `static VariantValue` | `fromTextValue(@NonNull java.util.List<java.lang.String> textValue)` |
| `static VariantValue` | `fromEnumValue(@NonNull java.util.List<FeatureEnumValue> enumValue)` |
| `BooleanValue` | `getBooleanValue()` |
| `java.util.List<java.lang.String>` | `getTextValue()` |
| `java.util.List<FeatureEnumValue>` | `getEnumValue()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### VariantValue

```java
VariantValue()
```

## Methods

### fromBooleanValue

```java
@NonNull
VariantValue fromBooleanValue(@NonNull BooleanValue booleanValue)
```

### fromTextValue

```java
@NonNull
VariantValue fromTextValue(@NonNull java.util.List<java.lang.String> textValue)
```

### fromEnumValue

```java
@NonNull
VariantValue fromEnumValue(@NonNull java.util.List<FeatureEnumValue> enumValue)
```

### getBooleanValue

```java
@Nullable
BooleanValue getBooleanValue()
```

### getTextValue

```java
@Nullable
java.util.List<java.lang.String> getTextValue()
```

### getEnumValue

```java
@Nullable
java.util.List<FeatureEnumValue> getEnumValue()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
