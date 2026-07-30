---
name: yml-docs
description: "Навигация по локальной копии справочника Яндекс MapKit в ymk-docs/. Используй, когда нужен любой факт из API MapKit: что делает класс, какая у метода сигнатура и nullability, какие есть свойства, enum-константы, слушатели и опции, чем отличаются Android и iOS API, как называется iOS-аналог Android-типа, где посмотреть пример из руководства. Здесь лежит полный справочник — 2043 страницы для Android (com.yandex.*), iOS Objective-C и Swift, — поэтому за фактами по MapKit иди сюда, а не в веб-поиск и не по памяти. Не путай со скиллом yml-update-original-docs: тот пересобирает копию заново и запускается только вручную."
trigger: /yml-docs
---

# Справочник MapKit в `ymk-docs/`

Полная офлайн-копия документации с `yandex.ru/maps-api/docs/mapkit`. Отвечая на вопросы по MapKit, бери факты отсюда: справочник полный, у каждой страницы в шапке есть `source` со ссылкой на оригинал.

## Что где лежит

| Путь | Что внутри |
|---|---|
| `ymk-docs/com/yandex/…/<Тип>.md` | справочник Android, 663 типа; путь повторяет пакет |
| `ymk-docs/Objective-C/<Тип>.md` | справочник iOS, 665 типов |
| `ymk-docs/Swift/<Тип>.md` | те же типы в Swift-синтаксисе |
| `ymk-docs/{android,ios,flutter}/…` | руководства, «Начало работы», NaviKit SDK |
| `ymk-docs/{index,style,versions,faq,feedback}.md` | обзор, стили карты, история версий, FAQ |

Навигация: `README.md` в корне, `SUMMARY.md` со всем деревом, `INDEX-android.md` (пакеты + алфавитный список типов с описаниями), `INDEX-guides.md`, `Objective-C/README.md` и `Swift/README.md` (типы по видам), `README.md` в каждом пакете.

## Как искать

**Знаешь имя типа — открывай файл напрямую**, это быстрее любого поиска:

```bash
cat ymk-docs/com/yandex/mapkit/geometry/Point.md
```

**Не знаешь пакет** — найди файл по имени:

```bash
find ymk-docs -name 'PlacemarkMapObject.md' -o -name 'YMKPlacemarkMapObject.md'
```

**Не знаешь имя** — ищи по описанию в алфавитном индексе, там у каждого типа есть краткое описание:

```bash
grep -i 'кластер\|cluster' ymk-docs/INDEX-android.md
```

**Ищешь метод, а не тип** — грепай по всему справочнику платформы:

```bash
grep -rln 'addPlacemark' ymk-docs/com
```

**Нужен список типов определённого вида или пакета** — фильтруй по front-matter:

```bash
grep -rl '^kind: "Protocol"' ymk-docs/Objective-C
grep -rl '^package: "com.yandex.mapkit.geometry"' ymk-docs/com
```

**Нужно, кто использует тип** — ищи ссылки на его файл:

```bash
grep -rl ']([^)]*DrivingRouter\.md' ymk-docs
```

## Сопоставление Android и iOS

Для работы над обёрткой чаще всего нужно найти пару к типу с другой платформы. Порядок попыток:

1. `YMK` + имя: `com.yandex.mapkit.geometry.Point` → `YMKPoint`. Так совпадает 292 типа из 663.
2. `YMK` + последний сегмент пакета + имя: `com.yandex.mapkit.directions.driving.TurnMetadata` → `YMKDrivingTurnMetadata`, `…transport.masstransit.Section` → `YMKMasstransitSection`. Ещё 235 типов.
3. Остальные 136 по имени не выводятся — ищи по описанию или по сигнатуре метода:

   ```bash
   grep -rl 'Polyline to search near' ymk-docs/Objective-C
   ```

Не угадывай имя iOS-класса по памяти — проверяй, что файл существует.

## Как читать страницу

Шапка — YAML front-matter: `title`, `kind` (Class / Enum / Interface / Protocol / Typedef / Category / Extension / Guide), `platform`, `language`, `package`, `section`, `source`.

Дальше тело в том же порядке, что на сайте: объявление типа, описание, раздел `## Summary` со сводными таблицами и списком сигнатур, потом детальные разделы (`## Methods`, `## Properties`, `## Class methods`, `## Enum Constants Detail`) с описанием каждого члена. Сигнатуры лежат в блоках кода с подсветкой языка, примечания оформлены как `> [!NOTE]` и `> [!WARNING]`.

`> [!WARNING] Важно / This feature is available in the NaviKit SDK version` и аналогичная пометка про Full-версию — существенны: такой API недоступен в lite-сборке. Проект использует lite (`gradle/libs.versions.toml`), поэтому при выборе API проверяй эту пометку.

Страницы обычно небольшие, но несколько крупных (`Objective-C/YMKSpeakerPhraseToken.md`, `com/yandex/mapkit/annotations/SpeakerPhraseToken.md`, `com/yandex/mapkit/map/Map.md`) читай по частям и ориентируйся по `grep -n '^### '`.

## Чего ожидать

Копия точная, поэтому часть шероховатостей унаследована от оригинала и чинить их не нужно: заголовок «Constuctors» с опечаткой на 339 страницах, сломанная разметка `|| || ##-&nbsp;…` в описании `cameraPositionWithGeometry` у `YMKMap`, оборванное на `{` описание параметра `polyline` у `YMKSearchManager`, местами пустые описания.

Копия снята под конкретный релиз SDK и со временем расходится с сайтом. Если ответ выглядит устаревшим, сверься с оригиналом по ссылке `source` из шапки страницы. Пересобирать копию ради этого не надо — это отдельная редкая ручная операция (`/yml-update-original-docs`).
