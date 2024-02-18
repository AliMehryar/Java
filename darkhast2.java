package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class darkhast2 implements Initializable{
    public AnchorPane getAnchor() {
        return anchor;
    }

    public void setAnchor(AnchorPane anchor) {
        this.anchor = anchor;
    }

    @FXML
    private AnchorPane anchor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showUsers();
    }
    private void showUsers(){
        for (int i=0;i<20;i++){
            FXMLLoader loader=new FXMLLoader(this.getClass().getResource("component.fxml"));
            try {
                Parent root=loader.load();
                component control=loader.getController();

                control.getMablaghTXF().setText("1000");
                control.getKartnumbTXF().setText("178");
                control.getUserTXF().setText("41214");

                AnchorPane.setTopAnchor(root,50.0+i*130.0);
                AnchorPane.setLeftAnchor(root,25.0);
                anchor.getChildren().add(root);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
