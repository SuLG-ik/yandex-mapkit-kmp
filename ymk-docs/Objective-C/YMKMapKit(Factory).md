---
title: "YMKMapKit(Factory)"
kind: "Category"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Categories / YMKMapKit(Factory)"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapKit(Factory).html"
---
# YMKMapKit(Factory)

`IOS` · `Objective-C` · `Category` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapKit(Factory).html)

```objectivec
@interface YMKMapKit (Factory)
```

## Summary

### Class methods

```objectivec
+ (nonnull instancetype)mapKit;
```

Gets the MapKit instance

```objectivec
+ (nonnull instancetype)sharedInstance;
```

```objectivec
+ (void)setApiKey:(nonnull NSString *)apiKey;
```

Sets the API key for MapKit SDK

```objectivec
+ (void)setUserId:(nonnull NSString *)id;
```

Sets the user id for MapKit SDK

```objectivec
+ (void)setLocale:(nullable NSString *)locale;
```

Sets locale for MapKit SDK

### Instance methods

```objectivec
- (void)setCompletionHandler:(nonnull void (^)(void))completionHandler
     forBackgroundURLSession:(nonnull NSString *)identifier;
```

Sets completion handler for background URL session

## Class methods

### mapKit

```objectivec
+ (nonnull instancetype)mapKit;
```

Gets the MapKit instance.

### sharedInstance

```objectivec
+ (nonnull instancetype)sharedInstance;
```

### setApiKey:

```objectivec
+ (void)setApiKey:(nonnull NSString *)apiKey;
```

Sets the API key for MapKit SDK. Call this before [YMKMapKit mapKit] and [YMKMapKit sharedInstance]

### setUserId:

```objectivec
+ (void)setUserId:(nonnull NSString *)id;
```

Sets the user id for MapKit SDK. Call this before [YMKMapKit mapKit] and [YMKMapKit sharedInstance]

### setLocale:

```objectivec
+ (void)setLocale:(nullable NSString *)locale;
```

Sets locale for MapKit SDK. Call this before [YMKMapKit mapKit] and [YMKMapKit sharedInstance]

## Instance methods

### setCompletionHandler:forBackgroundURLSession:

```objectivec
- (void)setCompletionHandler:(nonnull void (^)(void))completionHandler
     forBackgroundURLSession:(nonnull NSString *)identifier;
```

Sets completion handler for background URL session.
