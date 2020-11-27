package lk.premierleague.pos.view.TM;

public class ClubDetailTM {
    private String name;
    private int wins;
    private int draws;
    private int defeats;
    private int received;
    private int scored;
    private int points;
    private int matches;

    public ClubDetailTM(String name, int wins, int draws, int defeats, int received, int scored, int points, int matches) {
        this.name = name;
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.received = received;
        this.scored = scored;
        this.points = points;
        this.matches = matches;
    }

    public ClubDetailTM() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
        this.received = received;
    }

    public int getScored() {
        return scored;
    }

    public void setScored(int scored) {
        this.scored = scored;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }
}

