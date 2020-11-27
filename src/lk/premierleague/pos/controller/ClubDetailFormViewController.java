package lk.premierleague.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.premierleague.pos.*;
import lk.premierleague.pos.view.TM.ClubDetailTM;
import lk.premierleague.pos.view.TM.ClubMatchTM;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClubDetailFormViewController {
    public ImageView imgLogo;
    public AnchorPane mainpane;
    public TableView<ClubDetailTM> tblClubDetails;
    public TableColumn colClubName, colWins, colDraws, colDefeats, colReceivedGoals, colScoredGoals, colPoints, colMatch;
    public Text txtClub1;
    public Text txtClub2;
    public JFXButton btnGenarate;
    public JFXButton btnExit;
    public JFXTextField txtDateSearch;
    public TableView<ClubMatchTM> tblSearchDate;
    public TableColumn columnClub, columnScored;
    public JFXButton btnSearchDate;
    public TableColumn columnClub2;
    public TableColumn columnScored2;


    public void initialize() {
        colClubName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colWins.setCellValueFactory(new PropertyValueFactory<>("wins"));
        colDraws.setCellValueFactory(new PropertyValueFactory<>("draws"));
        colDefeats.setCellValueFactory(new PropertyValueFactory<>("defeats"));
        colReceivedGoals.setCellValueFactory(new PropertyValueFactory<>("received"));
        colScoredGoals.setCellValueFactory(new PropertyValueFactory<>("scored"));
        colPoints.setCellValueFactory(new PropertyValueFactory<>("points"));
        colMatch.setCellValueFactory(new PropertyValueFactory<>("matches"));
        columnClub.setCellValueFactory(new PropertyValueFactory<>("club1"));
        columnScored.setCellValueFactory(new PropertyValueFactory<>("scoreClub1"));
        columnClub2.setCellValueFactory(new PropertyValueFactory<>("club2"));
        columnScored2.setCellValueFactory(new PropertyValueFactory<>("scoreClub2"));

        loadTable();

    }

    void loadTable() {
        ObservableList<ClubDetailTM> list = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM footballClub ORDER BY points desc");
            List<FootballClub> datalist = new ArrayList<>();
            while (resultSet.next()) {
                datalist.add(new FootballClub(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10)
                ));
            }

            for (FootballClub club : datalist) {
                ClubDetailTM tm = new ClubDetailTM(club.getName(), club.getWins(), club.getDraws(), club.getDefeats(), club.getPoints(),
                        club.getScoredGoals(), club.getReceivedGoals(), club.getPlayedMatches());
                list.add(tm);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tblClubDetails.setItems(list);


    }

    public void imgLogo(MouseEvent mouseEvent) {
        rotateAnimation();
    }

    public void btnGenarateOnAction(ActionEvent actionEvent) {
        try {
            List<String> list = new ArrayList<>();
            ResultSet resultSet = CrudUtil.execute("SELECT name FROM footballClub ORDER BY RAND() LIMIT 2");
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
            String name1 = list.get(0);
            String name2 = list.get(1);
            txtClub1.setText(name1);
            txtClub2.setText(name2);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnExitOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void rotateAnimation() {
        RotateTransition transition = new RotateTransition();
        transition.setAxis(Rotate.Y_AXIS);
        transition.setByAngle(360);
        transition.setCycleCount(500);
        transition.setDuration(Duration.seconds(15));
        transition.setAutoReverse(true);
        transition.setNode(imgLogo);
        transition.play();
    }


    public void btnSearchDateOnAction(ActionEvent actionEvent) {
        String s = txtDateSearch.getText().trim();
        Date date = Date.valueOf(s);

        try {
            ObservableList<ClubMatchTM> list = FXCollections.observableArrayList();
            List<Match> clubArr = new ArrayList<>();
            ResultSet rst = CrudUtil.execute("SELECT * FROM matchDetails WHERE date=?", date);
            while (rst.next()) {
                clubArr.add(new Match(
                                rst.getInt(1),
                                rst.getString(2),
                                rst.getString(3),
                                rst.getInt(4),
                                rst.getInt(5),
                                rst.getDate(6)

                        )
                );
            }
            for (Match match : clubArr) {
                ClubMatchTM tm = new ClubMatchTM(match.getClub1(), match.getClub2(), match.getScoreClub1(), match.getScoreClub2());
                list.add(tm);
            }
            tblSearchDate.setItems(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
