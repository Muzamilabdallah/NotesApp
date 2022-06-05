package com.example.notesapp.ui.theme.screen.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.notesapp.ui.theme.screen.NavGraphs
import com.example.notesapp.ui.theme.screen.Routes
import com.example.notesapp.ui.theme.screen.appCurrentDestinationAsState
import com.example.notesapp.ui.theme.screen.startAppDestination
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec


@Composable
fun CustomNavigationBar(
    navController: NavController,

    ) {
    var currentDestination: DirectionDestinationSpec? =
        (navController.appCurrentDestinationAsState().value
            ?: NavGraphs.root.startAppDestination) as DirectionDestinationSpec?

    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = CenterVertically
    ) {
        Routes.values().forEach { item ->
            BottomNavigationItems(item, isItemSelected = currentDestination == item.direction) {
                navController.navigate(item.direction) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
//                    val navigationRoutes = Routes.values()
//                    val firstBottomBarDestination = navController.backQueue
//                        .firstOrNull {navBackStackEntry -> checkForDestinations(navigationRoutes, navBackStackEntry) }
//                        ?.destination
//                    // so only the currently selected screen remains in the stack
//                    if (firstBottomBarDestination != null) {
//                        popUpTo(firstBottomBarDestination.id) {
//                            inclusive = true
//                            saveState = true
//                        }
//                    }


                }
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavigationItems(
    item: Routes,
    isItemSelected: Boolean,
    onClick: () -> Unit
) {
    val backround =
        if (isItemSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor =
        if (isItemSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(backround)
            .padding(8.dp)
            .clickable(onClick = onClick),

        ) {


        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {


            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = contentColor
            )

            AnimatedVisibility(visible = isItemSelected) {
                Text(
                    text = stringResource(id = item.label),
                    color = contentColor
                )
            }

        }
    }

}


fun checkForDestinations(
navigationRoutes: Array<Routes>,
navBackStackEntry: NavBackStackEntry
): Boolean {
    navigationRoutes.forEach {
        if (it.direction.route == navBackStackEntry.destination.route){
            return  true
        }

    }
    return false
}

@Composable
fun prev() {

}





