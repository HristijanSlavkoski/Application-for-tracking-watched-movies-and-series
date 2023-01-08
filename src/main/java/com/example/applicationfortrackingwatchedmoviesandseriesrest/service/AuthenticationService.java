package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.UserLoginDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.UserRegisterDTO;

import java.util.ArrayList;

public interface AuthenticationService
{
	boolean checkEmail(String email);

	boolean checkPassword(String password);

	boolean checkConfirmPassword(String password, String confirmPassword);

	ArrayList<String> validateAndRegister(UserRegisterDTO userRegisterDTO);

	String validateAndLogin(UserLoginDTO userLoginDTO);
}
