package com.example.food

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.food.ui.screens.CART_ROUTE
import com.example.food.ui.screens.CART_TITLE
import com.example.food.ui.screens.CartScreen
import com.example.food.ui.screens.HOME_ROUTE
import com.example.food.ui.screens.HOME_TITLE
import com.example.food.ui.screens.HomeScreen
import com.example.food.ui.screens.MORE_ROUTE
import com.example.food.ui.screens.MORE_TITLE
import com.example.food.ui.screens.MoreScreen
import com.example.food.ui.screens.ORDER_ROUTE
import com.example.food.ui.screens.ORDER_TITLE
import com.example.food.ui.screens.OrderScreen
import com.example.food.ui.screens.SEARCH_ROUTE
import com.example.food.ui.screens.SEARCH_TITLE
import com.example.food.ui.screens.SearchScreen
import com.example.food.ui.screens.bottomNavItems
import com.example.food.ui.theme.FoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodTheme {
                BottomNav()
            }
        }
    }
}

@Composable
fun BottomNav() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route
            NavigationBar(
                modifier = Modifier.fillMaxWidth()
            ) {
                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        selected = item.route == currentRoute,
                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = item.title
                            )
                        },
                        label = { Text(item.title) }
                    )
                }
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            NavHost(navController = navController, startDestination = HOME_ROUTE) {
                composable(HOME_ROUTE) { HomeScreen(HOME_TITLE) }
                composable(SEARCH_ROUTE) { SearchScreen(SEARCH_TITLE) }
                composable(CART_ROUTE) { CartScreen(CART_TITLE) }
                composable(ORDER_ROUTE) { OrderScreen(ORDER_TITLE) }
                composable(MORE_ROUTE) { MoreScreen(MORE_TITLE) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    FoodTheme {
        BottomNav()
    }
}