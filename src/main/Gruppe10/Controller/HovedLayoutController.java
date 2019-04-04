package Gruppe10.Controller;

import Gruppe10.Data.DataHandler;
import Gruppe10.MainJavaFX;
import Gruppe10.Model.Event;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class HovedLayoutController {

    @FXML
    private ListView<Event> eventListView;

    @FXML
    private Button btn;

    @FXML
    private Button newEvent;

    @FXML
    private Button editEvent;

    @FXML
    private Text titleLabel;

    @FXML
    private TextArea descriptionTextArea;

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

        editEvent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Event editEvent = eventListView.getSelectionModel().getSelectedItem();

                // Sjekker om eventet inneholder info
                if (editEvent != null) {
                    MainJavaFX.getInstance().setEventLayout(editEvent);


                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("No chosen event");
                    alert.setHeaderText("Please select an event");
                    alert.showAndWait();
                }
            }
        });

        newEvent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newEvent(event);
            }
        });
    }

    private void eventDetails(Event event) {
        titleLabel.setText(event.getTitle());
        descriptionTextArea.setText(event.getDescription());
        datePicker.setValue(event.getDate());
        placeTextArea.setText(event.getPlace());
        capacityTextArea.setText(String.valueOf(event.getCapacity()));
    }

    private void newEvent(ActionEvent actionEvent) {
        Event newEvent = new Event();

        MainJavaFX.getInstance().setEventLayout(newEvent);

    }

    private void emptyEvent() {
        titleLabel.setText("");
        descriptionTextArea.setText("");
        datePicker.setValue(LocalDate.parse(""));
        placeTextArea.setText("");
        capacityTextArea.setText("");
    }
}
