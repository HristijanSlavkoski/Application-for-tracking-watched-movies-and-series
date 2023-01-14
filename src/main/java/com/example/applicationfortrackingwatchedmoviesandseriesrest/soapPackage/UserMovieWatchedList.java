package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for userMovieWatchedList complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="userMovieWatchedList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userMovieWatched" type="{http://localhost.com/movie}userMovieWatched" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userMovieWatchedList", namespace = "http://localhost.com/movie", propOrder = {
		"userMovieWatched"
})
public class UserMovieWatchedList
{

	@XmlElement(required = true)
	protected List<UserMovieWatched> userMovieWatched;

	/**
	 * Gets the value of the userMovieWatched property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the javax XML Binding object.
	 * This is why there is not a <CODE>set</CODE> method for the userMovieWatched property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getUserMovieWatched().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link UserMovieWatched }
	 */
	public List<UserMovieWatched> getUserMovieWatched()
	{
		if (userMovieWatched == null)
		{
			userMovieWatched = new ArrayList<UserMovieWatched>();
		}
		return this.userMovieWatched;
	}

}
