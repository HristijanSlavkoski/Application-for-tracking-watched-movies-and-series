package com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO;


public class MovieDTO
{
	private String title;

	private String genre;

	private String director;

	private Integer year;

	private Integer durationInMinutes;

	private String image;

	public MovieDTO()
	{
	}

	public MovieDTO(String title, String genre, String director, Integer year, Integer durationInMinutes, String image)
	{
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.year = year;
		this.durationInMinutes = durationInMinutes;
		this.image = image;
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

	public Integer getDurationInMinutes()
	{
		return durationInMinutes;
	}

	public void setDurationInMinutes(Integer durationInMinutes)
	{
		this.durationInMinutes = durationInMinutes;
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
