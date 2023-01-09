package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.MovieDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Movie;

import java.util.List;

public interface MovieService
{
	List<Movie> getAllMovies();

	void saveMovie(MovieDTO movieDTO);

	void deleteMovie(Long id);

	void editMovie(Long id, MovieDTO movieDTO);

	Movie getMovieById(Long id);
}
