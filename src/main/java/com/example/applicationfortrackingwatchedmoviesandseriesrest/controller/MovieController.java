package com.example.applicationfortrackingwatchedmoviesandseriesrest.controller;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.MovieDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Movie;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Role;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.User;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.UserMovieWatched;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.MovieService;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.UserMovieWatchedService;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/users/{userId}/movies")
public class MovieController
{
	@Autowired
	private MovieService movieService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserMovieWatchedService userMovieWatchedService;

	@GetMapping("")
	public ModelAndView getAllMovies(@PathVariable Long userId)
	{
		Optional<User> user = userService.getUserById(userId);
		ModelAndView mav;
		if (user.get().getRole().equals(Role.USER))
		{
			mav = new ModelAndView("userMovies");
			mav.addObject("userRole", "user");
		} else
		{
			mav = new ModelAndView("adminMovies");
			mav.addObject("userRole", "admin");
		}
		List<UserMovieWatched> userMovieWatchedList = userMovieWatchedService.getAllRecordsForUserMovieWatched();
		mav.addObject("userMovieWatchedList", userMovieWatchedList);
		mav.addObject("userId", userId);
		mav.addObject("movies", movieService.getAllMovies());
		return mav;
	}

	@PostMapping("")
	public ResponseEntity<String> addMovie(@PathVariable Long userId, @RequestBody @Valid MovieDTO movieDTO)
	{
		try
		{
			movieService.saveMovie(movieDTO);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{movieId}/delete")
	public ResponseEntity<String> deleteMovie(@PathVariable Long userId, @PathVariable Long movieId)
	{
		try
		{
			movieService.deleteMovie(movieId);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{movieId}/mark")
	public ResponseEntity<String> markMovieAsWatchedOrNotWatched(@PathVariable Long userId, @PathVariable Long movieId)
	{
		try
		{
			userMovieWatchedService.markMovieAsWatchedOrNotWatched(userId, movieId);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{movieId}/edit")
	public ResponseEntity<String> editMovie(@PathVariable Long userId, @PathVariable Long movieId, @RequestBody @Valid MovieDTO movieDTO)
	{
		try
		{
			movieService.editMovie(movieId, movieDTO);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{movieId}/info")
	public ModelAndView getAllMovies(@PathVariable Long userId, @PathVariable Long movieId)
	{
		ModelAndView mav;
		mav = new ModelAndView("movieInfo");
		mav.addObject("userId", userId);
		Movie movie = movieService.getMovieById(movieId);
		if (movie == null)
		{
			throw new RuntimeException("Movie does not exist");
		}
		mav.addObject("movie", movie);
		return mav;
	}
}
