package Controller;

import Data.DataHandler;
import Model.Event;
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
