package fi.tuni.tiko.highscoredemo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HighScoreRepo extends CrudRepository <HighScoreEntry, Long> {
    public List<HighScoreEntry> findTop10ByOrderByScoreDesc();
}
