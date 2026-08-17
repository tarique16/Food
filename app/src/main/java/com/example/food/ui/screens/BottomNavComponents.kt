package com.example.food.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
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
    val icon: ImageVector,
    val route: String
)

val bottomNavItems = listOf(
    BottomNavItem(CART_TITLE, Icons.Filled.ShoppingCart, CART_ROUTE),
    BottomNavItem(SEARCH_TITLE, Icons.Filled.Search, SEARCH_ROUTE),
    BottomNavItem(HOME_TITLE, Icons.Filled.Home, HOME_ROUTE),
    BottomNavItem(ORDER_TITLE, Icons.Filled.History, ORDER_ROUTE),
    BottomNavItem(MORE_TITLE, Icons.Filled.MoreHoriz, MORE_ROUTE),
)