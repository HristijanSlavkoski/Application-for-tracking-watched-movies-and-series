package com.example.applicationfortrackingwatchedmoviesandseriesrest.repository;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long>
{
	public void deleteById(Long id);
}
