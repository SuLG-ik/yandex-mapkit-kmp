---
title: "Слой навигации"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / NaviKit SDK / Слой навигации"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/navigation/navigation_layer.html"
---
# Слой навигации

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/navigation/navigation_layer.html)

[NavigationLayer](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md) в NaviKit SDK представляет собой дополнительный слой на карте, который включает в себя пользовательский интерфейс (маршруты, точки маршрута, метка пользователя и баллуны) и логику их отображения. Кроме того, [NavigationLayer](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md) предоставляет API камеры, которое позволяет изменять положение карты на основе различных навигационных сценариев, например: слежение за меткой пользователя, обзор всего маршрута и свободный режим.

## Создание

Используйте метод [NavigationLayerFactory.createNavigationLayer](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayerFactory.md#createnavigationlayermapwindow-styleprovider-navigationstyleprovider-navigation) для создания нового экземпляра навигационного слоя.

```kotlin
val navigationLayer = NavigationLayerFactory.createNavigationLayer(
    mapWindow,
    roadEventsLayer,
    navigationStyleProvider,
    navigation
)
```

Процесс создания `navigation` - [тут](routes_building.md#navigation-create).

После создания [NavigationLayer](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md) при включенном [отслеживании локации](guidance.md#location-tracking) у [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md), на карте отобразиться метка с текущим местоположением пользователя.

## NavigationStyleProvider

Отображение UI-элементов на навигационном слое карты определяется при помощи интерфейса [NavigationStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/NavigationStyleProvider.md).

С помощью реализации [NavigationStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/NavigationStyleProvider.md) можно настроить стили отображения отдельных UI-элементов с помощью реализации нужного провайдера стилей:

- Полилинии маршрута - [RouteViewStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/RouteViewStyleProvider.md).
- Баллуны альтернатив и маневров - [BalloonImageProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/BalloonImageProvider.md).
- Точки маршрута - [RequestPointStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/RequestPointStyleProvider.md).
- Модель пользовательской метки - [UserPlacemarkStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/UserPlacemarkStyleProvider.md).
- Метки на маршруте - [RoutePinsStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/RoutePinsStyleProvider.md), включает в себя метки светофоров и предупреждения на маршруте.

Класс `AutomotiveNavigationStyleProvider` - это готовая реализация итерфейса [NavigationStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/NavigationStyleProvider.md), которая содержит UI-элементы в фирменном стиле Яндекс Карт. Она поставляется в виде [отдельной зависимости](getting_started.md#add-dependencies).

Для того, чтобы изменить некоторые стили UI-элементов, можно реализовать новый [NavigationStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/NavigationStyleProvider.md), используя `AutomotiveNavigationStyleProvider` в качестве делегата:

```kotlin
class NavigationStyleProviderImpl(private val context: Context) : NavigationStyleProvider {

    private val styleProvider = AutomotiveNavigationStyleProvider(context)

    // Default style provider implementation
    override fun balloonImageProvider() = styleProvider.balloonImageProvider()
    override fun requestPointStyleProvider() = styleProvider.requestPointStyleProvider()
    override fun userPlacemarkStyleProvider() = styleProvider.userPlacemarkStyleProvider()
    override fun routePinsStyleProvider() = styleProvider.routePinsStyleProvider()

    // Override the route style logic
    override fun routeViewStyleProvider(): RouteViewStyleProvider {
        return object : RouteViewStyleProvider {

            private val routeViewStyleProvider = styleProvider.routeViewStyleProvider()

            override fun provideRouteStyle(
                flags: Flags,
                isSelected: Boolean,
                isNightMode: Boolean,
                routeStyle: RouteStyle
            ) {
                routeViewStyleProvider.provideRouteStyle(flags, isSelected, isNightMode, routeStyle)
                // Only the current route will display traffic jams
                routeStyle.setShowJams(isSelected)
            }

            // Implementations of other methods through routeViewStyleProvider ...
        }
    }
}
```

Таким образом, можно реализовать отдельный провайдер стилей для линии маршрута [RouteViewStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/RouteViewStyleProvider.md) и изменить стиль отображения пробок на маршрутах. Для остальных UI-элементов используется стандартная реализация с помощью делегата `AutomotiveNavigationStyleProvider`.

Стили из [NavigationStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/NavigationStyleProvider.md) обновляются на каждый вызов [NavigationLayer.refreshStyle](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md#refreshstyle).

Подробнее с примером реализации [NavigationStyleProvider](../../../com/yandex/mapkit/navigation/automotive/layer/styling/NavigationStyleProvider.md) можно ознакомиться в [демо-приложении](overview.md#demo-app).

## Маршруты

Слой навигации отвечает за отображение маршрутов, которые хранятся в [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md).

![](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/navigation/navigation_layer/navigation_layer_routes.png)

### Отображение маршрутов

Слой навигации способен отображать маршруты на карте. Отрисовка маршрутов происходит по следующему сценарию:

1. При создании [NavigationLayer](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md) в него передается объект [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md), с помощью которого слой подписывается на состояние навигации и отслеживает изменение маршрутов в нем. Например, после [запроса маршрутов](routes_building.md#request-routes) с помощью обработчика событий [NavigationListener.onRoutesRequested](../../../com/yandex/mapkit/navigation/automotive/NavigationListener.md#onroutesrequestedjavautillistrequestpoint) навигация сообщает, что маршрут был запрошен и слой переводит камеру в режим обзора маршрутов.
2. Затем навигация сообщает об успешном получении маршрутов, происходит вызов метода [NavigationListener.onRoutesBuilt](../../../com/yandex/mapkit/navigation/automotive/NavigationListener.md#onroutesbuilt) и слой отображает маршруты на карте по обновленным данным.

Таким образом, слой навигации отлеживает состояние маршрутов внутри [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md), отображает их на карте и при необходимости перерисовывает.

### Мгновенное ведение

Чтобы пропустить этап сравнения альтернативных маршрутов в режиме обзора маршрутов и начать ведение по первому найденному маршруту следует [начинать ведение](guidance.md#guidance-start-stop) сразу же после получения результатов [запроса маршрутов](routes_building.md#request-routes) в методе обработчике события [NavigationListener.onRoutesBuilt](../../../com/yandex/mapkit/navigation/automotive/NavigationListener.md#onroutesbuilt).

При этом, в момент когда маршруты уже были запрошены, но ведение еще не началось, можно заметить "промаргивание" UI-маршрутов. Чтобы этого избежать нужно скрыть UI навигационного слоя до начала ведения по маршруту. Например, используя метод [NavigationLayer.setIsVisible](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md#setisvisibleboolean), или спрятать линии маршрута используя переопределение стилей через [NavigationStyleProvider](navigation_layer.md#style-provider).

### Режим отображения

[NavigationLayer.getMode](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md#getmode) позволяет узнать в каком режиме в данный момент находится слой навигации:

- [ROUTE_SELECTION](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayerMode.md#route_selection) - режим обзора.
- [GUIDANCE](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayerMode.md#guidance) - режим ведения.

### Текущий маршрут

[NavigationLayer](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md) хранит информацию о текущем выбранном маршруте. При помощи вызова [NavigationLayer.selectRoute](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md#selectrouterouteview) можно изменить текущий выбранный маршрут в режиме обзора.

Пример назначения текущего маршрута:

```kotlin
val routeViewListener = object : RouteViewListener {
    override fun onRouteViewTap(routeView: RouteView) {
        when (navigationLayer.routesSource) {
            RoutesSource.NAVIGATION -> navigationLayer.selectRoute(routeView)
            RoutesSource.GUIDANCE -> navigationLayer.navigation.guidance.switchToRoute(routeView.route)
        }
    }

    override fun onRouteViewsChanged() {
        if (navigationLayer.selectedRoute() != null) return
        val route = navigationLayer.routes.firstOrNull() ?: return
        navigationLayer.selectRoute(route)
    }
}
navigationLayer.addRouteViewListener(routeViewListener)
```

Для подписки на состояние маршрутов на карте навигационного слоя используется интерфейс [RouteViewListener](../../../com/yandex/mapkit/navigation/automotive/layer/RouteViewListener.md).

- [RouteViewListener.onRouteViewsChanged](../../../com/yandex/mapkit/navigation/automotive/layer/RouteViewListener.md#onrouteviewschanged) сообщает об изменении маршрутов в [NavigationLayer](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md), если выбранный маршрут отсутствует, то будет выбран самый быстрый (первый) маршрут.
- [RouteViewListener.onRouteViewTap](../../../com/yandex/mapkit/navigation/automotive/layer/RouteViewListener.md#onrouteviewtaprouteview) обрабатывает событие нажатия на линию маршрута на карте.

> [!NOTE] Примечание
> По умолчанию после [запроса маршрутов](routes_building.md#request-routes) через [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) текущий маршрут в навигационном слое отсутствует, поэтому его нужно назначить вручную, например, с помощью [RouteViewListener.onRouteViewsChanged](../../../com/yandex/mapkit/navigation/automotive/layer/RouteViewListener.md#onrouteviewschanged).

## Точки маршрута

Слой навигации отвечает за отображение *from*, *to* и *via* точек во время ведения и обзора маршрута.

Для подписки на изменение точек и их нажатия используется интерфейс [RequestPointListener](../../../com/yandex/mapkit/navigation/automotive/layer/RequestPointListener.md).

![](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/navigation/navigation_layer/route_points.png)

## Пользовательская метка

Пользовательской меткой называют модель на карте, которая отвечает за отображение текущей локации пользователя и направления его движения. Модель состоит из файла `.OBJ` и текстуры в формате `.PNG`.

![](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/navigation/navigation_layer/placemark.png)

## Баллуны

Баллуны представляют собой UI-элементы на карте с надписью. Существует несколько видов баллунов:

- *баллун маневра* во время ведения указывает на положение следующего маневра на маршруте;
- *баллун альтернативы* показывает информацию о маршруте во время обзора, содержит информацию о сравнении текущего и выбранного маршрута.

![](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/navigation/navigation_layer/balloons_overview.png) ![](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/navigation/navigation_layer/balloons_guidance.png)

Для подписки на события, связанные с баллунами, используется интерфейс [BalloonViewListener](../../../com/yandex/mapkit/navigation/automotive/layer/BalloonViewListener.md).

## Камера

Управление камерой происходит с помощью объета [Camera](../../../com/yandex/mapkit/navigation/guidance_camera/Camera.md), который можно получить используя вызов [NavigationLayer.getCamera](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md#getcamera).

Переключение режимов камеры происходит с помощью метода [Camera.setCameraMode](../../../com/yandex/mapkit/navigation/guidance_camera/Camera.md#setcameramodecameramode-animation). Поддерживаются следующие типы режимов:

- Following - режим слежения камеры за меткой пользователя во время ведения.
- Overview - обзор запрошенных маршрутов.
- Free - режим по умолчанию.

По умолчанию [Camera](../../../com/yandex/mapkit/navigation/guidance_camera/Camera.md) имеет полный контроль над картой и автоматически изменяет состояние камеры. При реализации специальных режимов камеры может быть полезно ограничить контроль камеры.

При помощи методов [Camera](../../../com/yandex/mapkit/navigation/guidance_camera/Camera.md) и [NavigationLayer](../../../com/yandex/mapkit/navigation/automotive/layer/NavigationLayer.md) можно изменять следующие параметры камеры:

- автоматическое приближение камеры;
- автоматический поворот камеры;
- автоматическое переключение режимов камеры;
- параметр корректировки приближения во время ведения;
- включение/отключение 2D режима камеры.

При создании комплексного интерфейса поверх карты UI-элементы могут перекрывать некоторые области карты. Для того, чтобы это избежать существует возможность настроить параметры видимой области карты.

Поддержаны следующие настройки видимой области карты:

- [Camera.setOverviewRectWith](../../../com/yandex/mapkit/navigation/guidance_camera/Camera.md#setoverviewrectscreenrect-animation) - определяет область карты, в пределах которой будут отображены маршруты в режиме обзора.
- [Camera.setExtraOverviewPoints](../../../com/yandex/mapkit/navigation/guidance_camera/Camera.md#setextraoverviewpointsjavautillistpoint) - задает список точек, которые должны быть видны на карте при переходе в режим обзора.

# Слой дорожных событий

Дорожные события - это информация о различных событиях, которые могут происходить на дорогах. Это могут быть сведения о дорожных происшествиях, ограничениях движения, ремонтных работах, камерах контроля скорости и т.д. Полный список доступных дорожных событий можно найти в перечислении [EventTag](../../../com/yandex/mapkit/road_events/EventTag.md).

Слой дорожных событий способен отображать дорожные события на маршруте в виде иконок.

![](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/navigation/road_events_layer/road_events_in_overview.png) ![](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/navigation/road_events_layer/road_events_in_guidance.png)

## StyleProvider

Для кастомизации отображения дорожных событий используется интерфейс [StyleProvider](../../../com/yandex/mapkit/road_events_layer/StyleProvider.md).

Существует готовая реализация [StyleProvider](../../../com/yandex/mapkit/road_events_layer/StyleProvider.md), которая предоставляет стили и ресурсы иконок дорожных событий в фирменном стиле Яндекс Карт. Подробнее о подключении данной зависимости можно почитать [по ссылке](getting_started.md#add-dependencies).
