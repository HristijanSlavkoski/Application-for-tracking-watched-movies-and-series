package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.UserLoginDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.UserRegisterDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Role;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.User;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthenticationServiceImpl implements AuthenticationService
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean checkEmail(String email)
	{
		if ((email == null) || (email.length() == 0))
		{
			return false;
		}
		String regex = "^[A-Za-z0-9_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches())
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean checkPassword(String password)
	{
		String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{7,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches())
		{
			return true;

		}
		return false;
	}

	@Override
	public boolean checkConfirmPassword(String password, String confirmPassword)
	{
		if (password.equals(confirmPassword))
		{
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<String> validateAndRegister(UserRegisterDTO userRegisterDTO)
	{
		ArrayList<String> errors = new ArrayList<>();
		if (checkEmail(userRegisterDTO.getEmail()) == false)
		{
			errors.add("The email is in invalid format");
		}
		Optional<User> u = userRepository.findByEmail(userRegisterDTO.getEmail());
		if (u.isPresent())
		{
			errors.add("The email is already in use");
		}
		if (checkPassword(userRegisterDTO.getPassword()) == false)
		{
			errors.add("The password is invalid");
		}
		if (checkConfirmPassword(userRegisterDTO.getPassword(), userRegisterDTO.getConfirmPassword()) == false)
		{
			errors.add("The password does not match with confirmed password");
		}
		if (errors.isEmpty())
		{
			User user = new User();
			user.setEmail(userRegisterDTO.getEmail());
			user.setAge(userRegisterDTO.getAge());
			user.setRole(Role.USER);
			user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
			userRepository.save(user);
		}
		return errors;
	}

	@Override
	public String validateAndLogin(UserLoginDTO userLoginDTO)
	{
		Optional<User> user = userRepository.findByEmail(userLoginDTO.getEmail());
		if (!user.isPresent())
		{
			return "The email is not registered";
		}
		if (passwordEncoder.matches(userLoginDTO.getPassword(), user.get().getPassword()) == false)
		{
			return "The email and password does not match";
		}
		return "Success";
	}
}
