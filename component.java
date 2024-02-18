package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class component implements Initializable {

    @FXML
    private Label userTXF;

    @FXML
    private Label kartnumbTXF;

    @FXML
    private Label mablaghTXF;
    @FXML
    private Button okbtn;

    @FXML
    void sayok(ActionEvent event) {
        System.out.println("hi");
    }

    public Label getUserTXF() {
        return userTXF;
    }

    public void setUserTXF(Label userTXF) {
        this.userTXF = userTXF;
    }

    public Label getKartnumbTXF() {
        return kartnumbTXF;
    }

    public void setKartnumbTXF(Label kartnumbTXF) {
        this.kartnumbTXF = kartnumbTXF;
    }

    public Label getMablaghTXF() {
        return mablaghTXF;
    }

    public void setMablaghTXF(Label mablaghTXF) {
        this.mablaghTXF = mablaghTXF;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
