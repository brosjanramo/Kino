package Gruppe10.Controller;
import Gruppe10.Data.DataHandler;
import Gruppe10.Json.WriteJson;
import Gruppe10.Model.AlertBox;
import Gruppe10.Model.Customer;
import Gruppe10.MainJavaFX;
import Gruppe10.Model.Event;
import Gruppe10.Model.Ticket;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

public class TicketController {



    @FXML
    private Button buy;
    @FXML
    private Label eventTitle;
    @FXML
    private ComboBox seat,row,stand;
    @FXML
    private DatePicker age;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtPosition;



    private Event buyTicketEvent;


    @FXML
    public void initialize(){

        age.setEditable(false);

        buy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Period period= Period.between(age.getValue(),LocalDate.now());

                if(period.getYears() < buyTicketEvent.getAgeRestrict()){
                    new AlertBox("Too young", "You are not old enough for this event", "", 2);
                }
                else{
                    String name = txtName.getText();
                    LocalDate date = age.getValue();
                    String email = txtEmail.getText();
                    int phone = Integer.parseInt(txtMobile.getText());
                    String position = txtPosition.getText();
                    Customer newCustomer = new Customer(name, date, email, phone, position);

                    int seatN = (Integer) seat.getValue() - 1;
                    int rowN = (Integer) row.getValue() - 1;
                    //int standN = (Integer) stand.getValue();

                    if (buyTicketEvent.getSeats(seatN, rowN) == 0) {
                        new Ticket(buyTicketEvent, newCustomer, seatN, rowN, 0);

                        new AlertBox("Confirmation", "A mail has been sent to " + txtEmail.getText(),"",2);
                        MainJavaFX.getInstance().setHovedLayout();

                        ArrayList<Event> arrayList = DataHandler.getEventList();
                        WriteJson.addToJson(arrayList);

                        buyTicketEvent.printSeats();
                    } else {
                        new AlertBox("Error", "Your seat has been taken, please choose another one","", 2);
                    }



                }

            }
        });

    }

    public void btnCancelTicket() {
        MainJavaFX.getInstance().setHovedLayout();
    }

    public void setEventToBeEdited(Event buyTicketEvent) {
        this.buyTicketEvent = buyTicketEvent;

        if (buyTicketEvent != null) {
            eventTitle.setText(buyTicketEvent.getTitle());

            for (int i=0;i<buyTicketEvent.getSeat();i++)
                seat.getItems().addAll(i+1);

            for (int i=0;i<buyTicketEvent.getRow();i++)
                row.getItems().addAll(i+1);

            for (int i=0;i<buyTicketEvent.getStand();i++) {
                stand.getItems().addAll(i+1);
            }

        }

        row.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == null) {
                seat.getItems().clear();
                seat.setDisable(true);
            } else {
                seat.getItems().setAll(buyTicketEvent.getRowList((Integer) newValue - 1));
                seat.setDisable(false);
            }
        });
    }




}
