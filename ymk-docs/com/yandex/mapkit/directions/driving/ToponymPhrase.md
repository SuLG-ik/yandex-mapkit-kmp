---
title: "ToponymPhrase"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / ToponymPhrase"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ToponymPhrase.html"
---
# ToponymPhrase

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ToponymPhrase.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.ToponymPhrase

`class ToponymPhrase implements Serializable`

The description of the object.

## Summary

### Constructors

**Signature and Description**

```java
ToponymPhrase()
```

Use constructor with parameters in your code.

```java
ToponymPhrase(@NonNull java.lang.String text,
              @Nullable java.lang.Integer actionProximity)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getText()`<br>The string containing the description. |
| `synchronized java.lang.Integer` | `getActionProximity()`<br>Positions at which text should be pronounced. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ToponymPhrase

```java
ToponymPhrase()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ToponymPhrase

```java
ToponymPhrase(@NonNull java.lang.String text,
              @Nullable java.lang.Integer actionProximity)
```

## Methods

### getText

```java
@NonNull
java.lang.String getText()
```

The string containing the description.

### getActionProximity

```java
@Nullable
java.lang.Integer getActionProximity()
```

Positions at which text should be pronounced.

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
