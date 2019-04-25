package Gruppe10.Model;

import javafx.scene.control.Alert;

public class AlertBox {
    public AlertBox(String title, String header, String context, int alertType) {

        Alert alert;
        if (alertType == 1)
            alert = new Alert(Alert.AlertType.ERROR);
        else if (alertType == 2)
            alert = new Alert(Alert.AlertType.INFORMATION);
        else
            alert = new Alert(Alert.AlertType.NONE);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }
}
