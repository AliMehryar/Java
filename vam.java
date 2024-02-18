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

public class vam {
    @FXML
    private TextField shomarekart;


    @FXML
    private PasswordField ramzfield;

    @FXML
    private TextField matnevam;


    @FXML
    private TextField mablaghField;

    @FXML
    private Button backbtn;

    @FXML
    private Button tayidbtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("bankPage.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Stage stage = (Stage) backbtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void tayid(ActionEvent event) throws IOException {
        if (shomarekart.getText().isBlank()==false&&ramzfield.getText().isBlank()==false&&mablaghField.getText().isBlank()==false&&matnevam.getText().isBlank()==false){

            if(searchRamz(shomarekart.getText(),"customer.txt").equals(ramzfield.getText())){

                String contents=shomarekart.getText()+"@"+matnevam.getText()+"@"+mablaghField.getText()+"@";
                write(contents,"vams.txt");
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText(" درخواست وام با موفقیت ثبت شد.");
                a.show();


            }
            else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("رمز عبور یا شماره کارت نادرست میباشد.");
                a.setHeaderText(null);
                a.show();
            }

        }

        else{

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(" THE  FIELDS CANNOT BE empty. ");
            a.setHeaderText(null);
            a.show();

        }

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
    public static void write(String contents,String path) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile(path,"rw");
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.writeUTF("@"+contents+"\n");
        randomAccessFile.close();
    }

}
