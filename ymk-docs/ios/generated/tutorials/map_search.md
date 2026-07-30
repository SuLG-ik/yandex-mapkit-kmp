---
title: "Поиск"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / Руководство / Поиск"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_search.html"
---
# Поиск

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_search.html)

MapKit SDK позволяет искать различные места и объекты на карте по их названию. Например, при помощи поискового API можно получить список ресторанов поблизости, узнать о наличии заправочных станций вдоль маршрута или найти место по точному адресу. Кроме поиска по названию MapKit SDK предоставляет запросы к геокодеру. С его помощью можно определить координату объекта по его адресу или наоборот - узнать адрес по координате.

> [!WARNING] Важно
> Функционал поиска доступен в [full](../getting_started.md#add-library)-версии MapKit SDK.

## Выполнение поискового запроса

Рассмотрим общий алгоритм выполнения поискового запроса с помощью MapKit SDK:

1. Создайте экземпляр класса [YMKSearchManager](../../../Swift/YMKSearchManager.md), он является входной точкой поискового API MapKit SDK.

   ```swift
   let searchManager = YMKSearch.sharedInstance().createSearchManager(with: .combined)
   ```

   При создании [YMKSearchManager](../../../Swift/YMKSearchManager.md) укажите его тип [YMKSearchManagerType](../../../Swift/YMKSearchManagerType.md), который определяет режим работы: офлайн, онлайн или смешанный.
2. Определите какой [тип поискового запроса](map_search.md#search-request-types) следует использовать в вашем случае.
   Например, поиск по тексту в некоторой геометрии - метод [YMKSearchManager.submit(withText:geometry:searchOptions:responseHandler:)](../../../Swift/YMKSearchManager.md#submitwithtextgeometrysearchoptionsresponsehandler).
3. Создайте экземпляр класса [YMKSearchOptions](../../../Swift/YMKSearchOptions.md), чтобы задать [параметры поиска](map_search.md#search-options) запроса.
   Пример параметров для поиска только по организациям:

   ```swift
   let searchOptions: YMKSearchOptions = {
       let options = YMKSearchOptions()
       options.searchTypes = .biz
       options.resultPageSize = 32
       return options
   }()
   ```
4. Создайте новую [сессию поиска](map_search.md#search-session) с помощью одного из методов класса [YMKSearchManager](../../../Swift/YMKSearchManager.md), который соответствует нужному типу поискового запроса.
   Пример поиска мест, в которых можно поесть, например, кафе, рестораны и т.д.

   ```swift
   let session = searchManager.submit(
       withText: "where to eat",
       geometry: YMKVisibleRegionUtils.toPolygon(with: map.visibleRegion),
       searchOptions: searchOptions,
       responseHandler: handleSearchSessionResponse
   )
   ```
5. Во время создания поисковой сессии, используйте следующий механизм для получения [результатов поискового запроса](map_search.md#search-result).
   Создайте обработчик типа [YMKSearchSessionResponseHandler](../../../Swift/YMKSearchSessionResponseHandler.md):

   ```swift
   private func handleSearchSessionResponse(response: YMKSearchResponse?, error: Error?) {
       if let error {
           // Handle search error
           return
       }

       // Handle search response
   }
   ```

   Данная функция-обработчик передается в качестве аргумента во все методы создания поисковой сессии.
   Передавайте такой объект в качестве аргумента во все методы создания поисковой сессии.

## Типы поисковых запросов

MapKit SDK предоставляет несколько типов поисковых запросов, каждый из которых реализует различные пользовательские сценарии поиска. Запросы делятся на следующие группы:

- [текстовый](map_search.md#text-search);
- [обратное геокодирование](map_search.md#reverse-geocoding);
- [запрос по URI](map_search.md#uri-search).

Рассмотрим основные особенности и различия каждого типа поисковых запросов.

### Текстовый поиск

Данный поиск осуществляется по тексту, который вводится пользователем.

Поиск по тексту обладает большой вариативностью. В зависимости от введенного текста можно искать, например, по:

- названию организации;
- адресу;
- названию рубрики ("Рестораны", "Фитнес");
- месту досуга ("Где погулять вечером");
- координате, например, (59.935493, 30.327392).

Для создания поисковой сессии текстового поиска используется два вида методов:

1. [YMKSearchManager.submit(withText:geometry:searchOptions:responseHandler:)](../../../Swift/YMKSearchManager.md#submitwithtextgeometrysearchoptionsresponsehandler) - осуществляет поиск объектов по тексту запроса, которые ограничены некоторой геометрией на карте: вдоль полилинии, рядом с точкой, внутри boundingBox или полигона.
2. [YMKSearchManager.submit(withText:polyline:geometry:searchOptions:responseHandler:)](../../../Swift/YMKSearchManager.md#submitwithtextpolylinegeometrysearchoptionsresponsehandler) - используется для поиска вдоль полилинии, но внутри заданного boundingBox или полигона. Данный метод полезен при осуществлении поиска вдоль некоторого маршрута внутри видимой области карты. Например, поиск заправочных станций, которые находятся на текущем маршруте.

При выполнении поиска вдоль маршрута MapKit SDK сортирует поисковые результаты в зависимости от расстояния найденных объектов до переданной полилинии и возвращает ближайшие.

### Обратное геокодирование

Обратное геокодирование решает следующую задачу - как по координате, которую указал пользователь, получить адрес или название расположенного там объекта.

Для создания поисковой сессии обратного поиска используется метод [YMKSearchManager.submit(with:zoom:searchOptions:responseHandler:)](../../../Swift/YMKSearchManager.md#submitwithzoomsearchoptionsresponsehandler), со следующими аргументами:

- `point` - точка, по координате которой будет происходить поиск.
- `zoom` - значение текущего уровня масштаба карты, оно используется для отбрасывания слишком малых объектов на малых зумах.

### URI поиск

Некоторые гео-объекты карты MapKit предоставляют строковый URI-идентификатор. Поиск по URI позволяет осуществить поиск по таким объектам. Получить URI можно при помощи [URI-метаданных](map_search.md#uri-object-metadata) гео-объекта.

Для создания сессии поиска по URI существует два вида методов:

1. [YMKSearchManager.resolveURI(withUri:searchOptions:responseHandler:)](../../../Swift/YMKSearchManager.md#resolveuriwithurisearchoptionsresponsehandler) - используется для поиска гео-объектов по их URI, который был получен с помощью [URI-метаданных](map_search.md#uri-object-metadata).
2. [YMKSearchManager.searchByURI(withUri:searchOptions:responseHandler:)](../../../Swift/YMKSearchManager.md#searchbyuriwithurisearchoptionsresponsehandler) - позволяет найти несколько объектов по URI. Используется для осуществления поиска по геосаджесту с использованием URI.

## Параметры поиска

Каждый из типов поисковых запросов поддерживает передачу аргумента [YMKSearchOptions](../../../Swift/YMKSearchOptions.md) для определения параметров поиска.

Существует следующие виды параметров поиска:

- `searchTypes` - тип объектов для поиска: топонимы, компании или и то, и другое.
- `resultPageSize` - количество результатов на одну страницу поиска.
- `userPosition` - используется для вычисления дистанции от пользователя до объектов результата поиска.
- `geometry` - возвращение геометрии для найденного объекта (используется при поиске топонимов).
- `disableSpellingCorrection` - включает исправление ошибок в тексте поискового запроса.
- `filters` - задает параметры фильтрации для поискового запроса.

> [!WARNING] Важно
> В зависимости от [типа поискового запроса](map_search.md#search-types) некоторые параметры поиска могут быть **проигнорированы**.
>
>
> Чтобы узнать какие параметры поиска поддерживаются для конкретных типов поисковых запросов, смотрите документацию поисковых методов класса [YMKSearchManager](../../../Swift/YMKSearchManager.md).

## Сессия поиска

Поисковый запрос в MapKit SDK реализован в виде асинхронной операции, он может потребовать выполнения сетевого запроса, например, во время онлайн поиска. Каждый из методов создания поискового запроса класса [YMKSearchManager](../../../Swift/YMKSearchManager.md) возвращает объект сессии поиска [YMKSearchSession](../../../Swift/YMKSearchSession.md), он управляет состоянием поискового запроса.

Пример создания поисковой сессии для поиска ресторанов на карте:

```swift
searchSession = searchManager.submit(
    withText: "Restaurant",
    geometry: YMKVisibleRegionUtils.toPolygon(with: map.mapRegion),
    searchOptions: {
        let options = YMKSearchOptions()
        options.searchTypes = .biz
        return options
    }(),
    responseHandler: handleSearchSessionResponse
)
```

> [!WARNING] Важно
> Объект сессии [YMKSearchSession](../../../Swift/YMKSearchSession.md) должен хранится на стороне клиентского приложения. Иначе поисковый запрос может быть автоматически отменен.

Класс [YMKSearchSession](../../../Swift/YMKSearchSession.md) поддерживает большое количество операций по управлению поисковым запросом, например: отмена текущего запроса, получение следующей страницы с результатами, включение сортировки результатов по дистанции до конкретной геометрии и т.д. С помощью функционала повторного выполнения запроса можно изменить некоторые параметры первоначального запроса, а затем выполнить повторный запрос.

Пример использования созданного объекта [YMKSearchSession](../../../Swift/YMKSearchSession.md) для создания повторного запроса с другой геометрией для поиска:

```swift
private var searchSession: YMKSearchSession?

func resubmitAfterMove() {
    let geometry = YMKVisibleRegionUtils.toPolygon(with: map.visibleRegion)
    searchSession?.setSearchAreaWithArea(geometry)
    searchSession?.resubmit(responseHandler: handleSearchSessionResponse)
}
```

Данный метод можно использовать, например, при изменении положения камеры после свайпа карты.

## Результаты поиска

Для получения результатов поискового запроса используется обработчик [YMKSearchSessionResponseHandler](../../../Swift/YMKSearchSessionResponseHandler.md). Он принимается в качестве аргумента при вызове метода создания поискового запроса [YMKSearchManager.submit(withText:geometry:searchOptions:responseHandler:)](../../../Swift/YMKSearchManager.md#submitwithtextgeometrysearchoptionsresponsehandler).

В результате выполнения поискового запроса метод-обработчик может быть вызван со следующими опциональными аргументами:

- `response` - оповещает об успешном завершении поискового запроса, если содержит не `nil` значение. Предоставляет объект [YMKSearchResponse](../../../Swift/YMKSearchResponse.md), который содержит информацию о результатах запроса.
- `error` - оповещает о завершении поискового запроса с ошибкой, если не `nil`.

При успешном выполнении запроса можно получить объект [YMKSearchResponse](../../../Swift/YMKSearchResponse.md), он предоставляет информацию о:

- [коллекции гео-объектов](map_search.md#geo-object-collection);
- [метаданных поискового запроса](map_search.md#request-metadata);
- наличии или отсутствии офлайн запроса.

Рассмотрим более детально, из чего состоят данные об успешном выполнении запроса.

### Коллекция гео-объектов

Метод [YMKSearchResponse.collection](../../../Swift/YMKSearchResponse.md#collection) позволяет получить коллекцию найденных объектов. При помощи метода [YMKGeoObjectCollection.children](../../../Swift/YMKGeoObjectCollection.md#children) можно получить список найденных [гео-объектов](map_search.md#search-geo-object).

```swift
private func handleSearchSessionResponse(response: YMKSearchResponse?, error: Error?) {
    if let error {
        onSearchError(error: error)
        return
    }

    guard let response,
          let boundingBox = response.metadata.boundingBox else {
        return
    }

    let geoObjects = response.collection.children.compactMap { $0.obj }

    // Process geoObjects collection
}
```

### Гео-объекты

Класс [YMKGeoObject](../../../Swift/YMKGeoObject.md) - это сущность MapKit SDK, которая предоставляет информацию об объектах на карте. Гео-объектом может являться организация, здание или какой-нибудь географический объект, например, страна, город или море.

Гео-объекты делятся на два типа:

1. Организации - например, рестораны, салоны красоты, государственные учреждения, школы, больницы, магазины, отели и другие компании.
2. Топонимы - строения, города, страны, различные географические объекты.

В контексте поискового API гео-объекты используются в качестве результата поиска. Наиболее используемыми параметрами гео-объектов во время поиска являются:

- `name` - название объекта.
- `geometry` - геометрия, содержит координату организации или геометрию топонима.
- `metadataContainer` - используется для расширения базового гео-объекта дополнительными метаданными.

У разных типов гео-объектов имеются разные виды метаданных.

#### YMKUriObjectMetadata

При помощи типа [YMKUriObjectMetadata](../../../Swift/YMKUriObjectMetadata.md) можно получить уникальный идентификатор для гео-объекта.

```swift
let uri = (
    geoObject.metadataContainer.getItemOf(YMKUriObjectMetadata.self) as? YMKUriObjectMetadata
)?.uris.first
```

С помощью URI можно организовать функционал закладок в приложении. Пользователь выбирает понравившееся место (гео-объект), затем приложение сохраняет строковый идентификатор данного гео-объекта. Когда пользователь захочет вернуться к сохраненному месту, с помощью [поиска по URI](map_search.md#uri-search) можно получить гео-объект и отобразить его на карте.

#### YMKSearchBusinessObjectMetadata

Класс [YMKSearchBusinessObjectMetadata](../../../Swift/YMKSearchBusinessObjectMetadata.md) содержит большое количество методов с разнообразной информацией о организации. [YMKSearchBusinessObjectMetadata](../../../Swift/YMKSearchBusinessObjectMetadata.md) можно получить только если данный гео-объект является организацией.

```swift
let metadata = (
    geoObject.metadataContainer
        .getItemOf(YMKSearchBusinessObjectMetadata.self) as? YMKSearchBusinessObjectMetadata
)
if let metadata {
    // Geo object is a business organization
} else {
    // Not an organization
}
```

Ключевыми данными класса [YMKSearchBusinessObjectMetadata](../../../Swift/YMKSearchBusinessObjectMetadata.md) являются:

- `name` - название организации;
- `address` - адрес организации;
- `phones` - список номеров организации;
- `workingHours` - часы работы организации;
- `features` - список особенностей организации, например, наличие Wi-Fi или возможность оплатить картой.

#### YMKSearchToponymObjectMetadata

С помощью класса [YMKSearchToponymObjectMetadata](../../../Swift/YMKSearchToponymObjectMetadata.md) можно получить дополнительную информацию о топониме: адрес, название и т.д. [YMKSearchToponymObjectMetadata](../../../Swift/YMKSearchToponymObjectMetadata.md) можно получить только если данный гео-объект является топонимом.

### Метаданные запроса

Метаданные запроса представлены классом [YMKSearchMetadata](../../../Swift/YMKSearchMetadata.md), они содержат дополнительную информацию о поисковом запросе.

Общая информация:

- `found` - примерное количество найденных объектов.
- `displayType` - тип отображения: `single` - результат не является частью какой-либо группы, скорее всего не нужно выполнять перезапрос при перемещении карты, `multiple` - результат может быть частью группы, имеет смысл делать перезапрос при перемещении карты.
- `boundingBox` - bounding box объектов-результатов на карте. Можно переместить карту в данную геометрию, чтобы показать результаты поиска на карте.
- `sort` - тип сортировки объектов в выдаче, например, по дистанции от пользователя.
- `toponym` - результат обратного геокодинга, если он был применен.
- `requestText` - текст запроса, который был введен пользователем при поиске.
- `correctedRequestText` - это `requestText`, после примененной автокоррекции текста.
- `requestBoundingBox` - bounding-box карты, который был передан во время создания запроса.

Кроме общей информации метаданные запроса содержат дополнительную информацию, которая зависит от типа поискового запроса, был ли это поиск организаций или топонимов:

- `toponym` - содержит гео-объект с результатом поиска топонимов.
- `toponymResultMetadata` - дополнительная информация о поисковом запросе топонимов.
- `businessResultMetadata` - дополнительная информация о поисковом запросе организаций.

Рассмотрим более подробно, в чем состоит отличия между `toponymResultMetadata` и `businessResultMetadata` метаданными.

#### YMKSearchToponymResultMetadata

Представлен классом [YMKSearchToponymResultMetadata](../../../Swift/YMKSearchToponymResultMetadata.md), предоставляет данные о:

- количестве найденных топонимов;
- режиме и точности поиска;
- координате, по которой был осуществлен [обратный геокодинг](map_search.md#reverse-geocoding).

#### YMKSearchBusinessResultMetadata

Класс [YMKSearchBusinessResultMetadata](../../../Swift/YMKSearchBusinessResultMetadata.md) предоставляет данные о наличии:

- поисковых категорий в результате поиска;
- поисковых цепочек - список не пустой, если по запросу была найдена сетевая организация;
- поисковых фильтров.

## Исходный код

С примером использования функционала поискового API можно ознакомиться в приложении `MapSearch` в нашем [GitHub репозитории](https://github.com/yandex/mapkit-ios-demo).
