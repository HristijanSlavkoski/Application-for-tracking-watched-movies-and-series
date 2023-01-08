package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.UserMovieWatched;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.UserMovieWatchedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserMovieWatchedServiceImpl implements UserMovieWatchedService
{
	@Autowired
	private UserMovieWatchedRepository userMovieWatchedRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void markMovieAsWatchedOrNotWatched(Long userId, Long movieId)
	{
		Optional<UserMovieWatched> userMovieWatched = userMovieWatchedRepository.findByUserAndMovie(userId, movieId);
		if (userMovieWatched.isPresent())
		{
			// The User has already watched the movie, mark it as not watched
			String queryDeleteRow = "DELETE FROM user_movie_watched WHERE user_id=?1 AND movie_id=?2";
			Query nativeQueryDeleteRow = entityManager.createNativeQuery(queryDeleteRow);
			nativeQueryDeleteRow.setParameter(1, userId);
			nativeQueryDeleteRow.setParameter(2, movieId);
			nativeQueryDeleteRow.executeUpdate();
		} else
		{
			// The User hasn't watched the movie, mark it as watched
			String queryToInsert = "INSERT INTO user_movie_watched(user_id,movie_id) VALUES (?1,?2)";
			Query nativeQueryToInsert = entityManager.createNativeQuery(queryToInsert);
			nativeQueryToInsert.setParameter(1, userId);
			nativeQueryToInsert.setParameter(2, movieId);
			nativeQueryToInsert.executeUpdate();
		}
	}

	@Override
	public List<UserMovieWatched> getAllRecordsForUserMovieWatched()
	{
		return userMovieWatchedRepository.findAll();
	}
}
