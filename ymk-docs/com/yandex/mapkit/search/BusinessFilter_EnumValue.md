---
title: "EnumValue"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessFilter_EnumValue"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilter_EnumValue.html"
---
# EnumValue

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilter_EnumValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessFilter.EnumValue

`static class EnumValue implements Serializable`

Value for enum filters.

## Summary

### Constructors

**Signature and Description**

```java
EnumValue()
```

Use constructor with parameters in your code.

```java
EnumValue(@NonNull FeatureEnumValue value,
          @Nullable java.lang.Boolean selected,
          @Nullable java.lang.Boolean disabled)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized FeatureEnumValue` | `getValue()`<br>Filter value. |
| `synchronized java.lang.Boolean` | `getSelected()`<br>Selected marker. |
| `synchronized java.lang.Boolean` | `getDisabled()`<br>Same as [mapkit.search.BusinessFilter#disabled](BusinessFilter.md#disabled), but for this specific enum value. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### EnumValue

```java
EnumValue()
```

Use constructor with parameters in your code.

This one is for serialization only!

### EnumValue

```java
EnumValue(@NonNull FeatureEnumValue value,
          @Nullable java.lang.Boolean selected,
          @Nullable java.lang.Boolean disabled)
```

## Methods

### getValue

```java
@NonNull
FeatureEnumValue getValue()
```

Filter value.

Set in server response for selected filters.

### getSelected

```java
@Nullable
java.lang.Boolean getSelected()
```

Selected marker.

Set in server response for selected filters.

Optional field, can be null.

### getDisabled

```java
@Nullable
java.lang.Boolean getDisabled()
```

Same as [mapkit.search.BusinessFilter#disabled](BusinessFilter.md#disabled), but for this specific enum value.

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
