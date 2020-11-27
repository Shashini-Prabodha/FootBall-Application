package lk.premierleague.pos;


import java.util.List;

public interface LeagueManager {
    boolean addLeague() throws Exception;
    boolean updateLeague() throws Exception;
    boolean deleteLeague() throws Exception;
    void getLeague() throws Exception;
    List getAllLeague() throws Exception;
}
