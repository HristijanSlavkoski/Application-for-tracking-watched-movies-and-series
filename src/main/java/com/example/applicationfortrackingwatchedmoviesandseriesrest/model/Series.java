package com.example.applicationfortrackingwatchedmoviesandseriesrest.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "series")
public class Series
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

	@Column(name = "number_of_seasons")
	private Integer numberOfSeasons;

	@Column(name = "image", nullable = false)
	@Lob
	private String image;

	@OneToMany(mappedBy = "series", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Episode> episodes;

	public Series()
	{
	}

	public Series(Long id, String title, String genre, String director, Integer year, Integer numberOfSeasons, String image)
	{
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.year = year;
		this.numberOfSeasons = numberOfSeasons;
		this.image = image;
	}

	public Series(String title, String genre, String director, Integer year, Integer numberOfSeasons, String image)
	{
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.year = year;
		this.numberOfSeasons = numberOfSeasons;
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
