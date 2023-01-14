package com.example.applicationfortrackingwatchedmoviesandseriesrest.model;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.Movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

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

	@Column(name = "date_watched")
	@Temporal(TemporalType.DATE)
	private Date dateWatched;

	public UserMovieWatched()
	{
	}

	public UserMovieWatched(User user, Movie movie, Date dateWatched)
	{
		this.user = user;
		this.movie = movie;
		this.dateWatched = dateWatched;
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

	public Date getDateWatched()
	{
		return dateWatched;
	}

	public void setDateWatched(Date dateWatched)
	{
		this.dateWatched = dateWatched;
	}
}
