package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.MovieDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Movie;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService
{
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovies()
	{
		return movieRepository.findAll();
	}

	@Override
	public void saveMovie(MovieDTO movieDTO)
	{
		Movie movie = new Movie(movieDTO.getTitle(), movieDTO.getGenre(), movieDTO.getDirector(), movieDTO.getYear(), movieDTO.getDurationInMinutes(), movieDTO.getImage());
		movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(Long id)
	{
		movieRepository.deleteById(id);
	}
}
