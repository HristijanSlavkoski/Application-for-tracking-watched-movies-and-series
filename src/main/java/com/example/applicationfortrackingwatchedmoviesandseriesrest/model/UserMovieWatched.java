package com.example.applicationfortrackingwatchedmoviesandseriesrest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_movie_watched")
@IdClass(UserMovieWatchedPrimaryKey.class)
public class UserMovieWatched
{
	@Id
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false)
	private Movie movie;

	public UserMovieWatched()
	{
	}

	public UserMovieWatched(User user, Movie movie)
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
