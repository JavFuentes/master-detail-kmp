import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val database = getDatabaseBuilder().build()
    App(database.moviesDao())
}