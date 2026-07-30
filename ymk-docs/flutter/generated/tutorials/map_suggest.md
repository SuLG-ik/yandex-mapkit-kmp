---
title: "Геосаджест"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / Руководство / Геосаджест"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_suggest.html"
---
# Геосаджест

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_suggest.html)

Геосаджест - это встроенный функционал API Яндекс Карт для быстрого ввода и проверки названий организаций и адресов во время ввода поисковых запросов от пользователей. При помощи геосаджеста в MapKit SDK можно сформировать список поисковых подсказок (геосаджестов) и сделать процесс ввода поискового запроса более простым и удобным.

> [!WARNING] Важно
> Функционал геосаджеста доступен в [full](https://pub.dev/packages/yandex_maps_mapkit)-версии MapKit SDK.

## Выполнение запроса геосаджестов

Принцип выполнения запроса геосаджестов похож на создание [поискового запроса](map_search.md#search-request), но имеет несколько важных отличий. Для создания запроса нужно выполнить следующие шаги:

1. Создайте новый экземпляр класса [SearchManager](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager-class.html) или используйте существующий.

   ```dart
   final searchManager = SearchFactory.instance.createSearchManager(SearchManagerType.Combined);
   ```
2. При помощи метода [SearchManager.createSuggestSession](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager/createSuggestSession.html) создайте экземпляр [сессии геосаджеста](map_suggest.md#suggest-session).

   ```dart
   final suggestSession = searchManager.createSuggestSession();
   ```
3. Создайте экземпляр класса [SuggestOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestOptions-class.html), чтобы задать [параметры запроса геосаджестов](map_suggest.md#suggest-options).
   Пример параметров для поиска только по организациям.

   ```dart
   final suggestOptions = SuggestOptions(suggestTypes: SuggestType.Biz.value);
   ```
4. С помощью метода [SearchSuggestSession.suggest](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSuggestSession/suggest.html) создайте новый запрос геосаджестов.
   Данный пример начнет поиск возможных поисковых запросов, которые имеют префикс `"ho"`, например: `"Hotels"`, `"Hospitals"` и т.п.

   ```dart
   suggestSession.suggest(
     BoundingBox(map.visibleRegion.bottomLeft, map.visibleRegion.topRight),
     suggestOptions,
     suggestListener,
     text: "ho",
   );
   ```
5. Во время создания запроса геосаджестов, используйте следующий механизм для получения [результатов геосаджеста](map_suggest.md#suggest-results).

   ```dart
   final class SuggestListenerImpl implements SearchSuggestSessionSuggestListener {

     @override
     void onResponse(SuggestResponse suggest) {
       // Handle geo suggest response
     }

     @override
     void onError(Error error) {
       // Handle geo suggest error
     }
   }
   ```

   Реализация данного интерфейса передается в качестве аргумента во все методы создания запроса геосаджестов.

## Сессия геосаджеста

Сессия геосаджеста представляет собой класс [SearchSuggestSession](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSuggestSession-class.html), при помощи которого осуществляется управление запросами.

Данный класс предоставляет следующий функционал:

- [SearchSuggestSession.suggest](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSuggestSession/suggest.html) - используется для создания нового запроса геосаджестов. Принимает следующие аргументы:

  - `text` - текст, по которому будут строиться поисковые подсказки;
  - `window` - текущее положение окна карты;
  - параметры геосаджеста и объект `SuggestListener`.
- [SearchSuggestSession.reset](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSuggestSession/reset.html) - сбрасывает текущий запрос и внутреннее состояние сессии геосаджеста.

> [!WARNING] Важно
> Как и для [сессии поиска](map_search.md#search-session), приложение должно хранить ссылку на объект сессии геосаджеста. Иначе запрос будет отменен.

## Параметры геосаджеста

При помощи параметров геосаджеста [SuggestOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestOptions-class.html) можно задать:

- `suggestTypes` - тип поисковых объектов для подбора: организации, топонимы и общественный транспорт. Данный параметр является битовой маской, поэтому можно выбрать некоторое подмножество типов.
- `userPosition` - текущая позиция пользователя. Используется для вычисления расстояния от позиции пользователя до объектов, которые могут быть предложены геосаджестом.

## Результаты геосаджеста

Для получения результатов запроса геосаджестов используется подписка на интерфейс [SearchSuggestSessionSuggestListener](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSuggestSessionSuggestListener-class.html). Его реализация передается во время вызова метода создания запроса геосаджестов [SearchSuggestSession.suggest](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSuggestSession/suggest.html).

Данный интерфейс содержит следующие callback-методы:

1. [SearchSuggestSessionSuggestListener.onResponse](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSuggestSessionSuggestListener/onResponse.html) - вызывается при успешном завершении запроса. Предоставляет список найденных подсказок, который состоит из объектов [SuggestItem](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestItem-class.html) - саджестов.
2. [SearchSuggestSessionSuggestListener.onError](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSuggestSessionSuggestListener/onError.html) - вызывается при завершении запроса с ошибкой.

### Данные саджестов

Класс [SuggestItem](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestItem-class.html) предоставляет большое количество данных, ключевые из них:

- `type` - тип саджеста: топоним, организация или общественный транспорт.
- `searchText` - текст, по которому нужно осуществить поиск если данный саджест был выбран.
- `displayText` - текст для отображения в поле для ввода запроса.
- `uri` - URI объекта.
- `distance` - дистанция до объекта.
- `action` - тип действия, которое должно быть осуществлено при выборе данного варианта: подстановка или мгновенный поиск.
- `distance` - дистанция до объекта поиска.
- `center` - положение на карте.

### Отображение саджестов

Класс [SuggestItem](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestItem-class.html) предоставляет информацию для удобного отображения саджестов на экране:

- `title` - короткое название саджеста.
- `subtitle` - данные о местоположении, адрес.

Данные параметры имеют тип [SpannableString](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/SpannableString-class.html). Он представляет собой строку, в которой выделены подстроки, совпадающие с текстом поискового запроса, введенного пользователем. Данные подстроки следует отрисовывать акцентными цветами.

### Обработка нажатий на саджесты

При помощи [SuggestItem.action](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestItem/action.html) можно получить тип действия, которое должно быть совершено при выборе данного саджеста:

- [Search](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestItemAction.html#Search) - нужно выполнить новый [поисковый запрос](map_search.md#search-request). Если [SuggestItem.uri](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestItem/uri.html) возвращает ненулевой URI, то нужно использовать [поиск по URI](map_search.md#uri-search). Если его нет, то нужно искать по тексту из метода [SuggestItem.searchText](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestItem/searchText.html). Используется, как правило, когда пользователь нажимает на название категории, например: "Кафе", "Ресторан", или на название организации.
- [Substitute](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestItemAction.html#Substitute) - заменить текст текущего поискового запроса на [SuggestItem.displayText](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SuggestItem/displayText.html) и выполнить новый запрос геосаджеста. Обычно используется при поиске адресов: сначала подставляется название города, затем улица и т.д.

## Исходный код

С примером использования геосаджеста в MapKit SDK можно ознакомиться в приложении `map_search` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-flutter-demo).
