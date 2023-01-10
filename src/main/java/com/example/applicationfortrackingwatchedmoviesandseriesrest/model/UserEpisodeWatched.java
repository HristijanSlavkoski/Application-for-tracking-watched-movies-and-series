package com.example.applicationfortrackingwatchedmoviesandseriesrest.model;

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
@Table(name = "user_episode_watched")
@IdClass(UserEpisodeWatchedPrimaryKey.class)
public class UserEpisodeWatched
{
	@Id
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "episode_id", nullable = false)
	private Episode episode;

	@Column(name = "date_watched")
	@Temporal(TemporalType.DATE)
	private Date dateWatched;

	public UserEpisodeWatched()
	{
	}

	public UserEpisodeWatched(User user, Episode episode, Date dateWatched)
	{
		this.user = user;
		this.episode = episode;
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

	public Episode getEpisode()
	{
		return episode;
	}

	public void setEpisode(Episode episode)
	{
		this.episode = episode;
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
