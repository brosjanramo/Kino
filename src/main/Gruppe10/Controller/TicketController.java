package Gruppe10.Controller;
import Gruppe10.Data.DataHandler;
import Gruppe10.Model.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
