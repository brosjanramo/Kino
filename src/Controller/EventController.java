package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EventController {
    @FXML
    private TextField txtField;
    @FXML
    private TextField txtPrice;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Slider agePicker;
    @FXML
    private Slider capacityPicker;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtCapacity;


    @FXML
    public void initialize() {
        agePicker.valueProperty().addListener(((observable, oldValue, newValue) -> {
            txtAge.setText(Integer.toString(newValue.intValue()));
        }));
    }


    public void btnAddEvent(MouseEvent mouseEvent) {
        System.out.println("Hei");
    }
}
