import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home"){
            HomeScreen(
                onMovieClick = { movie ->
                    navController.navigate("details/${movie.id}")
                }
            )
        }

        composable(
            route = "details/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ){ backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId")
            DetailScreen(
                movie = movies.first { it.id == movieId },
                onBack = { navController.popBackStack() }
            )
        }
    }
}

