package kz.hackathon.krcm_36.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kz.hackathon.krcm_36.ui.screens.company.CompanyScreen
import kz.hackathon.krcm_36.ui.screens.main.SearchScreen

@Composable
fun Routing()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "/main"){
        composable("/main"){
            SearchScreen(navController)
        }
        composable(
            route = "main/company/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val companyName = backStackEntry.arguments?.getString("name")
            companyName?.let { CompanyScreen(it) }
        }
    }
}