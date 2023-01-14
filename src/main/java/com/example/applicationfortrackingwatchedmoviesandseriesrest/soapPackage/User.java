package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for user complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="user"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="role" type="{http://localhost.com/movie}role"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", namespace = "http://localhost.com/movie", propOrder = {
		"id",
		"email",
		"password",
		"age",
		"role"
})
public class User
{

	protected long id;
	@XmlElement(required = true)
	protected String email;
	@XmlElement(required = true)
	protected String password;
	protected int age;
	@XmlElement(required = true)
	@XmlSchemaType(name = "string")
	protected Role role;

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
	 * Gets the value of the email property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Sets the value of the email property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setEmail(String value)
	{
		this.email = value;
	}

	/**
	 * Gets the value of the password property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Sets the value of the password property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setPassword(String value)
	{
		this.password = value;
	}

	/**
	 * Gets the value of the age property.
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * Sets the value of the age property.
	 */
	public void setAge(int value)
	{
		this.age = value;
	}

	/**
	 * Gets the value of the role property.
	 *
	 * @return possible object is
	 * {@link Role }
	 */
	public Role getRole()
	{
		return role;
	}

	/**
	 * Sets the value of the role property.
	 *
	 * @param value allowed object is
	 *              {@link Role }
	 */
	public void setRole(Role value)
	{
		this.role = value;
	}

}
