package com.example.applicationfortrackingwatchedmoviesandseriesrest.model;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.Movie;

import java.io.Serializable;

public class UserMovieWatchedPrimaryKey implements Serializable
{
	private User user;
	private Movie movie;

	public UserMovieWatchedPrimaryKey()
	{
	}

	public UserMovieWatchedPrimaryKey(User user, Movie movie)
	{
		this.user = user;
		this.movie = movie;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Movie getMovie()
	{
		return movie;
	}

	public void setMovie(Movie movie)
	{
		this.movie = movie;
	}
}
