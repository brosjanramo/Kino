package Gruppe10.Controller;

import Gruppe10.Json.WriteJson;
import Gruppe10.Model.Event;
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
    private TextField txtAge;
    @FXML
    private TextField txtSeat;
    @FXML
    private TextField txtStand;
    @FXML
    private TextField txtRow;
    @FXML
    private TextField txtLocation;


    @FXML
    public void initialize() {
        agePicker.valueProperty().addListener(((observable, oldValue, newValue) -> {
            txtAge.setText(Integer.toString(newValue.intValue()));
        }));

    }


    public void btnAddEvent(MouseEvent mouseEvent) {
        String title = txtTitle.getText();
        int price = Integer.parseInt(txtPrice.getText());
        LocalDate date = datePicker.getValue();
        int agerestrict = (int) Math.round(agePicker.getValue());
        int seat = Integer.parseInt(txtSeat.getText());
        int stand = Integer.parseInt(txtStand.getText());
        int row = Integer.parseInt(txtRow.getText());
        String place = txtLocation.getText();
        //String title, LocalDate date, int agerestrict, String place, int capacity, int price
        Event test = new Event(title, date, agerestrict, place, price, seat, row, stand,"beskrivelse");

        WriteJson.addToJson(test);
        System.out.println(test.toString());
    }
}
