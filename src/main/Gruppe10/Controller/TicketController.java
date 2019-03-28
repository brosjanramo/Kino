package Gruppe10.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TicketController {

    @FXML
    private Button addBtn;

    @FXML
    public void initilize(){
        addBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("hei");
            }
        });


    }







}
