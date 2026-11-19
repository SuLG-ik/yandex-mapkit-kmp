# Measure return to a map

Open **Measure return to map** in the sample. The probe uses the same 260 dp viewport, daytime
style, camera at 55.751225 / 37.629540 (zoom 16, zero tilt and azimuth), and three local markers
on Android and iOS. The default mode uses no basemap. The **Real tiles** mode uses the SDK's
vector basemap and default disk cache. Choose a mode before the first measurement.

## Controlled run

Use a disposable test install, a fixed device and OS/runtime per report, portrait orientation,
the same revision and a stable connection for the real-tile comparison. Build the normal sample
for each platform. For a trusted real-tile run, configure a dedicated MapKit key with the sample's
ignored `local.properties` on a trusted machine. Keep the key out of logs and uploaded artifacts.
No hosted PR job runs this probe. A blank or all-zero placeholder key is reported as
`missing_key` if real tiles are requested. The placeholder can be used for view-only measurements.

1. Use a new install with fresh app data and open **Open on clean install**. Tap once at the
   center when the prompt appears. Wait for the result or its 30-second deadline.
2. Use **Details (unmount map)**, then **Return to map**. Repeat the tap and wait for the result.
   This recreates the view in the same process after the preceding viewport warmed the SDK.
3. Use **Other tab (retain map)**, then **Return to map**. The map stays mounted behind the other
   tab. Tap and wait for the result.
4. Stop and restart the app process while keeping app data, choose the same tile mode, then
   use **Open after process restart**. Tap and wait again. On Android use a normal force-stop
   and launch. On iOS terminate and launch the same installed app. The report ID changes on
   reentering the benchmark, so keep the captured logs from both processes.

Repeat each in-process case at least five times and repeat the clean-install and process-restart
sequence on fresh test installs for cold trials. For the real-tile series, wait for `tiles=loaded`
before using a cold view to warm its matched reopen/restart sample. Record any timeouts. Keep a
separate file or report per device, SDK mode and experimental configuration. Record the network
and whether this is a real device or emulator/simulator. Time the real run on each target before
claiming an improvement.

## Collect a report

Copy the selectable `MAPKIT_RETURN_METRIC|` lines from the sample, or save the Android Logcat
or Xcode console output that contains those lines. Do not combine captures from different devices.
Use the same revision identifier for the compared binaries.

```sh
python3 verification/return-to-map/summarize.py --device "Android Pixel 6a, API 33" --revision YOUR_GIT_SHA android.log
python3 verification/return-to-map/summarize.py --device "iOS iPhone 16e Simulator, iOS 26.2" --revision YOUR_GIT_SHA ios.log
```

The report gives medians, ranges and observed/attempted counts. Duplicate log lines are deduplicated
by trial ID. The parser rejects mixed measured viewports and conflicting duplicate IDs. It keeps
deadline rows and missing fields. It reports signed differences only from pairs in the same trial.

| Field | Meaning |
|---|---|
| `mount_ms` / `mounts` | First native map attachment after the route action and count of attachments since route departure. An intact retained map has no mount timing and zero attachments. |
| `overlay_ms`, `markers`, `icons` | Time when local markers were assigned to the native map and number of new markers and bitmap providers. For retained overlays, the first valid returning frame records when the existing overlays are available again. Assignment timing is not a screenshot/presentation measurement. |
| `ready_ms` | First observed Compose frame with a nonzero native window, the intended camera and a valid world-to-screen projection. It is the input-readiness proxy independent of the basemap. |
| `tap_ms` | First native input callback near the center after projection. This upper bound includes the operator's reaction. Compare `ready_ms` for host readiness rather than manual tap latency. |
| `tile_ms`, `tiles` | Elapsed time from route entry to the one-shot loaded callback for the fixed viewport. A retained return doesn't request or infer a fresh tile completion. A timeout or missing key is explicitly marked. |
| SDK metrics | The nine fields of `MapLoadStatistics` exposed by the wrapper. SDK durations are separate from route durations. |

Compare matched cold/reopen/restart `tile_ms` minus `ready_ms` values to see how long the basemap was
the last observed bottleneck. Compare cold/reopen/retained `mount_ms`, `overlay_ms`, `ready_ms` and
counters to isolate work in the view and markers. A warm response with the same viewport can
suggest a cache effect. The public SDK data does not supply a per-request cache-hit counter.
Both network variation and cache eviction can change the result.

Keep the raw anonymized measurements with the report for
[#74](https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/74). There is no measured baseline in this
directory. No timing values should be treated as established until the controlled Android and iOS
series are captured. See the SDK's [Android](https://yandex.com/maps-api/docs/mapkit/com/yandex/mapkit/map/MapLoadedListener.html)
and [iOS](https://yandex.com/maps-api/docs/mapkit/Swift/YMKMapLoadedListener.html) load callbacks.
