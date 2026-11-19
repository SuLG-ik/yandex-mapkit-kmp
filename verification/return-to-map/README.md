# Measure return to a map

[Русская инструкция](README.ru.md)

Open **Measure return to map** in the sample. The separate **Return to map** example demonstrates
preserving camera and selection. The probe uses the same 260 dp viewport, daytime style, camera
at 55.751225 / 37.629540 (zoom 16, zero tilt and azimuth), and three local markers on Android
and iOS. The default mode uses no basemap. The **Real tiles** mode uses the SDK's vector basemap
and default disk cache. Choose a mode before the first measurement.

The sample initializes MapKit while showing the setup controls. Each trial starts at the opening
button press and reports `scope=post_init`. The numbers cover the route and native viewport
from there. Process startup, SDK initialization and menu navigation fall outside the interval.

## Controlled run

Use a disposable test install, a fixed device and OS/runtime per report, portrait orientation,
the same revision and a stable connection for the real-tile comparison. Build the normal sample
for each platform. For a trusted real-tile run, configure a dedicated MapKit key with the sample's
ignored `local.properties` on a trusted machine. Keep the key out of logs and uploaded artifacts.
The hosted sample workflow compiles the probe with a placeholder key without collecting timings.
A blank key, the sample CI placeholder or the all-zero placeholder is reported as `missing_key`
if real tiles are requested. The all-zero placeholder can be used for view-only measurements.

1. Clear the disposable Android test app's storage after installing it. On iOS delete the test
   app and reinstall it with a fresh container. Offloading preserves app data. Use a fresh
   simulator/device test sandbox if any MapKit data is shared across installations. Enter an
   anonymous cohort ID such as `trial_01`, select the mode, and use **Open after clearing app data**.
   Tap near the center once when prompted. Wait for the result or its 30-second deadline.
2. Use **Details (unmount map)**, then **Return to map**. Repeat the tap and wait for the result.
   This recreates the view in the same process after the preceding viewport warmed the SDK.
3. Use **Other tab (retain map)**, then **Return to map**. The map stays mounted behind the other
   tab. Tap and wait for the result.
4. Stop and restart the same installed app process with its storage and cache intact. On Android
   use force-stop and launch. On iOS terminate and launch the same app. Reenter the cohort ID and
   select the original tile mode, then use **Open after process restart**. Tap and wait again.
   Keep the rows from both processes. The trial IDs differ and the cohort ID ties them together.

Repeat each in-process case at least five times and repeat the clean-install and process-restart
sequence on freshly cleared test installs, assigning a new cohort ID for each series. For the
real-tile series, wait for `tiles=loaded` before using a cold view to warm its matched reopen/restart
sample. Record any timeouts. Keep a
separate file or report per device, SDK mode and experimental configuration. Record the network
and whether this is a real device or emulator/simulator. Time the real run on each target before
claiming an improvement.

## Collect a report

Copy the selectable `MAPKIT_RETURN_METRIC|` lines from the sample. You can also extract the rows
locally from Android Logcat or the Xcode console with `--metrics-out`. Share only the extracted
metric rows and the aggregate, since full logs may contain data outside the benchmark. Keep each
report to one device and use the same revision identifier for the compared binaries.

For an external UI driver, wait for the `return-map-benchmark-ready` test tag and send one
physical tap to the center of `return-map-benchmark-viewport` at a fixed delay after detection.
Report the delay and keep it the same for all compared cases. The observed tap still includes
the driver's detection and scheduling time.

```sh
python3 verification/return-to-map/summarize.py --device "Android Pixel 6a, API 33" --revision YOUR_GIT_SHA --metrics-out android.metrics android-local.log
python3 verification/return-to-map/summarize.py --device "iOS iPhone 16e Simulator, iOS 26.2" --revision YOUR_GIT_SHA --metrics-out ios.metrics ios-local.log
```

The report lists trial counts by cohort and gives medians, ranges and observed/attempted counts
for each route. Route metrics use all trials for the same case. The report summarizes verified
tile callback metrics separately for `mount` and `ready` registrations. Each tile table counts
only the attempts from its registration phase, including timeouts. Unverified early callbacks
are counted with route metrics because the recorded phase reflects the final registration.
The parser deduplicates by trial ID and rejects mixed measured viewports, conflicting duplicates
and changes in SDK, mode or timing scope inside a cohort. It keeps deadline rows and missing
fields. Signed differences use pairs from the same trial.

| Field | Meaning |
|---|---|
| `mount_ms` / `mounts` | First native map attachment after the route action and count of attachments since route departure. An intact retained map has no mount timing and zero attachments. |
| `overlay_ms`, `markers`, `icons` | Observed local marker assignment time and count of new markers and bitmap providers. Reused overlays report `overlay_ms=na`; work while the route is hidden can increase counters without an observed route timestamp. The metric measures assignment to the native map. |
| `ready_ms` | First observed Compose frame with a nonzero native window, the intended camera and a valid world-to-screen projection. This is a viewport-readiness proxy. |
| `tap_ms` | First native input callback near the center after projection, including the operator's reaction. It confirms an actual interaction. Timeline comparisons use the projection proxy or a separately controlled tap cadence. |
| `tile_ms`, `tiles` | Elapsed time from route entry to a loaded callback with the expected camera and projection. An intact retained return records `retained` after observing projection with zero new mounts. If a retained attempt gained a new native mount, it waits for verified tile data like other new mounts. |
| `early_tile_ms`, `tile_registered` | The first SDK callback that arrived before the expected viewport could be verified is recorded separately. The probe registers again after readiness if needed. A final `early_only` or `timeout` means no verified callback arrived. Readiness-time registration can observe an already cached viewport. The registration phase and any missing key are explicit in the output. |
| SDK metrics | The nine fields of `MapLoadStatistics` exposed by the wrapper. SDK durations are separate from route durations. |

Use matched cohorts for comparisons. With real tiles, compare the paired `tile_ms` minus
`ready_ms` where each is present and the registration phases agree. A negative value means the
verified loaded callback preceded the first observed frame. Compare cold/reopen/retained
`mount_ms`, `overlay_ms`, `ready_ms` and counters to separate work in the view and markers.
Describe a warm-versus-cold difference at the same viewport as an inference about caching.
The SDK reports tile memory use. Cache eviction and network changes can both affect the result.

Keep only the extracted anonymous metric rows with the report for
[#74](https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/74). The [measured baseline](baselines/)
includes the Android and iOS observations and their device scope. See the SDK's
[Android](https://yandex.com/maps-api/docs/mapkit/com/yandex/mapkit/map/MapLoadedListener.html)
and [iOS](https://yandex.com/maps-api/docs/mapkit/Swift/YMKMapLoadedListener.html) load callbacks.
