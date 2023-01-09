package com.example.applicationfortrackingwatchedmoviesandseriesrest;

import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Episode;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Movie;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Role;
import com.example.applicationfortrackingwatchedmoviesandseriesrest.model.Series;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

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
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			if (userRepository.count() == 0)
			{
				userRepository.save(new User("admin@admin.com", bCryptPasswordEncoder.encode("admin123"), null, Role.ADMIN));
				userRepository.save(new User("user@user.com", bCryptPasswordEncoder.encode("user123"), null, Role.USER));
			}
			if (movieRepository.count() == 0)
			{
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

			if (seriesRepository.count() == 0 && episodeRepository.count() == 0)
			{
				// Game of Thrones
				String fileName = "/GameOfThrones.jpg";
				URL fileUrl = classLoader.getResource("static/images/" + fileName);
				URI fileUri = fileUrl.toURI();
				Path filePath = Paths.get(fileUri);
				byte[] imageData = Files.readAllBytes(filePath);

				Series gameOfThrones = new Series("Game of Thrones", "Fantasy", "David Benioff and D. B. Weiss", 2011, 8, Base64.getEncoder().encodeToString(imageData));
				seriesRepository.save(gameOfThrones);

				List<Episode> gameOfThronesEpisodes = new ArrayList<>();
				gameOfThronesEpisodes.add(new Episode(gameOfThrones, 1, 1, "Winter Is Coming", 60, new Date(2011, 4, 17)));
				gameOfThronesEpisodes.add(new Episode(gameOfThrones, 1, 2, "The Kingsroad", 60, new Date(2011, 4, 24)));
				gameOfThronesEpisodes.add(new Episode(gameOfThrones, 1, 3, "Lord Snow", 60, new Date(2011, 5, 1)));
				gameOfThronesEpisodes.add(new Episode(gameOfThrones, 1, 4, "Cripples, Bastards, and Broken Things", 60, new Date(2011, 5, 8)));
				gameOfThronesEpisodes.add(new Episode(gameOfThrones, 1, 5, "The Wolf and the Lion", 60, new Date(2011, 5, 15)));

				episodeRepository.saveAll(gameOfThronesEpisodes);

				// Stranger Things
				fileName = "/StrangerThings.jpg";
				fileUrl = classLoader.getResource("static/images/" + fileName);
				fileUri = fileUrl.toURI();
				filePath = Paths.get(fileUri);
				imageData = Files.readAllBytes(filePath);

				Series strangerThings = new Series("Stranger Things", "Sci-Fi", "The Duffer Brothers", 2016, 4, Base64.getEncoder().encodeToString(imageData));
				seriesRepository.save(strangerThings);

				List<Episode> strangerThingsEpisodes = new ArrayList<>();
				strangerThingsEpisodes.add(new Episode(strangerThings, 1, 1, "Chapter One: The Vanishing of Will Byers", 50, new Date(2016, 7, 15)));
				strangerThingsEpisodes.add(new Episode(strangerThings, 1, 2, "Chapter Two: The Weirdo on Maple Street", 50, new Date(2016, 7, 15)));
				strangerThingsEpisodes.add(new Episode(strangerThings, 1, 3, "Chapter Three: Holly, Jolly", 50, new Date(2016, 7, 15)));
				strangerThingsEpisodes.add(new Episode(strangerThings, 1, 4, "Chapter Four: The Body", 50, new Date(2016, 7, 15)));
				strangerThingsEpisodes.add(new Episode(strangerThings, 1, 5, "Chapter Five: The Flea and the Acrobat", 50, new Date(2016, 7, 15)));

				episodeRepository.saveAll(strangerThingsEpisodes);

				// The Office
				fileName = "/TheOffice.jpg";
				fileUrl = classLoader.getResource("static/images/" + fileName);
				fileUri = fileUrl.toURI();
				filePath = Paths.get(fileUri);
				imageData = Files.readAllBytes(filePath);

				Series theOffice = new Series("The Office", "Comedy", "Greg Daniels", 2005, 9, Base64.getEncoder().encodeToString(imageData));
				seriesRepository.save(theOffice);

				List<Episode> theOfficeEpisodes = new ArrayList<>();
				theOfficeEpisodes.add(new Episode(theOffice, 1, 1, "Pilot", 30, new Date(2005, 3, 24)));
				theOfficeEpisodes.add(new Episode(theOffice, 1, 2, "Diversity Day", 30, new Date(2005, 3, 31)));
				theOfficeEpisodes.add(new Episode(theOffice, 1, 3, "Health Care", 30, new Date(2005, 4, 7)));
				theOfficeEpisodes.add(new Episode(theOffice, 1, 4, "The Alliance", 30, new Date(2005, 4, 14)));
				theOfficeEpisodes.add(new Episode(theOffice, 1, 5, "Basketball", 30, new Date(2005, 4, 21)));

				episodeRepository.saveAll(theOfficeEpisodes);

				// The Sopranos
				fileName = "/TheSopranos.jpg";
				fileUrl = classLoader.getResource("static/images/" + fileName);
				fileUri = fileUrl.toURI();
				filePath = Paths.get(fileUri);
				imageData = Files.readAllBytes(filePath);

				Series theSopranos = new Series("The Sopranos", "Crime", "David Chase", 1999, 6, Base64.getEncoder().encodeToString(imageData));
				seriesRepository.save(theSopranos);

				List<Episode> theSopranosEpisodes = new ArrayList<>();
				theSopranosEpisodes.add(new Episode(theSopranos, 1, 1, "The Sopranos", 75, new Date(1999, 1, 10)));
				theSopranosEpisodes.add(new Episode(theSopranos, 1, 2, "46 Long", 75, new Date(1999, 1, 17)));
				theSopranosEpisodes.add(new Episode(theSopranos, 1, 3, "Denial, Anger, Acceptance", 75, new Date(1999, 1, 24)));
				theSopranosEpisodes.add(new Episode(theSopranos, 1, 4, "Meadowlands", 75, new Date(1999, 1, 31)));
				theSopranosEpisodes.add(new Episode(theSopranos, 1, 5, "College", 75, new Date(1999, 2, 7)));

				episodeRepository.saveAll(theSopranosEpisodes);

				// The Mandalorian
				fileName = "/TheMandalorian.jpg";
				fileUrl = classLoader.getResource("static/images/" + fileName);
				fileUri = fileUrl.toURI();
				filePath = Paths.get(fileUri);
				imageData = Files.readAllBytes(filePath);

				Series theMandalorian = new Series("The Mandalorian", "Action", "Jon Favreau", 2019, 2, Base64.getEncoder().encodeToString(imageData));
				seriesRepository.save(theMandalorian);

				List<Episode> theMandalorianEpisodes = new ArrayList<>();
				theMandalorianEpisodes.add(new Episode(theMandalorian, 1, 1, "Chapter 1: The Mandalorian", 35, new Date(2019, 11, 12)));
				theMandalorianEpisodes.add(new Episode(theMandalorian, 1, 2, "Chapter 2: The Child", 35, new Date(2019, 11, 15)));
				theMandalorianEpisodes.add(new Episode(theMandalorian, 1, 3, "Chapter 3: The Sin", 35, new Date(2019, 11, 22)));
				theMandalorianEpisodes.add(new Episode(theMandalorian, 1, 4, "Chapter 4: Sanctuary", 35, new Date(2019, 11, 29)));
				theMandalorianEpisodes.add(new Episode(theMandalorian, 1, 5, "Chapter 5: The Gunslinger", 35, new Date(2019, 12, 6)));

				episodeRepository.saveAll(theMandalorianEpisodes);

				// Westworld
				fileName = "/Westworld.jpg";
				fileUrl = classLoader.getResource("static/images/" + fileName);
				fileUri = fileUrl.toURI();
				filePath = Paths.get(fileUri);
				imageData = Files.readAllBytes(filePath);

				Series westworld = new Series("Westworld", "Sci-Fi", "Jonathan Nolan", 2016, 3, Base64.getEncoder().encodeToString(imageData));
				seriesRepository.save(westworld);

				List<Episode> westworldEpisodes = new ArrayList<>();
				westworldEpisodes.add(new Episode(westworld, 1, 1, "The Original", 60, new Date(2016, 10, 2)));
				westworldEpisodes.add(new Episode(westworld, 1, 2, "Chestnut", 60, new Date(2016, 10, 9)));
				westworldEpisodes.add(new Episode(westworld, 1, 3, "The Stray", 60, new Date(2016, 10, 16)));
				westworldEpisodes.add(new Episode(westworld, 1, 4, "Dissonance Theory", 60, new Date(2016, 10, 23)));
				westworldEpisodes.add(new Episode(westworld, 1, 5, "Contrapasso", 60, new Date(2016, 10, 30)));

				episodeRepository.saveAll(westworldEpisodes);
			}
		};
	}
}
