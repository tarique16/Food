package com.example.food.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Receipt
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

const val HOME_TITLE: String = "Home"
const val SEARCH_TITLE: String = "Search"
const val CART_TITLE: String = "Cart"
const val ORDER_TITLE: String = "Order"
const val MORE_TITLE: String = "More"

const val HOME_ROUTE: String = "home"
const val SEARCH_ROUTE: String = "search"
const val CART_ROUTE: String = "cart"
const val ORDER_ROUTE: String = "order"
const val MORE_ROUTE: String = "more"

data class BottomNavItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(
        title = CART_TITLE,
        route = CART_ROUTE,
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart
    ),
    BottomNavItem(
        title = SEARCH_TITLE,
        route = SEARCH_ROUTE,
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search
    ),
    BottomNavItem(
        title = HOME_TITLE,
        route = HOME_ROUTE,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    BottomNavItem(
        title = ORDER_TITLE,
        route = ORDER_ROUTE,
        selectedIcon = Icons.Filled.Receipt,
        unselectedIcon = Icons.Outlined.Receipt
    ),
    BottomNavItem(
        title = MORE_TITLE,
        route = MORE_ROUTE,
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle
    ),
)