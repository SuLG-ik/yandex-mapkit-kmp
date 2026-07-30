---
title: "I18nPrefs"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.i18n"
section: "Android / Справочник / com.yandex.runtime.i18n / I18nPrefs"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/i18n/I18nPrefs.html"
---
# I18nPrefs

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/i18n/I18nPrefs.html)

**Package** com.yandex.runtime.i18n

java.lang.Object
↳ com.yandex.runtime.i18n.I18nPrefs

`class I18nPrefs implements Serializable`

Localization preferences.

## Summary

### Constructors

**Signature and Description**

```java
I18nPrefs(@NonNull SystemOfMeasurement som,
          @NonNull TimeFormat timeFormat)
```

```java
I18nPrefs()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `SystemOfMeasurement` | `getSom()`<br>System of measurement (metric or imperial). |
| `TimeFormat` | `getTimeFormat()`<br>Time format (12- or 24-hour). |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### I18nPrefs

```java
I18nPrefs(@NonNull SystemOfMeasurement som,
          @NonNull TimeFormat timeFormat)
```

### I18nPrefs

```java
I18nPrefs()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getSom

```java
@NonNull
SystemOfMeasurement getSom()
```

System of measurement (metric or imperial).

### getTimeFormat

```java
@NonNull
TimeFormat getTimeFormat()
```

Time format (12- or 24-hour).

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
