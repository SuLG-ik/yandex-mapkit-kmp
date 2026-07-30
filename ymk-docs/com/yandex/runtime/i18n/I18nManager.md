---
title: "I18nManager"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.runtime.i18n"
section: "Android / Справочник / com.yandex.runtime.i18n / I18nManager"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/i18n/I18nManager.html"
---
# I18nManager

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/i18n/I18nManager.html)

**Package** com.yandex.runtime.i18n

`interface I18nManager`

Localization manager.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `localizeDistance(int distance)`<br>Converts a distance value to the current locale. |
| `java.lang.String` | `localizeDuration(int duration)`<br>Converts a duration to the current locale. |
| `java.lang.String` | `localizeSpeed(double speed)`<br>Converts speed to the current locale. |
| `java.lang.String` | `localizeDataSize(long dataSize)`<br>Converts data size to the current locale. |
| `CanonicalUnit` | `canonicalSpeed(double speed)`<br>Represents the speed with the value and unit of measurement separated. |
| `java.lang.String` | `localizeCanonicalUnit(@NonNull CanonicalUnit canonicalUnit)`<br>Localizes a value represented by canonical units. |
| `I18nPrefs` | `getPrefs()`<br>Localization preferences. |
| `void` | `setPrefs(@NonNull I18nPrefs prefs)` |
| `SystemOfMeasurement` | `getSom()`<br>System of measurement used. |
| `void` | `setSom(@NonNull SystemOfMeasurement som)` |
| `TimeFormat` | `getTimeFormat()`<br>Preferred time format. |
| `void` | `setTimeFormat(@NonNull TimeFormat timeFormat)` |
| `boolean` | `isValid()`<br>Tells if this **I18nManager** is valid or not. |

## Methods

### localizeDistance

```java
@NonNull
java.lang.String localizeDistance(int distance)
```

Converts a distance value to the current locale.

### localizeDuration

```java
@NonNull
java.lang.String localizeDuration(int duration)
```

Converts a duration to the current locale.

### localizeSpeed

```java
@NonNull
java.lang.String localizeSpeed(double speed)
```

Converts speed to the current locale.

### localizeDataSize

```java
@NonNull
java.lang.String localizeDataSize(long dataSize)
```

Converts data size to the current locale.

### canonicalSpeed

```java
@NonNull
CanonicalUnit canonicalSpeed(double speed)
```

Represents the speed with the value and unit of measurement separated.

### localizeCanonicalUnit

```java
@NonNull
java.lang.String localizeCanonicalUnit(@NonNull CanonicalUnit canonicalUnit)
```

Localizes a value represented by canonical units.

### getPrefs

```java
@NonNull
I18nPrefs getPrefs()
```

Localization preferences.

### setPrefs

```java
void setPrefs(@NonNull I18nPrefs prefs)
```

### getSom

```java
@NonNull
SystemOfMeasurement getSom()
```

System of measurement used.

### setSom

```java
void setSom(@NonNull SystemOfMeasurement som)
```

### getTimeFormat

```java
@NonNull
TimeFormat getTimeFormat()
```

Preferred time format.

### setTimeFormat

```java
void setTimeFormat(@NonNull TimeFormat timeFormat)
```

### isValid

```java
boolean isValid()
```

Tells if this **I18nManager** is valid or not.

Any other method (except for this one) called on an invalid **I18nManager** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
