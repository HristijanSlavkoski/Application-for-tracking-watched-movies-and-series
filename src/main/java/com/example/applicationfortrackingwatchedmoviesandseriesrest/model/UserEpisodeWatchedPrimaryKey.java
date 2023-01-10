package com.example.applicationfortrackingwatchedmoviesandseriesrest.model;

import java.io.Serializable;

public class UserEpisodeWatchedPrimaryKey implements Serializable
{
	private User user;
	private Episode episode;

	public UserEpisodeWatchedPrimaryKey()
	{
	}

	public UserEpisodeWatchedPrimaryKey(User user, Episode episode)
	{
		this.user = user;
		this.episode = episode;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Episode getEpisode()
	{
		return episode;
	}

	public void setEpisode(Episode episode)
	{
		this.episode = episode;
	}
}
