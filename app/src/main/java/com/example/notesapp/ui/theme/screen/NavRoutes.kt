package com.example.notesapp.ui.theme.screen

import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(
    val id: String,val title:String,val icon:ImageVector

) {
    object Home : Routes(id = "home", "Home", Icons.Outlined.Home)
    object Search : Routes(id = "search", "Search", Icons.Outlined.Search)
    object Setting : Routes(id = "setting", "Setting", Icons.Outlined.Settings)
    object bottomItems { val items = listOf( Home,  Search,Setting) }

}