---
title: "Annotation"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / Annotation"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Annotation.html"
---
# Annotation

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Annotation.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.Annotation

`class Annotation implements Serializable`

The annotation that is displayed on the map.

## Summary

### Constructors

**Signature and Description**

```java
Annotation()
```

Use constructor with parameters in your code.

```java
Annotation(@NonNull Action action,
           @Nullable java.lang.String toponym,
           @NonNull java.lang.String descriptionText,
           @Nullable ActionMetadata actionMetadata,
           @NonNull java.util.List<Landmark> landmarks,
           @NonNull java.util.List<ToponymPhrase> toponymPhrase)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Action` | `getAction()`<br>Driver action. |
| `synchronized java.lang.String` | `getToponym()`<br>The toponym of the location. |
| `synchronized java.lang.String` | `getDescriptionText()`<br>Description text to display. |
| `synchronized ActionMetadata` | `getActionMetadata()`<br>Action metadata. |
| `synchronized java.util.List<Landmark>` | `getLandmarks()`<br>Significant landmarks. |
| `synchronized java.util.List<ToponymPhrase>` | `getToponymPhrase()`<br>Toponym phrases with positions for pronunciation. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Annotation

```java
Annotation()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Annotation

```java
Annotation(@NonNull Action action,
           @Nullable java.lang.String toponym,
           @NonNull java.lang.String descriptionText,
           @Nullable ActionMetadata actionMetadata,
           @NonNull java.util.List<Landmark> landmarks,
           @NonNull java.util.List<ToponymPhrase> toponymPhrase)
```

## Methods

### getAction

```java
@NonNull
Action getAction()
```

Driver action.

### getToponym

```java
@Nullable
java.lang.String getToponym()
```

The toponym of the location.

Optional field, can be null.

### getDescriptionText

```java
@NonNull
java.lang.String getDescriptionText()
```

Description text to display.

### getActionMetadata

```java
@Nullable
ActionMetadata getActionMetadata()
```

Action metadata.

Optional field, can be null.

### getLandmarks

```java
@NonNull
java.util.List<Landmark> getLandmarks()
```

Significant landmarks.

### getToponymPhrase

```java
@NonNull
java.util.List<ToponymPhrase> getToponymPhrase()
```

Toponym phrases with positions for pronunciation.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
