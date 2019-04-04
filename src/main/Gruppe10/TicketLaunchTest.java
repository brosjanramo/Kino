package Gruppe10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicketLaunchTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("View/TicketLayout.fxml"));
        Parent ticketLayout = fxmlLoader.load();

        Scene eventScene = new Scene(ticketLayout, 600, 400);
        primaryStage.setScene(eventScene);
        primaryStage.setTitle("Create Event");
        primaryStage.show();
    }
}
