package lk.premierleague.pos;

import java.sql.Date;

public class Match {

    private int matchNumber;
    private String club1;
    private String club2;
    private int scoreClub1;
    private int scoreClub2;
    private Date date;

    public Match() {
    }

    public Match(int matchNumber, String club1, String club2, int scoreClub1, int scoreClub2, Date date) {
        this.matchNumber = matchNumber;
        this.club1 = club1;
        this.club2 = club2;
        this.scoreClub1 = scoreClub1;
        this.scoreClub2 = scoreClub2;
        this.date = date;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public String getClub1() {
        return club1;
    }

    public void setClub1(String club1) {
        this.club1 = club1;
    }

    public String getClub2() {
        return club2;
    }

    public void setClub2(String club2) {
        this.club2 = club2;
    }

    public int getScoreClub1() {
        return scoreClub1;
    }

    public void setScoreClub1(int scoreClub1) {
        this.scoreClub1 = scoreClub1;
    }

    public int getScoreClub2() {
        return scoreClub2;
    }

    public void setScoreClub2(int scoreClub2) {
        this.scoreClub2 = scoreClub2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
