package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.RandomAccessFile;

public class darkhast {

    public static String shomare[]=new String[12];
    public static String megdar[]=new String[12];
    public static String Username[]=new String[12];
    static int index=0;

    public void initialize() throws IOException {
        setData("vams.txt");
        acc1.setVisible(false);acc2.setVisible(false);acc3.setVisible(false);acc4.setVisible(false);
        acc5.setVisible(false);acc6.setVisible(false);acc7.setVisible(false);acc8.setVisible(false);
        acc9.setVisible(false);acc10.setVisible(false);acc11.setVisible(false);acc12.setVisible(false);

        rej1.setVisible(false);rej2.setVisible(false);rej3.setVisible(false);rej4.setVisible(false);
        rej5.setVisible(false);rej6.setVisible(false);rej7.setVisible(false);rej8.setVisible(false);
        rej9.setVisible(false);rej10.setVisible(false);rej11.setVisible(false);rej12.setVisible(false);





        kart1.setText(shomare[0]);kart2.setText(shomare[1]);kart3.setText(shomare[2]);kart4.setText(shomare[3]);
        kart5.setText(shomare[4]);kart6.setText(shomare[5]);kart7.setText(shomare[6]);kart8.setText(shomare[7]);
        kart9.setText(shomare[8]);kart10.setText(shomare[9]);kart11.setText(shomare[10]);kart12.setText(shomare[11]);

        id1.setText(Username[0]);id2.setText(Username[1]);id3.setText(Username[2]);id4.setText(Username[3]);
        id5.setText(Username[4]);id6.setText(Username[5]);id7.setText(Username[6]);id8.setText(Username[7]);
        id9.setText(Username[8]);id10.setText(Username[9]);id11.setText(Username[10]);id12.setText(Username[11]);

        mablagh1.setText(megdar[0]);mablagh2.setText(megdar[1]);mablagh3.setText(megdar[2]);mablagh4.setText(megdar[3]);
        mablagh5.setText(megdar[4]);mablagh6.setText(megdar[5]);mablagh7.setText(megdar[6]);mablagh8.setText(megdar[7]);
        mablagh9.setText(megdar[8]);mablagh10.setText(megdar[9]);mablagh11.setText(megdar[10]);mablagh12.setText(megdar[11]);

        if (id1.getText().isBlank()==false){
            acc1.setVisible(true);
            rej1.setVisible(true);
        }

        if (id2.getText().isBlank()==false){
            acc2.setVisible(true);
            rej2.setVisible(true);
        }
        if (id3.getText().isBlank()==false) {
            acc3.setVisible(true);
            rej3.setVisible(true);
        }
        if (id4.getText().isBlank()==false) {
            acc4.setVisible(true);rej4.setVisible(true);
        }
        if (id5.getText().isBlank()==false) {
            acc5.setVisible(true);rej5.setVisible(true);
        }
        if (id6.getText().isBlank()==false) {
            acc6.setVisible(true);rej6.setVisible(true);
        }
        if (id7.getText().isBlank()==false) {
            acc7.setVisible(true);rej7.setVisible(true);
        }
        if (id8.getText().isBlank()==false) {
            acc8.setVisible(true);rej8.setVisible(true);
        }
        if (id9.getText().isBlank()==false) {
            acc9.setVisible(true);rej9.setVisible(true);
        }
        if (id10.getText().isBlank()==false) {
            acc10.setVisible(true);rej10.setVisible(true);
        }
        if (id11.getText().isBlank()==false) {
            acc11.setVisible(true);rej11.setVisible(true);
        }
        if (id12.getText().isBlank()==false) {
            acc12.setVisible(true);rej12.setVisible(true);
        }



    }

    @FXML
    private Text id1;

    @FXML
    private Text id10;

    @FXML
    private Text id3;

    @FXML
    private Text id4;

    @FXML
    private Text id5;

    @FXML
    private Text id6;

    @FXML
    private Text id7;

    @FXML
    private Text id8;

    @FXML
    private Text id9;

    @FXML
    private Text id2;

    @FXML
    private Text id11;

    @FXML
    private Text id12;

    @FXML
    private Text kart1;

    @FXML
    private Text kart2;

    @FXML
    private Text kart3;

    @FXML
    private Text kart4;

    @FXML
    private Text kart5;

    @FXML
    private Text kart6;

    @FXML
    private Text kart7;

    @FXML
    private Text kart8;

    @FXML
    private Text kart9;

    @FXML
    private Text kart10;

    @FXML
    private Text kart11;

    @FXML
    private Text kart12;

    @FXML
    private Text mablagh1;

    @FXML
    private Text mablagh2;

    @FXML
    private Text mablagh3;

    @FXML
    private Text mablagh4;

    @FXML
    private Text mablagh5;

    @FXML
    private Text mablagh6;

    @FXML
    private Text mablagh7;

    @FXML
    private Text mablagh8;

    @FXML
    private Text mablagh9;

    @FXML
    private Text mablagh10;

    @FXML
    private Text mablagh11;

    @FXML
    private Text mablagh12;

    @FXML
    private Button backbtn;

    @FXML
    private Button acc1;

    @FXML
    private Button acc2;

    @FXML
    private Button acc3;

    @FXML
    private Button acc4;

    @FXML
    private Button acc6;

    @FXML
    private Button acc5;

    @FXML
    private Button acc7;

    @FXML
    private Button acc8;

    @FXML
    private Button acc9;

    @FXML
    private Button acc10;

    @FXML
    private Button acc11;

    @FXML
    private Button acc12;

    @FXML
    private Button rej1;

    @FXML
    private Button rej2;

    @FXML
    private Button rej3;

    @FXML
    private Button rej4;

    @FXML
    private Button rej5;

    @FXML
    private Button rej6;

    @FXML
    private Button rej7;

    @FXML
    private Button rej8;

    @FXML
    private Button rej9;

    @FXML
    private Button rej10;

    @FXML
    private Button rej11;

    @FXML
    private Button rej12;

    @FXML
    void accept1(ActionEvent event) throws IOException {
        acceptVam(1);
    }

    @FXML
    void accept10(ActionEvent event) throws IOException {
        acceptVam(10);
    }

    @FXML
    void accept11(ActionEvent event) throws IOException {
        acceptVam(11);

    }

    @FXML
    void accept12(ActionEvent event) throws IOException {
        acceptVam(12);
    }

    @FXML
    void accept2(ActionEvent event) throws IOException {
        acceptVam(2);
    }

    @FXML
    void accept3(ActionEvent event) throws IOException {
        acceptVam(3);
    }

    @FXML
    void accept4(ActionEvent event) throws IOException {
        acceptVam(4);

    }

    @FXML
    void accept5(ActionEvent event) throws IOException {
        acceptVam(5);

    }

    @FXML
    void accept6(ActionEvent event) throws IOException {
        acceptVam(6);
    }

    @FXML
    void accept7(ActionEvent event) throws IOException {
        acceptVam(7);
    }

    @FXML
    void accept8(ActionEvent event) throws IOException {
        acceptVam(8);

    }

    @FXML
    void accept9(ActionEvent event) throws IOException {
        acceptVam(9);

    }

    @FXML
    void back(ActionEvent event) throws IOException {

        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("modiriyat.fxml"));
        primaryStage.setTitle("Your Bank");
        primaryStage.setScene(new Scene(root, 600, 522));
        primaryStage.show();

        Stage stage = (Stage) backbtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void reject1(ActionEvent event) {
        showError2();

    }

    @FXML
    void reject10(ActionEvent event) {
        showError2();

    }

    @FXML
    void reject11(ActionEvent event) {
        showError2();

    }

    @FXML
    void reject12(ActionEvent event) {
        showError2();
    }

    @FXML
    void reject2(ActionEvent event) {
        showError2();

    }

    @FXML
    void reject3(ActionEvent event) {
        showError2();

    }

    @FXML
    void reject4(ActionEvent event) {
        showError2();

    }

    @FXML
    void reject5(ActionEvent event) {
        showError2();
    }

    @FXML
    void reject6(ActionEvent event) {
        showError2();

    }

    @FXML
    void reject7(ActionEvent event) {
        showError2();

    }

    @FXML
    void reject8(ActionEvent event) {
        showError2();
    }

    @FXML
    void reject9(ActionEvent event) {
        showError2();
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
    public String searchUser(String Number) throws IOException {
        String allContents = read("customer.txt");
        String[] rows = allContents.split("\n");
        String user = "";
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split("@");
            if (columns[3].equals(Number))
                user = columns[1];

        }
        return user;
    }
    public static void write(String contents,String path) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile(path,"rw");
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.writeUTF("@"+contents+"\n");
        randomAccessFile.close();
    }
    public static void setData(String path) throws IOException {
        String allContents = read(path);
        String[] rows = allContents.split("\n");

        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split("@");
            shomare[i] = columns[1];
            Username[i]=columns[2];
            megdar[i]=columns[3];

        }
        for (int i= rows.length;i<12;i++){
            shomare[i]="";
            megdar[i]="";
            Username[i]="";
        }

    }
    public void acceptVam(int x) throws IOException {
        Long ezafe = Long.parseLong(megdar[x-1]);
        String hesab =shomare[x-1];
        String ramz = searchRamz(hesab,"customer.txt");

        Long Mojudi =Long.parseLong(searchMojudi(hesab, "customer.txt"));
        String nahayi = Long.toString(Mojudi + ezafe);


        String user =Username[x-1];
        String contents = user + "@" +ramz+ "@" + hesab + "@" + nahayi + "@";
        write(contents, "customer.txt");
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("وام با موفقیت صادر شد.");
        a.show();

    }


    public static String searchMojudi (String mabdaNumber, String path) throws IOException {
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
    public static void showError(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("وامی برای صدور وجود ندارد.");
        a.setHeaderText(null);
        a.show();
    }
    public static void showError2(){
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("وام با موفقیت رد شد.");
        a.show();
    }
}
