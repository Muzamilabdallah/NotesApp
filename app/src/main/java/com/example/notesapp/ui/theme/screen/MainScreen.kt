package com.example.notesapp.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.ui.theme.NotesAppTheme
import com.example.notesapp.ui.theme.screen.component.CustomNavigationBar
import com.ramcosta.composedestinations.DestinationsNavHost

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            CustomNavigationBar(navController)
        }
    ) {
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.root
        )
    }


}




@Preview
@Composable
fun MainPreview() {
    NotesAppTheme {

    }
}

