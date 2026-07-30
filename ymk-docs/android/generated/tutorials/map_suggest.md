---
title: "Геосаджест"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / Руководство / Геосаджест"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_suggest.html"
---
# Геосаджест

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_suggest.html)

Геосаджест - это встроенный функционал API Яндекс Карт для быстрого ввода и проверки названий организаций и адресов во время ввода поисковых запросов от пользователей. При помощи геосаджеста в MapKit SDK можно сформировать список поисковых подсказок (геосаджестов) и сделать процесс ввода поискового запроса более простым и удобным.

> [!WARNING] Важно
> Функционал геосаджеста доступен в [full](../getting_started.md#add-library)-версии MapKit SDK.

## Выполнение запроса геосаджестов

Принцип выполнения запроса геосаджестов похож на создание [поискового запроса](map_search.md#search-request), но имеет несколько важных отличий. Для создания запроса нужно выполнить следующие шаги:

1. Создайте новый экземпляр класса [SearchManager](../../../com/yandex/mapkit/search/SearchManager.md) или используйте существующий.

   ```kotlin
   val searchManager = SearchFactory.getInstance().createSearchManager(SearchManagerType.COMBINED)
   ```
2. При помощи метода [SearchManager.createSuggestSession](../../../com/yandex/mapkit/search/SearchManager.md#createsuggestsession) создайте экземпляр [сессии геосаджеста](map_suggest.md#suggest-session).

   ```kotlin
   val suggestSession = searchManager.createSuggestSession()
   ```
3. Создайте экземпляр класса [SuggestOptions](../../../com/yandex/mapkit/search/SuggestOptions.md), чтобы задать [параметры запроса геосаджестов](map_suggest.md#suggest-options).
   Пример параметров для поиска только по организациям.

   ```kotlin
   val suggestOptions = SuggestOptions()
       .setSuggestTypes(
           SuggestType.BIZ.value
       )
   ```
4. С помощью метода [SuggestSession.suggest](../../../com/yandex/mapkit/search/SuggestSession.md#suggestjavalangstring-boundingbox-suggestoptions-suggestlistener) создайте новый запрос геосаджестов.
   Данный пример начнет поиск возможных поисковых запросов, которые имеют префикс `"ho"`, например: `"Hotels"`, `"Hospitals"` и т.п.

   ```kotlin
   suggestSession.suggest(
       "ho",
       BoundingBox(map.visibleRegion.bottomLeft, map.visibleRegion.topRight),
       suggestOptions,
       suggestListener,
   )
   ```
5. Во время создания запроса геосаджестов, используйте следующий механизм для получения [результатов геосаджеста](map_suggest.md#suggest-results).

   ```kotlin
   val suggestListener = object : SuggestSession.SuggestListener {
       override fun onResponse(items: MutableList<SuggestItem>) {
           // Handle geo suggest response.
       }

       override fun onError(error: Error) {
           // Handle geo suggest error.
       }
   }
   ```

   Реализация данного интерфейса передается в качестве аргумента во все методы создания запроса геосаджестов.

## Сессия геосаджеста

Сессия геосаджеста представляет собой класс [SuggestSession](../../../com/yandex/mapkit/search/SuggestSession.md), при помощи которого осуществляется управление запросами.

Данный класс предоставляет следующий функционал:

- [SuggestSession.suggest](../../../com/yandex/mapkit/search/SuggestSession.md#suggestjavalangstring-boundingbox-suggestoptions-suggestlistener) - используется для создания нового запроса геосаджестов. Принимает следующие аргументы:

  - `text` - текст, по которому будут строиться поисковые подсказки;
  - `window` - текущее положение окна карты;
  - параметры геосаджеста и объект `SuggestListener`.
- [SuggestSession.reset](../../../com/yandex/mapkit/search/SuggestSession.md#reset) - сбрасывает текущий запрос и внутреннее состояние сессии геосаджеста.

> [!WARNING] Важно
> Как и для [сессии поиска](map_search.md#search-session), приложение должно хранить ссылку на объект сессии геосаджеста. Иначе запрос будет отменен.

## Параметры геосаджеста

При помощи параметров геосаджеста [SuggestOptions](../../../com/yandex/mapkit/search/SuggestOptions.md) можно задать:

- `suggestTypes` - тип поисковых объектов для подбора: организации, топонимы и общественный транспорт. Данный параметр является битовой маской, поэтому можно выбрать некоторое подмножество типов.
- `userPosition` - текущая позиция пользователя. Используется для вычисления расстояния от позиции пользователя до объектов, которые могут быть предложены геосаджестом.

## Результаты геосаджеста

Для получения результатов запроса геосаджестов используется подписка на интерфейс [SuggestListener](../../../com/yandex/mapkit/search/SuggestListener.md). Его реализация передается во время вызова метода создания запроса геосаджестов [SuggestSession.suggest](../../../com/yandex/mapkit/search/SuggestSession.md#suggestjavalangstring-boundingbox-suggestoptions-suggestlistener).

Данный интерфейс содержит следующие callback-методы:

1. [SuggestListener.onResponse](../../../com/yandex/mapkit/search/SuggestListener.md#onresponsejavautillistsuggestitem) - вызывается при успешном завершении запроса. Предоставляет список найденных подсказок, который состоит из объектов [SuggestItem](../../../com/yandex/mapkit/search/SuggestItem.md) - саджестов.
2. [SuggestListener.onError](../../../com/yandex/mapkit/search/SuggestListener.md#onerrorerror) - вызывается при завершении запроса с ошибкой.

### Данные саджестов

Класс [SuggestItem](../../../com/yandex/mapkit/search/SuggestItem.md) предоставляет большое количество данных, ключевые из них:

- `type` - тип саджеста: топоним, организация или общественный транспорт.
- `searchText` - текст, по которому нужно осуществить поиск если данный саджест был выбран.
- `displayText` - текст для отображения в поле для ввода запроса.
- `uri` - URI объекта.
- `distance` - дистанция до объекта.
- `action` - тип действия, которое должно быть осуществлено при выборе данного варианта: подстановка или мгновенный поиск.
- `distance` - дистанция до объекта поиска.
- `center` - положение на карте.

### Отображение саджестов

Класс [SuggestItem](../../../com/yandex/mapkit/search/SuggestItem.md) предоставляет информацию для удобного отображения саджестов на экране:

- `title` - короткое название саджеста.
- `subtitle` - данные о местоположении, адрес.

Данные параметры имеют тип [SpannableString](../../../com/yandex/mapkit/SpannableString.md). Он представляет собой строку, в которой выделены подстроки, совпадающие с текстом поискового запроса, введенного пользователем. Данные подстроки следует отрисовывать акцентными цветами.

### Обработка нажатий на саджесты

При помощи [SuggestItem.getAction](../../../com/yandex/mapkit/search/SuggestItem.md#getaction) можно получить тип действия, которое должно быть совершено при выборе данного саджеста:

- [SEARCH](../../../com/yandex/mapkit/search/SuggestItem_Action.md#search) - нужно выполнить новый [поисковый запрос](map_search.md#search-request). Если [SuggestItem.getUri](../../../com/yandex/mapkit/search/SuggestItem.md#geturi) возвращает ненулевой URI, то нужно использовать [поиск по URI](map_search.md#uri-search). Если его нет, то нужно искать по тексту из метода [SuggestItem.getSearchText](../../../com/yandex/mapkit/search/SuggestItem.md#getsearchtext). Используется, как правило, когда пользователь нажимает на название категории, например: "Кафе", "Ресторан", или на название организации.
- [SUBSTITUTE](../../../com/yandex/mapkit/search/SuggestItem_Action.md#substitute) - заменить текст текущего поискового запроса на [SuggestItem.getDisplayText](../../../com/yandex/mapkit/search/SuggestItem.md#getdisplaytext) и выполнить новый запрос геосаджеста. Обычно используется при поиске адресов: сначала подставляется название города, затем улица и т.д.

## Исходный код

С примером использования геосаджеста в MapKit SDK можно ознакомиться в приложении `map-search` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-android-demo).
