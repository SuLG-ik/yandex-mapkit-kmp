# Live MapKit service checks

The current-runtime entries of **MapKit device matrix** report whether live service verification
can run. They only read the dedicated `MAPKIT_TEST_API_KEY` secret for scheduled and manual runs
on `main` of the maintainer repository. Use a restricted test key. Pull request jobs and release
verification do not use it.

The search hooks install the Full consumer built in a separate, credential-free step. They
transfer the key to a private file in the debug app's sandbox at launch. The app reads and removes
that file, then writes a marker with only its result category. On Android, a checked-in shell
script starts a dedicated emulator after the offline action exits. First-party steps stage and
consume a restricted runner file. The hook uses `adb run-as` and stdin for the app transfer. The
iOS hook writes the file in the installed simulator app container. The credential and its runner
handoff path stay out of action inputs, build arguments, artifact paths and device command
arguments. The driver then runs a separate credential-free
cleanup while the device is still running, including after a hook deadline. Cleanup is itself
bounded. It terminates only the fixture app, removes its temporary inputs and markers and reports
an incomplete cleanup if it cannot reach the device.

The app makes one online request for cafés in the same Moscow area on both platforms. An online
response must contain at least one nonblank name with valid coordinates. Ranking, result count
and specific businesses can change between runs. The app owns the native session and cancels an
unfinished request after 20 seconds. The surrounding runner limits a hook to 120 seconds so an
unresponsive emulator, launch or poll cannot block the job.

Routing remains skipped until `routing-android.sh` and `routing-ios.sh` are added. Each hook receives
the booted device identifier as its only argument and reads the key from its scoped environment.
Routing can add a credential-free preparation step if it needs its own fixture.

| Status | Meaning |
| --- | --- |
| `0` | Passed |
| `10` | MapKit supplied a typed unauthorized or forbidden error |
| `11` | The provider returned another error or the 20-second request deadline expired |
| `12` | Callback, conversion or result-shape verification failed |
| Anything else | The runner or fixture failed |

The driver discards raw output and uploads only the result categories. An authorization,
provider, wrapper or runner failure marks the corresponding scheduled/manual job failed. The
offline regression suite still runs without credentials.
