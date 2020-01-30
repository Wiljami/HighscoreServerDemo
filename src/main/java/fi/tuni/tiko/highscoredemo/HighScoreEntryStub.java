package fi.tuni.tiko.highscoredemo;

public class HighScoreEntryStub {
    private String name;
    private int score;

    public HighScoreEntryStub(HighScoreEntry highScoreEntry) {
        setName(highScoreEntry.getName());
        setScore(highScoreEntry.getScore());
    }

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
}
