package com.example.applicationfortrackingwatchedmoviesandseriesrest.repository;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.UserMovieWatched;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMovieWatchedRepository extends JpaRepository<UserMovieWatched, Long>
{
	@Query("SELECT u FROM UserMovieWatched u WHERE u.user.id=?1 AND u.movie.id=?2")
	Optional<UserMovieWatched> findByUserAndMovie(Long userId, Long movieId);
}
