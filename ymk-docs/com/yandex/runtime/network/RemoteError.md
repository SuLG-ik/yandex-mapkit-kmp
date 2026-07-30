---
title: "RemoteError"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.runtime.network"
section: "Android / Справочник / com.yandex.runtime.network / RemoteError"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/network/RemoteError.html"
---
# RemoteError

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/network/RemoteError.html)

**Package** com.yandex.runtime.network

## All Superinterfaces:

*[Error](../Error.md)*

## All known Subinterfaces:

*[BadRequestError](BadRequestError.md)*, *[ForbiddenError](ForbiddenError.md)*, *[NotFoundError](NotFoundError.md)*, *[RequestEntityTooLargeError](RequestEntityTooLargeError.md)*, *[UnauthorizedError](UnauthorizedError.md)*

`interface RemoteError extends Error`

Server responded in unexpected way: unparsable content, wrong content or unexpected HTTP code.
