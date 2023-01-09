package com.example.applicationfortrackingwatchedmoviesandseriesrest.controller;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.MovieDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.SeriesDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Movie;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Role;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Series;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.User;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.SeriesRepository;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.SeriesService;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/users/{userId}/series")
public class SeriesController
{
	//TODO:
	//da se smeni od repository vo service
	@Autowired
	private SeriesService seriesService;

	@Autowired
	private UserService userService;

	@GetMapping("")
	public ModelAndView getAllSeries(@PathVariable Long userId)
	{
		Optional<User> user = userService.getUserById(userId);
		ModelAndView mav;
		if (user.get().getRole().equals(Role.USER))
		{
			mav = new ModelAndView("userSeries");
			mav.addObject("userRole", "user");
		} else
		{
			mav = new ModelAndView("adminSeries");
			mav.addObject("userRole", "admin");
		}
		mav.addObject("userId", userId);
		mav.addObject("series", seriesService.getAllSeries());
		return mav;
	}

	@PostMapping("")
	public ResponseEntity<String> addSeries(@PathVariable Long userId, @RequestBody @Valid SeriesDTO seriesDTO)
	{
		try
		{
			//TODO:
			//da se kreira serviceDTO i kako vo movies controler da se dodava vo baza
			//Series series = new Series(movieDTO.getTitle(), movieDTO.getGenre(), movieDTO.getDirector(), movieDTO.getYear(), movieDTO.getDurationInMinutes(), movieDTO.getImage());
			//seriesRepository.save(series);
			seriesService.saveSeries(seriesDTO);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{seriesId}/delete")
	public ResponseEntity<String> deleteMovie(@PathVariable Long userId, @PathVariable Long seriesId)
	{
		try
		{
			seriesService.deleteSeries(seriesId);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{seriesId}/edit")
	public ResponseEntity<String> editSeries(@PathVariable Long userId, @PathVariable Long seriesId, @RequestBody @Valid SeriesDTO seriesDTO)
	{
		try
		{
			seriesService.editSeries(seriesId, seriesDTO);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{seriesId}/info")
	public ModelAndView getAllSeries(@PathVariable Long userId, @PathVariable Long seriesId)
	{
		ModelAndView mav;
		mav = new ModelAndView("movieInfo");
		mav.addObject("userId", userId);
		Series series = seriesService.getSeriesById(seriesId);
		if (series == null)
		{
			throw new RuntimeException("Movie does not exist");
		}
		mav.addObject("movie", series);
		return mav;
	}

	//TODO:
	//get mapping na {seriesId}/info isto kako vo movieController
}
