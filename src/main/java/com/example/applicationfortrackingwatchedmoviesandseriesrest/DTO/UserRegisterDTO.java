package com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegisterDTO
{
	@NotEmpty(message = "Email cannot be empty.")
	@Size(min = 5, max = 250)
	private String email;

	@NotEmpty(message = "Password cannot be empty.")
	@Size(min = 5, max = 250)
	private String password;

	@NotEmpty(message = "Confirm password cannot be empty.")
	@Size(min = 5, max = 250)
	private String confirmPassword;

	private Integer age;

	public UserRegisterDTO()
	{
	}

	public UserRegisterDTO(String email, String password, String confirmPassword, Integer age)
	{
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.age = age;
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

	public String getConfirmPassword()
	{
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}
}
