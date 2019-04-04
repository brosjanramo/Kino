package Gruppe10.Controller;

import Gruppe10.Data.DataHandler;
import Gruppe10.Model.Event;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TicketController {

    @FXML
    private Button buy;

    @FXML
    private Label event;

    @FXML
    private TextField name;

    @FXML
    private ComboBox seat,row,stand;

    @FXML
    private DatePicker age;

    @FXML
    private ListView<Event> eventListView;


    @FXML
    public void initialize(){

    }

    private void eventDetails(Event newValue) {
        event.setText(newValue.getTitle());
    }


    @FXML
    public void addText() {
        event.setText("Hei");
        name.setText("Hei");


    }
}
