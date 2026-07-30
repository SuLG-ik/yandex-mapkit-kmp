# Справочник MapKit Mobile SDK — локальная копия

Полная офлайн-копия документации Яндекс MapKit Mobile SDK в формате Markdown, снятая с https://yandex.ru/maps-api/docs/mapkit/.

- Страниц всего: **2043**
- Справочник Android (`com.yandex.*`) — типов: **663**, пакетов: **53**
- Справочник iOS Objective-C — типов: **665**
- Справочник iOS Swift — типов: **665**
- Руководства, NaviKit SDK, Flutter и прочее — страниц: **50**

## Навигация

| Раздел | Что внутри |
| --- | --- |
| [Полное оглавление](SUMMARY.md) | Дерево навигации 1:1 с сайтом, все страницы (2043) |
| [Справочник Android](INDEX-android.md) | Все пакеты `com.yandex.mapkit.*` и `com.yandex.runtime.*` |
| [Справочник iOS · Objective-C](Objective-C/README.md) | Classes, Enums, Protocols, Typedefs, Categories |
| [Справочник iOS · Swift](Swift/README.md) | Те же типы в Swift-синтаксисе |
| [Руководства](INDEX-guides.md) | Начало работы, туториалы, NaviKit SDK, Flutter, FAQ |
| [Скрипты пересборки](_tools/README.md) | Чем снята копия и как обновить её под новый релиз |

## Как устроены файлы

Пути повторяют структуру сайта: страница `https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressBook.html` лежит в `Objective-C/YMKAddressBook.md`, `https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Animation.html` — в `com/yandex/mapkit/Animation.md`.

Каждый файл начинается с YAML front-matter:

```yaml
---
title: "YMKAddressBook"      # имя типа
kind: "Class"                # Class | Enum | Interface | Protocol | Typedef | Category | Extension | Guide
platform: "ios"              # ios | android | flutter | common
language: "Objective-C"      # Objective-C | Swift | Java | Kotlin/Java | Dart
package: "com.yandex.mapkit" # только для Android
section: "iOS / Справочник / Objective-C / Classes"
source: "…"                  # адрес оригинальной страницы
---
```

Дальше идёт тело страницы: сигнатуры в блоках кода с подсветкой, сводные таблицы в GFM, примечания в формате `> [!NOTE]`.

## Ссылки

Все перекрёстные ссылки между страницами — относительные и ведут на локальные `.md`, поэтому документацию можно читать офлайн в любом markdown-редакторе. Ссылки на изображения оставлены абсолютными и ведут на сервер Яндекса.

## Обновление

Копия снята автоматически. Оригинал живёт по адресу https://yandex.ru/maps-api/docs/mapkit/ и обновляется вместе с релизами SDK — сверяйтесь с полем `source` в шапке нужной страницы.

Пересборка запускается вручную и очень редко — под релиз MapKit. Готовый порядок действий с проверками оформлен скиллом `/yml-update-original-docs`; сами скрипты лежат в [`_tools/`](_tools/README.md):

```bash
cd _tools && python3 fetch_toc.py && python3 fetch_all.py \
  && python3 build_docs.py .. && python3 build_indexes.py ..
```

Там же лежат проверки полноты (`validate2.py`) и целостности ссылок (`link_check.py`).
