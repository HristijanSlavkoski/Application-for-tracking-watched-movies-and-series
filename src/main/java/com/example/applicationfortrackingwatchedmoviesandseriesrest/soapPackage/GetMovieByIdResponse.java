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
 *         &lt;element name="movie" type="{http://localhost.com/movie}movie"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"movie"
})
@XmlRootElement(name = "getMovieByIdResponse", namespace = "http://localhost.com/movie")
public class GetMovieByIdResponse
{

	@XmlElement(required = true)
	protected Movie movie;

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

}
