package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.RandomAccessFile;

public class sabtnam {




    @FXML
    private TextField user;

    @FXML
    private TextField pass;

    @FXML
    private TextField phone;

    @FXML
    private TextField address;

    @FXML
    private Button registerbtn;
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
    void register(ActionEvent event) throws IOException
    {
        try {
            if (user.getText().isBlank()==false&& pass.getText().isBlank()==false&& phone.getText().isBlank()==false&&address.getText().isBlank()==false)
            {

                if(searchUsername(user.getText(),"customer.txt")==true){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("یوزرنیم تکراری. ");
                    a.setHeaderText(null);
                    a.show();

                }
                else if (searchkart(address.getText(),"customer.txt")==true){

                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("شماره کارت تکراری. ");
                    a.setHeaderText(null);
                    a.show();
                }
                else if(searchUsername(user.getText(),"customer.txt")==false) {
                    String contents = user.getText() + "@" + pass.getText() + "@" + address.getText() + "@00@";
                    write(contents, "customer.txt");
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setContentText(" USER HAS BEEN REGISTERED SUCCESSFULLY.");
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

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public void openMoshtari() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("vurudMoshtari.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) registerbtn.getScene().getWindow();
        stage.close();
    }
    public static void write(String contents,String path) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile(path,"rw");
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.writeUTF("@"+contents+"\n");
        randomAccessFile.close();
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
    public static boolean searchUsername(String user,String path) throws IOException {
        String allContents = read(path);
        String[] rows = allContents.split("\n");
        boolean find=false;
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split("@");
            if (columns[1].equals(user)) {
                find = true;
                break;
            }
        }
        return find;
    }
    public static boolean searchkart(String kart,String path) throws IOException {
        String allContents = read(path);
        String[] rows = allContents.split("\n");
        boolean find=false;
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split("@");
            if (columns[3].equals(kart)) {
                find = true;
                break;
            }
        }
        return find;
    }



}
