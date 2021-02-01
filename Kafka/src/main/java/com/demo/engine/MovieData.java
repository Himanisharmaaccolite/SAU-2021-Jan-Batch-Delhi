package com.demo.engine;

public class MovieData {

    public MovieData() {
    }
    public MovieData(int year, String movieName, String actor, String actress) {
        this.year = year;
        this.movieName = movieName;
        this.actor = actor;
        this.actress = actress;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

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

    private int year;
    private String movieName;
    private String actor;
    private String actress;

    @Override
    public String toString() {
        return "MoviesData{" + "year=" + year + ", movieName='" + movieName + '\'' + ", actor='" + actor + '\'' + ", actress='" + actress + '\'' + '}';
    }
}
