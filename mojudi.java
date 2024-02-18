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
import java.io.RandomAccessFile;

public class mojudi {

    public void initialize(){
        mojudifield.setEditable(false);
    }


    @FXML
    private TextField mojudifield;

    @FXML
    private PasswordField ramzField;

    @FXML
    private Button tayidbtn;

    @FXML
    private Button backbtn;

    @FXML
    private TextField userField;



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
    void tayid(ActionEvent event) throws IOException {

        if (searchramz(userField.getText(),"customer.txt").equals(ramzField.getText()))
          {
              String mojudi = searchMojudi(userField.getText(), "customer.txt");
              mojudifield.setText(mojudi);
              mojudifield.setEditable(false);
          }

        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("رمز عبور نادرست می باشد. ");
            a.setHeaderText(null);
            a.show();
          }

    }
    public static String read(String path) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile(path,"rw");
        randomAccessFile.seek(0);
        StringBuffer stringBuffer=new StringBuffer();
        while (randomAccessFile.getFilePointer()<randomAccessFile.length())
        {
            stringBuffer.append(randomAccessFile.readLine()).append(System.lineSeparator());

        }
        String contents=stringBuffer.toString();
        return contents;
    }
    public static String searchMojudi(String user,String path) throws IOException {
        String allContents = read(path);
        String[] rows = allContents.split("\n");
        String mojudi = "";
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split("@");
            if (columns[1].equals(user))
                mojudi = columns[4];

        }
        return mojudi;
    }
    public static String searchramz(String user,String path) throws IOException {
        String allContents = read(path);
        String[] rows = allContents.split("\n");
        String ramz = "";
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split("@");
            if (columns[1].equals(user))
                ramz = columns[2];

        }
        return ramz;
    }
}
