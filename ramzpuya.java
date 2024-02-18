package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ramzpuya {
    public void initialize(){
        ramzepuyafield.setEditable(false);
    }

    @FXML
    private TextField ramzepuyafield;

    @FXML
    private Button ramzbtn;

    @FXML
    private Button backbtn;

    @FXML
    void back(ActionEvent event) throws IOException {

        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("bankPage.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) backbtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void ramz(ActionEvent event) {
        ramzepuyafield.setEditable(false);
        String a="";
        for (int i=1;i<=10;i++)
            a+=(int)(Math.random() *(9) +1);
        ramzepuyafield.setText(a);

    }


}
