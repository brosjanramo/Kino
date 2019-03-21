import Model.NumEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainJavaFX extends Application{
    public static MainJavaFX kinoApplication;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        kinoApplication = this;

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

    public void MakeTickets(NumEvent numTickets){

        try{

            FXMLLoader fxmlLoader= new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("View/TicketCreator.fxml"));

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



}
