package Gruppe10.Controller;

import Gruppe10.Data.DataHandler;
import Gruppe10.Main;
import Gruppe10.MainJavaFX;
import Gruppe10.Model.Person;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController {
    @FXML
    public Button loginButton;
    @FXML
    public Button guestButton;
    @FXML
    public PasswordField idField;
    @FXML
    public AnchorPane rootPane;


    public void initialize() {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < MainJavaFX.managerList().size(); i++){
                    if (Integer.toString(MainJavaFX.managerList().get(i).getId()).equals(idField.getText())){
                        MainJavaFX.managerList().get(i).getId();
                        MainJavaFX.setCurrentPassword(MainJavaFX.managerList().get(i).getId());
                        MainJavaFX.getInstance().setHovedLayout();
                    }
                    System.out.println(idField.getText());
                }
        }

        });

        guestButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainJavaFX.getInstance().setHovedLayout();
            }
        });
    }

    public void guestButtonClicked(javafx.event.ActionEvent actionEvent) {

    }
}
