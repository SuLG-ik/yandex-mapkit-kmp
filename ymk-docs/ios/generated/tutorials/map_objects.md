---
title: "Объекты карты"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / Руководство / Объекты карты"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_objects.html"
---
# Объекты карты

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_objects.html)

MapKit SDK позволяет отображать на карте объекты. Все объекты карты настраиваемые: вы можете создавать уникальные пользовательские сценарии с учетом потребностей разработчиков.

## Метки

Добавьте пользовательские метки изображения на карту с помощью метода [YMKMapObjectCollection.addPlacemark()](../../../Swift/YMKMapObjectCollection.md#addplacemark) из поля [YMKMap.mapObjects](../../../Swift/YMKMap.md#mapobjects).

Метод принимает [`YMKPoint`](../../../Swift/YMKPoint.md) с координатами для метки и экземпляр `UIImage`.

```swift
let placemark = map.mapObjects.addPlacemark()
placemark.geometry = YMKPoint(latitude: 59.939638, longitude: 30.339916)
placemark.setIconWith(UIImage(named: "icon_dollar")!)
```

С помощью приведенного выше кода создается экземпляр класса [YMKPlacemarkMapObject](../../../Swift/YMKPlacemarkMapObject.md), который расширяет интерфейс [YMKMapObject](../../../Swift/YMKMapObject.md).

Интерфейс [YMKMapObject](../../../Swift/YMKMapObject.md) представляет каждый видимый объект на карте. Существует несколько способов настройки объектов карты: изменение видимости, разрешение перетаскивания, изменение z-индекса, настройка обработчика событий касания или перетаскивания и многое другое.

Подробнее об этом можно почитать в разделе [YMKMapObject](../../../Swift/YMKMapObject.md).

### Настройка текста

Вы можете создавать текстовые надписи рядом с метками. Для этого используйте метод  [YMKPlacemarkMapObject.setTextWithText(_:)](../../../Swift/YMKPlacemarkMapObject.md#settextwithtext_).

Чтобы изменить внешний вид меток, включая их размер, цвет и положение текста относительно значка, используйте метод [YMKTextStyle](../../../Swift/YMKTextStyle.md).

```swift
placemark.setTextWithText(
    "Special place",
    style: {
        let textStyle = YMKTextStyle()
        textStyle.size = 10.0
        textStyle.placement = .right
        textStyle.offset = 5.0
        return textStyle
    }()
)
```

### Стили значков

Вы можете настроить представление значков меток с помощью класса [YMKIconStyle](../../../Swift/YMKIconStyle.md). Он позволяет изменять положение привязки, размер, тип поворота, z-индекс, кликабельные области, видимость и плоскость по отношению к карте.

```swift
let iconStyle = YMKIconStyle()
iconStyle.anchor = NSValue(cgPoint: CGPoint(x: 0.5, y: 0.5))
iconStyle.scale = 0.6

let placemark = map.mapObjects.addPlacemark()
placemark.geometry = point
placemark.setIconWith(image, style: iconStyle)
```

### Составные значки

Объедините несколько значков, чтобы создать составной.

1. Создайте значок по умолчанию с помощью [YMKMapObjectCollection.addPlacemark()](../../../Swift/YMKMapObjectCollection.md#addplacemark).
2. Используйте [YMKPlacemarkMapObject.useCompositeIcon()](../../../Swift/YMKPlacemarkMapObject.md#usecompositeicon), чтобы создать составной значок.
3. Используйте [YMKCompositeIcon.setIconWithName(_:image:style:)](../../../Swift/YMKCompositeIcon.md#seticonwithname_imagestyle), чтобы добавить новый значок к составному значку.

Полный пример кода для создания составного значка:

```swift
let placemark = map.mapObjects.addPlacemark()
placemark.geometry = GeometryProvider.compositeIconPoint
placemark.addTapListener(with: singlePlacemarkTapListener)
placemark.setTextWithText(
    "Special place",
    style: {
        let textStyle = YMKTextStyle()
        textStyle.size = 10.0
        textStyle.placement = .right
        textStyle.offset = 5.0
        return textStyle
    }()
)

let compositeIcon = placemark.useCompositeIcon()
compositeIcon.setIconWithName(
    "pin",
    image: UIImage(named: "icon_dollar")!,
    style: {
        let iconStyle = YMKIconStyle()
        iconStyle.anchor = NSValue(cgPoint: CGPoint(x: 0.5, y: 1.0))
        iconStyle.scale = 0.9
        return iconStyle
    }()
)
compositeIcon.setIconWithName(
    "point",
    image: UIImage(named: "icon_circle")!,
    style: {
        let iconStyle = YMKIconStyle()
        iconStyle.anchor = NSValue(cgPoint: CGPoint(x: 0.5, y: 0.5))
        iconStyle.scale = 0.5
        iconStyle.flat = true
        return iconStyle
    }()
)
```

Результат:

![Пример составного значка](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/map_objects/objects_composite_icon.png)

### Анимированные метки

Вы можете создать анимированную метку из анимированного PNG-файла.

1. Создайте метку с помощью [YMKMapObjectCollection.addPlacemark()](../../../Swift/YMKMapObjectCollection.md#addplacemark).

   ```swift
   let animatedPlacemark = pinsCollection.addPlacemark()
   animatedPlacemark.geometry = GeometryProvider.animatedImagePoint
   ```
2. Используйте метод [YMKPlacemarkMapObject.useAnimation()](../../../Swift/YMKPlacemarkMapObject.md#useanimation) для создания объекта анимации. Задать ресурс анимации можно при помощи экземпляра [YRTAnimatedImageProvider](../../../Swift/YRTAnimatedImageProvider.md).

   ```swift
   let animatedImageProvider = YRTAnimatedImageProviderFactory.fromFile(
       Bundle.main.path(forResource: "animation", ofType: "png")
   ) as! YRTAnimatedImageProvider

   let animation = animatedPlacemark.useAnimation()
   animation.setIconWithImage(animatedImageProvider)
   ```
3. Запустите анимацию, управляя ею с помощью объекта [YMKPlacemarkAnimation](../../../Swift/YMKPlacemarkAnimation.md).

   ```swift
   animation.play()
   ```

## Коллекции меток

Коллекции меток используются для группировки нескольких меток в новую коллекцию вложенных объектов карты.

1. Чтобы создать коллекцию вложенных объектов карты, используйте метод [YMKMapObjectCollection.add()](../../../Swift/YMKMapObjectCollection.md#add).

   ```swift
   let pinsCollection = map.mapObjects.add()
   ```
2. Теперь вы можете использовать новую коллекцию `pinsCollection` для отображения меток и других объектов карты.

   ```swift
   GeometryProvider.placemarkPoints.enumerated().forEach { pair in
       let point = pair.element

       let image = UIImage(named: "icon_dollar")!

       let placemark = map.mapObjects.addPlacemark()
       placemark.geometry = point
       placemark.setIconWith(image)

       placemark.isDraggable = true
   }
   ```

   Как это выглядит после добавления меток в коллекцию новых объектов карты:
   ![Карта с коллекцией меток](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/map_objects/objects_placemarks_collection.png)

После создания коллекции `pinCollection` вы можете добавить в нее пины так же, как и для объектов [YMKMap.mapObjects](../../../Swift/YMKMap.md#mapobjects), поскольку они имеют тот же тип [YMKMapObjectCollection](../../../Swift/YMKMapObjectCollection.md).

> [!NOTE] Примечание
> Интерфейс [YMKMapObjectCollection](../../../Swift/YMKMapObjectCollection.md) расширяет [YMKMapObject](../../../Swift/YMKMapObject.md), поэтому допускается создавать вложенные коллекции и добавлять их в другие.
>
>
> Все методы, имеющие интерфейс [YMKMapObject](../../../Swift/YMKMapObject.md), также доступны в [YMKMapObjectCollection](../../../Swift/YMKMapObjectCollection.md).

Вы можете итерироваться по элементам [YMKMapObjectCollection](../../../Swift/YMKMapObjectCollection.md), используя метод [YMKBaseMapObjectCollection.traverse(with:)](../../../Swift/YMKBaseMapObjectCollection.md#traversewith).

## Геометрии

MapKit SDK позволяет рисовать на карте примитивные геометрические объекты, такие как полигоны, полилинии и круги. Все они настраиваемые и реализуют интерфейс [YMKMapObject](../../../Swift/YMKMapObject.md).

### Полигоны

Используйте полигон, когда вам нужно отобразить **область** карты для пользователей.

1. Начните с создания экземпляра [YMKPolygon](../../../Swift/YMKPolygon.md).

   ```swift
   static let polygon: YMKPolygon = {
       var points = [
           YMKPoint(latitude: 59.936046, longitude: 30.326869),
           YMKPoint(latitude: 59.938185, longitude: 30.32808),
           YMKPoint(latitude: 59.937376, longitude: 30.33621),
           YMKPoint(latitude: 59.934517, longitude: 30.335059)
       ]

       points.append(points[0])

       let outerRing = YMKLinearRing(points: points)

       return YMKPolygon(outerRing: outerRing, innerRings: [])
   }()
   ```
2. Используйте метод [YMKMapObjectCollection.addPolygon(with:)](../../../Swift/YMKMapObjectCollection.md#addpolygonwith) для создания полигонального объекта карты.

   ```swift
   polygonMapObject = collection.addPolygon(with: GeometryProvider.polygon)
   ```

   После завершения сборки вы увидите полигон в стиле по умолчанию:
   ![Карта с полигоном по умолчанию](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/map_objects/objects_polygon.png)
3. Задайте **внутренние** точки при создании полигона, чтобы исключить часть внутри него.

   ```swift
   static let polygon: YMKPolygon = {
       var points = [
           YMKPoint(latitude: 59.936046, longitude: 30.326869),
           YMKPoint(latitude: 59.938185, longitude: 30.32808),
           YMKPoint(latitude: 59.937376, longitude: 30.33621),
           YMKPoint(latitude: 59.934517, longitude: 30.335059)
       ]

       points.append(points[0])
       let outerRing = YMKLinearRing(points: points)

       var innerPoints = [
           YMKPoint(latitude: 59.937487, longitude: 30.330034),
           YMKPoint(latitude: 59.936688, longitude: 30.33127),
           YMKPoint(latitude: 59.937116, longitude: 30.33328),
           YMKPoint(latitude: 59.937704, longitude: 30.331842)
       ]

       innerPoints.append(innerPoints[0])
       let innerRing = YMKLinearRing(points: innerPoints)

       return YMKPolygon(outerRing: outerRing, innerRings: [innerRing])
   }()
   ```

   Полигон с внутренними точками:
   ![Карта с полигоном с использованием внутренних точек](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/map_objects/objects_polygon_inner.png)
4. Измените цвет заливки и обводки по умолчанию, используя созданный экземпляр [YMKPolygonMapObject](../../../Swift/YMKPolygonMapObject.md).

   ```swift
   polygonMapObject.strokeWidth = 1.5
   polygonMapObject.strokeColor = Palette.olive
   polygonMapObject.fillColor = Palette.oliveTransparent
   ```

   ![Карта со стилизованным полигоном](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/map_objects/objects_polygon_styled.png)

Подробнее про настройку полигонов см. в разделе [YMKPolygonMapObject](../../../Swift/YMKPolygonMapObject.md).

### Полилинии

Полилинии часто используются для отображения маршрутов и траекторий.

1. Создайте экземпляр [YMKPolyline](../../../Swift/YMKPolyline.md) с искомой геометрией и добавьте на карту объект полилинейной карты с помощью метода [YMKMapObjectCollection.addPolyline(with:)](../../../Swift/YMKMapObjectCollection.md#addpolylinewith).

   ```swift
   let polyline: YMKPolyline = {
       YMKPolyline(
           points: [
               YMKPoint(latitude: 59.936046, longitude: 30.326869),
               YMKPoint(latitude: 59.938185, longitude: 30.32808),
               YMKPoint(latitude: 59.937376, longitude: 30.33621),
               YMKPoint(latitude: 59.934517, longitude: 30.335059)
           ]
       )
   }()

   let polylineMapObject = collection.addPolyline(with: polyline)
   ```
2. Настройте стили полилиний, используя переменную [YMKPolylineMapObject](../../../Swift/YMKPolylineMapObject.md).

   ```swift
   polylineMapObject.strokeWidth = 5.0
   polylineMapObject.setStrokeColorWith(.gray)
   polylineMapObject.outlineWidth = 1.0
   polylineMapObject.outlineColor = .black
   ```

   Результат после добавления полилинии на карту:
   ![Карта с добавленной полилинией](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/map_objects/objects_polyline.png)

Подробнее об этом можно почитать в разделе [YMKPolylineMapObject](../../../Swift/YMKPolylineMapObject.md).

### Круги

Круги используются для отображения круглых областей.

1. Создайте экземпляр [YMKCircle](../../../Swift/YMKCircle.md) с искомой геометрией: центральной точкой и радиусом в метрах.

   ```swift
   var circleWithRandomRadius: YMKCircle {
       YMKCircle(center: YMKPoint(latitude: 59.935493, longitude: 30.327392), radius: 400.0)
   }
   ```
2. С помощью метода [YMKMapObjectCollection.addCircle(with:stroke:strokeWidth:fill:)](../../../Swift/YMKMapObjectCollection.md#addcirclewith) добавьте на карту объект круга.

   ```swift
   let circle = pinsCollection.addCircle(with: GeometryProvider.circleWithRandomRadius)
   circle.strokeColor = Palette.red
   circle.strokeWidth = 2.0
   circle.fillColor = Palette.redTransparent
   ```

   Результат после добавления круга на карту:
   ![Карта с кругом](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/map_objects/objects_circle.png)

Подробнее о том, как настроить круговой объект карты, можно почитать в разделе [YMKCircleMapObject](../../../Swift/YMKCircleMapObject.md).

## Кластеры

Кластеризованные коллекции используются для отображения нескольких меток.

1. Начните с создания [YMKClusterListener](../../../Swift/YMKClusterListener.md) с одним методом [YMKClusterListener.onClusterAdded(with:)](../../../Swift/YMKClusterListener.md#onclusteraddedwith), который управляет внешним видом кластера на карте.

   ```swift
   final class ClusterListener: NSObject, YMKClusterListener, YMKClusterTapListener {
   // MARK: - Constructor

   init(controller: UIViewController) {
       self.controller = controller
   }

   // MARK: - Public methods

   func onClusterTap(with cluster: YMKCluster) -> Bool {
       AlertPresenter.present(
           from: controller,
           with: "Tapped the cluster",
           message: "With \(cluster.size) items"
       )
       return true
   }

   func onClusterAdded(with cluster: YMKCluster) {
       let placemarks = cluster.placemarks.compactMap { $0.userData as? PlacemarkUserData }
       cluster.appearance.setViewWithView(YRTViewProvider(uiView: ClusterView(placemarks: placemarks)))
       cluster.addClusterTapListener(with: self)
   }

   // MARK: - Private properties

   private weak var controller: UIViewController?
   }
   ```

   Свойство [YMKCluster.appearance](../../../Swift/YMKCluster.md#appearance) возвращает объект [YMKPlacemarkMapObject](../../../Swift/YMKPlacemarkMapObject.md). В нашем примере мы используем метод [YMKPlacemarkMapObject.setViewWithView(_:)](../../../Swift/YMKPlacemarkMapObject.md#setviewwithview_), чтобы изменить внешний вид кластера.
   `ClusterView` — это определяемый пользователем класс. Чтобы узнать, как он реализован, посмотрите код в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-ios-demo).
2. Создайте новую вложенную коллекцию с помощью метода [YMKMapObjectCollection.addClusterizedPlacemarkCollection(with:)](../../../Swift/YMKMapObjectCollection.md#addclusterizedplacemarkcollectionwith).

   ```swift
   clusterizedCollection = collection.addClusterizedPlacemarkCollection(with: clusterListener)
   ```
3. Добавьте несколько меток в новый `clusterizedCollection`.

   ```swift
   GeometryProvider.clusterizedPoints.enumerated().forEach { pair in
       let index = pair.offset
       let point = pair.element

       let type = PlacemarkType.random
       let image = type.image

       let iconStyle = YMKIconStyle()
       iconStyle.anchor = NSValue(cgPoint: CGPoint(x: 0.5, y: 0.5))
       iconStyle.scale = 0.6

       let placemark = clusterizedCollection.addPlacemark()
       placemark.geometry = point
       placemark.setIconWith(image, style: iconStyle)

       placemark.isDraggable = true
       placemark.setDragListenerWith(mapObjectDragListener)
       placemark.userData = PlacemarkUserData(name: "Data_\(index)", type: type)
       placemark.addTapListener(with: mapObjectTapListener)
   }
   ```
4. Вызовите метод [YMKClusterizedPlacemarkCollection.clusterPlacemarks(withClusterRadius:minZoom:)](../../../Swift/YMKClusterizedPlacemarkCollection.md#clusterplacemarkswithclusterradiusminzoom). Он принимает два аргумента:

   - `clusterRadius` — минимальное расстояние в единицах между объектами, которые остаются в отдельных кластерах.
   - `minZoom` — минимальный уровень масштабирования, отображающий кластеры.

   ```swift
   clusterizedCollection.clusterPlacemarks(withClusterRadius: Const.clusterRadius, minZoom: Const.clusterMinZoom)
   ```

   > [!WARNING] Важно
   > [YMKClusterizedPlacemarkCollection.clusterPlacemarks(withClusterRadius:minZoom:)](../../../Swift/YMKClusterizedPlacemarkCollection.md#clusterplacemarkswithclusterradiusminzoom) следует вызывать явно каждый раз, когда метки добавляются в кластеризованные коллекции или удаляются из них.
   >
   >
   > Иначе кластеризованные метки не будут повторно отображаться.

   Кластеризованные метки с разным масштабом:
   ![Кластеры](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/map_objects/objects_clusters.gif)

## Разрешение конфликтов

При добавлении объектов [YMKPlacemarkMapObject](../../../Swift/YMKPlacemarkMapObject.md) на карту, они могут накладываться как друг на друга, так и на иконки и подписи карты. Для разрешения конфликтов наложения предусмотрен механизм [YMKConflictResolutionMode](../../../Swift/YMKConflictResolutionMode.md).

Разрешение конфликтов происходит в соотвествии с порядком отрисовки, то есть объект отрисованый выше, может вытеснить объект, отрисованый ниже, но не наоборот. Порядок отрисовки формируется на основе свойств zIndex объекта `PlacemarkMapObject` и `MapObjectCollection` которой он принадлежит. При равных `zIndex` объекты отрисовываются в том же порядке, в котором они были добавлены.

Для выставления режима разрешения конфликтов используйте метод [YMKRootMapObjectCollection.setConflictResolutionMode()](../../../Swift/YMKRootMapObjectCollection.md#conflictresolutionmode).

> [!NOTE] Примечание
> Mapkit поддерживает настройку режима разрешения конфликтов только для корневой коллекции. Любые дочерние элементы/коллекции будут использовать режим разрешения конфликтов корневой коллекции.
> По умолчанию режим разрешения конфликтов — `ConflictResolution.Ignore`.

Пример проблемы:

![Разрешение конфликтов по умолчанию](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/map_objects/objects_resolution_ignore.png)

При установке значения `ConflictResolution.Major` для коллекции добавленные объекты начинают вытеснять подписи и иконки на карте:

![Выставленное разрешение конфликтов](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/map_objects/objects_resolution_major.png)

## Исходный код

Полные примеры кода из руководства смотрите в приложении `MapObjects` в нашем [GitHub репозитории](https://github.com/yandex/mapkit-ios-demo).
