---
title: "YMKSuggestItem"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSuggestItem"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSuggestItem.html"
---
# YMKSuggestItem

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSuggestItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSuggestItem : NSObject
```

A single suggested item.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSuggestItem *)suggestItemWithType:( YMKSuggestItemType)type
                                          title:(nonnull YMKSpannableString *)title
                                       subtitle:(nullable YMKSpannableString *)subtitle
                                           tags:(nonnull NSArray<NSString *> *)tags
                                     searchText:(nonnull NSString *)searchText
                                    displayText:(nullable NSString *)displayText
                                            uri:(nullable NSString *)uri
                                           link:(nullable NSString *)link
                                       distance:(nullable YMKLocalizedValue *)distance
                                     isPersonal:( BOOL)isPersonal
                                         action:( YMKSuggestItemAction)action
                                          logId:(nullable NSString *)logId
                                      isOffline:( BOOL)isOffline
                                     isWordItem:( BOOL)isWordItem
                                     properties:(nonnull NSArray<YRTKeyValuePair *> *)properties
                                         center:(nullable YMKPoint *)center
                                businessContext:(nullable NSNumber *)businessContext;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKSuggestItemType type;
```

Suggested object type

```objectivec
@property (nonatomic, readonly, nonnull) YMKSpannableString *title;
```

Short object name

```objectivec
@property (nonatomic, readonly, nullable) YMKSpannableString *subtitle;
```

If type is TOPONYM returns reversed toponym hierarchy, if type is BUSINESS returns business address

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

Additional free-form data for suggest item

```objectivec
@property (nonatomic, readonly, nonnull) NSString *searchText;
```

Text to search for

```objectivec
@property (nonatomic, readonly, nullable) NSString *displayText;
```

Text to display if searchText is too technical to display

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

Element uri, if applicable

```objectivec
@property (nonatomic, readonly, nullable) NSString *link;
```

Element link, if applicable

```objectivec
@property (nonatomic, readonly, nullable) YMKLocalizedValue *distance;
```

Optional distance localized value

```objectivec
@property (nonatomic, readonly) BOOL isPersonal;
```

If the suggested item respects personalization

```objectivec
@property (nonatomic, readonly) YMKSuggestItemAction action;
```

Action to perform on click/tap/enter

```objectivec
@property (nonatomic, readonly, nullable) NSString *logId;
```

Id for request logging

```objectivec
@property (nonatomic, readonly) BOOL isOffline;
```

Item is from offline search

```objectivec
@property (nonatomic, readonly) BOOL isWordItem;
```

Item is a word suggest item

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YRTKeyValuePair *> *properties;
```

Additional item properties

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *center;
```

Position of object

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *businessContext;
```

Detailed subtype of the Business type

Optional field, can be nil

## Class methods

### suggestItemWithType:title:subtitle:tags:searchText:displayText:uri:link:distance:isPersonal:action:logId:isOffline:isWordItem:properties:center:businessContext:

```objectivec
+ (nonnull YMKSuggestItem *)suggestItemWithType:( YMKSuggestItemType)type
                                          title:(nonnull YMKSpannableString *)title
                                       subtitle:(nullable YMKSpannableString *)subtitle
                                           tags:(nonnull NSArray<NSString *> *)tags
                                     searchText:(nonnull NSString *)searchText
                                    displayText:(nullable NSString *)displayText
                                            uri:(nullable NSString *)uri
                                           link:(nullable NSString *)link
                                       distance:(nullable YMKLocalizedValue *)distance
                                     isPersonal:( BOOL)isPersonal
                                         action:( YMKSuggestItemAction)action
                                          logId:(nullable NSString *)logId
                                      isOffline:( BOOL)isOffline
                                     isWordItem:( BOOL)isWordItem
                                     properties:(nonnull NSArray<YRTKeyValuePair *> *)properties
                                         center:(nullable YMKPoint *)center
                                businessContext:(nullable NSNumber *)businessContext;
```

## Properties

### type

```objectivec
@property (nonatomic, readonly) YMKSuggestItemType type;
```

Suggested object type.

### title

```objectivec
@property (nonatomic, readonly, nonnull) YMKSpannableString *title;
```

Short object name.

### subtitle

```objectivec
@property (nonatomic, readonly, nullable) YMKSpannableString *subtitle;
```

If type is TOPONYM returns reversed toponym hierarchy, if type is BUSINESS returns business address.

Optional field, can be nil.

### tags

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

Additional free-form data for suggest item. If type is TOPONYM, returns toponym kind (house/street/locality/...). If type is BUSINESS, returns category class (drugstores/restaurants/...).

### searchText

```objectivec
@property (nonatomic, readonly, nonnull) NSString *searchText;
```

Text to search for.

### displayText

```objectivec
@property (nonatomic, readonly, nullable) NSString *displayText;
```

Text to display if searchText is too technical to display.

Optional field, can be nil.

### uri

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

Element uri, if applicable.

Optional field, can be nil.

### link

```objectivec
@property (nonatomic, readonly, nullable) NSString *link;
```

Element link, if applicable.

Optional field, can be nil.

### distance

```objectivec
@property (nonatomic, readonly, nullable) YMKLocalizedValue *distance;
```

Optional distance localized value.

Optional field, can be nil.

### isPersonal

```objectivec
@property (nonatomic, readonly) BOOL isPersonal;
```

If the suggested item respects personalization.

### action

```objectivec
@property (nonatomic, readonly) YMKSuggestItemAction action;
```

Action to perform on click/tap/enter.

### logId

```objectivec
@property (nonatomic, readonly, nullable) NSString *logId;
```

Id for request logging.

Optional field, can be nil.

### isOffline

```objectivec
@property (nonatomic, readonly) BOOL isOffline;
```

Item is from offline search.

### isWordItem

```objectivec
@property (nonatomic, readonly) BOOL isWordItem;
```

Item is a word suggest item.

### properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YRTKeyValuePair *> *properties;
```

Additional item properties.

### center

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *center;
```

Position of object.

Optional field, can be nil.

### businessContext

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *businessContext;
```

Detailed subtype of the Business type

Optional field, can be nil.
