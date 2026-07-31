---
title: "YMKSearchDayGroup"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKSearchDayGroup"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchDayGroup.html"
---
# YMKSearchDayGroup

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchDayGroup.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKSearchDayGroup : NSUInteger {}
```

A group of week days.

## Summary

### Enum cases

```objectivec
YMKSearchDayGroupNone = 0
```

Nothing

```objectivec
YMKSearchDayGroupSunday = 1
```

Sunday

```objectivec
YMKSearchDayGroupMonday = 1 << 1
```

Monday

```objectivec
YMKSearchDayGroupTuesday = 1 << 2
```

Tuesday

```objectivec
YMKSearchDayGroupWednesday = 1 << 3
```

Wednesday

```objectivec
YMKSearchDayGroupThursday = 1 << 4
```

Thursday

```objectivec
YMKSearchDayGroupFriday = 1 << 5
```

Friday

```objectivec
YMKSearchDayGroupSaturday = 1 << 6
```

Saturday

```objectivec
YMKSearchDayGroupWeekdays = YMKSearchDayGroupMonday | YMKSearchDayGroupTuesday |
                            YMKSearchDayGroupWednesday |
                            YMKSearchDayGroupThursday | YMKSearchDayGroupFriday
```

Weekdays from Monday to Friday

```objectivec
YMKSearchDayGroupWeekend = YMKSearchDayGroupSaturday | YMKSearchDayGroupSunday
```

Weekend days (Saturday and Sunday)

```objectivec
YMKSearchDayGroupEveryday = YMKSearchDayGroupWeekdays | YMKSearchDayGroupWeekend
```

Every day of the week

## Enum cases

### YMKSearchDayGroupNone

```objectivec
YMKSearchDayGroupNone = 0
```

Nothing.

### YMKSearchDayGroupSunday

```objectivec
YMKSearchDayGroupSunday = 1
```

Sunday.

### YMKSearchDayGroupMonday

```objectivec
YMKSearchDayGroupMonday = 1 << 1
```

Monday.

### YMKSearchDayGroupTuesday

```objectivec
YMKSearchDayGroupTuesday = 1 << 2
```

Tuesday.

### YMKSearchDayGroupWednesday

```objectivec
YMKSearchDayGroupWednesday = 1 << 3
```

Wednesday.

### YMKSearchDayGroupThursday

```objectivec
YMKSearchDayGroupThursday = 1 << 4
```

Thursday.

### YMKSearchDayGroupFriday

```objectivec
YMKSearchDayGroupFriday = 1 << 5
```

Friday.

### YMKSearchDayGroupSaturday

```objectivec
YMKSearchDayGroupSaturday = 1 << 6
```

Saturday.

### YMKSearchDayGroupWeekdays

```objectivec
YMKSearchDayGroupWeekdays = YMKSearchDayGroupMonday | YMKSearchDayGroupTuesday |
                            YMKSearchDayGroupWednesday |
                            YMKSearchDayGroupThursday | YMKSearchDayGroupFriday
```

Weekdays from Monday to Friday.

### YMKSearchDayGroupWeekend

```objectivec
YMKSearchDayGroupWeekend = YMKSearchDayGroupSaturday | YMKSearchDayGroupSunday
```

Weekend days (Saturday and Sunday)

### YMKSearchDayGroupEveryday

```objectivec
YMKSearchDayGroupEveryday = YMKSearchDayGroupWeekdays | YMKSearchDayGroupWeekend
```

Every day of the week
