package com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserLoginDTO
{
	@NotEmpty(message = "Email cannot be empty.")
	@Size(min = 5, max = 250)
	private String email;

	@NotEmpty(message = "Password cannot be empty.")
	@Size(min = 5, max = 250)
	private String password;

	public UserLoginDTO()
	{
	}

	public UserLoginDTO(String email, String password)
	{
		this.email = email;
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
