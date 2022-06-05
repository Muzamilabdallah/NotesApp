package com.example.notesapp.ui.theme.screen

import android.media.Image
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.notesapp.R
import com.example.notesapp.ui.theme.screen.destinations.HomeScreenDestination
import com.example.notesapp.ui.theme.screen.destinations.SearchDestination
import com.example.notesapp.ui.theme.screen.destinations.SettingDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class Routes(
    val direction: DirectionDestinationSpec,
    @StringRes val label: Int,
    val icon: ImageVector,
) {
    Home(HomeScreenDestination, R.string.home, Icons.Outlined.Home),
    Search(SearchDestination, R.string.search, Icons.Outlined.Search),
    Setting(SettingDestination, R.string.setting, Icons.Outlined.Settings)
//    object bottomItems { val items = listOf( Home,  Search,Setting) }

}