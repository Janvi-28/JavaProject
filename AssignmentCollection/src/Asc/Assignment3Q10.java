package Asc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MovieDetails {
    private String movieName;
    private String actor;
    private String actress;
    private String genre;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

class MovieDetailsList {
    private List<MovieDetails> movieList;

    public MovieDetailsList() {
        movieList = new ArrayList<>();
    }

    public void addMovie(MovieDetails movie) {
        movieList.add(movie);
    }

    public void removeMovie(String movieName) {
        movieList.removeIf(movie -> movie.getMovieName().equals(movieName));
    }

    public void removeAllMovies(List<MovieDetails> movies) {
        movieList.removeAll(movies);
    }

    public MovieDetails findMovieByMovieName(String movieName) {
        for (MovieDetails movie : movieList) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<MovieDetails> findMoviesByGenre(String genre) {
        List<MovieDetails> movies = new ArrayList<>();
        for (MovieDetails movie : movieList) {
            if (movie.getGenre().equals(genre)) {
                movies.add(movie);
            }
        }
        return movies;
    }

    public void removeAllMovies() {
        movieList.clear();
    }

    public void sort(Comparator<MovieDetails> movieDetailsComparator) {
        movieList.sort(movieDetailsComparator);
    }

    public void printSortedMovieList() {
        for (MovieDetails movie : movieList) {
            System.out.println("Movie Name: " + movie.getMovieName() +
                    ", Actor: " + movie.getActor() +
                    ", Actress: " + movie.getActress() +
                    ", Genre: " + movie.getGenre());
        }
    }
}

public class Assignment3Q10 {
    public static void main(String[] args) {
        MovieDetailsList movieList = new MovieDetailsList();

        MovieDetails movie1 = new MovieDetails();
        movie1.setMovieName("Zootopia");
        movie1.setActor("Nick");
        movie1.setActress("Judy Hopps");
        movie1.setGenre("Action");

        MovieDetails movie2 = new MovieDetails();
        movie2.setMovieName("Incredibles");
        movie2.setActor("Bob Parr");
        movie2.setActress("Helen Parr");
        movie2.setGenre("Action");

        MovieDetails movie3 = new MovieDetails();
        movie3.setMovieName("The Lion King");
        movie3.setActor("Simba");
        movie3.setActress("Nala");
        movie3.setGenre("Drama");

        movieList.addMovie(movie1);
        movieList.addMovie(movie2);
        movieList.addMovie(movie3);

        // sorting by movie name
        movieList.sort(Assignment3Q10.sortAccordingly("movieName"));
        movieList.printSortedMovieList();

        // removing a movie
        movieList.removeMovie("Zootopia");

        // finding a movie by name
        MovieDetails movie = movieList.findMovieByMovieName("Incredibles");
        if (movie != null) {
            System.out.println("Movie Found: " + movie.getMovieName());
        } else {
            System.out.println("Movie not Found");
        }

        // finding movies by genre
        List<MovieDetails> actionMovies = movieList.findMoviesByGenre("Action");
        System.out.println("Action Movies: ");
        for (MovieDetails actionMovie : actionMovies) {
            System.out.println(actionMovie.getMovieName());
        }

        // removing all movies
        movieList.removeAllMovies();

        // sorting by actor
        movieList.sort(Assignment3Q10.sortAccordingly("actor"));
        movieList.printSortedMovieList();
    }

    public static void sort(ArrayList<MovieDetails> movieDetails, Comparator<MovieDetails> movieDetailsComparator) {
        movieDetails.sort(movieDetailsComparator);
    }

    public static void printSortedMovieList(ArrayList<MovieDetails> movieDetails) {
        for (MovieDetails movie : movieDetails) {
            System.out.println("Movie Name: " + movie.getMovieName() +
                    ", Actor: " + movie.getActor() +
                    ", Actress: " + movie.getActress() +
                    ", Genre: " + movie.getGenre());
        }
    }

    public static Comparator<MovieDetails> sortAccordingly(String sortBy) {
        switch (sortBy) {
            case "movieName":
                return Comparator.comparing(MovieDetails::getMovieName);
            case "actor":
                return Comparator.comparing(MovieDetails::getActor);
            case "actress":
                return Comparator.comparing(MovieDetails::getActress);
            case "genre":
                return Comparator.comparing(MovieDetails::getGenre);
            default:
                throw new IllegalArgumentException("Invalid Sort By Parameter");
        }
    }
}

