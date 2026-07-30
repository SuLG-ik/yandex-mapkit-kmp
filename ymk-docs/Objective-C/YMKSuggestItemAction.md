---
title: "YMKSuggestItemAction"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKSuggestItemAction"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSuggestItemAction.html"
---
# YMKSuggestItemAction

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSuggestItemAction.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKSuggestItemAction : NSUInteger {}
```

Action to be performed when user selected suggest item.

## Summary

### Enum cases

```objectivec
YMKSuggestItemActionSearch
```

Immediately search for `text`

```objectivec
YMKSuggestItemActionSubstitute
```

Substitute query by `text` for further editing

```objectivec
YMKSuggestItemActionFollowLink
```

Exit suggest session and open link

## Enum cases

### YMKSuggestItemActionSearch

```objectivec
YMKSuggestItemActionSearch
```

Immediately search for `text`.

### YMKSuggestItemActionSubstitute

```objectivec
YMKSuggestItemActionSubstitute
```

Substitute query by `text` for further editing.

### YMKSuggestItemActionFollowLink

```objectivec
YMKSuggestItemActionFollowLink
```

Exit suggest session and open link
