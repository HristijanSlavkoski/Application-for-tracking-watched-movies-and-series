package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.SeriesDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Series;

import java.util.List;

public interface SeriesService
{
	List<Series> getAllSeries();

	void saveSeries(SeriesDTO seriesDTO);

	void deleteSeries(Long id);

	void editSeries(Long id, SeriesDTO seriesDTO);

	Series getSeriesById(Long id);
}
