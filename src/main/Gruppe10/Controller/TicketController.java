package Gruppe10.Controller;
import Gruppe10.Data.DataHandler;
import Gruppe10.Json.WriteJson;
import Gruppe10.Model.Customer;
import Gruppe10.MainJavaFX;
import Gruppe10.Model.Event;
import Gruppe10.Model.Ticket;
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

        buy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Period period= Period.between(age.getValue(),LocalDate.now());
                System.out.println(period.getYears());

                if(period.getYears()<buyTicketEvent.getAgeRestrict()){

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Too young");
                    alert.setHeaderText("You are not old enough for this event");
                    alert.showAndWait();
                }
                else{
                    String name = txtName.getText();
                    LocalDate date = age.getValue();
                    String email = txtEmail.getText();
                    int phone = Integer.parseInt(txtMobile.getText());
                    String position = txtPosition.getText();
                    Customer newCustomer = new Customer(name, date, email, phone, position);

                    int seatN = (Integer) seat.getValue();
                    int rowN = (Integer) row.getValue();
                    //int standN = (Integer) stand.getValue();

                    Ticket newTicket = new Ticket(buyTicketEvent, newCustomer, seatN, rowN, 0);
                    buyTicketEvent.setSeats(seatN, rowN);

                    ArrayList<Event> arrayList = DataHandler.getEventList();
                    WriteJson.addToJson(arrayList);

                    for (int I = 0; I < buyTicketEvent.getSeat(); I++){
                        System.out.println("");
                        for (int Y = 0; Y < buyTicketEvent.getRow(); Y++){
                            System.out.print(buyTicketEvent.getSeats(I, Y) + " ");
                        }
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

            for (int i=0;i<buyTicketEvent.getStand();i++)
                stand.getItems().addAll(i+1);
        }
    }


}
