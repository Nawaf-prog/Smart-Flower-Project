package fx_prog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class PACKAGEController implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    private Line line1;
    public RadioButton rad1;
    @FXML
    private RadioButton rad2;
    @FXML
    private ImageView IMG_1;
    @FXML
    private Label lbl_bouquet;
    @FXML
    private ToggleGroup PACKAGE_RAD;
    @FXML
    private RadioButton rad4;
    @FXML
    private RadioButton rad3;
    @FXML
    private Line line3;
    @FXML
    private Line line4;
    @FXML
    private ComboBox<String> comb1;
    @FXML
    private ComboBox<String> comb2;
    @FXML
    private TextArea txt_area;
    @FXML
    private Label lbl_comments;
    @FXML
    private Label lbl_type;
    @FXML
    private Label lbl_color;
    @FXML
    private Button btn_check;

    @FXML
    private void btnOrderDet(ActionEvent event) throws IOException {
        BufferedWriter file1 = new BufferedWriter(new FileWriter("Order.txt", true));
        
        //the tax is 20%
        if (rad1.isSelected() == true) {
            file1.write("Quantity: 10    |    Total Price with tax: 30.0 SR");
            file1.write(System.getProperty("line.separator"));
        } else if (rad2.isSelected() == true) {
            file1.write("Quantity: 15    |    Total Price with tax: 42.0 SR");
            file1.write(System.getProperty("line.separator"));
        } else if (rad3.isSelected() == true) {
            file1.write("Quantity: 20    |    Total Price with tax: 48.0 SR");
            file1.write(System.getProperty("line.separator"));
        } else if (rad4.isSelected() == true) {
            file1.write("Quantity: 25    |    Total Price with tax: 60.0 SR");
            file1.write(System.getProperty("line.separator"));
        }

        file1.close();

        Parent root = FXMLLoader.load(getClass().getResource("Order.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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
        comb1.getItems().add("YELLOW");
        comb1.getItems().add("RED");
        comb1.getItems().add("WHITE");
        comb1.getItems().add("BLUE");
        comb1.getItems().add("PINK");

        comb2.getItems().add("JASMINE");
        comb2.getItems().add("SUNFLOWER");
        comb2.getItems().add("TULIP");
        comb2.getItems().add("MARIGOLD");
        comb2.getItems().add("LAVENDER");

    }

}
