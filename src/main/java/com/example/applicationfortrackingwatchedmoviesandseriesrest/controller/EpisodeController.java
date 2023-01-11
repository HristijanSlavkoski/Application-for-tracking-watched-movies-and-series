package com.example.applicationfortrackingwatchedmoviesandseriesrest.controller;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.EpisodeDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.UserMovieEpisodeWatchedDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Episode;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Role;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.User;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.UserEpisodeWatched;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.EpisodeService;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.service.UserEpisodeWatchedService;
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
@RequestMapping(value = "/users/{userId}/series/{seriesId}/episodes")
public class EpisodeController
{
	@Autowired
	private EpisodeService episodeService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserEpisodeWatchedService userEpisodeWatchedService;

	@GetMapping("")
	public ModelAndView getAllEpisodesForSeries(@PathVariable Long userId, @PathVariable Long seriesId)
	{
		Optional<User> user = userService.getUserById(userId);
		ModelAndView mav;
		if (user.get().getRole().equals(Role.USER))
		{
			mav = new ModelAndView("userEpisodes");
			mav.addObject("userRole", "user");
		} else
		{
			mav = new ModelAndView("adminEpisodes");
			mav.addObject("userRole", "admin");
		}
		List<UserEpisodeWatched> userEpisodeWatchedList = userEpisodeWatchedService.getAllRecordsForUserEpisodeWatched();
		mav.addObject("userEpisodeWatchedList", userEpisodeWatchedList);
		mav.addObject("userId", userId);
		mav.addObject("episodes", episodeService.getAllEpisodesForSeries(seriesId));
		return mav;
	}

	@PostMapping("")
	public ResponseEntity<String> addEpisode(@PathVariable Long userId, @PathVariable Long seriesId, @RequestBody @Valid EpisodeDTO episodeDTO)
	{
		try
		{
			episodeService.saveEpisodeForSeries(episodeDTO, seriesId);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{episodeId}/delete")
	public ResponseEntity<String> deleteEpisode(@PathVariable Long userId, @PathVariable Long seriesId, @PathVariable Long episodeId)
	{
		try
		{
			episodeService.deleteEpisode(episodeId);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{episodeId}/mark")
	public ResponseEntity<String> markEpisodeAsWatched(@PathVariable Long userId, @PathVariable Long seriesId, @PathVariable Long episodeId, @RequestBody UserMovieEpisodeWatchedDTO userMovieEpisodeWatchedDTO)
	{
		try
		{
			userEpisodeWatchedService.markEpisodeAsWatched(userId, episodeId, userMovieEpisodeWatchedDTO);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{episodeId}/unmark")
	public ResponseEntity<String> markEpisodeAsNotWatched(@PathVariable Long userId, @PathVariable Long seriesId, @PathVariable Long episodeId)
	{
		try
		{
			userEpisodeWatchedService.markEpisodeAsNotWatched(userId, episodeId);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{episodeId}/edit")
	public ResponseEntity<String> editEpisode(@PathVariable Long userId, @PathVariable Long seriesId, @PathVariable Long episodeId, @RequestBody @Valid EpisodeDTO episodeDTO)
	{
		try
		{
			episodeService.editEpisode(episodeId, episodeDTO);
			return new ResponseEntity<String>("\"Success\"", HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{episodeId}/info")
	public ModelAndView getEpisode(@PathVariable Long userId, @PathVariable Long episodeId)
	{
		ModelAndView mav;
		mav = new ModelAndView("episodeInfo");
		mav.addObject("userId", userId);
		Episode episode = episodeService.getEpisodeById(episodeId);
		if (episode == null)
		{
			throw new RuntimeException("Episode does not exist");
		}
		mav.addObject("episode", episode);
		return mav;
	}

	@GetMapping("/last-watched-for-series")
	public ModelAndView getLastWatchedEpisodeForSeries(@PathVariable Long userId, @PathVariable Long seriesId)
	{
		ModelAndView mav;
		mav = new ModelAndView("episodeInfo");
		mav.addObject("userId", userId);
		Episode episode = userEpisodeWatchedService.getLastWatchedEpisodeForUserForSeries(userId, seriesId);
		if (episode == null)
		{
			throw new RuntimeException("Episode does not exist");
		}
		mav.addObject("isForSeries", true);
		mav.addObject("episode", episode);
		return mav;
	}
}
