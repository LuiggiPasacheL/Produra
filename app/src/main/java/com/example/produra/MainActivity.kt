package com.example.produra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.produra.presentation.cart.CartView
import com.example.produra.presentation.productForm.AddProductView
import com.example.produra.presentation.productList.ProductListView
import com.example.produra.ui.theme.ProduraTheme
import com.example.produra.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    ProduraTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController, startDestination = Constants.ComponentRoutes.LIST
            ) {
                composable(Constants.ComponentRoutes.LIST) {
                    ProductListView(onNavigateToAddProduct = {
                        navController.navigate(
                            Constants.ComponentRoutes.PRODUCTFORM
                        )
                    }, onNavigateToCart = {
                        navController.navigate(
                            Constants.ComponentRoutes.CART
                        )
                    }, onNavigateToProduct = {
                        navController.navigate(
                            Constants.ComponentRoutes.PRODUCTFORM.replace(
                                "{productId}", it.toString()
                            )
                        )
                    })
                }
                composable(
                    Constants.ComponentRoutes.PRODUCTFORM,
                    arguments = listOf(navArgument("productId") {
                        type = NavType.IntType
                        defaultValue = 0
                    })
                ) {
                    AddProductView(onNavigateToListProducts = {
                        navController.navigate(
                            Constants.ComponentRoutes.LIST
                        )
                    })
                }
                composable(Constants.ComponentRoutes.CART) {
                    CartView(onNavigateToListProducts = {
                        navController.navigate(
                            Constants.ComponentRoutes.LIST
                        )
                    }, onNavigateToProduct = {
                        navController.navigate(
                            Constants.ComponentRoutes.PRODUCTFORM.replace(
                                "{productId}", it.toString()
                            )
                        )
                    })
                }
            }
        }
    }
}