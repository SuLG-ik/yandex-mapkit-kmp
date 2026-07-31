---
title: "I18nManagerFactory"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.i18n"
section: "Android / Справочник / com.yandex.runtime.i18n / I18nManagerFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/i18n/I18nManagerFactory.html"
---
# I18nManagerFactory

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/i18n/I18nManagerFactory.html)

**Package** com.yandex.runtime.i18n

java.lang.Object
↳ com.yandex.runtime.i18n.I18nManagerFactory

`class I18nManagerFactory`

## Summary

### Constructors

**Signature and Description**

```java
I18nManagerFactory()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native java.lang.String` | `getLocale()`<br>Returns the locale currently used by the runtime. |
| `static native void` | `setLocale(@Nullable java.lang.String locale)`<br>Sets the application's locale. |
| `static native I18nManager` | `getI18nManagerInstance()`<br>Gets the internationalization manager interface. |

## Constuctors

### I18nManagerFactory

```java
I18nManagerFactory()
```

## Methods

### getLocale

```java
@NonNull
java.lang.String getLocale()
```

Returns the locale currently used by the runtime.

Should be called only after locale has been set.

### setLocale

```java
void setLocale(@Nullable java.lang.String locale)
```

Sets the application's locale.

Useful only if MapKit is not used by the application. Otherwise, use . Also useless if someone else has already set the locale (produses warning and does nothing). Can be set to none, in this case system locale will be used.

### getI18nManagerInstance

```java
@NonNull
I18nManager getI18nManagerInstance()
```

Gets the internationalization manager interface.
