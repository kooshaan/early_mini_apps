package com.example.nokiatest.movieapp.model

data class Movie(
    val id: String,
    val title: String,
    val year : String,
    val rated : String,
    val release : String,
    val runtime : String,
    val genre : String,
    val plot: String,
    val director : String,
    val language : String,
    val country : String,
    val awards : String,
    val metascore : String,
    val imdbRating : String,
    val imdbVotes : String,
    val imdbID : String,
    val images : List<String>,
)
val myList = listOf(
    Movie(
        "0",
        "The Avengers",
        "2012",
        "PG-13",
        "04 May 2012",
        "143 min",
        "Action, Sci-Fi, Thriller",
        "Earth's mightiest heroes must come together " +
                "and learn to fight as a team if they are to stop " +
                "the mischievous Loki and his alien army from enslaving humanity.",
        "Joss Whedon",
        "En, Rus",
        "USA",
        "Nom. for 1 Oscar. Another 34 wins & 75 nominations.",
        "69",
        "8.1",
        "1,003,301",
        "tt0848228",
        listOf(
            "https://cdn.sargarme.com/uploads/2023/11/photo1700407188.jpeg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTA0NjY0NzE4OTReQTJeQWpwZ15BbWU3MDczODg2Nzc@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjE1MzEzMjcyM15BMl5BanBnXkFtZTcwNDM4ODY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjMwMzM2MTg1M15BMl5BanBnXkFtZTcwNjM4ODY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4NzM2Mjc5MV5BMl5BanBnXkFtZTcwMTkwOTY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc3MzQ3NjA5N15BMl5BanBnXkFtZTcwMzY5OTY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfr8q20wC4e5UFojVrQCs_8tlfJ49o3RxF6lzSku8Y0X-vPELrtKEyLOXQP1W_yI0LJDg&usqp=CAU"
        )),
    Movie(
        "1",
        "Interstellar",
        "2014",
        "PG-13",
        "07 Nov 2014",
        "169 min",
        "Adventure, Drama, Sci-Fi",
        "A team of explorers travel through a wormhole" +
                " in space in an attempt to ensure humanity's survival.",
        "Christopher Nolan",
        "En",
        "USA, UK",
        "1 Oscar. Another 39 wins & 134 nominations.",
        "74",
        "8.6",
        "937,412",
        "tt0816692",
        listOf(
            "https://static.cdn.asset.cinematicket.org/media/image/2020/8/34ddde2d-7c3c-4884-bdb2-d8708a2c36cf_desktop.jpeg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjA3NTEwOTMxMV5BMl5BanBnXkFtZTgwMjMyODgxMzE@._V1_SX1500_CR0,0,1500,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMzQ5ODE2MzEwM15BMl5BanBnXkFtZTgwMTMyODgxMzE@._V1_SX1500_CR0,0,1500,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTg4Njk4MzY0Nl5BMl5BanBnXkFtZTgwMzIyODgxMzE@._V1_SX1500_CR0,0,1500,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMzE3MTM0MTc3Ml5BMl5BanBnXkFtZTgwMDIyODgxMzE@._V1_SX1500_CR0,0,1500,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BNjYzNjE2NDk3N15BMl5BanBnXkFtZTgwNzEyODgxMzE@._V1_SX1500_CR0,0,1500,999_AL_.jpg",
            "https://qph.cf2.quoracdn.net/main-qimg-58efec61c180d2acaaa7d240a0734e22-lq"

        )),
    Movie(
        "2",
        "Gotham",
        "2014–",
        "TV-14",
        "01 Aug 2014",
        "42 min",
        "Action, Crime, Drama",
        "The story behind Detective James Gordon's rise to" +
                " prominence in Gotham City in the years before Batman's arrival.",
        "N/A",
        "En",
        "USA",
        "4 nom. for Primetime Emmys. Another 3 wins & 22 nominations.",
        "N/A",
        "8.0",
        "133,375",
        "tt3749900",
        listOf(
            "https://static.cdn.asset.filimo.com/flmt/mov_25932_1-b.jpg?width=300&quality=85&secret=CVIb2XKFBFy-yytjLTiOAw",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BNDI3ODYyODY4OV5BMl5BanBnXkFtZTgwNjE5NDMwMDI@._V1_SY1000_SX1500_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjA5OTExMTIwNF5BMl5BanBnXkFtZTgwMjI5NDMwMDI@._V1_SY1000_SX1500_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTA3MDY2NjA3MzBeQTJeQWpwZ15BbWU4MDU0MDkzODgx._V1_SX1499_CR0,0,1499,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjM3MzYzNDgzOV5BMl5BanBnXkFtZTgwMjQwOTM4ODE@._V1_SY1000_CR0,0,1498,1000_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjQwODAyNjk0NF5BMl5BanBnXkFtZTgwODU4MzMyODE@._V1_SY1000_CR0,0,1500,1000_AL_.jpg",
            "https://info-world-hub.com/wp-content/uploads/2021/02/07b4e5c803b5bbbcae06e7029e7bbe52.jpg"
        )),
    Movie(
        "3",
        "Breaking Bad",
        "2008–2013",
        "TV-14",
        "20 Jan 2008",
        "49 min",
        "Crime, Drama, Thriller",
        "A high school chemistry teacher diagnosed with inoperable lung cancer" +
                " turns to manufacturing and selling methamphetamine in order to" +
                " secure his family's financial future.",
        "N/A",
        "En, Spa",
        "USA",
        "2 Golden Globes. Another 132 wins & 218 nominations.",
        "N/A",
        "9.5",
        "889,883",
        "tt0903747",
        listOf(
            "https://static.cdn.asset.filimo.com/flmt/mov_12338_1-b.jpg?width=300&quality=85&secret=xnWh83jpofOYZ33da6A3FQ",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTgyMzI5NDc5Nl5BMl5BanBnXkFtZTgwMjM0MTI2MDE@._V1_SY1000_CR0,0,1498,1000_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ2NDkwNDk5NV5BMl5BanBnXkFtZTgwNDM0MTI2MDE@._V1_SY1000_CR0,0,1495,1000_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTM4NDcyNDMzMF5BMl5BanBnXkFtZTgwOTI0MTI2MDE@._V1_SY1000_CR0,0,1495,1000_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTAzMTczMjM3NjFeQTJeQWpwZ15BbWU4MDc1MTI1MzAx._V1_SY1000_CR0,0,1495,1000_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjA5MTE3MTgwMF5BMl5BanBnXkFtZTgwOTQxMjUzMDE@._V1_SX1500_CR0,0,1500,999_AL_.jpg",
            "https://i.redd.it/02lv2hmxh0751.jpg"
        )
    ),
    Movie(
        "4",
        "Game of Thrones",
        "2011–",
        "TV-MA",
        "17 Apr 2011",
        "56 min",
        "Adventure, Drama, Fantasy",
        "While a civil war brews between several noble families in Westeros," +
                " the children of the former rulers of the land attempt to rise up to power." +
                " Meanwhile a forgotten race, bent on destruction, plans to return after" +
                " thousands of years in the North.",
        "N/A",
        "En",
        "USA, UK",
        "1 Golden Globe. Another 185 wins & 334 nominations.",
        "N/A",
        "9.5",
        "1,046,830",
        "tt0944947",
        listOf(
            "https://filmmusica.com/wp-content/uploads/2023/12/Game-of-Thrones-series.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BNDc1MGUyNzItNWRkOC00MjM1LWJjNjMtZTZlYWIxMGRmYzVlXkEyXkFqcGdeQXVyMzU3MDEyNjk@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BZjZkN2M5ODgtMjQ2OC00ZjAxLWE1MjMtZDE0OTNmNGM0NWEwXkEyXkFqcGdeQXVyNjUxNzgwNTE@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMDk4Y2Y1MDAtNGVmMC00ZTlhLTlmMmQtYjcyN2VkNzUzZjg2XkEyXkFqcGdeQXVyNjUxNzgwNTE@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BNjZjNWIzMzQtZWZjYy00ZTkwLWJiMTYtOWRkZDBhNWJhY2JmXkEyXkFqcGdeQXVyMjk3NTUyOTc@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BNTMyMTRjZWEtM2UxMS00ZjU5LWIxMTYtZDA5YmJhZmRjYTc4XkEyXkFqcGdeQXVyMjk3NTUyOTc@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYT_U-hRmmACHHALx6lfOOTCZcVCGBND7lfw&s"
        )),
    Movie(
        "5",
        "Avatar",
        "2009",
        "PG-13",
        "18 Dec 2009",
        "162 min",
        "Action, Adventure, Fantasy",
        "A paraplegic marine dispatched to " +
                "the moon Pandora on a unique mission becomes torn between following his orders " +
                "and protecting the world he feels is his home.",
        "James Cameron",
        "En, Spa",
        "USA, UK",
        "3 Oscars. Another 80 wins & 121 nominations.",
        "83",
        "7.9",
        "890,617",
        "tt0499549",
        listOf(
            "https://danofilm.com/wp-content/uploads/2024/05/AvatarTheWayOfWater2022.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyOTYyMzUxNl5BMl5BanBnXkFtZTcwNTg0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BNzM2MDk3MTcyMV5BMl5BanBnXkFtZTcwNjg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTY2ODQ3NjMyMl5BMl5BanBnXkFtZTcwODg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxOTEwNDcxN15BMl5BanBnXkFtZTcwOTg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxMDg1Nzk1MV5BMl5BanBnXkFtZTcwMDk0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg",
            "https://static.wikia.nocookie.net/movie-heroes-and-villains/images/e/e8/Jake_Sully.png/revision/latest?cb=20230819025438"
        ))
)

/*fun movieDetailsEditor (mainText: String): Movie{
    val output: Movie

}*/
fun getMovies(): List<Movie>{

    return myList
}
