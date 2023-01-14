package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for movies complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="movies"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="movie" type="{http://localhost.com/movie}movie" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movies", namespace = "http://localhost.com/movie", propOrder = {
		"movie"
})
public class Movies
{

	@XmlElement(required = true)
	protected List<Movie> movie;

	public Movies()
	{
	}

	public Movies(List<Movie> movie)
	{
		this.movie = movie;
	}

	/**
	 * Gets the value of the movie property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the javax XML Binding object.
	 * This is why there is not a <CODE>set</CODE> method for the movie property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getMovie().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Movie }
	 */
	public List<Movie> getMovie()
	{
		if (movie == null)
		{
			movie = new ArrayList<Movie>();
		}
		return this.movie;
	}

	public void setMovie(List<Movie> movie)
	{
		this.movie = movie;
	}
}
