package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.UserMovieWatched;

import java.util.List;

public interface UserMovieWatchedService
{
	void markMovieAsWatchedOrNotWatched(Long userId, Long movieId);

	List<UserMovieWatched> getAllRecordsForUserMovieWatched();
}
