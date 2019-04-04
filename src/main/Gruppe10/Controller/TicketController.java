package Gruppe10.Controller;
import Gruppe10.Data.DataHandler;
import Gruppe10.Model.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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


    @FXML
    public void initialize(){
        eventTitle.setText(DataHandler.getEventData().get(0).getTitle());

        for (int i=0;i<DataHandler.getEventData().get(0).getSeat();i++)
        seat.getItems().addAll(i);

    }


}
