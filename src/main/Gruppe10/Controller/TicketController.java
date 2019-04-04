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

        for (int i=0;i<DataHandler.getEventData().get(0).getSeat();i++)
        seat.getItems().addAll(i);

        for (int i=0;i<DataHandler.getEventData().get(0).getRow();i++)
            row.getItems().addAll(i);

        for (int i=0;i<DataHandler.getEventData().get(0).getStand();i++)
            stand.getItems().addAll(i);

    }

    public void setEventToBeEdited(Event buyTicketEvent) {
        this.buyTicketEvent = buyTicketEvent;

        if (buyTicketEvent != null) {
            eventTitle.setText(buyTicketEvent.getTitle());

        }
    }
}
