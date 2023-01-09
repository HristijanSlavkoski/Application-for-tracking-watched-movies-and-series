package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.SeriesDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Series;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SeriesServiceImpl implements SeriesService
{
	@Autowired
	private SeriesRepository seriesRepository;

	@Override
	public List<Series> getAllSeries()
	{
		return seriesRepository.findAll();
	}

	@Override
	public void saveSeries(SeriesDTO seriesDTO)
	{
		Series movie = new Series(seriesDTO.getTitle(), seriesDTO.getGenre(), seriesDTO.getDirector(), seriesDTO.getYear(), seriesDTO.getNumberOfSeasons(), seriesDTO.getImage());
		seriesRepository.save(movie);
	}

	@Override
	public void deleteSeries(Long id)
	{
		seriesRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void editSeries(Long id, SeriesDTO seriesDTO)
	{
		Optional<Series> movieToEdit = seriesRepository.findById(id);
		Series series = movieToEdit.get();
		series.setTitle(seriesDTO.getTitle());
		series.setGenre(seriesDTO.getGenre());
		series.setDirector(seriesDTO.getDirector());
		series.setNumberOfSeasons(seriesDTO.getNumberOfSeasons());
		series.setYear(seriesDTO.getYear());
		if (seriesDTO.getImage() != null)
		{
			series.setImage(seriesDTO.getImage());
		}
		seriesRepository.save(series);
	}

	@Override
	public Series getSeriesById(Long id)
	{
		Optional<Series> series = seriesRepository.findById(id);
		if (series.isPresent())
		{
			return series.get();
		} else
		{
			return null;
		}
	}
}
