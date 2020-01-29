package fi.tuni.tiko.highscoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class HighscoredemoApplication implements CommandLineRunner {
	@Autowired
	HighScoreRepo highScoreRepo;


	public static void main(String[] args) {
		SpringApplication.run(HighscoredemoApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) {
		List<HighScoreEntry> highScores = new ArrayList<>();

		highScores.add(new HighScoreEntry("Pekka", 100));
		highScores.add(new HighScoreEntry("Maija", 200));
		highScores.add(new HighScoreEntry("Kalle", 300));
		highScores.add(new HighScoreEntry("Heikki", 400));
		highScores.add(new HighScoreEntry("Jukka", 500));
		highScores.add(new HighScoreEntry("Hanna", 600));
		highScores.add(new HighScoreEntry("Lotta", 700));
		highScores.add(new HighScoreEntry("Anna", 800));
		highScores.add(new HighScoreEntry("Essi", 900));

		highScoreRepo.saveAll(highScores);
	}

	@RequestMapping("get/")
	public Iterable<HighScoreEntry> getScores() {
		return highScoreRepo.findAll();
	}
}
