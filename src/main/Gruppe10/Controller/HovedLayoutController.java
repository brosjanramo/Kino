package Gruppe10.Controller;

import Gruppe10.Data.DataHandler;
import Gruppe10.Model.Event;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class HovedLayoutController {

    @FXML
    private ListView<Event> eventListView;

    @FXML
    private Button btn;

    @FXML
    private Text titleLabel;

    /*@FXML
    private TextArea descriptionTextArea;*/

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea placeTextArea;

    @FXML
    private TextArea capacityTextArea;

    @FXML
    public void initialize() {
        eventListView.setItems(DataHandler.getEventData());

        eventListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Event>() {
            @Override
            public void changed(ObservableValue<? extends Event> observable, Event oldValue, Event newValue) {
                eventDetails(newValue);
            }
        });
    }

    private void eventDetails(Event event) {
        titleLabel.setText(event.getTitle());
        //descriptionTextArea.setText();
        datePicker.setValue(event.getDate());
        placeTextArea.setText(event.getPlace());
        capacityTextArea.setText(String.valueOf(event.getCapacity()));
    }

}
