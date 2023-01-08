package com.example.applicationfortrackingwatchedmoviesandseriesrest;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Movie;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Role;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.User;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.EpisodeRepository;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.MovieRepository;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.SeriesRepository;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@SpringBootApplication
public class ApplicationForTrackingWatchedMoviesAndSeriesRestApplication
{
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args)
	{
		SpringApplication.run(ApplicationForTrackingWatchedMoviesAndSeriesRestApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, MovieRepository movieRepository, SeriesRepository seriesRepository, EpisodeRepository episodeRepository)
	{
		return args ->
		{
			if (userRepository.count() == 0)
			{
				userRepository.save(new User("admin@admin.com", bCryptPasswordEncoder.encode("admin123"), null, Role.ADMIN));
				userRepository.save(new User("user@user.com", bCryptPasswordEncoder.encode("user123"), null, Role.USER));
			}
			if (movieRepository.count() == 0)
			{
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

				String fileName = "/TheDarkKnight.jpg";
				URL fileUrl = classLoader.getResource("static/images/" + fileName);
				URI fileUri = fileUrl.toURI();
				Path filePath = Paths.get(fileUri);
				byte[] imageData = Files.readAllBytes(filePath);
				movieRepository.save(new Movie("The Dark Knight", "Action", "Christopher Nolan", 2008, 152, Base64.getEncoder().encodeToString(imageData)));

				fileName = "/Gladiator.png";
				fileUrl = classLoader.getResource("static/images/" + fileName);
				fileUri = fileUrl.toURI();
				filePath = Paths.get(fileUri);
				imageData = Files.readAllBytes(filePath);
				movieRepository.save(new Movie("Gladiator", "Action", "Ridley Scott", 2000, 155, Base64.getEncoder().encodeToString(imageData)));

				fileName = "/AvengersEndGame.jpg";
				fileUrl = classLoader.getResource("static/images/" + fileName);
				fileUri = fileUrl.toURI();
				filePath = Paths.get(fileUri);
				imageData = Files.readAllBytes(filePath);
				movieRepository.save(new Movie("Avengers: Endgame", "Action", "Anthony Russo, Joe Russo", 2019, 182, Base64.getEncoder().encodeToString(imageData)));

				fileName = "/HomeAlone.jpg";
				fileUrl = classLoader.getResource("static/images/" + fileName);
				fileUri = fileUrl.toURI();
				filePath = Paths.get(fileUri);
				imageData = Files.readAllBytes(filePath);
				movieRepository.save(new Movie("Home Alone", "Comedy", "Chris Columbus", 1990, 103, Base64.getEncoder().encodeToString(imageData)));

				fileName = "/TheInvitation.jpg";
				fileUrl = classLoader.getResource("static/images/" + fileName);
				fileUri = fileUrl.toURI();
				filePath = Paths.get(fileUri);
				imageData = Files.readAllBytes(filePath);
				movieRepository.save(new Movie("The Invitation", "Horror", "\n" +
						"Jessica M. Thompson", 2022, 105, Base64.getEncoder().encodeToString(imageData)));

				fileName = "/KnivesOut.jpg";
				fileUrl = classLoader.getResource("static/images/" + fileName);
				fileUri = fileUrl.toURI();
				filePath = Paths.get(fileUri);
				imageData = Files.readAllBytes(filePath);
				movieRepository.save(new Movie("Knives Out", "Comedy", "Rian Johnson", 2008, 130, Base64.getEncoder().encodeToString(imageData)));
			}

			//TODO:
			//da se dodadat serii
		};
	}
}
