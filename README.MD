# yandex-maps-kmp

Kotlin Multiplatform Library

### Publish to MavenCentral

1) Registering a Sonatype account as described here: 
   https://dev.to/kotlin/how-to-build-and-publish-a-kotlin-multiplatform-library-going-public-4a8k
2) Add developer id, name, email and the project url to
   `/convention-plugins/src/main/kotlin/convention.publication.gradle.kts`
3) Add the secrets to `local.properties`:

```
signing.keyId=...
signing.password=...
signing.secretKeyRingFile=...
ossrhUsername=...
ossrhPassword=...
```

4) Run `./gradlew :yandex-map-kmp:publishAllPublicationsToSonatypeRepository`

### Build platform artifacts

#### Android aar

- Run `./gradlew :yandex-map-kmp:assembleRelease`
- Output: `/yandex-map-kmp/build/outputs/aar/yandex-map-kmp-release.aar`

#### iOS Framework

- Run `./gradlew :yandex-map-kmp:linkReleaseFrameworkIosArm64`
- Output: `/yandex-map-kmp/build/bin/iosArm64/releaseFramework/yandex-map-kmp.framework`
