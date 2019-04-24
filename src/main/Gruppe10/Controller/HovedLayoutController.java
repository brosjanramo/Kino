package Gruppe10.Controller;

import Gruppe10.Data.DataHandler;
import Gruppe10.Main;
import Gruppe10.MainJavaFX;
import Gruppe10.Model.Event;
import Gruppe10.Model.Person;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import javax.xml.crypto.Data;
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

    @FXML
    private TextField timeOfEvent;

    private Person person;
    ObservableList<String> sortMethods= FXCollections.observableArrayList(
      "Alfabetical",
              "Date",
            "Price",
            "Capacity"
    );

    ObservableList<Event> listWithEvents= FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        for (int i = 0; i < DataHandler.getEventData().size(); i++){
            if (MainJavaFX.getCurrentPassword() == DataHandler.getEventData().get(i).getManagerId() && MainJavaFX.getCurrentPassword() != 0){
                listWithEvents.add(DataHandler.getEventData().get(i));
            }
        }
        if (MainJavaFX.getCurrentPassword() == 0){
            listWithEvents.addAll(DataHandler.getEventData());
            newEvent.setVisible(false);
            editEvent.setVisible(false);
        }
        eventListView.setItems(listWithEvents);
        sortBy.setItems(sortMethods);

        capacityTextArea.setEditable(false);
        placeTextArea.setEditable(false);
        capacityTextArea.setEditable(false);
        descriptionTextArea.setEditable(false);
        datePicker.setEditable(false);

        sortBy.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                if(newValue=="Alfabetical"){
                    Comparator<Event> comparator= Comparator.comparing(Event::getTitle);
                    FXCollections.sort(listWithEvents, comparator);

                }
                else if(newValue=="Date"){
                    Comparator<Event> comparator= Comparator.comparing(Event::getDate);
                    FXCollections.sort(listWithEvents, comparator);
                }
                else if(newValue=="Price"){
                    Comparator<Event>comparator= Comparator.comparing(Event::getPrice);
                    FXCollections.sort(listWithEvents, comparator.reversed());
                }
                else if(newValue=="Capacity"){
                    Comparator<Event>comparator= Comparator.comparingInt(Event::getCapacity);
                    FXCollections.sort(listWithEvents, comparator.reversed());

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
                MainJavaFX.getInstance().setNewEventLayout();
                System.out.println("Ny event");
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
        timeOfEvent.setText(String.valueOf(event.getTime()));
        placeTextArea.setText(event.getPlace());
        capacityTextArea.setText(String.valueOf(event.getCapacity()));
    }

    public void newEvent(ActionEvent actionEvent) {
        Event newEvent = new Event();

        MainJavaFX.getInstance().setEventLayout(newEvent);
    }


}
