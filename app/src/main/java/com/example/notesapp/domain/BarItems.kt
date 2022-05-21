package com.example.notesapp.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BarItems(
    val title: String,
    val image: ImageVector,
    val route: String
)


object NaveBarItem {

    val NavItems = listOf(
        BarItems(title = "Home", image = Icons.Outlined.Home, route = "home"),
        BarItems(title = "Setting", image = Icons.Outlined.Search, route = "setting"),
        BarItems(
            title = "Search",
            image = Icons.Outlined.Search,
            route = "search"
        )
    )

}