package com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO;

public class SeriesDTO {

    private String title;
    private String genre;
    private String director;
    private Integer year;
    private Integer numberOfSeasons;
    private String image;

    public SeriesDTO(String title, String genre, String director, Integer year, Integer numberOfSeasons, String image) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.year = year;
        this.numberOfSeasons = numberOfSeasons;
        this.image = image;
    }

    public SeriesDTO(){

    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }

    public Integer getNumberOfSeasons()
    {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Integer numberOfSeasons)
    {
        this.numberOfSeasons = numberOfSeasons;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

}
