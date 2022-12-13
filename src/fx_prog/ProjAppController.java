package fx_prog;

import javafx.event.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class ProjAppController implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    private ImageView FD;
    @FXML
    private Label L2;
    @FXML
    private Button BTN;
    @FXML
    private Label LL2;
    @FXML
    private Label L1;

    Image myImage = new Image(getClass().getResourceAsStream("yellow_flower.jpg"));

    @FXML
    private ComboBox<String> comb_1;
    @FXML
    private Label flower_emj;
    @FXML
    private AnchorPane ANCH1;
    @FXML
    private MenuBar menu_id;
    @FXML
    private Menu About_id;
    @FXML
    private MenuItem inform_id;
    @FXML
    private Menu help_id;
    @FXML
    private MenuItem contact_id;

    @FXML
    public void btnNext(ActionEvent e) throws IOException {
        if ("Delivery".equals(comb_1.getValue())) {
            Parent root = FXMLLoader.load(getClass().getResource("Delivery.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else if ("pick Up".equals(comb_1.getValue())) {
            Parent root = FXMLLoader.load(getClass().getResource("Pick_up.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        comb_1.getItems().add("Delivery");
        comb_1.getItems().add("pick Up");

    }

    @FXML
    private void OurInfromation(ActionEvent event) {
        String info;
        info = "It is time consuming and difficult "
                + "to go to flower shops to gift your loved ones.\n"
                + "We developed an application that will create ideas\n for booking and gifting "
                + "a bouquet made with love\n and our app will save you time and energy.";
        JOptionPane.showMessageDialog(null, info);
    }

    @FXML
    private void ContactInfo(ActionEvent event) {
        String ContInfo1, ContInfo2;
        ContInfo1 = "Nawaf Mohammed \n +966545257052 \n Eng.NawafMI@gmail.com\n"
                + "--------------------------\n";
        ContInfo2 = "Muhannad Jamil \n +966552921172 \n Muhannadd23@gmail.com\n"
                + "--------------------------\n";
        JOptionPane.showMessageDialog(null, ContInfo1 + ContInfo2);

    }

}
