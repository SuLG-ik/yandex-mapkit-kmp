# Live MapKit service checks

The current-runtime entries of **MapKit device matrix** report whether live service verification
can run. They only read the dedicated `MAPKIT_TEST_API_KEY` secret for scheduled and manual runs
on `main` of the maintainer repository. Use a restricted test key. Pull request jobs and release
verification do not use it.

The hooks install the same Full consumer built in a separate, credential-free step. On Android,
the workflow boots a dedicated emulator with a checked-in shell script after the offline matrix
action exits. On iOS it reuses the booted simulator. First-party steps stage and consume a
restricted runner file. Each hook transfers the key to a separate private file in the app sandbox.
Android uses `adb run-as` with stdin. iOS writes directly into the installed simulator app's
container. The app reads and removes the file at launch. The credential and the runner handoff path
stay out of action inputs, build arguments, device command arguments and diagnostic artifacts.

The search probe makes one online request for cafés in a preset Moscow area. An online response
must contain a nonblank place name with valid coordinates. Rankings and businesses may change. The
app owns the session and cancels an unfinished request after 20 seconds.

The routing probe requests driving, pedestrian, bicycle and public transit routes in the same preset
region. Each mode starts a route to a different destination and cancels it before submitting the
replacement. The probe requires a real callback for the replacement and observes whether the
retired request delivers a callback during cancellation or the bounded draw window. It checks
nonempty geometry and ordered waypoints. The public transit case requires an alternative with a
transit line. The accepted geometry is set on a native polyline, then cleared. A mode times out
after 18 seconds. Success requires four mode markers and the final routing marker. Deterministic
adapter tests inject retired callbacks separately to cover delivery even when the provider honors
cancellation before it replies.

Markers contain fixed probe names and status codes. After each launch, including a timeout, the
runner starts bounded, credential-free cleanup on the same device. It terminates the fixture app,
removes its temporary inputs and markers and reports an incomplete cleanup if the device is
unreachable. Each hook has a 120-second outer deadline.

| Status | Meaning |
| --- | --- |
| `0` | Passed |
| `10` | MapKit supplied a typed unauthorized or forbidden error |
| `11` | The provider returned another error or the request deadline expired |
| `12` | Callback, conversion or result-shape verification failed |
| Anything else | The runner or fixture failed |

The driver discards raw output and uploads only the result categories. An authorization,
provider, wrapper or runner failure marks the corresponding scheduled/manual job failed. The
offline regression suite still runs without credentials.
