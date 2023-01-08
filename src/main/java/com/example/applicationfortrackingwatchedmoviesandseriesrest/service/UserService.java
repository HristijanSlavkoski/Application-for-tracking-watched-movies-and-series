package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.User;

import java.util.Optional;

public interface UserService
{
	Optional<User> getUserById(Long id);

	Optional<User> getUserByEmail(String email);
}
