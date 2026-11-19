# Live MapKit service checks

The current-runtime entries of **MapKit device matrix** report whether live service verification
can run. They only read the dedicated `MAPKIT_TEST_API_KEY` secret for scheduled and manual runs
on `main` of the maintainer repository. Use a restricted test key. Pull request jobs and release
verification do not use it.

The driver looks for `search-android.sh`, `search-ios.sh`, `routing-android.sh` and
`routing-ios.sh` in this directory. The search and routing implementations can add their hooks
independently. An absent hook is reported as skipped. Each hook receives the booted device
identifier as its only argument and reads the key from its environment. Keep the hook focused on
the device check. A future workflow step can build the test app before the secret-scoped step
when a fresh build would consume the hook's deadline.

Use fixed inputs and check the result shape. For example, check that a search response exposes
the expected metadata shape or a route has valid geometry and duration. Search ranking, route
choice and measured duration can change independently of the wrapper. Give each request a finite
deadline and cancel its native session on timeout. The surrounding runner limits a hook to 120
seconds and reports only a normalized category.

| Status | Meaning |
| --- | --- |
| `0` | Passed |
| `10` | The provider rejected the API key or its authorization |
| `11` | The provider returned a service/network error or the bounded request timed out |
| `12` | Callback, conversion or result-shape verification failed |
| Anything else | The runner or fixture failed |

Pass the key only to the temporary test process. Keep the key, provider logs and unfiltered
device logs out of uploaded artifacts. The driver discards raw output and uploads only the
result categories. An authorization, provider, wrapper or runner failure marks the corresponding
scheduled/manual job failed. The offline regression suite still runs without credentials.
