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
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.shape.Line;

/**
 * FXML Controller class
 */
public class OrderController extends PACKAGEController implements Initializable {

    @FXML
    private Label order_bill;
    @FXML
    private Line line1;
    @FXML
    private Label barcoode;
    @FXML
    private Label bar_number;
    @FXML
    private Line line2;
    @FXML
    private Button order_btn;
    @FXML
    private Label lbl_customer;
    @FXML
    private Label lbl_order;
    @FXML
    private TextArea receipt_order;
    @FXML
    private TextArea receipt_cust;
    @FXML
    private Label thx_lbl;
    @FXML
    private Label thx2_lbl;

    @FXML
    public void receiveData(ActionEvent event) throws FileNotFoundException, IOException {

        BufferedReader file = new BufferedReader(new FileReader("Customer_data.txt"));
        String last = null, line;

        while ((line = file.readLine()) != null) {
            last = line;
        }

        receipt_cust.appendText(last);

        BufferedReader file3 = new BufferedReader(new FileReader("Order.txt"));
        String last3 = null, line3;

        while ((line3 = file3.readLine()) != null) {
            last3 = line3;
        }

        receipt_order.appendText(last3);

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
