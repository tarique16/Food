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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    val defaultTab = HOME_ROUTE
    val selectedTab = remember { mutableStateOf(defaultTab) }
    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier.fillMaxWidth()
            ) {
                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        selected = item.route == selectedTab.value,
                        onClick = { selectedTab.value = item.route },
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
            when (selectedTab.value) {
                HOME_ROUTE -> {
                    HomeScreen(HOME_TITLE)
                }

                SEARCH_ROUTE -> {
                    SearchScreen(SEARCH_TITLE)
                }

                CART_ROUTE -> {
                    CartScreen(CART_TITLE)
                }

                ORDER_ROUTE -> {
                    OrderScreen(ORDER_TITLE)
                }

                MORE_ROUTE -> {
                    MoreScreen(MORE_TITLE)
                }

                else -> {
                    HomeScreen(HOME_TITLE)
                }
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