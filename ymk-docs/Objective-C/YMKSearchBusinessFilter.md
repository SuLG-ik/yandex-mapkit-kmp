---
title: "YMKSearchBusinessFilter"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessFilter"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilter.html"
---
# YMKSearchBusinessFilter

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessFilter : NSObject
```

A filter that could be applied to search results.

Filters can be either boolean (that is Wi-Fi availability in a cafe) or enumerated (that is cuisine type in a restaurant). Enumerated filters support multiple selected values (OR-combined), to search, for example, for restaurants with Armenian or Georgian cuisine at once.

This class is used in two separate ways: server response contains all filters applicable to current search request and client can use some of these filters to get more specific results in the following search requests

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessFilter *)businessFilterWithId:(nonnull NSString *)id
                                                     name:(nullable NSString *)name
                                                 disabled:(nullable NSNumber *)disabled
                                                iconLight:(nullable YMKImage *)iconLight
                                                 iconDark:(nullable YMKImage *)iconDark
                                           iconAfterLight:(nullable YMKImage *)iconAfterLight
                                            iconAfterDark:(nullable YMKImage *)iconAfterDark
                                             singleSelect:(nullable NSNumber *)singleSelect
                                                   values:(nonnull YMKSearchBusinessFilterValues *)values;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Filter id

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Human-readable filter name

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *disabled;
```

The filter should not be used by the client, because filter is either used already (selected:true, disabled:true) or nothing would be found * (selected:false, disabled:true)

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconLight;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconDark;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconAfterLight;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconAfterDark;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *singleSelect;
```

Only one of multiple available values should be selected

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchBusinessFilterValues *values;
```

Filter values

## Class methods

### businessFilterWithId:name:disabled:iconLight:iconDark:iconAfterLight:iconAfterDark:singleSelect:values:

```objectivec
+ (nonnull YMKSearchBusinessFilter *)businessFilterWithId:(nonnull NSString *)id
                                                     name:(nullable NSString *)name
                                                 disabled:(nullable NSNumber *)disabled
                                                iconLight:(nullable YMKImage *)iconLight
                                                 iconDark:(nullable YMKImage *)iconDark
                                           iconAfterLight:(nullable YMKImage *)iconAfterLight
                                            iconAfterDark:(nullable YMKImage *)iconAfterDark
                                             singleSelect:(nullable NSNumber *)singleSelect
                                                   values:(nonnull YMKSearchBusinessFilterValues *)values;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Filter id.

### name

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Human-readable filter name.

Optional field, can be nil.

### disabled

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *disabled;
```

The filter should not be used by the client, because filter is either used already (selected:true, disabled:true) or nothing would be found * (selected:false, disabled:true).

Optional field, can be nil.

### iconLight

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconLight;
```

Optional field, can be nil.

### iconDark

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconDark;
```

Optional field, can be nil.

### iconAfterLight

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconAfterLight;
```

Optional field, can be nil.

### iconAfterDark

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconAfterDark;
```

Optional field, can be nil.

### singleSelect

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *singleSelect;
```

Only one of multiple available values should be selected.

Optional field, can be nil.

### values

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchBusinessFilterValues *values;
```

Filter values.
