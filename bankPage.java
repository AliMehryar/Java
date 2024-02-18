package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class bankPage {

    @FXML
    private Button transferbtn;

    @FXML
    private Button afzayeshbtn;

    @FXML
    private Button ramzepuyabtn;

    @FXML
    private Button back;

    @FXML
    private Button bardashhtbtn;

    @FXML
    private Button mojudibtn;

    @FXML
    private Button vambtn;


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
    void afzayesh(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("afzayesh.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) afzayeshbtn.getScene().getWindow();
        stage.close();

    }


    @FXML
    void bardasht(ActionEvent event) throws IOException {

        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("bardasht.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) bardashhtbtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void mojudi(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("mojudi.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) mojudibtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void ramzpuya(ActionEvent event) throws IOException {

        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ramzpuya.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) ramzepuyabtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void transfer(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("kartbekart.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) transferbtn.getScene().getWindow();
        stage.close();


    }

    @FXML
    void vam(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("vam.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) vambtn.getScene().getWindow();
        stage.close();

    }

}
