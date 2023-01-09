package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.EpisodeDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Episode;

import java.util.List;

public interface EpisodeService
{
	List<Episode> getAllEpisodesForSeries(Long seriesId);

	void saveEpisodeForSeries(EpisodeDTO episodeDTO, Long seriesId);

	void deleteEpisode(Long episodeId);

	void editEpisode(Long episodeId, EpisodeDTO episodeDTO);

	Episode getEpisodeById(Long id);
}
