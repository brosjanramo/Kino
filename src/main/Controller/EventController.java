package Controller;

import Model.Event;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;

public class EventController {
    @FXML
    private TextField txtTitle;
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
    private TextField txtLocation;


    @FXML
    public void initialize() {
        agePicker.valueProperty().addListener(((observable, oldValue, newValue) -> {
            txtAge.setText(Integer.toString(newValue.intValue()));
        }));
        capacityPicker.valueProperty().addListener(((observable, oldValue, newValue) -> {
            txtCapacity.setText(Integer.toString(newValue.intValue()));
        }));
    }


    public void btnAddEvent(MouseEvent mouseEvent) {
        String title = txtTitle.getText();
        int price = Integer.parseInt(txtPrice.getText());
        LocalDate date = datePicker.getValue();
        int agerestrict = (int) Math.round(agePicker.getValue());
        String place = txtLocation.getText();
        int capacity = (int) Math.round(capacityPicker.getValue());
        //String title, LocalDate date, int agerestrict, String place, int capacity, int price
        Event test = new Event(title, date, agerestrict, place, capacity, price);

        System.out.println(test.toString());
    }
}
