package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class vurudModir {

    @FXML
    private TextField userid;

    @FXML
    private PasswordField passid;

    @FXML
    private Button vurud;

    @FXML
    private Button backbtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("safheAsli.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) backbtn.getScene().getWindow();
        stage.close();


    }

    @FXML
    void vurud(ActionEvent event) throws IOException
    {
        if (userid.getText().isBlank()==false&&passid.getText().isBlank()==false)
        {
            if (userid.getText().equals("admin") && passid.getText().equals("admin")) {

                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("modiriyat.fxml"));
                primaryStage.setTitle("Your Bank");
                primaryStage.setScene(new Scene(root, 600, 522));
                primaryStage.show();

                Stage stage = (Stage) vurud.getScene().getWindow();
                stage.close();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Incorrect password or username");
                a.show();
            }
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("THE FIELDS CANNOT BE EMPTY. ");
            a.setHeaderText(null);
            a.show();
        }

    }

}
