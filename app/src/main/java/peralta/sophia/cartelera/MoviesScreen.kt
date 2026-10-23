package peralta.sophia.cartelera

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.keepScreenOn
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.rotationMatrix
import peralta.sophia.cartelera.ui.theme.CarteleraTheme

@Composable
fun MoviesScreen(
    email: String,
    onMovieClick: (Int) -> Unit,
    onLogout: () -> Unit
){
    Column(modifier = Modifier.fillMaxSize()){
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column {
                Text(
                    text = "Movies",
                    style = MaterialTheme.typography.headlineMedium,
                )
                Text(
                    text = email,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
            TextButton(onClick = onLogout) {
                Text("Log out")
            }
        }
        
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(movies) {movie ->
                MovieItem(
                    movie = movie,
                    onClick = {onMovieClick(movie.id)}
                )
            }
        }
    }


}

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(movie.image),
                contentDescription = "${movie.title} Poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 80.dp, height = 120.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "${movie.year} - ${movie.genre}"
                )
            }
        }
    }
}

@Preview
@Composable
fun MoviesScreenPreview(){
    MoviesScreen(
        email = "jannette@correo.com",
        onMovieClick = {},
        onLogout = {}
    )
}