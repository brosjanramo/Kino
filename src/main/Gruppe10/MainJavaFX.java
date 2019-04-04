package Gruppe10;

import Gruppe10.Controller.EventController;
import Gruppe10.Controller.HovedLayoutController;
import Gruppe10.Model.Manager;
import Gruppe10.Model.NumEvent;
import Gruppe10.Model.Person;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainJavaFX extends Application{
    private static MainJavaFX mainJavaFX;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {

        mainJavaFX = this;
        System.out.println(managerList().get(0).getId());

        try{
            this.primaryStage = primaryStage;

            FXMLLoader fxmlLoader = new FXMLLoader();

            fxmlLoader.setLocation(getClass().getResource("View/Login.fxml"));

            Parent hovedLayout = fxmlLoader.load();

            Scene hovedScene = new Scene(hovedLayout);

            primaryStage.setScene(hovedScene);

            primaryStage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

   public void setHovedLayout() {
        try{
            this.primaryStage = primaryStage;

            FXMLLoader fxmlLoader = new FXMLLoader();

            fxmlLoader.setLocation(getClass().getResource("View/HovedLayout.fxml"));

            Parent hovedLayout = fxmlLoader.load();

            Scene hovedScene = new Scene(hovedLayout);

            primaryStage.setScene(hovedScene);

            HovedLayoutController hovedController = fxmlLoader.getController();

           /* primaryStage.show();*/
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setEventLayout(Event eventToBeEdited) {
        try {
            this.primaryStage = primaryStage;
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("View/EventLayout.fxml"));
            Parent ticketLayout = fxmlLoader.load();

            Scene eventScene = new Scene(ticketLayout, 400, 400);
            primaryStage.setScene(eventScene);
            primaryStage.setTitle("Create Event");

            EventController eventController = fxmlLoader.getController();

            eventController.setEventToBeEdited(eventToBeEdited);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void MakeTickets(NumEvent numTickets){

        try{

            FXMLLoader fxmlLoader= new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Gruppe10/View/TicketCreator.fxml"));

            Parent ticketLayout = fxmlLoader.load();
            Scene ticketScene= new Scene(ticketLayout, 500,500);

            primaryStage.setScene(ticketScene);
            primaryStage.setTitle("Make Tickets");
            primaryStage.show();

        }
        catch(IOException e) {
            e.printStackTrace();
        }


    }

    public static Gruppe10.MainJavaFX getInstance(){
        return mainJavaFX;
    }

    public static ArrayList<Manager> managerList(){
        Manager manager1 = new Manager("title", "John Johnsen", 123456, LocalDate.of(1996, 12, 20), "john@hotmail.com", 21436587);
        Manager manager2 = new Manager("title", "Tom Tom", 654321, LocalDate.of(1996, 12, 20), "tom@hotmail.com", 21436587);
        ArrayList<Manager> managerArrayList = new ArrayList<>();
        managerArrayList.add(manager1);
        managerArrayList.add(manager2);
        return managerArrayList;
    }
}
