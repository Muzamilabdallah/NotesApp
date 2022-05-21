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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.notesapp.domain.BarItems
import com.example.notesapp.ui.theme.screen.Routes


@Composable
fun CustomNavigationBar(
    navController: NavHostController,
    items: List<Routes>,
    currentScreenId: String,
    onItemSelected: (Routes) -> Unit
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = CenterVertically
    ) {
        items.forEach { item ->
            BottomNavigationItems(item, isItemSelected = item.id == currentScreenId) {
                onItemSelected(item)
                navController.navigate(item.id) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
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
                    text = item.title,
                    color = contentColor
                )
            }

        }
    }

}


@Composable
fun prev(){

}





