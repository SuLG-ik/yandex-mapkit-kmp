---
title: "LocalizedPhrase"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.annotations"
section: "Android / Справочник / com.yandex.mapkit.annotations / LocalizedPhrase"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/annotations/LocalizedPhrase.html"
---
# LocalizedPhrase

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/annotations/LocalizedPhrase.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.annotations

java.lang.Object
↳ com.yandex.mapkit.annotations.LocalizedPhrase

`class LocalizedPhrase implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
LocalizedPhrase()
```

Use constructor with parameters in your code.

```java
LocalizedPhrase(@NonNull java.util.List<SpeakerPhraseToken> tokens,
                @NonNull java.lang.String text,
                @NonNull AnnotationLanguage language)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<SpeakerPhraseToken>` | `getTokens()` |
| `synchronized java.lang.String` | `getText()` |
| `synchronized AnnotationLanguage` | `getLanguage()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### LocalizedPhrase

```java
LocalizedPhrase()
```

Use constructor with parameters in your code.

This one is for serialization only!

### LocalizedPhrase

```java
LocalizedPhrase(@NonNull java.util.List<SpeakerPhraseToken> tokens,
                @NonNull java.lang.String text,
                @NonNull AnnotationLanguage language)
```

## Methods

### getTokens

```java
@NonNull
java.util.List<SpeakerPhraseToken> getTokens()
```

### getText

```java
@NonNull
java.lang.String getText()
```

### getLanguage

```java
@NonNull
AnnotationLanguage getLanguage()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
