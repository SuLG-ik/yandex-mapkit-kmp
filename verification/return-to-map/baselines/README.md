# Real-tile return-to-map baseline

Captured on November 20, 2026, on two disposable local simulators with a configured MapKit key.
Each platform completed five matched cohorts at one viewport, for 20 trials per platform and
zero deadlines. Both ran Lite SDK `2026081315.14-d31a76c2e2204db-210.5-lite-public` from MapKit
4.45.0. Each row includes an observed native map tap. Both drivers waited 350 ms after detecting
the readiness prompt. Tap timings also include observation and scheduling by the driver.

| Platform | Configuration | Measured viewport | Revision | Rows |
| --- | --- | --- | --- | --- |
| Android | Pixel 7 profile, Android 13 API 33 arm64, software GPU | 683×683 physical pixels | [`3467ce80`](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/3467ce8044bd58b2ebb3747839e3bfaa2e0674c3) | [Android metrics](2026-11-20-android-api33.metrics) |
| iOS | iPhone 16e Simulator, iOS 26.5 | 780×780 physical pixels | [`89cd6817`](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/89cd68175679b81e3dfe1b10609eb0403c45452e) | [iOS metrics](2026-11-20-ios26.5.metrics) |

## Median and range

Times are milliseconds from the route action after MapKit initialization. The tile columns
report loaded callbacks registered at mount. The retained case preserves the existing viewport.

| Case | Android projection | Android tile callback | iOS projection | iOS tile callback |
| --- | ---: | ---: | ---: | ---: |
| Cold | 279 [144–531] | 9,497 [7,523–10,024] | 583 [501–633] | 3,480 [2,862–7,862] |
| Same-process reopen | 83 [75–117] | 6,606 [5,022–7,715] | 66 [50–116] | 521 [507–534] |
| Retained tab | 28 [21–33] | Retained | 17 [17–17] | Retained |
| Process restart | 171 [149–449] | 6,892 [5,918–9,629] | 83 [67–104] | 543 [535–636] |

Every fresh attachment created one map, three markers and one bitmap provider. The retained
return created none. For fresh attachments the largest observed interval was after projection
readiness. The warm/cold difference within each platform is consistent with cache reuse.
The captures do not isolate cache, connection and SDK rendering work, and the two simulator
configurations should be compared separately.

Recreate the detailed summaries from the repository root.

```sh
python3 verification/return-to-map/summarize.py --device "Pixel 7 profile API 33 arm64 emulator" --revision 3467ce8044bd58b2ebb3747839e3bfaa2e0674c3 verification/return-to-map/baselines/2026-11-20-android-api33.metrics
python3 verification/return-to-map/summarize.py --device "iPhone 16e Simulator iOS 26.5" --revision 89cd68175679b81e3dfe1b10609eb0403c45452e verification/return-to-map/baselines/2026-11-20-ios26.5.metrics
```

Use the [measurement procedure](../README.md) to repeat the comparison on another device.
