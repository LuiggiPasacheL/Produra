package com.example.produra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.produra.presentation.addProduct.AddProductView
import com.example.produra.presentation.productList.ProductListView
import com.example.produra.ui.theme.ProduraTheme
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
            NavHost(navController = navController, startDestination = "list") {
                composable("list") {
                    ProductListView(onNavigateToAddProduct = {
                        navController.navigate(
                            "add"
                        )
                    })
                }
                composable("add") {
                    AddProductView(
                        onNavigateToListProducts = {
                            navController.navigate(
                                "list"
                            )
                        }
                    )
                }
            }
        }
    }
}