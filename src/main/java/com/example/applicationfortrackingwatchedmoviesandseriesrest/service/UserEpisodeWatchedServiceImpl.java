package com.example.applicationfortrackingwatchedmoviesandseriesrest.service;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.DTO.UserMovieEpisodeWatchedDTO;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Episode;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.User;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.UserEpisodeWatched;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.UserEpisodeWatchedRepository;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserEpisodeWatchedServiceImpl implements UserEpisodeWatchedService
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserEpisodeWatchedRepository userEpisodeWatchedRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void markEpisodeAsWatched(Long userId, Long episodeId, UserMovieEpisodeWatchedDTO userMovieEpisodeWatchedDTO)
	{
		String queryToInsert = "INSERT INTO user_episode_watched (user_id,episode_id,date_watched) VALUES (?1,?2, ?3)";
		Query nativeQueryToInsert = entityManager.createNativeQuery(queryToInsert);
		nativeQueryToInsert.setParameter(1, userId);
		nativeQueryToInsert.setParameter(2, episodeId);
		nativeQueryToInsert.setParameter(3, userMovieEpisodeWatchedDTO.getDateWatched());
		nativeQueryToInsert.executeUpdate();
	}

	@Override
	@Transactional
	public void markEpisodeAsNotWatched(Long userId, Long episodeId)
	{
		Optional<UserEpisodeWatched> userEpisodeWatched = userEpisodeWatchedRepository.findByUserAndEpisode(userId, episodeId);
		if (userEpisodeWatched.isPresent())
		{
			String queryDeleteRow = "DELETE FROM user_episode_watched WHERE user_id=?1 AND episode_id=?2";
			Query nativeQueryDeleteRow = entityManager.createNativeQuery(queryDeleteRow);
			nativeQueryDeleteRow.setParameter(1, userId);
			nativeQueryDeleteRow.setParameter(2, episodeId);
			nativeQueryDeleteRow.executeUpdate();
		}
	}

	@Override
	public List<UserEpisodeWatched> getAllRecordsForUserEpisodeWatched()
	{
		return userEpisodeWatchedRepository.findAll();
	}

	@Override
	public Episode getLastWatchedEpisodeForUser(Long userId)
	{
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent())
		{
			Optional<UserEpisodeWatched> userEpisodeWatched = userEpisodeWatchedRepository.findTopByUserOrderByDateWatchedDesc(user.get());
			if (userEpisodeWatched.isPresent())
			{
				return userEpisodeWatched.get().getEpisode();
			}
		}
		return null;
	}

	@Override
	@Transactional
	public Episode getLastWatchedEpisodeForUserForSeries(Long userId, Long seriesId)
	{
		String queryString = "SELECT e.* FROM user_episode_watched uew "
				+ "INNER JOIN episode e ON uew.episode_id = e.id "
				+ "WHERE uew.user_id = :userId "
				+ "AND e.id IN (SELECT ep.id FROM episode ep WHERE ep.series_id = :seriesId) "
				+ "ORDER BY uew.date_watched DESC LIMIT 1";

		Query query = entityManager.createNativeQuery(queryString, Episode.class);
		query.setParameter("userId", userId);
		query.setParameter("seriesId", seriesId);

		List<Episode> episodes = query.getResultList();
		if (!episodes.isEmpty())
		{
			return episodes.get(0);
		} else
		{
			return null;
		}
	}
}
