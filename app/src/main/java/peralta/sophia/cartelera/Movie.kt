package peralta.sophia.cartelera

data class Movie(
    val id: Int,
    val title: String,
    val year: Int,
    val duration: Int,
    val genre: String,
    val director: String,
    val synopsis: String,
    val image: Int
)

var movies = listOf(
    Movie(
        1,
        "Obsession",
        2025,
        109,
        "Supernatural Horror",
        "Curry Barker",
        "The plot of the 2025/2026 psychological horror film Obsession, directed by Curry Barker, centers on a socially awkward music store clerk named Baron \"Bear\" Bailey (Michael Johnston) and his unrequited obsession with his childhood friend and coworker, Nikki Freeman (Inde Navarrette).",
        R.drawable.obsession_poster
    ),
    Movie(
        2,
        "San Andreas",
        2015,
        114,
        "Disaster thriller",
        "Brad Peyton",
        "San Andreas is a 2015 American disaster thriller film starring Dwayne Johnson. The film was directed by Brad Peyton and written by Carlton Cuse. Carla Gugino, Alexandra Daddario, Ioan Gruffudd, Archie Panjabi and Paul Giamatti also star. Its plot centers on a massive earthquake caused by the San Andreas Fault that devastates the West Coast of the United States.",
        R.drawable.san_andreas_poster
    ),
    Movie(
        3,
        "Dune",
        2021,
        155,
        "Epic Space Opera",
        "Denis Villeneuve",
        "Dune (titled on-screen as Dune: Part One) is a 2021 American epic space opera film co-produced and directed by Denis Villeneuve, who co-wrote the screenplay with Jon Spaihts and Eric Roth. It is the first of a two-part adaptation of the 1965 novel by Frank Herbert and the first installment in Villeneuve's Dune film trilogy. The cast includes Timothée Chalamet, Rebecca Ferguson, Oscar Isaac, Josh Brolin, Stellan Skarsgård, Dave Bautista, Stephen McKinley Henderson, Zendaya, Chang Chen, Sharon Duncan-Brewster, Charlotte Rampling, Jason Momoa, and Javier Bardem. Set in the distant future, the film follows Paul Atreides (Chalamet) as his family, the aristocratic House Atreides, is thrust into a war for the inhospitable desert planet Arrakis.",
        R.drawable.dune_poster
    ),
    Movie(
        4,
        "Coraline",
        2009,
        100,
        "Gothic Dark Fantasy Horror",
        "Henry Selick",
        "The film tells the story of a young girl discovering an idealized alternate universe behind a secret door in her new home, unaware that it contains something dark and sinister.",
        R.drawable.coraline_poster
    ),
    Movie(
        5,
        "Pixels",
        2015,
        105,
        "Science Fiction Comedy",
        "Chris Columbus",
        "In the film, an alien force misinterprets videotaped footage of classic arcade games as a declaration of war, resulting in them attacking Earth with technological recreations of icons from the games; the president of the United States assembles a team of former arcade champions to lead the planet's defense.",
        R.drawable.pixels_poster
    ),
    Movie(
        6,
        "Spider-Man: No Way Home",
        2021,
        148,
        "American Superhero",
        "Jon Watts",
        "In the film, Peter asks Dr. Stephen Strange (Cumberbatch) to use magic to make his identity as Spider-Man a secret again after it was revealed to the world at the end of Far From Home. When the spell goes wrong due to Peter's actions, the multiverse is broken open and several visitors from alternate realities are brought into Peter's universe.",
        R.drawable.spiderman_poster
    ),


)
