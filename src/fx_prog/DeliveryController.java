/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx_prog;

import java.io.*;
import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class DeliveryController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField tf_name;

    @FXML
    private Label lbl_cus;
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
    private Label lbl_address;
    @FXML
    private Label lbl_del;
    @FXML
    private TextField tf_address;
    @FXML
    private Label lbl_date;
    @FXML
    private TextField tf_date;
    @FXML
    private ToggleGroup PAY;
    @FXML
    private RadioButton rad_pay1;
    @FXML
    private RadioButton rad_pay2;
    @FXML
    private Label lbl_pay;
    @FXML
    private ComboBox<String> comb_time;
    @FXML
    private Label lbl_time;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnNext;
    @FXML
    private Label del_emoji;

    static boolean check = true;
    @FXML
    private Tooltip tib_back;

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

    /**
     *
     * @param ae
     * @throws java.lang.Exception
     */
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
                //////////////////////////////////////////

                ////////////////////////////////////////
                scene = new Scene(root);
                stage.setScene(scene);
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
                file.write(" | " + tf_phone.getText() + " | " + tf_email.getText() + " | " + tf_address.getText());
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
        comb_time.getItems().add("5PM - 12AM ");
        comb_time.getItems().add("7AM - 2PM");

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
