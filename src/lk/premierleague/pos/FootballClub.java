package lk.premierleague.pos;

public class FootballClub extends SportClub {
    private String name;
    private String location;
    private int tp;
    private int wins;
    private int draws;
    private int defeats;
    private int receivedGoals;
    private int scoredGoals;
    private int points;
    private int playedMatches;

    public FootballClub(String name, String location, int tp, int wins, int draws, int defeats, int receivedGoals, int scoredGoals, int points, int playedMatches) {
        this.name = name;
        this.location = location;
        this.tp = tp;
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.receivedGoals = receivedGoals;
        this.scoredGoals = scoredGoals;
        this.points = points;
        this.playedMatches = playedMatches;
    }



    public FootballClub(String name, int receivedGoals, int scoredGoals,int points) {
        this.name = name;
        this.points = points;
        this.scoredGoals = scoredGoals;
        this.receivedGoals=receivedGoals;

    }

    public FootballClub(String string, String string1) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int getTp() {
        return tp;
    }

    @Override
    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getReceivedGoals() {
        return receivedGoals;
    }

    public void setReceivedGoals(int receivedGoals) {
        this.receivedGoals = receivedGoals;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPlayedMatches() {
        return playedMatches;
    }

    public void setPlayedMatches(int playedMatches) {
        this.playedMatches = playedMatches;
    }
}
