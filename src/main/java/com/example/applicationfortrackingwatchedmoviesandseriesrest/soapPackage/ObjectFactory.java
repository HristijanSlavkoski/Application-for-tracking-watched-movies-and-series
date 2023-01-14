package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the soapPackage package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory
{


	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soapPackage
	 */
	public ObjectFactory()
	{
	}

	/**
	 * Create an instance of {@link GetAllMoviesRequest }
	 */
	public GetAllMoviesRequest createGetAllMoviesRequest()
	{
		return new GetAllMoviesRequest();
	}

	/**
	 * Create an instance of {@link GetAllMoviesResponse }
	 */
	public GetAllMoviesResponse createGetAllMoviesResponse()
	{
		return new GetAllMoviesResponse();
	}

	/**
	 * Create an instance of {@link UserMovieWatchedList }
	 */
	public UserMovieWatchedList createUserMovieWatchedList()
	{
		return new UserMovieWatchedList();
	}

	/**
	 * Create an instance of {@link Movies }
	 */
	public Movies createMovies()
	{
		return new Movies();
	}

	/**
	 * Create an instance of {@link AddMovieRequest }
	 */
	public AddMovieRequest createAddMovieRequest()
	{
		return new AddMovieRequest();
	}

	/**
	 * Create an instance of {@link MovieDTO }
	 */
	public MovieDTO createMovieDTO()
	{
		return new MovieDTO();
	}

	/**
	 * Create an instance of {@link AddMovieResponse }
	 */
	public AddMovieResponse createAddMovieResponse()
	{
		return new AddMovieResponse();
	}

	/**
	 * Create an instance of {@link UpdateMovieRequest }
	 */
	public UpdateMovieRequest createUpdateMovieRequest()
	{
		return new UpdateMovieRequest();
	}

	/**
	 * Create an instance of {@link UpdateMovieResponse }
	 */
	public UpdateMovieResponse createUpdateMovieResponse()
	{
		return new UpdateMovieResponse();
	}

	/**
	 * Create an instance of {@link DeleteMovieRequest }
	 */
	public DeleteMovieRequest createDeleteMovieRequest()
	{
		return new DeleteMovieRequest();
	}

	/**
	 * Create an instance of {@link DeleteMovieResponse }
	 */
	public DeleteMovieResponse createDeleteMovieResponse()
	{
		return new DeleteMovieResponse();
	}

	/**
	 * Create an instance of {@link GetMovieByIdRequest }
	 */
	public GetMovieByIdRequest createGetMovieByIdRequest()
	{
		return new GetMovieByIdRequest();
	}

	/**
	 * Create an instance of {@link GetMovieByIdResponse }
	 */
	public GetMovieByIdResponse createGetMovieByIdResponse()
	{
		return new GetMovieByIdResponse();
	}

	/**
	 * Create an instance of {@link Movie }
	 */
	public Movie createMovie()
	{
		return new Movie();
	}

	/**
	 * Create an instance of {@link UserMovieWatched }
	 */
	public UserMovieWatched createUserMovieWatched()
	{
		return new UserMovieWatched();
	}

	/**
	 * Create an instance of {@link User }
	 */
	public User createUser()
	{
		return new User();
	}

}
