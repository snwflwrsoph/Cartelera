package peralta.sophia.cartelera

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import peralta.sophia.cartelera.ui.theme.CarteleraTheme

@Composable
fun DetailScreen(movieId: Int, onBack: () -> Unit) {
    val movie = movies.first {it.id == movieId}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(movie.image),
            contentDescription = "${movie.title} Poster",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
        )
        Text(
            text = movie.title,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "${movie.year} - ${movie.duration} min - ${movie.genre}"
        )
        Text(
            text = "Director: ${movie.director}"
        )
        Text(
            text = "Synopsis",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = movie.synopsis
        )
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    CarteleraTheme {
        DetailScreen(movieId = 1, onBack = {})
    }
}