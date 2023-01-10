package com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO;

import java.util.Date;

public class UserMovieEpisodeWatchedDTO
{
	private Date dateWatched;

	public UserMovieEpisodeWatchedDTO()
	{
	}

	public UserMovieEpisodeWatchedDTO(Date dateWatched)
	{
		this.dateWatched = dateWatched;
	}

	public Date getDateWatched()
	{
		return dateWatched;
	}

	public void setDateWatched(Date dateWatched)
	{
		this.dateWatched = dateWatched;
	}
}
