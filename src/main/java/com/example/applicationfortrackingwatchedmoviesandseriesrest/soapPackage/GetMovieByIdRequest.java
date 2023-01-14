package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="movieId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"userId",
		"movieId"
})
@XmlRootElement(name = "getMovieByIdRequest", namespace = "http://localhost.com/movie")
public class GetMovieByIdRequest
{

	protected long userId;
	protected long movieId;

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
	 * Gets the value of the movieId property.
	 */
	public long getMovieId()
	{
		return movieId;
	}

	/**
	 * Sets the value of the movieId property.
	 */
	public void setMovieId(long value)
	{
		this.movieId = value;
	}

}
