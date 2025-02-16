package com.example.anfisaplants


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.anfisaplants.ui.NotificationAppBar
import com.example.anfisaplants.ui.NotificationScreen
import com.example.anfisaplants.ui.StartScreen
import com.example.anfisaplants.ui.StartScreenBottomBar

/**
 * enum values that represent the screens in the app
 */
enum class PlantsScreen {
    Start,
    Notifications,
}

@Composable
fun PlantsApp(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = PlantsScreen.valueOf(
        backStackEntry?.destination?.route ?: PlantsScreen.Start.name
    )

    val bottomBar: (@Composable () -> Unit)? = when (currentScreen) {
        PlantsScreen.Start -> {
            {
                StartScreenBottomBar(
                    onNotificationsClick = {
                        navController.navigate(PlantsScreen.Notifications.name)
                    }
                )
            }
        }

        else -> null
    }

    val topBar: (@Composable () -> Unit)? = when (currentScreen) {
        PlantsScreen.Notifications -> {
            {
                NotificationAppBar(
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            }
        }

        else -> null
    }

    Scaffold(
        topBar = { topBar?.invoke() },
        bottomBar = { bottomBar?.invoke() },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PlantsScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = PlantsScreen.Start.name) {
                StartScreen(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = PlantsScreen.Notifications.name) {
                NotificationScreen(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}
