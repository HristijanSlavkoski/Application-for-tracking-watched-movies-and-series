package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for userMovieWatched complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="userMovieWatched"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="user" type="{http://localhost.com/movie}user"/&gt;
 *         &lt;element name="movie" type="{http://localhost.com/movie}movie"/&gt;
 *         &lt;element name="dateWatched" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userMovieWatched", namespace = "http://localhost.com/movie", propOrder = {
		"user",
		"movie",
		"dateWatched"
})
public class UserMovieWatched
{

	@XmlElement(required = true)
	protected User user;
	@XmlElement(required = true)
	protected Movie movie;
	@XmlElement(required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateWatched;

	/**
	 * Gets the value of the user property.
	 *
	 * @return possible object is
	 * {@link User }
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * Sets the value of the user property.
	 *
	 * @param value allowed object is
	 *              {@link User }
	 */
	public void setUser(User value)
	{
		this.user = value;
	}

	/**
	 * Gets the value of the movie property.
	 *
	 * @return possible object is
	 * {@link Movie }
	 */
	public Movie getMovie()
	{
		return movie;
	}

	/**
	 * Sets the value of the movie property.
	 *
	 * @param value allowed object is
	 *              {@link Movie }
	 */
	public void setMovie(Movie value)
	{
		this.movie = value;
	}

	/**
	 * Gets the value of the dateWatched property.
	 *
	 * @return possible object is
	 * {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateWatched()
	{
		return dateWatched;
	}

	/**
	 * Sets the value of the dateWatched property.
	 *
	 * @param value allowed object is
	 *              {@link XMLGregorianCalendar }
	 */
	public void setDateWatched(XMLGregorianCalendar value)
	{
		this.dateWatched = value;
	}

}
