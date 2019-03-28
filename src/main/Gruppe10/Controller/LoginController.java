package Gruppe10.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

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
        /*loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainJavaFX.getInstance().setHovedLayout();
            }
        });*/

    }

    public void guestButtonClicked(javafx.event.ActionEvent actionEvent) {

    }
}
