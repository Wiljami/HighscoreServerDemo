package fi.tuni.tiko.highscoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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

	@RequestMapping(value = "add/", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody HighScoreEntry c, UriComponentsBuilder b) {
		highScoreRepo.save(c);
		UriComponents uriComponents = b.path("/get/{id}").buildAndExpand(c.getId());

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponents.toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/name={name}&score={score}&user={user}&password={password}", method = RequestMethod.POST)
	public void id(
			@PathVariable(value = "name") String name,
			@PathVariable(value = "score") int score,
			@PathVariable(value = "user") String user,
			@PathVariable(value = "password") String password) {

		System.out.println(name);
		System.out.println(score);
		System.out.println(user);
		System.out.println(password);
	}


	@RequestMapping(value = "", method = RequestMethod.POST)
	public void test() {
		System.out.println("hellurei");
	}

	@RequestMapping("get/")
	public String getScores() {

		String response = "{\"message\": \"\", \"2\": [\"Jussi\", 11200], \"3\": [\"Ville\", 10212], \"4\":\n" +
				"[\"Sami\", 10011], \"5\": [\"Sami\", 10011], \"6\": [\"Sami\", 10010], \"1\":\n" +
				"[\"Jussi\", 11200], \"8\": [\"Sami\", 10001], \"9\": [\"Sami\", 10000],\n" +
				"\"10\": [\"Samppa\", 9889], \"7\": [\"Sami\", 10010], \"error\": 0, \"count\":\n" +
				"10} ";

		return response;
	}
}
