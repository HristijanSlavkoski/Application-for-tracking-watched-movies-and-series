package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.MovieRepository;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.AddMovieRequest;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.AddMovieResponse;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.DeleteMovieRequest;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.DeleteMovieResponse;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.GetAllMoviesResponse;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.GetMovieByIdRequest;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.GetMovieByIdResponse;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.Movie;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.Movies;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.UpdateMovieRequest;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.UpdateMovieResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import java.util.Optional;

@Service
public class SoapMovieServiceImpl
{

	private final MovieRepository movieRepository;

	public SoapMovieServiceImpl(MovieRepository movieRepository)
	{
		this.movieRepository = movieRepository;
	}

	public GetAllMoviesResponse getAllMovies()
	{
		GetAllMoviesResponse response = new GetAllMoviesResponse();
		response.setMovies(new Movies(movieRepository.findAll()));
		return response;
	}

	public AddMovieResponse addMovie(@RequestPayload AddMovieRequest request)
	{
		Movie movie = new Movie();
		movie.setTitle(request.getMovieDTO().getTitle());
		movie.setGenre(request.getMovieDTO().getGenre());
		movie.setDirector(request.getMovieDTO().getDirector());
		movie.setYear(request.getMovieDTO().getYear());
		movie.setDurationInMinutes(request.getMovieDTO().getDurationInMinutes());
		movie.setImage(request.getMovieDTO().getImage());
		movieRepository.save(movie);

		AddMovieResponse response = new AddMovieResponse();
		response.setStatus("Success");
		return response;
	}

	public UpdateMovieResponse updateMovie(UpdateMovieRequest request)
	{
		Optional<Movie> movieOptional = movieRepository.findById(request.getMovieId());
		if (movieOptional.isPresent())
		{
			Movie movie = movieOptional.get();
			movie.setTitle(request.getMovieDTO().getTitle());
			movie.setGenre(request.getMovieDTO().getGenre());
			movie.setDirector(request.getMovieDTO().getDirector());
			movie.setYear(request.getMovieDTO().getYear());
			movie.setDurationInMinutes(request.getMovieDTO().getDurationInMinutes());
			movie.setImage(request.getMovieDTO().getImage());
			movieRepository.save(movie);
			UpdateMovieResponse response = new UpdateMovieResponse();
			response.setStatus("Success");
			return response;
		} else
		{
			UpdateMovieResponse response = new UpdateMovieResponse();
			response.setStatus("Failed");
			return response;
		}
	}

	public DeleteMovieResponse deleteMovie(DeleteMovieRequest request)
	{
		movieRepository.deleteById(request.getMovieId());
		DeleteMovieResponse response = new DeleteMovieResponse();
		response.setStatus("Success");
		return response;
	}

	public GetMovieByIdResponse getMovieById(GetMovieByIdRequest request)
	{
		Optional<Movie> movie = movieRepository.findById(request.getMovieId());
		GetMovieByIdResponse response = new GetMovieByIdResponse();
		if (movie.isPresent())
		{
			response.setMovie(movie.get());
			return response;
		}
		response.setMovie(null);
		return response;
	}
}

