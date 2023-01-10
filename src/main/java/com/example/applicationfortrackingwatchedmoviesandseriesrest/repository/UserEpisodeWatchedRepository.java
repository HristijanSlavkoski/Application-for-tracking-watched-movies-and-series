package com.example.applicationfortrackingwatchedmoviesandseriesrest.repository;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.User;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.UserEpisodeWatched;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEpisodeWatchedRepository extends JpaRepository<UserEpisodeWatched, Long>
{
	@Query("SELECT u FROM UserEpisodeWatched u WHERE u.user.id=?1 AND u.episode.id=?2")
	Optional<UserEpisodeWatched> findByUserAndEpisode(Long userId, Long episodeId);

	Optional<UserEpisodeWatched> findTopByUserOrderByDateWatchedDesc(User user);
}
