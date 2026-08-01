# Установка

Все модули опубликованы в Maven Central в группе `ru.sulgik.mapkit`.

!!! info "Собрано против [Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/ru/) `{{ mapkit_version }}`"
    Обёртка нацелена на сборку **lite**. Сам MapKit подключает ваш проект, поэтому используйте там
    ту же версию.

| Модуль | Зависимость Gradle | Описание |
|---|:---|:---|
| [Обёртка](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/yandex-mapkit-kmp) | [`ru.sulgik.mapkit:yandex-mapkit-kmp:{{ version }}`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp) | API MapKit в общем коде |
| [Compose](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/yandex-mapkit-kmp-compose) | [`ru.sulgik.mapkit:yandex-mapkit-kmp-compose:{{ version }}`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-compose) | Отрисовка карты через Compose Multiplatform и [compose-resources](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-images-resources.html) как изображения карты |
| [Moko](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/yandex-mapkit-kmp-moko) | [`ru.sulgik.mapkit:yandex-mapkit-kmp-moko:{{ version }}`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-moko) | [moko-resources](https://github.com/icerockdev/moko-resources) как `ImageProvider`. Требует инициализации на платформе |
| [Moko Compose](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/yandex-mapkit-kmp-moko-compose) | [`ru.sulgik.mapkit:yandex-mapkit-kmp-moko-compose:{{ version }}`](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp-moko-compose) | То же в composable-контексте, без инициализации на платформе |

## Требования

- **Android** — минимальный SDK {{ min_sdk }}.
- **iOS** — `iosArm64` и `iosSimulatorArm64`. `iosX64` убран, потому что Compose Multiplatform
  больше под него не публикуется.
- **Kotlin** {{ kotlin_version }}, **Compose Multiplatform** {{ compose_version }} для
  Compose-модулей.
- [API-ключ](https://yandex.ru/dev/mapkit/doc/ru/android/generated/getting_started#key) от Яндекса.

## Подключение самого MapKit

MapKit **не** приходит транзитивно вместе с этими модулями — его подключаете вы, версией из таблицы
выше.

=== "Android"

    Достаточно Gradle-зависимости; добавьте её в Android-исходники модуля, который линкует
    приложение.

    ```kotlin
    kotlin {
        sourceSets {
            androidMain.dependencies {
                implementation("com.yandex.android:maps.mobile:{{ mapkit_version }}")
            }
        }
    }
    ```

=== "iOS (CocoaPods)"

    ```kotlin
    kotlin {
        cocoapods {
            pod("YandexMapsMobile") {
                version = "{{ mapkit_version }}"
            }
        }
    }
    ```

=== "iOS (SPM)"

    Добавьте `YandexMapsMobile` в проект Xcode обычным способом и откройте его для Kotlin через
    [interop с SPM](https://kotlinlang.org/docs/native-spm.html#project-configuration-options).

!!! warning "На iOS линковка на вашей стороне"
    Klib не может нести в себе нативный фреймворк, поэтому проект, который сам не линкует
    [Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/ru/ios/generated/getting_started), падает
    на линковке, а не на компиляции.

## Основной модуль

`yandex-mapkit-kmp` — это обёртка: собственный API MapKit, доступный из `commonMain`. Сам он ничего
не рисует — как платформенный `MapView` попадает в общий код, описано в
[Обзоре обёртки](../wrapper/overview.md).

=== "Kotlin"

    ```kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp:{{ version }}")
            }
        }
    }
    ```

## Compose Multiplatform

`yandex-mapkit-kmp-compose` рисует карту как composable и управляет объектами карты через отдельную
композицию: `YandexMap`, `Placemark`, `Polyline`, `Polygon`, `Circle`, `Clustering`,
`MapObjectCollection`, `TileLayer`, `MapObjectLayer`, `TrafficLayer`, `MapListeners`,
`CameraPositionState` и `MapEffect`.

!!! info "Обёртка уже внутри"
    Модуль зависит от `yandex-mapkit-kmp` как от `api`-зависимости, поэтому отдельное объявление
    нужно только чтобы явно зафиксировать версию.

=== "Kotlin"

    ```kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-compose:{{ version }}")
            }
        }
    }
    ```

## moko-resources

`yandex-mapkit-kmp-moko` превращает изображения, сгенерированные
[moko-resources](https://github.com/icerockdev/moko-resources), в `ImageProvider`. Модуль добавляет
`MOKOImageLoader` с платформенными реализациями `AndroidMOKOImageLoader` (нужен `Context`) и
`IOSMOKOImageLoader` — их вы создаёте на стороне платформы и передаёте в общий код.

=== "Kotlin"

    ```kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-moko:{{ version }}")
            }
        }
    }
    ```

## moko-resources в Compose

`yandex-mapkit-kmp-moko-compose` добавляет `rememberMOKOImageLoader()`, который сам собирает
платформенную реализацию, так что передавать ничего не нужно.

=== "Kotlin"

    ```kotlin
    kotlin {
        sourceSets {
            commonMain.dependencies {
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-moko-compose:{{ version }}")
            }
        }
    }
    ```

Оба moko-модуля описаны на странице [Изображения](../wrapper/image-resources.md).
