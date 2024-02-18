package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class modiriyat {

    @FXML
    private Button vamsbtn;

    @FXML
    private Button back;

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("safheAsli.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();



    }

    @FXML
    void vams(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("darkhast.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Stage stage = (Stage) vamsbtn.getScene().getWindow();
        stage.close();

    }

}
