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

public class kartbekart {

    @FXML
    private TextField mabda;

    @FXML
    private TextField magsad;

    @FXML
    private PasswordField ramzfield;

    @FXML
    private TextField mablagh;

    @FXML
    private Button tayidbtn;

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
    void tayid(ActionEvent event) throws IOException {
        if (mabda.getText().isBlank()==false&&magsad.getText().isBlank()==false&&mablagh.getText().isBlank()==false&&ramzfield.getText().isBlank()==false) {
            int Mablagh = 0;
            int Mojudi = 0;

            String mabdaNumber = mabda.getText();
            String magsadNumber = magsad.getText();

            try {
                Mablagh = Integer.parseInt(mablagh.getText());
            } catch (Exception e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("مبلغ انتقالی باید به صورت عدد صحیح باشد.");
                a.setHeaderText(null);
                a.show();
            }

            if (searchRamz(mabda.getText(),"customer.txt").equals(ramzfield.getText())) {

                String mojudi = searchMojudi(mabdaNumber, "customer.txt");
                Mojudi = Integer.parseInt(mojudi);

                if (Mablagh <= Mojudi) {
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setContentText(" کارت به کارت با موفقیت انجام شد.");
                    a.show();

                    String nahayi=Integer.toString(Mojudi-Mablagh);
                    String user=searchUser(mabdaNumber,"customer.txt");
                    String contents=user+"@"+ramzfield.getText()+"@"+mabdaNumber+"@"+nahayi+"@";
                    write(contents,"customer.txt");



                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("موجودی کافی نیست.");
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
        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(" THE  FIELDS CANNOT BE 0. ");
            a.setHeaderText(null);
            a.show();
        }



    }

    public static String searchmabda(String id,String path) throws IOException {
        String allContents=read(path);
        String[] rows=allContents.split("\n");
        String mabda="";
        for (int i=0;i< rows.length;i++)
        {
            String[] columns=rows[i].split("@");
            if (columns[2].equals(id))
                mabda=columns[3];

        }
        return mabda;

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
    public static void write(String contents,String path) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile(path,"rw");
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.writeUTF("@"+contents+"\n");
        randomAccessFile.close();
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
