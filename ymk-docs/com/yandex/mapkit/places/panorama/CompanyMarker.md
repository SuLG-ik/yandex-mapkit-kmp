---
title: "CompanyMarker"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / CompanyMarker"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/CompanyMarker.html"
---
# CompanyMarker

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/CompanyMarker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.CompanyMarker

`class CompanyMarker implements Serializable`

Company marker struct

## Summary

### Constructors

**Signature and Description**

```java
CompanyMarker()
```

Use constructor with parameters in your code.

```java
CompanyMarker(@NonNull Direction angularPosition,
              @NonNull java.lang.String label,
              @NonNull java.lang.String iconId,
              @NonNull java.lang.String permalink)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Direction` | `getAngularPosition()`<br>Angular position, degrees. |
| `synchronized java.lang.String` | `getLabel()`<br>Displayed label. |
| `synchronized java.lang.String` | `getIconId()`<br>The company iconId. |
| `synchronized java.lang.String` | `getPermalink()`<br>Permalink is passed as a parameter to the onCompanyTap method. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### CompanyMarker

```java
CompanyMarker()
```

Use constructor with parameters in your code.

This one is for serialization only!

### CompanyMarker

```java
CompanyMarker(@NonNull Direction angularPosition,
              @NonNull java.lang.String label,
              @NonNull java.lang.String iconId,
              @NonNull java.lang.String permalink)
```

## Methods

### getAngularPosition

```java
@NonNull
Direction getAngularPosition()
```

Angular position, degrees.

(bearing, tilt) (0, 0) - (north, horizon)

### getLabel

```java
@NonNull
java.lang.String getLabel()
```

Displayed label.

For example, a company name 'Sweet market'

### getIconId

```java
@NonNull
java.lang.String getIconId()
```

The company iconId.

The iconId is passed as a parameter to the IconImageFactory and IconUrlProvider

### getPermalink

```java
@NonNull
java.lang.String getPermalink()
```

Permalink is passed as a parameter to the onCompanyTap method.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
