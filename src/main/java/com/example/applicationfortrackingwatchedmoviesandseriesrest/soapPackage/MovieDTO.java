package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for movieDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="movieDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
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
@XmlType(name = "movieDTO", namespace = "http://localhost.com/movie", propOrder = {
		"title",
		"genre",
		"director",
		"year",
		"durationInMinutes",
		"image"
})
public class MovieDTO
{

	@XmlElement(required = true)
	protected String title;
	@XmlElement(required = true)
	protected String genre;
	@XmlElement(required = true)
	protected String director;
	protected int year;
	protected int durationInMinutes;
	@XmlElement(required = true)
	protected String image;

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
