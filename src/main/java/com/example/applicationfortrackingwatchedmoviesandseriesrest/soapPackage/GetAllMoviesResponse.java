package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userMovieWatchedList" type="{http://localhost.com/movie}userMovieWatchedList"/&gt;
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="movies" type="{http://localhost.com/movie}movies"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"userMovieWatchedList",
		"userId",
		"movies"
})
@XmlRootElement(name = "getAllMoviesResponse", namespace = "http://localhost.com/movie")
public class GetAllMoviesResponse
{

	@XmlElement(required = true)
	protected UserMovieWatchedList userMovieWatchedList;
	protected long userId;
	@XmlElement(required = true)
	protected Movies movies;

	/**
	 * Gets the value of the userMovieWatchedList property.
	 *
	 * @return possible object is
	 * {@link UserMovieWatchedList }
	 */
	public UserMovieWatchedList getUserMovieWatchedList()
	{
		return userMovieWatchedList;
	}

	/**
	 * Sets the value of the userMovieWatchedList property.
	 *
	 * @param value allowed object is
	 *              {@link UserMovieWatchedList }
	 */
	public void setUserMovieWatchedList(UserMovieWatchedList value)
	{
		this.userMovieWatchedList = value;
	}

	/**
	 * Gets the value of the userId property.
	 */
	public long getUserId()
	{
		return userId;
	}

	/**
	 * Sets the value of the userId property.
	 */
	public void setUserId(long value)
	{
		this.userId = value;
	}

	/**
	 * Gets the value of the movies property.
	 *
	 * @return possible object is
	 * {@link Movies }
	 */
	public Movies getMovies()
	{
		return movies;
	}

	/**
	 * Sets the value of the movies property.
	 *
	 * @param value allowed object is
	 *              {@link Movies }
	 */
	public void setMovies(Movies value)
	{
		this.movies = value;
	}


}
