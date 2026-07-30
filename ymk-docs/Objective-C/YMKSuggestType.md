---
title: "YMKSuggestType"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKSuggestType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSuggestType.html"
---
# YMKSuggestType

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSuggestType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKSuggestType : NSUInteger {}
```

Bitmask for requested suggest types.

## Summary

### Enum cases

```objectivec
YMKSuggestTypeUnspecified = 0
```

Default value: server-defined types are returned

```objectivec
YMKSuggestTypeGeo = 1
```

Toponyms

```objectivec
YMKSuggestTypeBiz = 1 << 1
```

Companies

```objectivec
YMKSuggestTypeTransit = 1 << 2
```

Mass transit routes

```objectivec
YMKSuggestTypeOneOrg = 1 << 4
```

Organization that can be uniquely identified by search request

```objectivec
YMKSuggestTypeChain = 1 << 5
```

Chains

```objectivec
YMKSuggestTypeRubric = 1 << 6
```

Rubrics

```objectivec
YMKSuggestTypeTextHint = 1 << 7
```

Text hints

```objectivec
YMKSuggestTypePromoQuery = 1 << 8
```

Promo queries

```objectivec
YMKSuggestTypeCoords = 1 << 9
```

Coordinates

## Enum cases

### YMKSuggestTypeUnspecified

```objectivec
YMKSuggestTypeUnspecified = 0
```

Default value: server-defined types are returned.

### YMKSuggestTypeGeo

```objectivec
YMKSuggestTypeGeo = 1
```

Toponyms.

### YMKSuggestTypeBiz

```objectivec
YMKSuggestTypeBiz = 1 << 1
```

Companies.

### YMKSuggestTypeTransit

```objectivec
YMKSuggestTypeTransit = 1 << 2
```

Mass transit routes.

### YMKSuggestTypeOneOrg

```objectivec
YMKSuggestTypeOneOrg = 1 << 4
```

Organization that can be uniquely identified by search request.

### YMKSuggestTypeChain

```objectivec
YMKSuggestTypeChain = 1 << 5
```

Chains.

### YMKSuggestTypeRubric

```objectivec
YMKSuggestTypeRubric = 1 << 6
```

Rubrics.

### YMKSuggestTypeTextHint

```objectivec
YMKSuggestTypeTextHint = 1 << 7
```

Text hints.

### YMKSuggestTypePromoQuery

```objectivec
YMKSuggestTypePromoQuery = 1 << 8
```

Promo queries.

### YMKSuggestTypeCoords

```objectivec
YMKSuggestTypeCoords = 1 << 9
```

Coordinates.
