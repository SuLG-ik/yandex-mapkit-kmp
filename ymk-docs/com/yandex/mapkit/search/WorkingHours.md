---
title: "WorkingHours"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / WorkingHours"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/WorkingHours.html"
---
# WorkingHours

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/WorkingHours.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.WorkingHours

`class WorkingHours implements Serializable`

Open hours for an organization.

## Summary

### Constructors

**Signature and Description**

```java
WorkingHours()
```

Use constructor with parameters in your code.

```java
WorkingHours(@NonNull java.lang.String text,
             @NonNull java.util.List<Availability> availabilities,
             @Nullable State state)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getText()`<br>Human-readable localized open hours description. |
| `synchronized java.util.List<Availability>` | `getAvailabilities()`<br>Structured open hours information. |
| `synchronized State` | `getState()`<br>Current company working status<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### WorkingHours

```java
WorkingHours()
```

Use constructor with parameters in your code.

This one is for serialization only!

### WorkingHours

```java
WorkingHours(@NonNull java.lang.String text,
             @NonNull java.util.List<Availability> availabilities,
             @Nullable State state)
```

## Methods

### getText

```java
@NonNull
java.lang.String getText()
```

Human-readable localized open hours description.

### getAvailabilities

```java
@NonNull
java.util.List<Availability> getAvailabilities()
```

Structured open hours information.

### getState

```java
@Nullable
State getState()
```

Current company working status

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
