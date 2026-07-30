---
title: "CompanyTapInfo"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / CompanyTapInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/CompanyTapInfo.html"
---
# CompanyTapInfo

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/CompanyTapInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.CompanyTapInfo

`class CompanyTapInfo implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
CompanyTapInfo()
```

Use constructor with parameters in your code.

```java
CompanyTapInfo(@NonNull java.lang.String permalink,
               @NonNull ScreenPoint screenPoint)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getPermalink()`<br>Permalink of the company which icon or text was tapped. |
| `synchronized ScreenPoint` | `getScreenPoint()`<br>The screen position of the company tapped icon. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### CompanyTapInfo

```java
CompanyTapInfo()
```

Use constructor with parameters in your code.

This one is for serialization only!

### CompanyTapInfo

```java
CompanyTapInfo(@NonNull java.lang.String permalink,
               @NonNull ScreenPoint screenPoint)
```

## Methods

### getPermalink

```java
@NonNull
java.lang.String getPermalink()
```

Permalink of the company which icon or text was tapped.

The permalink may be used to show company info page

### getScreenPoint

```java
@NonNull
ScreenPoint getScreenPoint()
```

The screen position of the company tapped icon.

The screenPoint may be useful in positioning company info page

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
