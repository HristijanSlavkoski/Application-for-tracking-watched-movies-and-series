package com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO;

import java.util.Date;

public class EpisodeDTO
{
	private Integer seasonNumber;

	private Integer episodeNumber;

	private String title;

	private Integer durationInMinutes;

	private Date releaseDate;

	public EpisodeDTO()
	{
	}

	public EpisodeDTO(Integer seasonNumber, Integer episodeNumber, String title, Integer durationInMinutes, Date releaseDate)
	{
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		this.title = title;
		this.durationInMinutes = durationInMinutes;
		this.releaseDate = releaseDate;
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
