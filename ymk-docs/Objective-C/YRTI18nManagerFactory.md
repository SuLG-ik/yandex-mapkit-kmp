---
title: "YRTI18nManagerFactory"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTI18nManagerFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTI18nManagerFactory.html"
---
# YRTI18nManagerFactory

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTI18nManagerFactory.html)

```objectivec
@interface YRTI18nManagerFactory : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull NSString *)getLocale;
```

Returns the locale currently used by the runtime

```objectivec
+ (void)setLocaleWithLocale:(nullable NSString *)locale;
```

Sets the application's locale

```objectivec
+ (nonnull YRTI18nManager *)getI18nManagerInstance;
```

Gets the internationalization manager interface

## Class methods

### getLocale

```objectivec
+ (nonnull NSString *)getLocale;
```

Returns the locale currently used by the runtime. Should be called only after locale has been set.

### setLocaleWithLocale:

```objectivec
+ (void)setLocaleWithLocale:(nullable NSString *)locale;
```

Sets the application's locale. Useful only if MapKit is not used by the application. Otherwise, use {``` mapkit.MapKitFactory.setLocale()}. Also useless if someone else has already set the locale (produses warning and does nothing). Can be set to none, in this case system locale will be used.

### getI18nManagerInstance

```objectivec
+ (nonnull YRTI18nManager *)getI18nManagerInstance;
```

Gets the internationalization manager interface.
