package Gruppe10.Controller;

import Gruppe10.Data.DataHandler;
import Gruppe10.Json.ReadJson;
import Gruppe10.Json.WriteJson;
import Gruppe10.Main;
import Gruppe10.MainJavaFX;
import Gruppe10.Model.Event;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

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


    private Event eventToBeEdited;
    private Boolean editNewEvent;

    @FXML
    public void initialize() {
        agePicker.valueProperty().addListener(((observable, oldValue, newValue) -> {
            txtAge.setText(Integer.toString(newValue.intValue()));
        }));

    }


    public void btnAddEvent(MouseEvent mouseEvent) {
        int managerID = MainJavaFX.getCurrentPassword();
        String title = txtTitle.getText();
        int price = Integer.parseInt(txtPrice.getText());
        LocalDate date = datePicker.getValue();
        int agerestrict = (int) Math.round(agePicker.getValue());
        int seat = Integer.parseInt(txtSeat.getText());
        int stand = Integer.parseInt(txtStand.getText());
        int row = Integer.parseInt(txtRow.getText());
        String place = txtLocation.getText();
        //String title, LocalDate date, int agerestrict, String place, int capacity, int price
        ArrayList<Event> arrayList = DataHandler.getEventList();

        if (!editNewEvent){
            Event newEvent = new Event(title, date, managerID, agerestrict, place, price, seat, row, stand,"beskrivelse");
            arrayList.add(newEvent);
            WriteJson.addToJson(arrayList);
        } else {
            eventToBeEdited.setTitle(title);
            eventToBeEdited.setDate(date);
            eventToBeEdited.setAgeRestrict(agerestrict);
            eventToBeEdited.setSeat(seat);
            eventToBeEdited.setStand(stand);
            eventToBeEdited.setRow(row);
            eventToBeEdited.setPlace(place);
            WriteJson.addToJson(arrayList);
            for (Event event : arrayList
                 ) {
                System.out.println(event);
            }

        }

        MainJavaFX.getInstance().setHovedLayout();
    }

    public void setEventToBeEdited(Event eventToBeEdited) {

        this.eventToBeEdited = eventToBeEdited;
        this.editNewEvent = true;

        if (eventToBeEdited != null) {
            txtTitle.setText(eventToBeEdited.getTitle());
            txtAge.setText(String.valueOf(eventToBeEdited.getAgeRestrict()));
            agePicker.setValue(eventToBeEdited.getAgeRestrict());
            txtLocation.setText(eventToBeEdited.getPlace());
            txtPrice.setText(String.valueOf(eventToBeEdited.getPrice()));
            datePicker.setValue(eventToBeEdited.getDate());
            txtSeat.setText(String.valueOf(eventToBeEdited.getSeat()));
            txtRow.setText(String.valueOf(eventToBeEdited.getRow()));
            txtStand.setText(String.valueOf(eventToBeEdited.getStand()));
        }
    }
}
