package com.example.applicationfortrackingwatchedmoviesandseriesrest.repository;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>
{
	public void deleteById(Long id);
}
