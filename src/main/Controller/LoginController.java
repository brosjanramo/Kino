package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {
    @FXML
    public Button loginButton;
    @FXML
    public Button guestButton;
    @FXML
    public PasswordField idField;
    @FXML
    public AnchorPane rootPane;

    @FXML
    public void initialize() {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    AnchorPane pane = null;
                    pane = FXMLLoader.load(getClass().getResource("View/HovedLayout.fxml"));
                    rootPane.getChildren().setAll(pane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void guestButtonClicked(javafx.event.ActionEvent actionEvent) {

    }
}
