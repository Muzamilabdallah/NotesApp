package com.example.notesapp.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.ui.theme.NotesAppTheme
import com.example.notesapp.ui.theme.screen.component.CustomNavigationBar
import com.example.notesapp.ui.theme.screen.component.Setting
import com.ramcosta.composedestinations.annotation.Destination

@Destination(route = "main",start = true)
@Composable
fun MainScreen(items: List<Routes>) {
    val navController = rememberNavController()
    val currentScreen = remember { mutableStateOf<Routes>(Routes.Home) }

    Scaffold(
topBar = { TopAppBar(modifier = Modifier.background(Color.Blue)) {
    Text(text = "Hello")
}},
       content = { navigationHost(navController = navController) },
        bottomBar = {
            CustomNavigationBar(
                navController,
                items = items,
                currentScreenId = currentScreen.value.id
            ) {
                currentScreen.value = it
            }
        }
    )
}


@Composable
fun navigationHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Home.id) {
        composable(Routes.Home.id) {
            HomeScreen()
        }

        composable(Routes.Setting.id) {
            Setting()
        }

        composable(Routes.Search.id) {
            Search()
        }

    }
}


@Preview
@Composable
fun MainPreview() {
    NotesAppTheme{
        MainScreen(items =      Routes.bottomItems.items
        )
    }
}

