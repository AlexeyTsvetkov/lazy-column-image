import androidx.compose.material.MaterialTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale

data class Image(val imageRes: String)

val Images = listOf(
    Image("red.jpeg"),
    Image("orange.jpeg"),
    Image("yellow.jpeg"),
    Image("green.jpeg"),
    Image("blue.jpeg"),
    Image("violet.jpeg"),
    Image("black.jpeg"),
)

fun main() {
    application {
        Window(onCloseRequest = ::exitApplication) {
            MaterialTheme {
                AllImagesView(Images)
            }
        }
    }
}

@Composable
fun AllImagesView(imageList: List<Image>) {
    LazyColumn(
        Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = imageList) { art ->
            ImageView(art.imageRes)
        }
    }
}

@Composable
fun ImageView(image: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .requiredHeight(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = image,
            modifier = Modifier.padding(top = 8.dp),
        )
    }
}
