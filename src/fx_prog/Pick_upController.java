package fx_prog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Pick_upController implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane an;
    @FXML
    private Label lbl_cus;
    @FXML
    private TextField tf_name;
    @FXML
    private Label lbl_name;
    @FXML
    private Label lbl_phone;
    @FXML
    private TextField tf_phone;
    @FXML
    private TextField tf_email;
    @FXML
    private Label lbl_email;
    @FXML
    private Line line;
    @FXML
    private Label lbl_del;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnNext;
    @FXML
    private Label lbl_work;
    @FXML
    private Label lbl_hours;
    @FXML
    private Label lbl_days;
    @FXML
    private ComboBox<String> comb_branch;
    @FXML
    private ListView<String> list_times;
    @FXML
    private Label lbl_att_time;

    static boolean check = true;
    @FXML
    private Tooltip tool_back;

    /**
     * Initializes the controller class.
     *
     * @param e
     * @throws java.io.IOException
     */
    @FXML
    public void btnBack(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProjApp.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void txt_excep(ActionEvent ae) throws Exception {

        try {

            if (tf_phone.getLength() == 0) {
                throw new InputMismatchException("");
            }
            if (isNumeric(tf_phone.getText())) {
                check = true;
            }
            if (tf_phone.getLength() != 0 && tf_name.getLength() != 0 && check) {
                BufferedWriter file = new BufferedWriter(new FileWriter("Customer_data.txt", true));
                file.write(tf_name.getText());

                file.close();
            }
            if (tf_phone.getLength() != 0 && tf_name.getLength() != 0 && check) {
                Parent root = FXMLLoader.load(getClass().getResource("Package.fxml"));
                stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "PHONE FIELD CAN NOT BE NULL !!");
        }

        try {
            if (tf_name.getLength() == 0) {
                throw new InputMismatchException("");
            }
            if (tf_phone.getLength() != 0 && tf_name.getLength() != 0 && check) {
                BufferedWriter file = new BufferedWriter(new FileWriter("Customer_data.txt", true));
                file.write(" | " + tf_phone.getText() + " | " + tf_email.getText());
                file.write(System.getProperty("line.separator"));
                file.close();
            }
            if (tf_phone.getLength() != 0 && tf_name.getLength() != 0 && check) {
                Parent root = FXMLLoader.load(getClass().getResource("Package.fxml"));
                stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "NAME FIELD CAN NOT BE NULL !!");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comb_branch.getItems().add("Al-Rehaily");
        comb_branch.getItems().add("Obhur Al-Shamaliah");
        comb_branch.getItems().add("Obhur Al-Janubiyah");
        comb_branch.getItems().add("Al-Basatin");
        comb_branch.getItems().add("Al-Naim");
        comb_branch.getItems().add("Al-Hamadaniyyah");
        list_times.getItems().add("4-5 pm");
        list_times.getItems().add("5-6 pm");
        list_times.getItems().add("6-7 pm");
        list_times.getItems().add("7-8 pm");
        list_times.getItems().add("8-9 pm");
        list_times.getItems().add("9-10 pm");
        list_times.getItems().add("10-11 pm");
        

    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "PHONE FIELD MUST BE NUMBERS !!");
            check = false;
            return false;
        }
        return true;
    }

}
