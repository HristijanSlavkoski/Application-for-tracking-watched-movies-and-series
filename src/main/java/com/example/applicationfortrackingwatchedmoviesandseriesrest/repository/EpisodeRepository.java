package com.example.applicationfortrackingwatchedmoviesandseriesrest.repository;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Episode;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long>
{
	void deleteById(Long id);

	List<Episode> findAllBySeries(Series series);
}
