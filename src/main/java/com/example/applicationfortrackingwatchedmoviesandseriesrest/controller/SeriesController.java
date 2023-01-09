package com.example.applicationfortrackingwatchedmoviesandseriesrest.controller;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.SeriesDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Role;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.User;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.SeriesRepository;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	private SeriesRepository seriesRepository;

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
		mav.addObject("series", seriesRepository.findAll());
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
			seriesRepository.deleteById(seriesId);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	//TODO:
	//get mapping na {seriesId}/info isto kako vo movieController
}
