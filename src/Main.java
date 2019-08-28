import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) {


        try {
           Parent root = FXMLLoader.load(getClass().getResource("/Student/AddStudent.fxml"));
            Scene scene = new Scene(root,1280,720);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public static void main(String[] args) {
        launch(args);
    }

}
