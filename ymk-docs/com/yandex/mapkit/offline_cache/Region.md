---
title: "Region"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.offline_cache"
section: "Android / Справочник / com.yandex.mapkit.offline_cache / Region"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/Region.html"
---
# Region

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/Region.html)

**Package** com.yandex.mapkit.offline_cache

java.lang.Object
↳ com.yandex.mapkit.offline_cache.Region

`class Region implements Serializable`

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

## Summary

### Constructors

**Signature and Description**

```java
Region(int id,
       @NonNull java.lang.String name,
       @NonNull java.lang.String country,
       @NonNull Point center,
       @NonNull LocalizedValue size,
       long releaseTime,
       @Nullable java.lang.Integer parentId)
```

```java
Region()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getId()`<br>Region ID. |
| `java.lang.String` | `getName()`<br>Name of the region. |
| `java.lang.String` | `getCountry()`<br>Country of the region. |
| `Point` | `getCenter()`<br>Center point. |
| `LocalizedValue` | `getSize()`<br>Region size |
| `long` | `getReleaseTime()`<br>Returns the region creation time. |
| `java.lang.Integer` | `getParentId()`<br>Region id of the parent region. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Region

```java
Region(int id,
       @NonNull java.lang.String name,
       @NonNull java.lang.String country,
       @NonNull Point center,
       @NonNull LocalizedValue size,
       long releaseTime,
       @Nullable java.lang.Integer parentId)
```

### Region

```java
Region()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getId

```java
int getId()
```

Region ID.

### getName

```java
@NonNull
java.lang.String getName()
```

Name of the region.

### getCountry

```java
@NonNull
java.lang.String getCountry()
```

Country of the region.

### getCenter

```java
@NonNull
Point getCenter()
```

Center point.

### getSize

```java
@NonNull
LocalizedValue getSize()
```

Region size

### getReleaseTime

```java
long getReleaseTime()
```

Returns the region creation time.

### getParentId

```java
@Nullable
java.lang.Integer getParentId()
```

Region id of the parent region.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
