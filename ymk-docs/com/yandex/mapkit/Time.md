---
title: "Time"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / Time"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Time.html"
---
# Time

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Time.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.Time

`class Time implements Serializable`

Time in I18nTime format.

## Summary

### Constructors

**Signature and Description**

```java
Time(long value,
     int tzOffset,
     @NonNull java.lang.String text)
```

```java
Time()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `long` | `getValue()`<br>Time value. |
| `int` | `getTzOffset()`<br>Time offset to account for time zones. |
| `java.lang.String` | `getText()`<br>The description of the timer. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Time

```java
Time(long value,
     int tzOffset,
     @NonNull java.lang.String text)
```

### Time

```java
Time()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getValue

```java
long getValue()
```

Time value.

### getTzOffset

```java
int getTzOffset()
```

Time offset to account for time zones.

### getText

```java
@NonNull
java.lang.String getText()
```

The description of the timer.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
