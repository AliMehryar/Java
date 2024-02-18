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

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class bardasht {

    @FXML
    private TextField bardashtfield;

    @FXML
    private Button tayidbtn;

    @FXML
    private Button backbtn;

    @FXML
    private TextField shomarefield;

    @FXML
    private PasswordField passfield;

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
        if (shomarefield.getText().isBlank()==false&&passfield.getText().isBlank()==false) {
            int kasri = 0;
            String shomare = shomarefield.getText();
            String ramz = searchRamz(shomare, "customer.txt");
            if (ramz.equals(passfield.getText())) {
                try {
                    kasri = Integer.parseInt(bardashtfield.getText());
                } catch (NumberFormatException e) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("مبلغ برداشتی نمیتواند اعشاری باشد.");
                    a.setHeaderText(null);
                    a.show();
                }

                int Mojudi = Integer.parseInt(searchMojudi(shomare, "customer.txt"));

                if (Mojudi >= kasri) {
                    String nahayi = Integer.toString(Mojudi - kasri);
                    String user = searchUser(shomare, "customer.txt");
                    String contents = user + "@" + passfield.getText() + "@" + shomare + "@" + nahayi + "@";
                    write(contents, "customer.txt");

                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setContentText("ok");
                    a.show();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("no mojudi");
                    a.setHeaderText(null);
                    a.show();
                }


            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("رمز عبور یا شماره کارت نادرست میباشد.");
                a.setHeaderText(null);
                a.show();
            }
        }
        else
        {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(" THE  FIELDS CANNOT BE empty. ");
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
    public static String searchMojudi(String mabdaNumber,String path) throws IOException {
        String allContents = read(path);
        String[] rows = allContents.split("\n");
        String mojudi = "";
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split("@");
            if (columns[3].equals(mabdaNumber))
                mojudi = columns[4];

        }
        return mojudi;
    }
    public static void write(String contents,String path) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile(path,"rw");
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.writeUTF("@"+contents+"\n");
        randomAccessFile.close();
    }
    public static String searchUser(String mabda,String path) throws IOException {
        String allContents=read(path);
        String[] rows=allContents.split("\n");
        String user="";
        for (int i=0;i< rows.length;i++)
        {
            String[] columns=rows[i].split("@");
            if (columns[3].equals(mabda))
                user=columns[1];

        }
        return user;

    }
    public static String searchRamz(String mabda,String path) throws IOException {
        String allContents=read(path);
        String[] rows=allContents.split("\n");
        String ramz="";
        for (int i=0;i< rows.length;i++)
        {
            String[] columns=rows[i].split("@");
            if (columns[3].equals(mabda))
                ramz=columns[2];

        }
        return ramz;

    }
}





