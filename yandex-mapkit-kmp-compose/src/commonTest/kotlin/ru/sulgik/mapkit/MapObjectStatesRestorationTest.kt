//package ru.sulgik.mapkit
//
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.testTag
//import androidx.compose.ui.test.ComposeUiTest
//import androidx.compose.ui.test.ExperimentalTestApi
//import androidx.compose.ui.test.StateRestorationTester
//import androidx.compose.ui.test.assertTextEquals
//import androidx.compose.ui.test.onNodeWithTag
//import androidx.compose.ui.test.performClick
//import androidx.compose.ui.test.runComposeUiTest
//import ru.sulgik.mapkit.compose.rememberCircleState
//import ru.sulgik.mapkit.geometry.Circle
//import ru.sulgik.mapkit.geometry.Point
//import kotlin.test.Test
//
//@OptIn(ExperimentalTestApi::class)
//public class MapObjectStatesRestorationTest {
//
//    @Test
//    public fun `CircleState should be restored valid`() {
//        composeUiStateRestorationTest(
//            expectedResult = CIRCLE_GEOMETRY_CHANGE.toString(),
//            state = { rememberCircleState(geometry = CIRCLE_GEOMETRY_INITIAL) },
//            updateState = { it.geometry = CIRCLE_GEOMETRY_CHANGE },
//            result = { it.geometry.toString() },
//        )
//    }
//
//    private inline fun composeUiStateRestorationTest(
//        crossinline content: ComposeUiTest.(StateRestorationTester) -> Unit,
//    ) {
//        runComposeUiTest {
//            content(StateRestorationTester(this))
//        }
//    }
//
//    private inline fun <T> composeUiStateRestorationTest(
//        expectedResult: String,
//        crossinline state: @Composable () -> T,
//        crossinline updateState: (T) -> Unit,
//        crossinline result: (T) -> String = { it.toString() },
//    ) {
//        composeUiStateRestorationTest { tester ->
//            tester.setContent {
//                val currentState = state()
//                Button(
//                    onClick = { updateState(currentState) },
//                    modifier = Modifier.testTag("changeStateButton")
//                ) {}
//                Text(result(currentState), modifier = Modifier.testTag("resultText"))
//            }
//            onNodeWithTag("changeStateButton").performClick()
//            tester.emulateSaveAndRestore()
//            onNodeWithTag("resultText").assertTextEquals(expectedResult)
//        }
//    }
//
//    private companion object {
//        val CIRCLE_GEOMETRY_INITIAL =
//            Circle(center = Point(0.0, 0.0), radius = 15f)
//        val CIRCLE_GEOMETRY_CHANGE =
//            Circle(center = Point(0.0, 0.0), radius = 15f)
//    }
//
//}