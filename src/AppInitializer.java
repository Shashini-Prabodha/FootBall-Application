import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.premierleague.pos.PremierLeagueManager;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class AppInitializer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

//        URL resource = this.getClass().getResource("lk/premierleague/pos/ClubDetailFormView.fxml");
//        Parent root = FXMLLoader.load(resource);
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
//        primaryStage.centerOnScreen();
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        primaryStage.show();
//        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("lk/premierleague/pos/view/ClubDetailFormView.fxml"))));
//         primaryStage.show();
         PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
//
    }

    public static void main(String[] args) {
        launch(args);
    }
}
