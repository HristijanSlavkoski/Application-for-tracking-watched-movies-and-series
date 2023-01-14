package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for movie complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="movie"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="durationInMinutes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movie", namespace = "http://localhost.com/movie", propOrder = {
		"id",
		"title",
		"genre",
		"director",
		"year",
		"durationInMinutes",
		"image"
})
@Entity
public class Movie
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	protected long id;
	@XmlElement(required = true)
	@Column(name = "title", unique = true, nullable = false)
	protected String title;
	@XmlElement(required = true)
	@Column(name = "genre", nullable = false)
	protected String genre;
	@XmlElement(required = true)
	@Column(name = "director", nullable = false)
	protected String director;
	@Column(name = "year", nullable = false)
	protected int year;
	@Column(name = "duration_in_minutes")
	protected int durationInMinutes;
	@XmlElement(required = true)
	@Column(name = "image", nullable = false, length = 10000000)
	protected String image;

	public Movie()
	{
	}

	public Movie(long id, String title, String genre, String director, int year, int durationInMinutes, String image)
	{
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.year = year;
		this.durationInMinutes = durationInMinutes;
		this.image = image;
	}

	public Movie(String title, String genre, String director, int year, int durationInMinutes, String image)
	{
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.year = year;
		this.durationInMinutes = durationInMinutes;
		this.image = image;
	}

	/**
	 * Gets the value of the id property.
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * Sets the value of the id property.
	 */
	public void setId(long value)
	{
		this.id = value;
	}

	/**
	 * Gets the value of the title property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Sets the value of the title property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setTitle(String value)
	{
		this.title = value;
	}

	/**
	 * Gets the value of the genre property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getGenre()
	{
		return genre;
	}

	/**
	 * Sets the value of the genre property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setGenre(String value)
	{
		this.genre = value;
	}

	/**
	 * Gets the value of the director property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getDirector()
	{
		return director;
	}

	/**
	 * Sets the value of the director property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setDirector(String value)
	{
		this.director = value;
	}

	/**
	 * Gets the value of the year property.
	 */
	public int getYear()
	{
		return year;
	}

	/**
	 * Sets the value of the year property.
	 */
	public void setYear(int value)
	{
		this.year = value;
	}

	/**
	 * Gets the value of the durationInMinutes property.
	 */
	public int getDurationInMinutes()
	{
		return durationInMinutes;
	}

	/**
	 * Sets the value of the durationInMinutes property.
	 */
	public void setDurationInMinutes(int value)
	{
		this.durationInMinutes = value;
	}

	/**
	 * Gets the value of the image property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getImage()
	{
		return image;
	}

	/**
	 * Sets the value of the image property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setImage(String value)
	{
		this.image = value;
	}

}
