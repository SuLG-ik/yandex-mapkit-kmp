---
title: "Values"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessFilter_Values"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilter_Values.html"
---
# Values

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessFilter_Values.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessFilter.Values

`static class Values implements Serializable`

Possible filter values.

## Summary

### Constructors

**Signature and Description**

```java
Values()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static Values` | `fromBooleans(@NonNull java.util.List<BooleanValue> booleans)` |
| `static Values` | `fromEnums(@NonNull java.util.List<EnumValue> enums)` |
| `static Values` | `fromRange(@NonNull RangeValue range)` |
| `static Values` | `fromDate(@NonNull DateValue date)` |
| `java.util.List<BooleanValue>` | `getBooleans()` |
| `java.util.List<EnumValue>` | `getEnums()` |
| `RangeValue` | `getRange()` |
| `DateValue` | `getDate()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Values

```java
Values()
```

## Methods

### fromBooleans

```java
@NonNull
Values fromBooleans(@NonNull java.util.List<BooleanValue> booleans)
```

### fromEnums

```java
@NonNull
Values fromEnums(@NonNull java.util.List<EnumValue> enums)
```

### fromRange

```java
@NonNull
Values fromRange(@NonNull RangeValue range)
```

### fromDate

```java
@NonNull
Values fromDate(@NonNull DateValue date)
```

### getBooleans

```java
@Nullable
java.util.List<BooleanValue> getBooleans()
```

### getEnums

```java
@Nullable
java.util.List<EnumValue> getEnums()
```

### getRange

```java
@Nullable
RangeValue getRange()
```

### getDate

```java
@Nullable
DateValue getDate()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
