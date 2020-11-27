package lk.premierleague.pos;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Date;

public class PremierLeagueManager implements LeagueManager {

    Scanner scanner = new Scanner(System.in);

    public PremierLeagueManager() {
        mainmenu();
    }

    private void mainmenu() {
        try {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("                               Premier League - 2020");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Create new club and register to league ---> press (1)");
            System.out.println("Delete club                            ---> press (2)");
            System.out.println("Display statistics for a selected club ---> press (3)");
            System.out.println("Display the Premier League Table       ---> press (4)");
            System.out.println("Add new match                          ---> press (5)");
            System.out.println("Get All Detials from UI                ---> press (6)");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("Enter Number : ");
            int enter = scanner.nextInt();
            System.out.println("-------------------------------------------------------------------------------------");
            switch (enter) {
                case 1:
                    if (addLeague()) {
                        System.out.println("Added your Club ...!");
                        mainmenu();
                    } else {
                        System.out.println("Try again ...!");
                    }
                    break;
                case 2:
                    if (deleteLeague()) {
                        System.out.println("Deleted successfull ...!");
                        mainmenu();
                    } else {
                        System.out.println("Try again ...!");
                    }
                    break;
                case 3:
                    getLeague();
                    break;
                case 4:
                    getAllLeague();
                    break;
                case 5:
                    if (updateLeague()) {
                        System.out.println("Added match ...!");
                        mainmenu();
                    } else {
                        System.out.println("Try again ...!");
                    }
                    break;
                case 6:
                    Stage stage = new Stage();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/premierleague/pos/view/ClubDetailFormView.fxml"))));
                    stage.setResizable(false);
                    stage.centerOnScreen();
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.show();

                    break;
                default:
                    System.out.println("Please use only 1 to 5 numbers");
                    System.out.println("Enter Number : ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addLeague() {
        try {
            System.out.println("             *** Add New Club to League ***");
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.print("Input Football club name : ");
            scanner.nextLine();
            String name = scanner.nextLine();

            System.out.print("Input Telephone No : ");
            int tp = scanner.nextInt();

            System.out.print("Input location : ");
            scanner.nextLine();
            String location = scanner.nextLine();

            // if (Pattern.compile("^\\d{10}$").matcher(tp + "").matches()) {
            // try {
            System.out.print("Input no of win : ");
            int wins = scanner.nextInt();

            System.out.print("Input no of draw : ");
            int draws = scanner.nextInt();

            System.out.print("Input no of defeats : ");
            int defeats = scanner.nextInt();

            System.out.print("Input no of received goal : ");
            int receivedGoals = scanner.nextInt();

            System.out.print("Input no of scored goal : ");
            int scoredGoals = scanner.nextInt();

            System.out.print("Input no of points : ");
            int points = scanner.nextInt();

            System.out.print("Input no of played matches : ");
            int playedMatches = scanner.nextInt();


            return CrudUtil.execute("INSERT INTO footballClub VALUES(?,?,?,?,?,?,?,?,?,?)", name, location,
                    tp, wins, draws, defeats, receivedGoals, scoredGoals, points, playedMatches);


//            } catch (Exception e) {
//                System.out.println("Please use only numbers");
//            }
//        return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateLeague() {

        try {
            System.out.println("             *** Match Update ***");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("Enter the club 1 name : ");
            scanner.nextLine();
            String name1 = scanner.nextLine();

            System.out.print("Enter the club 2 name : ");
            String name2 = scanner.nextLine();

            System.out.print("Input no of score goal club 1 : ");
            int scoreClub1 = scanner.nextInt();

            System.out.print("Input no of score goal club 2 : ");
            int scoreClub2 = scanner.nextInt();

            System.out.print("Input Date (yyyy-mm-dd) : ");

            scanner.nextLine();
            String d = scanner.nextLine();
            Date date = Date.valueOf(d);

            FootballClub league = getLeague(name1);
            FootballClub league2 = getLeague(name2);


            CrudUtil.execute("INSERT INTO matchDetails VALUES(?,?,?,?,?,?)", getLastMatchID() + 1, name1, name2, scoreClub1, scoreClub2, date);

            if (scoreClub1 > scoreClub2) {

                CrudUtil.execute("UPDATE footballClub SET defeats=?, receivedGoals=?,scoredGoals=?, playedMatches=? WHERE name=?",
                        league2.getDefeats() + 1, league2.getReceivedGoals() + scoreClub2, league2.getScoredGoals() + scoreClub2, league2.getPlayedMatches() + 1, name2);
                return CrudUtil.execute("UPDATE footballClub SET wins=?, receivedGoals=?,scoredGoals=?, points=?, playedMatches=? WHERE name=?",
                        league.getWins() + 1, league.getReceivedGoals() + scoreClub1, league.getScoredGoals() + scoreClub1, league.getPoints() + 1, league.getPlayedMatches() + 1, name1);

            } else if (scoreClub1 == scoreClub2) {
                CrudUtil.execute("UPDATE footballClub SET draws=?, receivedGoals=?,scoredGoals=?, points=?, playedMatches=? WHERE name=?",
                        league2.getDraws() + 1, league2.getReceivedGoals() + scoreClub2, league2.getScoredGoals() + scoreClub2, league2.getPoints() + 1, league2.getPlayedMatches() + 1, name2);
                return CrudUtil.execute("UPDATE footballClub SET draws=?, receivedGoals=?,scoredGoals=?, points=?, playedMatches=? WHERE name=?",
                        league.getDraws() + 1, league.getReceivedGoals() + scoreClub1, league.getScoredGoals() + scoreClub1, league.getPoints() + 1, league.getPlayedMatches() + 1, name1);

            } else {
                CrudUtil.execute("UPDATE footballClub SET wins=?, receivedGoals=?,scoredGoals=?, points=?,playedMatches=? WHERE name=?",
                        league2.getWins() + 1, league2.getReceivedGoals() + scoreClub2, league2.getScoredGoals() + scoreClub2, league2.getPoints() + 1, league2.getPlayedMatches() + 1, name2);
                return CrudUtil.execute("UPDATE footballClub SET defeats=?, receivedGoals=?,scoredGoals=?,  playedMatches=? WHERE name=?",
                        league.getDefeats() + 1, league.getReceivedGoals() + scoreClub1, league.getScoredGoals() + scoreClub1, league.getPlayedMatches() + 1, name1);

            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean deleteLeague() {
        try {
            System.out.println("             *** Delete Club ***");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("Enter the club name you want to delete : ");
            scanner.nextLine();
            String name = scanner.nextLine();

            System.out.print("Are you sure (Y/N) : ");
            String comment = scanner.nextLine();

            if (comment.equalsIgnoreCase("N")) {
                mainmenu();
            } else if (comment.equalsIgnoreCase("Y")) {

                return CrudUtil.execute("DELETE FROM footballClub WHERE name=?", name);

            } else {
                System.out.println("Invalid Input. Please use Y or N");
                mainmenu();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void getLeague() {
        System.out.println("             *** Detail of the Club ***");
        System.out.println("-------------------------------------------------------------------------------------");
        scanner.nextLine();
        System.out.print("Enter the club name : ");
        String name = scanner.nextLine();
        FootballClub team = getLeague(name);
        if (!team.equals(null)) {

            System.out.println("Name of the club : " + team.getName());
            System.out.println("Location : " + team.getLocation());
            System.out.println("Telephone No : " + team.getTp());
            System.out.println("Number of win : " + team.getWins());
            System.out.println("Number of draw : " + team.getDraws());
            System.out.println("Number of defeats : " + team.getDefeats());
            System.out.println("Number of received goal : " + team.getReceivedGoals());
            System.out.println("Number of scored goal : " + team.getScoredGoals());
            System.out.println("Number of goal difference : " + (team.getReceivedGoals() - team.getScoredGoals()));
            System.out.println("Number of points : " + team.getPoints());
            System.out.println("Number of played matches : " + team.getPlayedMatches());
        }
        mainmenu();

    }

    public FootballClub getLeague(String name) {
        FootballClub team = null;
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM footballClub WHERE name=?", name);
            if (resultSet.next()) {

                team = new FootballClub(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10));

            } else {
                System.out.println("Can't found this club...");
                mainmenu();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return team;
    }

    @Override
    public List getAllLeague() {
        List<FootballClub> list = new ArrayList<>();

        try {
            System.out.println("             *** Premier League Table ***");
            System.out.println("-------------------------------------------------------------------------------------");
            ResultSet resultSet = CrudUtil.execute("SELECT name,receivedGoals,scoredGoals,points FROM footballClub ORDER BY points desc, scoredGoals desc");
            while (resultSet.next()) {
                list.add(new FootballClub(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4))
                );
            }

            for (FootballClub club : list) {
                System.out.println("Club Name ---> " + club.getName() + "   |   Points : " + club.getPoints() + "   |   Scored Goals : " + club.getScoredGoals() + "   |   Goals Difference : " + (club.getReceivedGoals() - club.getScoredGoals()));
            }
            mainmenu();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getLastMatchID() {

        try {
            ResultSet rst = CrudUtil.execute("SELECT matchID FROM matchDetails ORDER BY matchID DESC LIMIT 1");
            int id = 0;
            if (rst.next()) {
                id = rst.getInt(1);
            }
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
