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

import java.io.*;
import java.util.Scanner;

public class vurudMoshtari {

    public static String Ramz;



    @FXML
    private TextField userid;

    @FXML
    private PasswordField passid;

    @FXML
    private Button vurud;

    @FXML
    private Button sabtenam;
    @FXML
    private Button backbtn;

    @FXML
    void sabtenam(ActionEvent event) throws IOException {

        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sabtnam.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) sabtenam.getScene().getWindow();
        stage.close();


    }

    @FXML
    void vurud(ActionEvent event) throws IOException {



        if (userid.getText().isBlank()==false&&passid.getText().isBlank()==false)
        {
            boolean flag=false;
            String id=searchID(userid.getText(),"customer.txt");
            if (id.equals(passid.getText())) {
                Ramz=passid.getText();
                flag=true;
            }
            if (flag==true)
            {
                openbankPage();
                Stage stage = (Stage) vurud.getScene().getWindow();
                stage.close();

            }
            else
                { Alert a=new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Incorrect password or username");
                    a.show();
                }

        }
        else
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("THE FIELDS CANNOT BE EMPTY. ");
            a.setHeaderText(null);
            a.show();
        }

    }

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


    public void openbankPage() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("bankPage.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

    }
    public static String read(String path) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile(path,"rw");
        randomAccessFile.seek(0);
        StringBuffer stringBuffer=new StringBuffer();
        while (randomAccessFile.getFilePointer()<randomAccessFile.length())

            stringBuffer.append(randomAccessFile.readLine()).append(System.lineSeparator());

        String contents=stringBuffer.toString();
        return contents;
    }
    public static String searchName(int id,String path) throws IOException {
        String allContents=read(path);
        String[] rows=allContents.split("\n");
        String name="";
        for (int i=0;i< rows.length;i++)
        {
            String[] columns=rows[i].split("@");
            if (columns[2].equals(String.valueOf(id)))
                name=columns[1];

        }
        return name;

    }

    public static String searchID(String name,String path) throws IOException {

        String allContents=read(path);
        String[] rows=allContents.split("\n");
        String id="";
        for (int i=0;i< rows.length;i++)
        {
            String[] columns=rows[i].split("@");
            if (columns[1].equals(name))
                id=columns[2];

        }
        return id;
    }

}
