---
title: "Logo"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.logo"
section: "Android / Справочник / com.yandex.mapkit.logo / Logo"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/logo/Logo.html"
---
# Logo

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/logo/Logo.html)

**Package** com.yandex.mapkit.logo

`interface Logo`

The object that allows to control logo display properties.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setAlignment(@NonNull Alignment alignment)`<br>Set logo alignment in the container. |
| `void` | `setPadding(@NonNull Padding padding)`<br>Set logo padding relative to the left/right and top/bottom edges. |
| `boolean` | `isValid()`<br>Tells if this **Logo** is valid or not. |

## Methods

### setAlignment

```java
void setAlignment(@NonNull Alignment alignment)
```

Set logo alignment in the container.

### setPadding

```java
void setPadding(@NonNull Padding padding)
```

Set logo padding relative to the left/right and top/bottom edges.

Values must be positive.

### isValid

```java
boolean isValid()
```

Tells if this **Logo** is valid or not.

Any other method (except for this one) called on an invalid **Logo** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
