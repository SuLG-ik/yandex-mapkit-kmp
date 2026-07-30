---
title: "Начало работы с MapKit для Android"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / Начало работы"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/getting_started.html"
---
# Начало работы с MapKit для Android

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/getting_started.html)

В этом руководстве объясняется как установить и настроить библиотеку MapKit и создать карту с меткой для определенной локации.

## Шаг 1. Получите API-ключ для работы с MapKit

Перед тем, как использовать MapKit SDK в своем приложении, вам нужно получить API-ключ.

1. Перейдите в [Кабинет Разработчика](https://developer.tech.yandex.ru/services/).
2. Авторизуйтесь, используя учетную запись Яндекса, или зарегистрируйте новый аккаунт.
3. Нажмите **Подключить API** и выберите **MapKit – мобильный SDK**.
4. Введите информацию о себе и своем проекте, выберите тарифный план и нажмите **Продолжить**.
5. После того, как ваш API-ключ будет успешно создан, он будет доступен на вкладке **Интерфейсы API** → **MapKit – мобильный SDK**.

> [!NOTE] Примечание
> Активация API-ключей занимает около 15 минут.

## Шаг 2. Добавьте библиотеку MapKit в проект

Библиотека MapKit SDK для Android доступна в репозитории [Maven Central](https://central.sonatype.com/search?smo=true&q=maps.mobile).

1. [Создайте](https://developer.android.com/training/basics/firstapp/creating-project.html) новый проект или откройте существующий, например, в [Android Studio](https://developer.android.com/intl/ru/tools/studio/index.html).
2. Откройте файл `build.gradle` **проекта**. В секции `repositories` добавьте репозитории [Maven Central](https://central.sonatype.org/) и [Google Maven](https://maven.google.com/):

   ```groovy
   repositories {
       ...
       mavenCentral()
       maven {
            url "https://maven.google.com/"
       }
   }
   ```
3. Откройте файл `build.gradle` **приложения (модуля)**. В секции `dependencies` добавьте [зависимость](https://docs.gradle.org/current/userguide/artifact_dependencies_tutorial.html):

   ```groovy
   dependencies
   {
       // Облегченная библиотека, содержит только карту, слой пробок,
       // LocationManager, UserLocationLayer
       // и возможность скачивать офлайн-карты (только в платной версии).
       implementation 'com.yandex.android:maps.mobile:4.42.0-lite'

       // Полная библиотека в дополнение к lite версии предоставляет автомобильную маршрутизацию,
       // веломаршрутизацию, пешеходную маршрутизацию и маршрутизацию на общественном транспорте,
       // поиск, suggest, геокодирование и отображение панорам.
       // implementation 'com.yandex.android:maps.mobile:4.42.0-full'
   }
   ```
4. Синхронизируйте проект, чтобы применить изменения. Например, в Android Studio можно нажать **Sync Now** или выбрать в меню **File → Synchronize**. Дождитесь окончания синхронизации.
   Если синхронизация завершилась успешно, при компиляции библиотека будет добавлена в проект автоматически.

## Шаг 3. Добавьте API-ключ для MapKit

Для MapKit SDK необходимо, чтобы вы установили API-ключ с помощью [MapKitFactory.setApiKey](../../com/yandex/mapkit/MapKitFactory.md#setapikeyjavalangstring).

Рекомендуем сделать это в методе `Application.onCreate`:

```kotlin
override fun onCreate() {
    super.onCreate()
    MapKitFactory.setApiKey("YOUR_API_KEY")
}
```

Если вы не хотите, чтобы ваш API-ключ хранился в системе контроля версий, вы можете настроить его подстановку из файла `local.properties` с помощью класса `BuildConfig`:

1. Откройте или создайте файл `local.properties` **проекта**. Добавьте следующее свойство, подставив вместо `YOUR_API_KEY` значение вашего API-ключа:

   ```groovy
   MAPKIT_API_KEY=YOUR_API_KEY
   ```

   > [!NOTE] Примечание
   > Убедитесь, что файл `local.properties` игнорируется **системой контроля версий**.
2. Откройте файл `build.gradle` **проекта**. Добавьте код для загрузки API-ключа из файла `local.properties`:

   ```groovy
   ext {
       mapkitApiKey = getMapkitApiKey()
   }

   private String getMapkitApiKey() {
       def properties = new Properties()
       project.file("local.properties").withInputStream { properties.load(it) }
       return properties.getProperty("MAPKIT_API_KEY", "")
   }
   ```
3. В файле `build.gradle` **приложения** в поле **BuildConfig** введите значение переменной `mapkitApiKey` (в нее загружается API-ключ):

   ```groovy
   defaultConfig {
       // ...

       buildConfigField "String", "MAPKIT_API_KEY", "\"${mapkitApiKey}\""
   }
   ```
4. Добавьте API-ключ в `MapKitFactory`, используя поле `BuildConfig.MAPKIT_API_KEY`:

   ```kotlin
   override fun onCreate() {
       super.onCreate()
       MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
   }
   ```

## Шаг 4. Добавьте карту

1. Добавьте [MapView](../../com/yandex/mapkit/mapview/MapView.md) в xml-разметку Activity:

   ```xml
   <com.yandex.mapkit.mapview.MapView
       android:id="@+id/mapview"
       android:layout_width="match_parent"
       android:layout_height="match_parent" />
   ```
2. Чтобы инициализировать библиотеку MapKit, вызовите метод [MapKitFactory.initialize](../../com/yandex/mapkit/MapKitFactory.md#initializeandroidcontentcontext) в `Activity.onCreate`. Создайте приватное свойство `mapView: MapView`.

   ```kotlin
   private lateinit var mapView: MapView

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)

       MapKitFactory.initialize(this)
       setContentView(R.layout.activity_main)
       mapView = findViewById(R.id.mapview)
   }
   ```

   > [!WARNING] Важно
   > С помощью вызова `MapKitFactory.initialize(Context)` загружаются все необходимые для MapKit нативные библиотеки.
3. Отправьте события `onStart` и `onStop` в `MapKitFactory` и `MapView`, переопределив методы `Activity.onStart` и `Activity.onStop` для Activity:

   ```kotlin
   override fun onStart() {
       super.onStart()
       MapKitFactory.getInstance().onStart()
       mapView.onStart()
   }

   override fun onStop() {
       mapView.onStop()
       MapKitFactory.getInstance().onStop()
       super.onStop()
   }
   ```

   Иначе MapKit не сможет отображать карту и прекратит ее обработку, когда Activity с картой станет невидимой для пользователей.

Создайте и запустите приложение. Пример приложения с кликабельной картой:

![Карта с наименьшим увеличением](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/getting_started/map.png)

Чтобы изменить положение или масштаб карты, используйте метод [Map.move](../../com/yandex/mapkit/map/Map.md#movecameraposition-animation-cameracallback):

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    // ...
    map.move(
        CameraPosition(
            Point(55.751225, 37.62954),
            /* zoom = */ 17.0f,
            /* azimuth = */ 150.0f,
            /* tilt = */ 30.0f
        )
    )
}
```

[Map.move](../../com/yandex/mapkit/map/Map.md#movecameraposition-animation-cameracallback) принимает на вход аргумент [CameraPosition](../../com/yandex/mapkit/map/CameraPosition.md), который полностью задает положение, масштаб, наклон и азимут карты.

Карты по умолчанию поддерживают несколько действий: перемещение, поворот, изменение масштаба и наклон.

Без дополнительной настройки карта будет отображаться с минимально возможным масштабом для экрана пользователя.

Пример карты после изменения положения камеры:

![Карта после применения](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/getting_started/map_after_move.png)

## Шаг 5. Обратите внимание при дальнейшей работе

MapKit хранит слабые ссылки на передаваемые ему Listener-объекты. Необходимо самим хранить ссылку на них в памяти:

```kotlin
val cameraListener = CameraListener { _, _, _, _ ->
    // ...
}
mapView.mapWindow.map.addCameraListener(cameraListener)
```

> [!NOTE] Примечание
> По умолчанию методы всех Listener-объектов и платформенных интерфейсов вызываются на главном потоке, если в документации метода не сказано обратное.

## Шаг 6. Отображение метки на карте

Изменим приложение таким образом, чтобы вы могли показывать на карте кликабельную метку.

1. Добавьте в проект ресурс `png` для изображения метки.
   Например, есть **изображение**, и оно доступно по идентификатору `R.drawable.ic_pin`.
   ![Значок метки](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/getting_started/placemark_icon.png)
2. Добавьте метку для коллекции [Map.getMapObjects](../../com/yandex/mapkit/map/Map.md#getmapobjects) в определенное место.
   Используйте [ImageProvider.fromResource](../../com/yandex/runtime/image/ImageProvider.md#fromresourceandroidcontentcontext-int), чтобы создать экземпляр [ImageProvider](../../com/yandex/runtime/image/ImageProvider.md) для изображения метки.

   ```kotlin
   override fun onCreate(savedInstanceState: Bundle?) {
       // ...
       val imageProvider = ImageProvider.fromResource(this, R.drawable.ic_pin)
       val placemark = mapView.map.mapObjects.addPlacemark().apply {
           geometry = Point(55.751225, 37.62954)
           setIcon(imageProvider)
       }
   }
   ```
3. Чтобы подписаться на нажатия на созданную метку, используйте метод [MapObject.addTapListener](../../com/yandex/mapkit/map/MapObject.md#addtaplistenermapobjecttaplistener).

   ```kotlin
   private val placemarkTapListener = MapObjectTapListener { _, point ->
       Toast.makeText(
           this@MainActivity,
           "Tapped the point (${point.longitude}, ${point.latitude})",
           Toast.LENGTH_SHORT
       ).show()
       true
   }

   override fun onCreate(savedInstanceState: Bundle?) {
       // ...
       placemark.addTapListener(placemarkTapListener)
   }
   ```

Соберите и запустите приложение. На карте есть метка с вашим изображением. Коснитесь метки, и появится всплывающее сообщение:

![Карта после нажатия метки](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/getting_started/map_with_placemark_on_tap_message.png)

## Исходный код

Полные примеры кода из руководства вы можете найти в приложении `map-with-placemark` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-android-demo).
