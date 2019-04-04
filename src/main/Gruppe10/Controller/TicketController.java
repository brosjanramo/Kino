package Gruppe10.Controller;
import Gruppe10.Data.DataHandler;
import Gruppe10.Model.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class TicketController {



    @FXML
    private Button buy;

    @FXML
    private Label eventTitle;

    @FXML
    private TextField name;

    @FXML
    private ComboBox seat,row,stand;

    @FXML
    private DatePicker age;


    private Event buyTicketEvent;


    @FXML
    public void initialize(){

        buy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {



                Period period= Period.between(age.getValue(),LocalDate.now());
                System.out.println(period.getYears());

                if(period.getYears()<buyTicketEvent.getAgeRestrict()){

                    System.out.println("You are not old Enough");
                }
                else{

                    

                }

            }
        });



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
