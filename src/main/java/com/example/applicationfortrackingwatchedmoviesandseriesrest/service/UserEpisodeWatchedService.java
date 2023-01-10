package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.UserMovieEpisodeWatchedDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Episode;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.UserEpisodeWatched;

import java.util.List;

public interface UserEpisodeWatchedService
{
	void markEpisodeAsWatched(Long userId, Long episodeId, UserMovieEpisodeWatchedDTO userMovieEpisodeWatchedDTO);

	void markEpisodeAsNotWatched(Long userId, Long episodeId);

	List<UserEpisodeWatched> getAllRecordsForUserEpisodeWatched();

	Episode getLastWatchedEpisodeForUser(Long userId);

	Episode getLastWatchedEpisodeForUserForSeries(Long userId, Long seriesId);
}
