package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.MovieDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Movie;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

	@Override
	@Transactional
	public void editMovie(Long id, MovieDTO movieDTO)
	{
		Optional<Movie> movieToEdit = movieRepository.findById(id);
		Movie movie = movieToEdit.get();
		movie.setTitle(movieDTO.getTitle());
		movie.setGenre(movieDTO.getGenre());
		movie.setDirector(movieDTO.getDirector());
		movie.setDurationInMinutes(movieDTO.getDurationInMinutes());
		movie.setYear(movieDTO.getYear());
		if (movieDTO.getImage() != null)
		{
			movie.setImage(movieDTO.getImage());
		}
		movieRepository.save(movie);
	}

	@Override
	public Movie getMovieById(Long id)
	{
		Optional<Movie> movie = movieRepository.findById(id);
		if (movie.isPresent())
		{
			return movie.get();
		} else
		{
			return null;
		}
	}
}
