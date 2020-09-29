package monakhov.maxim.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TabPane pane = null;


        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/SelectAndRunPane.fxml"));
            pane = loader.load();

            System.out.println(javafx.scene.text.Font.getFamilies());

            TitledPane titledPane = new TitledPane();

//            pane.getStylesheets().add(getClass().getResource("/view/styles.css").toExternalForm());

        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(pane));

        primaryStage.show();
    }
}
