---
title: "BusinessFilter"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessFilter"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilter.html"
---
# BusinessFilter

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessFilter

`class BusinessFilter implements Serializable`

A filter that could be applied to search results.

Filters can be either boolean (that is Wi-Fi availability in a cafe) or enumerated (that is cuisine type in a restaurant). Enumerated filters support multiple selected values (OR-combined), to search, for example, for restaurants with Armenian or Georgian cuisine at once.

This class is used in two separate ways: server response contains all filters applicable to current search request and client can use some of these filters to get more specific results in the following search requests

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [BooleanValue](BusinessFilter_BooleanValue.md) | Value for boolean filters. |
| `static` | [EnumValue](BusinessFilter_EnumValue.md) | Value for enum filters. |
| `static` | [RangeValue](BusinessFilter_RangeValue.md) | Value for range filters. |
| `static` | [DateValue](BusinessFilter_DateValue.md) | Value for date filters. |
| `static` | [Values](BusinessFilter_Values.md) | Possible filter values. |

## Summary

### Constructors

**Signature and Description**

```java
BusinessFilter()
```

Use constructor with parameters in your code.

```java
BusinessFilter(@NonNull java.lang.String id,
               @Nullable java.lang.String name,
               @Nullable java.lang.Boolean disabled,
               @Nullable Image iconLight,
               @Nullable Image iconDark,
               @Nullable Image iconAfterLight,
               @Nullable Image iconAfterDark,
               @Nullable java.lang.Boolean singleSelect,
               @NonNull Values values)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getId()`<br>Filter id. |
| `synchronized java.lang.String` | `getName()`<br>Human-readable filter name. |
| `synchronized java.lang.Boolean` | `getDisabled()`<br>The filter should not be used by the client, because filter is either used already (selected:true, disabled:true) or nothing would be found (selected:false, disabled:true). |
| `synchronized Image` | `getIconLight()`<br>Optional field, can be null. |
| `synchronized Image` | `getIconDark()`<br>Optional field, can be null. |
| `synchronized Image` | `getIconAfterLight()`<br>Optional field, can be null. |
| `synchronized Image` | `getIconAfterDark()`<br>Optional field, can be null. |
| `synchronized java.lang.Boolean` | `getSingleSelect()`<br>Only one of multiple available values should be selected. |
| `synchronized Values` | `getValues()`<br>Filter values. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### BusinessFilter

```java
BusinessFilter()
```

Use constructor with parameters in your code.

This one is for serialization only!

### BusinessFilter

```java
BusinessFilter(@NonNull java.lang.String id,
               @Nullable java.lang.String name,
               @Nullable java.lang.Boolean disabled,
               @Nullable Image iconLight,
               @Nullable Image iconDark,
               @Nullable Image iconAfterLight,
               @Nullable Image iconAfterDark,
               @Nullable java.lang.Boolean singleSelect,
               @NonNull Values values)
```

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Filter id.

### getName

```java
@Nullable
java.lang.String getName()
```

Human-readable filter name.

Optional field, can be null.

### getDisabled

```java
@Nullable
java.lang.Boolean getDisabled()
```

The filter should not be used by the client, because filter is either used already (selected:true, disabled:true) or nothing would be found (selected:false, disabled:true).

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

### getIconAfterLight

```java
@Nullable
Image getIconAfterLight()
```

Optional field, can be null.

### getIconAfterDark

```java
@Nullable
Image getIconAfterDark()
```

Optional field, can be null.

### getSingleSelect

```java
@Nullable
java.lang.Boolean getSingleSelect()
```

Only one of multiple available values should be selected.

Optional field, can be null.

### getValues

```java
@NonNull
Values getValues()
```

Filter values.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
