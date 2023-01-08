package com.example.applicationfortrackingwatchedmoviesandseriesrest.controller;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.UserLoginDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.UserRegisterDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.AuthenticationService;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController
{
	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("user", new UserLoginDTO());
		return "login";
	}

	@GetMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("user", new UserRegisterDTO());
		return "register";
	}

	@PostMapping("/register-successful")
	public Object processRegister(@Valid UserRegisterDTO user, BindingResult result, ModelMap model)
	{
		ArrayList<String> errorMessage = authenticationService.validateAndRegister(user);
		result.getAllErrors().stream().forEach(s -> errorMessage.add(s.getDefaultMessage()));
		if (!errorMessage.isEmpty())
		{
			model.addAttribute("user", user);
			String errors = String.join(", ", errorMessage);
			model.addAttribute("errors", errors);
			return "register";
		} else
		{
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new RedirectView("/users/" + userService.getUserByEmail(user.getEmail()).get().getId() + "/movies");

		}
	}

	@PostMapping("/login-successful")
	public Object processLogin(@Valid UserLoginDTO user, ModelMap model)
	{
		Authentication authentication;
		try
		{
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch (Exception e)
		{
			model.addAttribute("user", user);
			model.addAttribute("error", e.getMessage());
			return "login";
		}
		String error = authenticationService.validateAndLogin(user);
		if (error.equals("Success"))
		{
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new RedirectView("/users/" + userService.getUserByEmail(user.getEmail()).get().getId() + "/movies");
		}
		model.addAttribute("error", error);
		return "login";
	}

	@GetMapping("/logout")
	public String logout(Model model)
	{
		SecurityContextHolder.getContext().setAuthentication(null);
		model.addAttribute("user", new UserLoginDTO());
		return "login";
	}
}
