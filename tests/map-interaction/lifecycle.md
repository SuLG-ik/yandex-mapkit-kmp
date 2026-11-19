# Native map lifecycle regression

The Android device test and iOS XCTest open the same opt-in Compose scenario. Both send native
touches to the same projected map point before and after a Compose overlay appears. The exact
trace requires the covered touch to reach the overlay and each uncovered touch to reach the
current map once.

Each run explicitly saves a different camera viewport and marker selection. It backgrounds and
resumes the host, closes the map twice while it is animating, then removes the host. The new map
reports ready only after the native camera and marker selection match the saved state. The trace
requires one detach for each previous map and exposes late camera or input events with the old
attachment ID.

Android uses a regular `ActivityScenario` and sends input in screen coordinates. The driver moves
the Activity through background/resume and recreates it. It waits for a frame after applying an
overlay change and spaces taps on the same attachment past the double-tap interval. The Activity writes
the viewport choices to its saved state and restores them on creation. The driver also checks
MapKit's native window validity after removal. iOS uses Home and app activation for the foreground
transition. Its SwiftUI parent removes and recreates the Compose view controller while retaining
only the test scenario, which contains no native handles. The iOS test checks listener cleanup and
input across the controller replacement. Explicit native MapView destruction is Android-only.

Run the Android or iOS commands in [Native map interaction tests](README.md). Both lifecycle tests
run with the existing device test jobs.
