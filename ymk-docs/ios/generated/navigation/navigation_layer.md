---
title: "Слой навигации"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / NaviKit SDK / Слой навигации"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/navigation/navigation_layer.html"
---
# Слой навигации

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/navigation/navigation_layer.html)

[YMKNavigationLayer](../../../Swift/YMKNavigationLayer.md) в NaviKit SDK представляет собой дополнительный слой на карте, который включает в себя пользовательский интерфейс (маршруты, точки маршрута, метка пользователя и баллуны) и логику их отображения. Кроме того, [YMKNavigationLayer](../../../Swift/YMKNavigationLayer.md) предоставляет API камеры, которое позволяет изменять положение карты на основе различных навигационных сценариев, например: слежение за меткой пользователя, обзор всего маршрута и свободный режим.

## Создание

Используйте метод [YMKNavigationLayerFactory.createNavigationLayer(with:roadEventsLayer:styleProvider:navigation:)](../../../Swift/YMKNavigationLayerFactory.md#createnavigationlayerwithroadeventslayerstyleproviderstyleprovidernavigation) для создания нового экземпляра навигационного слоя.

```swift
let navigationLayer = YMKNavigationLayerFactory.createNavigationLayer(
    with: mapWindow,
    roadEventsLayer: roadEventsLayer,
    styleProvider: navigationStyleProvider,
    navigation: navigation
)
```

Процесс создания `navigation` - [тут](routes_building.md#navigation-create).

После создания [YMKNavigationLayer](../../../Swift/YMKNavigationLayer.md) при включенном [отслеживании локации](guidance.md#location-tracking) у [YMKNavigation](../../../Swift/YMKNavigation.md), на карте отобразиться метка с текущим местоположением пользователя.

## YMKNavigationStyleProvider

Отображение UI-элементов на навигационном слое карты определяется при помощи интерфейса [YMKNavigationStyleProvider](../../../Swift/YMKNavigationStyleProvider.md).

С помощью реализации [YMKNavigationStyleProvider](../../../Swift/YMKNavigationStyleProvider.md) можно настроить стили отображения отдельных UI-элементов с помощью реализации нужного провайдера стилей:

- Полилинии маршрута - [YMKNavigationRouteViewStyleProvider](../../../Swift/YMKNavigationRouteViewStyleProvider.md).
- Баллуны альтернатив и маневров - [YMKNavigationBalloonImageProvider](../../../Swift/YMKNavigationBalloonImageProvider.md).
- Точки маршрута - [YMKNavigationRequestPointStyleProvider](../../../Swift/YMKNavigationRequestPointStyleProvider.md).
- Модель пользовательской метки - [YMKNavigationUserPlacemarkStyleProvider](../../../Swift/YMKNavigationUserPlacemarkStyleProvider.md).
- Метки на маршруте - [YMKNavigationRoutePinsStyleProvider](../../../Swift/YMKNavigationRoutePinsStyleProvider.md), включает в себя метки светофоров и предупреждения на маршруте.

Класс `AutomotiveNavigationStyleProvider` - это готовая реализация итерфейса [YMKNavigationStyleProvider](../../../Swift/YMKNavigationStyleProvider.md), которая содержит UI-элементы в фирменном стиле Яндекс Карт. Она поставляется в виде [отдельной зависимости](getting_started.md#add-dependencies).

Для того, чтобы изменить некоторые стили UI-элементов, можно реализовать новый [YMKNavigationStyleProvider](../../../Swift/YMKNavigationStyleProvider.md), используя `AutomotiveNavigationStyleProvider` в качестве делегата:

```swift
class NavigationStyleProviderImpl: NSObject, YMKNavigationStyleProvider {

    private let defaultNavigationStyleProvider = AutomotiveNavigationStyleProvider()

    // Default style provider implementation
    override func balloonImageProvider() = styleProvider.balloonImageProvider()
    override func requestPointStyleProvider() = styleProvider.requestPointStyleProvider()
    override func userPlacemarkStyleProvider() = styleProvider.userPlacemarkStyleProvider()
    override func routePinsStyleProvider() = styleProvider.routePinsStyleProvider()

    func routeViewStyleProvider() -> YMKNavigationRouteViewStyleProvider {
        routeViewStyleProviderImpl
    }

    func balloonImageProvider() -> YMKNavigationBalloonImageProvider {
        defaultNavigationStyleProvider.balloonImageProvider()
    }

    func requestPointStyleProvider() -> YMKNavigationRequestPointStyleProvider {
        defaultNavigationStyleProvider.requestPointStyleProvider()
    }

    func userPlacemarkStyleProvider() -> YMKNavigationUserPlacemarkStyleProvider {
        defaultNavigationStyleProvider.userPlacemarkStyleProvider()
    }

    func routePinsStyleProvider() -> YMKNavigationRoutePinsStyleProvider {
        defaultNavigationStyleProvider.routePinsStyleProvider()
    }

    private var routeViewStyleProviderImpl: RouteViewStyleProviderImpl!

    private class RouteViewStyleProviderImpl: YMKNavigationRouteViewStyleProvider {

        init(defaultNavigationStyleProvider: YMKNavigationStyleProvider) {
            routeViewStyleProvider = defaultNavigationStyleProvider.routeViewStyleProvider()
        }

        private let routeViewStyleProvider: YMKNavigationRouteViewStyleProvider

        func provideRouteStyle(
            with flags: YMKDrivingFlags,
            isSelected: Bool,
            isNightMode: Bool,
            routeStyle: YMKNavigationRouteStyle
        ) {
            routeViewStyleProvider
                .provideRouteStyle(
                    with: flags,
                    isSelected: isSelected,
                    isNightMode: isNightMode,
                    routeStyle: routeStyle
                )
        }

        // Implementations of other methods through routeViewStyleProvider ...
    }
}
```

Таким образом, можно реализовать отдельный провайдер стилей для линии маршрута [YMKNavigationRouteViewStyleProvider](../../../Swift/YMKNavigationRouteViewStyleProvider.md) и изменить стиль отображения пробок на маршрутах. Для остальных UI-элементов используется стандартная реализация с помощью делегата `AutomotiveNavigationStyleProvider`.

Стили из [YMKNavigationStyleProvider](../../../Swift/YMKNavigationStyleProvider.md) обновляются на каждый вызов [YMKNavigationLayer.refreshStyle()](../../../Swift/YMKNavigationLayer.md#refreshstyle).

Подробнее с примером реализации [YMKNavigationStyleProvider](../../../Swift/YMKNavigationStyleProvider.md) можно ознакомиться в [демо-приложении](overview.md#demo-app).

## Маршруты

Слой навигации отвечает за отображение маршрутов, которые хранятся в [YMKNavigation](../../../Swift/YMKNavigation.md).

![](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/navigation/navigation_layer/navigation_layer_routes.png)

### Отображение маршрутов

Слой навигации способен отображать маршруты на карте. Отрисовка маршрутов происходит по следующему сценарию:

1. При создании [YMKNavigationLayer](../../../Swift/YMKNavigationLayer.md) в него передается объект [YMKNavigation](../../../Swift/YMKNavigation.md), с помощью которого слой подписывается на состояние навигации и отслеживает изменение маршрутов в нем. Например, после [запроса маршрутов](routes_building.md#request-routes) с помощью обработчика событий [YMKNavigationListener.onRoutesRequested(with:)](../../../Swift/YMKNavigationListener.md#onroutesrequestedwith) навигация сообщает, что маршрут был запрошен и слой переводит камеру в режим обзора маршрутов.
2. Затем навигация сообщает об успешном получении маршрутов, происходит вызов метода [YMKNavigationListener.onRoutesBuilt()](../../../Swift/YMKNavigationListener.md#onroutesbuilt) и слой отображает маршруты на карте по обновленным данным.

Таким образом, слой навигации отлеживает состояние маршрутов внутри [YMKNavigation](../../../Swift/YMKNavigation.md), отображает их на карте и при необходимости перерисовывает.

### Мгновенное ведение

Чтобы пропустить этап сравнения альтернативных маршрутов в режиме обзора маршрутов и начать ведение по первому найденному маршруту следует [начинать ведение](guidance.md#guidance-start-stop) сразу же после получения результатов [запроса маршрутов](routes_building.md#request-routes) в методе обработчике события [YMKNavigationListener.onRoutesBuilt()](../../../Swift/YMKNavigationListener.md#onroutesbuilt).

При этом, в момент когда маршруты уже были запрошены, но ведение еще не началось, можно заметить "промаргивание" UI-маршрутов. Чтобы этого избежать нужно скрыть UI навигационного слоя до начала ведения по маршруту. Например, используя метод [YMKNavigationLayer.isVisible](../../../Swift/YMKNavigationLayer.md#isisvisible), или спрятать линии маршрута используя переопределение стилей через [NavigationStyleProvider](navigation_layer.md#style-provider).

### Режим отображения

[YMKNavigationLayer.mode](../../../Swift/YMKNavigationLayer.md#mode) позволяет узнать в каком режиме в данный момент находится слой навигации:

- [route_selection](../../../Swift/YMKNavigationLayerMode.md#routeselection) - режим обзора.
- [guidance](../../../Swift/YMKNavigationLayerMode.md#guidance) - режим ведения.

### Текущий маршрут

[YMKNavigationLayer](../../../Swift/YMKNavigationLayer.md) хранит информацию о текущем выбранном маршруте. При помощи вызова [YMKNavigationLayer.selectRoute(withRoute:)](../../../Swift/YMKNavigationLayer.md#selectroutewithroute) можно изменить текущий выбранный маршрут в режиме обзора.

Пример назначения текущего маршрута:

```swift
class RouteViewListener: NSObject, YMKRouteViewListener {
    func onRouteViewTap(withRoute: YMKRouteView) {
        switch navigationLayer.routesSource {
        case .navigation:
            navigationLayer.selectRoute(withRoute: routeView)
        case .guidance:
            navigationLayer.navigation.switchToRoute(with: routeView.route)
        }
    }

    func onRouteViewsChanged() {
        guard navigationLayer.selectedRoute() == nil,
              let route = navigationLayer.routes.first else {
            return
        }
        navigationLayer.selectRoute(withRoute: route)
    }
}

let routeViewListener = RouteViewListener()
navigationLayer.addRouteViewListener(with: routeViewListener)
```

Для подписки на состояние маршрутов на карте навигационного слоя используется интерфейс [YMKRouteViewListener](../../../Swift/YMKRouteViewListener.md).

- [YMKRouteViewListener.onRouteViewsChanged()](../../../Swift/YMKRouteViewListener.md#onrouteviewschanged) сообщает об изменении маршрутов в [YMKNavigationLayer](../../../Swift/YMKNavigationLayer.md), если выбранный маршрут отсутствует, то будет выбран самый быстрый (первый) маршрут.
- [YMKRouteViewListener.onRouteViewTap(withRoute:)](../../../Swift/YMKRouteViewListener.md#onrouteviewtapwithroute) обрабатывает событие нажатия на линию маршрута на карте.

> [!NOTE] Примечание
> По умолчанию после [запроса маршрутов](routes_building.md#request-routes) через [YMKNavigation](../../../Swift/YMKNavigation.md) текущий маршрут в навигационном слое отсутствует, поэтому его нужно назначить вручную, например, с помощью [YMKRouteViewListener.onRouteViewsChanged()](../../../Swift/YMKRouteViewListener.md#onrouteviewschanged).

## Точки маршрута

Слой навигации отвечает за отображение *from*, *to* и *via* точек во время ведения и обзора маршрута.

Для подписки на изменение точек и их нажатия используется интерфейс [YMKRequestPointListener](../../../Swift/YMKRequestPointListener.md).

![](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/navigation/navigation_layer/route_points.png)

## Пользовательская метка

Пользовательской меткой называют модель на карте, которая отвечает за отображение текущей локации пользователя и направления его движения. Модель состоит из файла `.OBJ` и текстуры в формате `.PNG`.

![](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/navigation/navigation_layer/placemark.png)

## Баллуны

Баллуны представляют собой UI-элементы на карте с надписью. Существует несколько видов баллунов:

- *баллун маневра* во время ведения указывает на положение следующего маневра на маршруте;
- *баллун альтернативы* показывает информацию о маршруте во время обзора, содержит информацию о сравнении текущего и выбранного маршрута.

![](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/navigation/navigation_layer/balloons_overview.png) ![](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/navigation/navigation_layer/balloons_guidance.png)

Для подписки на события, связанные с баллунами, используется интерфейс [YMKBalloonViewListener](../../../Swift/YMKBalloonViewListener.md).

## Камера

Управление камерой происходит с помощью объета [YMKCamera](../../../Swift/YMKCamera.md), который можно получить используя вызов [YMKNavigationLayer.camera](../../../Swift/YMKNavigationLayer.md#camera).

Переключение режимов камеры происходит с помощью метода [YMKCamera.setCameraModeWith(_:animation:)](../../../Swift/YMKCamera.md#setcameramodewith_animation). Поддерживаются следующие типы режимов:

- Following - режим слежения камеры за меткой пользователя во время ведения.
- Overview - обзор запрошенных маршрутов.
- Free - режим по умолчанию.

По умолчанию [YMKCamera](../../../Swift/YMKCamera.md) имеет полный контроль над картой и автоматически изменяет состояние камеры. При реализации специальных режимов камеры может быть полезно ограничить контроль камеры.

При помощи методов [YMKCamera](../../../Swift/YMKCamera.md) и [YMKNavigationLayer](../../../Swift/YMKNavigationLayer.md) можно изменять следующие параметры камеры:

- автоматическое приближение камеры;
- автоматический поворот камеры;
- автоматическое переключение режимов камеры;
- параметр корректировки приближения во время ведения;
- включение/отключение 2D режима камеры.

При создании комплексного интерфейса поверх карты UI-элементы могут перекрывать некоторые области карты. Для того, чтобы это избежать существует возможность настроить параметры видимой области карты.

Поддержаны следующие настройки видимой области карты:

- [YMKCamera.setOverviewRectWith(_:animation:)](../../../Swift/YMKCamera.md#setoverviewrectwith_animation) - определяет область карты, в пределах которой будут отображены маршруты в режиме обзора.
- [YMKCamera.setExtraOverviewPointsWith(_:)](../../../Swift/YMKCamera.md#setextraoverviewpointswith_) - задает список точек, которые должны быть видны на карте при переходе в режим обзора.

# Слой дорожных событий

Дорожные события - это информация о различных событиях, которые могут происходить на дорогах. Это могут быть сведения о дорожных происшествиях, ограничениях движения, ремонтных работах, камерах контроля скорости и т.д. Полный список доступных дорожных событий можно найти в перечислении [YMKRoadEventsEventTag](../../../Swift/YMKRoadEventsEventTag.md).

Слой дорожных событий способен отображать дорожные события на маршруте в виде иконок.

![](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/navigation/road_events_layer/road_events_in_overview.png) ![](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/navigation/road_events_layer/road_events_in_guidance.png)

## YMKRoadEventsLayerStyleProvider

Для кастомизации отображения дорожных событий используется интерфейс [YMKRoadEventsLayerStyleProvider](../../../Swift/YMKRoadEventsLayerStyleProvider.md).

Существует готовая реализация [YMKRoadEventsLayerStyleProvider](../../../Swift/YMKRoadEventsLayerStyleProvider.md), которая предоставляет стили и ресурсы иконок дорожных событий в фирменном стиле Яндекс Карт. Подробнее о подключении данной зависимости можно почитать [по ссылке](getting_started.md#add-dependencies).
