package Gruppe10.Controller;

import Gruppe10.Data.DataHandler;
import Gruppe10.Model.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.awt.*;

public class HovedLayoutController {

    @FXML
    private ListView<Event> eventListView;

    @FXML
    private Button btn;

    @FXML
    public void initialize() {
        eventListView.setItems(DataHandler.getEventData());
    }

}
