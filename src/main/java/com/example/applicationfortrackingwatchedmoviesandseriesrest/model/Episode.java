package com.example.applicationfortrackingwatchedmoviesandseriesrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "episode")
public class Episode
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "series_id")
	private Series series;

	@Column(name = "season_number", nullable = false)
	private Integer seasonNumber;

	@Column(name = "episode_number", nullable = false)
	private Integer episodeNumber;

	@Column(name = "title")
	private String title;

	@Column(name = "duration_in_minutes")
	private Integer durationInMinutes;

	@Column(name = "release_date")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	public Episode()
	{
	}

	public Episode(Long id, Series series, Integer seasonNumber, Integer episodeNumber, String title, Integer durationInMinutes, Date releaseDate)
	{
		this.id = id;
		this.series = series;
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		this.title = title;
		this.durationInMinutes = durationInMinutes;
		this.releaseDate = releaseDate;
	}

	public Episode(Series series, Integer seasonNumber, Integer episodeNumber, String title, Integer durationInMinutes, Date releaseDate)
	{
		this.series = series;
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		this.title = title;
		this.durationInMinutes = durationInMinutes;
		this.releaseDate = releaseDate;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Series getSeries()
	{
		return series;
	}

	public void setSeries(Series series)
	{
		this.series = series;
	}

	public Integer getSeasonNumber()
	{
		return seasonNumber;
	}

	public void setSeasonNumber(Integer seasonNumber)
	{
		this.seasonNumber = seasonNumber;
	}

	public Integer getEpisodeNumber()
	{
		return episodeNumber;
	}

	public void setEpisodeNumber(Integer episodeNumber)
	{
		this.episodeNumber = episodeNumber;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Integer getDurationInMinutes()
	{
		return durationInMinutes;
	}

	public void setDurationInMinutes(Integer durationInMinutes)
	{
		this.durationInMinutes = durationInMinutes;
	}

	public Date getReleaseDate()
	{
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}
}
