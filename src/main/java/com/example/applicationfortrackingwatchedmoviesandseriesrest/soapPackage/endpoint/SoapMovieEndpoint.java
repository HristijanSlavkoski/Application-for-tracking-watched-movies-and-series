package com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.endpoint;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.AddMovieRequest;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.AddMovieResponse;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.DeleteMovieRequest;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.DeleteMovieResponse;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.GetAllMoviesRequest;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.GetAllMoviesResponse;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.GetMovieByIdRequest;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.GetMovieByIdResponse;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.UpdateMovieRequest;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.UpdateMovieResponse;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.soapPackage.service.SoapMovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapMovieEndpoint
{
	private static final String NAMESPACE_URI = "http://localhost.com/movie";

	private final SoapMovieServiceImpl soapMovieServiceImpl;

	@Autowired
	public SoapMovieEndpoint(SoapMovieServiceImpl soapMovieServiceImpl)
	{
		this.soapMovieServiceImpl = soapMovieServiceImpl;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllMoviesRequest")
	@ResponsePayload
	public GetAllMoviesResponse getAllMovies(@RequestPayload GetAllMoviesRequest request)
	{
		return soapMovieServiceImpl.getAllMovies();
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addMovieRequest")
	@ResponsePayload
	public AddMovieResponse addMovie(@RequestPayload AddMovieRequest request)
	{
		return soapMovieServiceImpl.addMovie(request);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateMovieRequest")
	@ResponsePayload
	public UpdateMovieResponse updateMovie(@RequestPayload UpdateMovieRequest request)
	{
		return soapMovieServiceImpl.updateMovie(request);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteMovieRequest")
	@ResponsePayload
	public DeleteMovieResponse deleteMovie(@RequestPayload DeleteMovieRequest request)
	{
		return soapMovieServiceImpl.deleteMovie(request);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMovieByIdRequest")
	@ResponsePayload
	public GetMovieByIdResponse getMovieById(@RequestPayload GetMovieByIdRequest request)
	{
		return soapMovieServiceImpl.getMovieById(request);
	}
}