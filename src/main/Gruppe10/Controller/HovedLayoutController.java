package Gruppe10.Controller;

import Gruppe10.Data.DataHandler;
import Gruppe10.MainJavaFX;
import Gruppe10.Model.Event;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Comparator;

public class HovedLayoutController {

    @FXML
    private ListView<Event> eventListView;

    @FXML
    private Button buyTicketBtn;

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
    private ComboBox sortBy;

    ObservableList<String> sortMethods= FXCollections.observableArrayList(
      "Alfabetical",
              "Date"
    );

    ObservableList<Event> listWithEvents= FXCollections.observableArrayList();

    @FXML
    public void initialize() {



        listWithEvents.addAll(DataHandler.getEventData());
        eventListView.setItems(listWithEvents);
        System.out.println(listWithEvents);

        sortBy.setItems(sortMethods);

        sortBy.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                if(newValue=="Alfabetical"){
                    

                }
                else if(newValue=="Date"){
                    System.out.println("D");
                }


            }
        });


        eventListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Event>() {
            @Override
            public void changed(ObservableValue<? extends Event> observable, Event oldValue, Event newValue) {
                if (newValue != null) {
                    eventDetails(newValue);
                }
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

        buyTicketBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Event buyTicket = eventListView.getSelectionModel().getSelectedItem();

                if (buyTicket != null) {
                    MainJavaFX.getInstance().setTicketLayout(buyTicket);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("No chosen event");
                    alert.setHeaderText("Please select an event");
                    alert.showAndWait();
                }
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

    public void newEvent(ActionEvent actionEvent) {
        Event newEvent = new Event();

        MainJavaFX.getInstance().setEventLayout(newEvent);
    }


}
