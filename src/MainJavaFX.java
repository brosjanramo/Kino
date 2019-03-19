import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainJavaFX extends Application{
    private static MainJavaFX kinoApplication;
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

                Scene loginScene = new Scene(loginLayout, 1000, 500);

                primaryStage.setScene(loginScene);
            }
            catch(IOException e){
                e.printStackTrace();
            }
    }
}
