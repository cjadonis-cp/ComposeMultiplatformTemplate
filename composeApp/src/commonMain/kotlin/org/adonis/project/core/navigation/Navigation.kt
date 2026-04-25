package org.adonis.project.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

// ============================================================================
// STEP 1: Define Routes
// ============================================================================
// Use @Serializable to make routes type-safe (Navigation Compose 2.9+).
// - Use `object` for screens with NO arguments.
// - Use `data class` for screens WITH arguments.
// - Use nullable types with defaults for optional arguments:
//       @Serializable data class SearchRoute(val query: String? = null)

@Serializable
object HomeRoute

// @Serializable
// data class DetailRoute(val itemId: String)

// @Serializable
// data class ProfileRoute(val userId: Int, val name: String)

// ============================================================================
// STEP 2: Set Up NavHost
// ============================================================================
// - rememberNavController() creates and remembers the NavHostController.
// - NavHost swaps composables based on the current route.
// - startDestination is the first screen shown.
// - Each composable<Route> { } block defines what UI to show for that route.

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            // TODO: Replace with your Home screen composable
            // Example: HomeScreen(navController)
        }

        // composable<DetailRoute> { backStackEntry ->
        //     // STEP 3: Read arguments using toRoute<>()
        //     val route = backStackEntry.toRoute<DetailRoute>()
        //     // Use route.itemId
        //     // Example: DetailScreen(itemId = route.itemId, navController = navController)
        // }

        // composable<ProfileRoute> { backStackEntry ->
        //     val route = backStackEntry.toRoute<ProfileRoute>()
        //     // Use route.userId, route.name
        // }
    }
}

// ============================================================================
// STEP 3: Navigate Between Screens
// ============================================================================
// From any composable that has access to navController:
//
//   Forward navigation (with arguments):
//       navController.navigate(DetailRoute(itemId = "abc"))
//
//   Go back:
//       navController.popBackStack()
//
//   Navigate and clear back stack (e.g. go home and remove everything above):
//       navController.navigate(HomeRoute) {
//           popUpTo<HomeRoute> { inclusive = true }
//           launchSingleTop = true
//       }
//
// ============================================================================
// STEP 4: Read Route Arguments
// ============================================================================
// Inside a composable<Route> block, use toRoute<>() to extract arguments:
//
//   composable<DetailRoute> { backStackEntry ->
//       val route = backStackEntry.toRoute<DetailRoute>()
//       DetailScreen(itemId = route.itemId)
//   }
//
// ============================================================================
// STEP 5: Nested Navigation (optional)
// ============================================================================
// Group related screens under a nested graph:
//
//   navigation<SettingsGraphRoute>(startDestination = SettingsHomeRoute) {
//       composable<SettingsHomeRoute> { ... }
//       composable<SettingsDetailRoute> { ... }
//   }
//
// ============================================================================
