---
title: "Геосаджест"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / Руководство / Геосаджест"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_suggest.html"
---
# Геосаджест

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_suggest.html)

Геосаджест - это встроенный функционал API Яндекс Карт для быстрого ввода и проверки названий организаций и адресов во время ввода поисковых запросов от пользователей. При помощи геосаджеста в MapKit SDK можно сформировать список поисковых подсказок (геосаджестов) и сделать процесс ввода поискового запроса более простым и удобным.

> [!WARNING] Важно
> Функционал геосаджеста доступен в [full](../getting_started.md#add-library)-версии MapKit SDK.

## Выполнение запроса геосаджестов

Принцип выполнения запроса геосаджестов похож на создание [поискового запроса](map_search.md#search-request), но имеет несколько важных отличий. Для создания запроса нужно выполнить следующие шаги:

1. Создайте новый экземпляр класса [YMKSearchManager](../../../Swift/YMKSearchManager.md) или используйте существующий.

   ```swift
   let searchManager = YMKSearch.sharedInstance().createSearchManager(with: .combined)
   ```
2. При помощи метода [YMKSearchManager.createSuggestSession()](../../../Swift/YMKSearchManager.md#createsuggestsession) создайте экземпляр [сессии геосаджеста](map_suggest.md#suggest-session).

   ```swift
   let suggestSession = searchManager.createSuggestSession()
   ```
3. Создайте экземпляр класса [YMKSuggestOptions](../../../Swift/YMKSuggestOptions.md), чтобы задать [параметры запроса геосаджестов](map_suggest.md#suggest-options).
   Пример параметров для поиска только по организациям.

   ```swift
   let suggestOptions = {
       let options = YMKSuggestOptions()
       options.suggestTypes: .biz
   }()
   ```
4. С помощью метода [YMKSearchSuggestSession.suggest(withText:window:suggestOptions:responseHandler:)](../../../Swift/YMKSearchSuggestSession.md#suggestwithtextwindowsuggestoptionsresponsehandler) создайте новый запрос геосаджестов.
   Данный пример начнет поиск возможных поисковых запросов, которые имеют префикс `"ho"`, например: `"Hotels"`, `"Hospitals"` и т.п.

   ```swift
   suggestSession.suggest(
       withText: "ho",
       window: YMKBoundingBox(
           southWest: map.visibleRegion.bottomLeft,
           northEast: map.visibleRegion.topRight
       ),
       suggestOptions: suggestOptions,
       responseHandler: handleSuggestSessionResponse
   )
   ```
5. Во время создания запроса геосаджестов, используйте следующий механизм для получения [результатов геосаджеста](map_suggest.md#suggest-results).

   ```swift
   func handleSuggestSessionResponse(response: YMKSuggestResponse?, error: Error?) {
       if let error {
           // Handle geo suggest error
           return
       }

       // Handle geo suggest response
   }
   ```

   Данная функция-обработчик передается в качестве аргумента во все методы создания запроса геосаджестов.

## Сессия геосаджеста

Сессия геосаджеста представляет собой класс [YMKSearchSuggestSession](../../../Swift/YMKSearchSuggestSession.md), при помощи которого осуществляется управление запросами.

Данный класс предоставляет следующий функционал:

- [YMKSearchSuggestSession.suggest(withText:window:suggestOptions:responseHandler:)](../../../Swift/YMKSearchSuggestSession.md#suggestwithtextwindowsuggestoptionsresponsehandler) - используется для создания нового запроса геосаджестов. Принимает следующие аргументы:

  - `text` - текст, по которому будут строиться поисковые подсказки;
  - `window` - текущее положение окна карты;
  - параметры геосаджеста и объект `SuggestListener`.
- [YMKSearchSuggestSession.reset()](../../../Swift/YMKSearchSuggestSession.md#reset) - сбрасывает текущий запрос и внутреннее состояние сессии геосаджеста.

> [!WARNING] Важно
> Как и для [сессии поиска](map_search.md#search-session), приложение должно хранить ссылку на объект сессии геосаджеста. Иначе запрос будет отменен.

## Параметры геосаджеста

При помощи параметров геосаджеста [YMKSuggestOptions](../../../Swift/YMKSuggestOptions.md) можно задать:

- `suggestTypes` - тип поисковых объектов для подбора: организации, топонимы и общественный транспорт. Данный параметр является битовой маской, поэтому можно выбрать некоторое подмножество типов.
- `userPosition` - текущая позиция пользователя. Используется для вычисления расстояния от позиции пользователя до объектов, которые могут быть предложены геосаджестом.

## Результаты геосаджеста

Для получения результатов запроса геосаджестов используется обработчик [YMKSearchSuggestSessionResponseHandler](../../../Swift/YMKSearchSuggestSessionResponseHandler.md). Он принимается в качестве аргумента при вызове метода создания запроса геосаджестов [YMKSearchSuggestSession.suggest(withText:window:suggestOptions:responseHandler:)](../../../Swift/YMKSearchSuggestSession.md#suggestwithtextwindowsuggestoptionsresponsehandler).

В результате выполнения запроса геосаджестов метод-обработчик может быть вызван со следующими опциональными аргументами:

1. `response` - оповещает об успешном завершении запроса геосаджестов, если содержит не `nil` значение. Предоставляет объект [YMKSuggestResponse](../../../Swift/YMKSuggestResponse.md), который содержит информацию о результатах запроса.
2. `error` - оповещает о завершении запроса геосаджестов с ошибкой, если не `nil`.

### Данные саджестов

Класс [YMKSuggestItem](../../../Swift/YMKSuggestItem.md) предоставляет большое количество данных, ключевые из них:

- `type` - тип саджеста: топоним, организация или общественный транспорт.
- `searchText` - текст, по которому нужно осуществить поиск если данный саджест был выбран.
- `displayText` - текст для отображения в поле для ввода запроса.
- `uri` - URI объекта.
- `distance` - дистанция до объекта.
- `action` - тип действия, которое должно быть осуществлено при выборе данного варианта: подстановка или мгновенный поиск.
- `distance` - дистанция до объекта поиска.
- `center` - положение на карте.

### Отображение саджестов

Класс [YMKSuggestItem](../../../Swift/YMKSuggestItem.md) предоставляет информацию для удобного отображения саджестов на экране:

- `title` - короткое название саджеста.
- `subtitle` - данные о местоположении, адрес.

Данные параметры имеют тип [YMKSpannableString](../../../Swift/YMKSpannableString.md). Он представляет собой строку, в которой выделены подстроки, совпадающие с текстом поискового запроса, введенного пользователем. Данные подстроки следует отрисовывать акцентными цветами.

### Обработка нажатий на саджесты

При помощи [YMKSuggestItem.action](../../../Swift/YMKSuggestItem.md#action) можно получить тип действия, которое должно быть совершено при выборе данного саджеста:

- [search](../../../Swift/YMKSuggestItemAction.md#search) - нужно выполнить новый [поисковый запрос](map_search.md#search-request). Если [YMKSuggestItem.uri](../../../Swift/YMKSuggestItem.md#uri) возвращает ненулевой URI, то нужно использовать [поиск по URI](map_search.md#uri-search). Если его нет, то нужно искать по тексту из метода [YMKSuggestItem.searchText](../../../Swift/YMKSuggestItem.md#searchtext). Используется, как правило, когда пользователь нажимает на название категории, например: "Кафе", "Ресторан", или на название организации.
- [substitute](../../../Swift/YMKSuggestItemAction.md#substitute) - заменить текст текущего поискового запроса на [YMKSuggestItem.displayText](../../../Swift/YMKSuggestItem.md#displaytext) и выполнить новый запрос геосаджеста. Обычно используется при поиске адресов: сначала подставляется название города, затем улица и т.д.

## Исходный код

С примером использования геосаджеста в MapKit SDK можно ознакомиться в приложении `MapSearch` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-ios-demo).
