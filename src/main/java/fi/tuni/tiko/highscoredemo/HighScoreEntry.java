package fi.tuni.tiko.highscoredemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HighScoreEntry {
    @Id
    @GeneratedValue
    private long id;

    public HighScoreEntry() {}

    public HighScoreEntry(String name, int score) {
        setName(name);
        setScore(score);
    }

    private String name;

    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getId() {
        return id;
    }
}
