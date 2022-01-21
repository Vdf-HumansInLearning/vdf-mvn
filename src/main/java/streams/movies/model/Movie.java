package streams.movies.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private int id;
    private String title;
    private int year;
    private String imdb;
    private final List<Genre> genres = new ArrayList<>();
    private final List<Director> directors = new ArrayList<>();

}
