---
title: "FeatureEnumValue"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Feature_FeatureEnumValue"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Feature_FeatureEnumValue.html"
---
# FeatureEnumValue

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Feature_FeatureEnumValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Feature.FeatureEnumValue

`static class FeatureEnumValue implements Serializable`

Value for enumerated features.

## Summary

### Constructors

**Signature and Description**

```java
FeatureEnumValue()
```

Use constructor with parameters in your code.

```java
FeatureEnumValue(@NonNull java.lang.String id,
                 @NonNull java.lang.String name,
                 @Nullable java.lang.String imageUrlTemplate,
                 @NonNull java.util.List<java.lang.String> tags)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getId()`<br>Machine readable value identifier. |
| `synchronized java.lang.String` | `getName()`<br>Human readable localized representation. |
| `synchronized java.lang.String` | `getImageUrlTemplate()`<br>urlTemplate for the image. |
| `synchronized java.util.List<java.lang.String>` | `getTags()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### FeatureEnumValue

```java
FeatureEnumValue()
```

Use constructor with parameters in your code.

This one is for serialization only!

### FeatureEnumValue

```java
FeatureEnumValue(@NonNull java.lang.String id,
                 @NonNull java.lang.String name,
                 @Nullable java.lang.String imageUrlTemplate,
                 @NonNull java.util.List<java.lang.String> tags)
```

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Machine readable value identifier.

### getName

```java
@NonNull
java.lang.String getName()
```

Human readable localized representation.

### getImageUrlTemplate

```java
@Nullable
java.lang.String getImageUrlTemplate()
```

urlTemplate for the image.

Available sizes are listed here: http://api.yandex.ru/fotki/doc/format-ref/f-img.xml

Optional field, can be null.

### getTags

```java
@NonNull
java.util.List<java.lang.String> getTags()
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
