package com.example.applicationfortrackingwatchedmoviesandseriesrest.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "title", unique = true, nullable = false)
	private String title;

	@Column(name = "genre", nullable = false)
	private String genre;

	@Column(name = "director", nullable = false)
	private String director;

	@Column(name = "year", nullable = false)
	private Integer year;

	@Column(name = "duration_in_minutes")
	private Integer durationInMinutes;

	@Column(name = "image", nullable = false, length = 10000000)
	private String image;

	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<UserMovieWatched> userMovieWatchedList;

	public Movie()
	{
	}

	public Movie(Long id, String title, String genre, String director, Integer year, Integer durationInMinutes, String image)
	{
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.year = year;
		this.durationInMinutes = durationInMinutes;
		this.image = image;
	}

	public Movie(String title, String genre, String director, Integer year, Integer durationInMinutes, String image)
	{
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.year = year;
		this.durationInMinutes = durationInMinutes;
		this.image = image;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
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

	public void setDurationInMinutes(Integer duration)
	{
		this.durationInMinutes = duration;
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
