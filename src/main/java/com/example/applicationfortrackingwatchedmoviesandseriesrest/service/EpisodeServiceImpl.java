package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.EpisodeDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Episode;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Series;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.EpisodeRepository;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeServiceImpl implements EpisodeService
{
	@Autowired
	private EpisodeRepository episodeRepository;

	@Autowired
	private SeriesRepository seriesRepository;

	@Override
	public List<Episode> getAllEpisodesForSeries(Long seriesId)
	{
		Optional<Series> series = seriesRepository.findById(seriesId);
		if (series.isPresent())
		{
			return episodeRepository.findAllBySeries(series.get());
		}
		return null;
	}

	@Override
	public void saveEpisodeForSeries(EpisodeDTO episodeDTO, Long seriesId)
	{
		Optional<Series> series = seriesRepository.findById(seriesId);
		if (series.isPresent())
		{
			Episode episode = new Episode(series.get(), episodeDTO.getSeasonNumber(), episodeDTO.getEpisodeNumber(), episodeDTO.getTitle(), episodeDTO.getDurationInMinutes(), episodeDTO.getReleaseDate());
			episodeRepository.save(episode);
		}
	}

	@Override
	public void deleteEpisode(Long episodeId)
	{
		episodeRepository.deleteById(episodeId);
	}

	@Override
	public void editEpisode(Long episodeId, EpisodeDTO episodeDTO)
	{
		Optional<Episode> episodeToEdit = episodeRepository.findById(episodeId);
		Episode episode = episodeToEdit.get();
		episode.setEpisodeNumber(episodeDTO.getEpisodeNumber());
		episode.setDurationInMinutes(episodeDTO.getDurationInMinutes());
		episode.setTitle(episodeDTO.getTitle());
		episode.setSeasonNumber(episodeDTO.getSeasonNumber());
		episode.setReleaseDate(episodeDTO.getReleaseDate());
		episodeRepository.save(episode);
	}

	@Override
	public Episode getEpisodeById(Long id)
	{
		Optional<Episode> episode = episodeRepository.findById(id);
		if (episode.isPresent())
		{
			return episode.get();
		}
		return null;
	}
}
