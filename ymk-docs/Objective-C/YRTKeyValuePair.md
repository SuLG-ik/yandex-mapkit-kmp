---
title: "YRTKeyValuePair"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTKeyValuePair"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTKeyValuePair.html"
---
# YRTKeyValuePair

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTKeyValuePair.html)

```objectivec
@interface YRTKeyValuePair : NSObject
```

Universal key-value data.

## Summary

### Class methods

```objectivec
+ (nonnull YRTKeyValuePair *)keyValuePairWithKey:(nonnull NSString *)key
                                           value:(nonnull NSString *)value;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *key;
```

Data key

```objectivec
@property (nonatomic, readonly, nonnull) NSString *value;
```

Data value

## Class methods

### keyValuePairWithKey:value:

```objectivec
+ (nonnull YRTKeyValuePair *)keyValuePairWithKey:(nonnull NSString *)key
                                           value:(nonnull NSString *)value;
```

## Properties

### key

```objectivec
@property (nonatomic, readonly, nonnull) NSString *key;
```

Data key. For example, "currency".

### value

```objectivec
@property (nonatomic, readonly, nonnull) NSString *value;
```

Data value. For example, "USD".
