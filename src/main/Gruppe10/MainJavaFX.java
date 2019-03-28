package Gruppe10;

import Gruppe10.Controller.HovedLayoutController;
import Gruppe10.Model.NumEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainJavaFX extends Application{
    private static MainJavaFX mainJavaFX;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {

        mainJavaFX = this;

            try{
                this.primaryStage = primaryStage;

                primaryStage.setTitle("Login");

                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("View/Login.fxml"));

                Parent loginLayout = fxmlLoader.load();

                Scene loginScene = new Scene(loginLayout, 500, 300);

                primaryStage.setScene(loginScene);

                primaryStage.show();
            }
            catch(IOException e){
                e.printStackTrace();
            }
    }

   public void setHovedLayout() {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader();

            fxmlLoader.setLocation(getClass().getResource("View/HovedLayout.fxml"));

            Parent hovedLayout = fxmlLoader.load();

            Stage hovedStage = new Stage();

            hovedStage.initOwner(primaryStage);

            Scene hovedScene = new Scene(hovedLayout);

            hovedStage.setScene(hovedScene);

            HovedLayoutController hovedController = fxmlLoader.getController();

            hovedStage.show();
        }
        catch(IOException e){
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


}
