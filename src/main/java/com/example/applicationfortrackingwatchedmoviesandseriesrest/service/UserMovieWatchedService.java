package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.UserMovieEpisodeWatchedDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.UserMovieWatched;

import java.util.List;

public interface UserMovieWatchedService
{
	void markMovieAsWatched(Long userId, Long movieId, UserMovieEpisodeWatchedDTO userMovieEpisodeWatchedDTO);

	void markMovieAsNotWatched(Long userId, Long movieId);

	List<UserMovieWatched> getAllRecordsForUserMovieWatched();
}
