package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import helper.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WaysToAddDataController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddFromFile;

    @FXML
    private Button AddFromKeyboard;

    @FXML
    void initialize() {
         
        AddFromKeyboard.setOnAction(event->{
     	   AnchorPane root;
           try {
               root = FXMLLoader.load(getClass().getClassLoader().getResource("Form/Offender.fxml"), resources);
               Stage stage = new Stage();
               stage.setTitle("Offender");
               stage.setScene(new Scene(root));
               stage.setResizable(false);
               stage.show();
     
              ((Node) event.getSource()).getScene().getWindow().hide();
           }
           catch (IOException e) {
               e.printStackTrace();
           }
        });
        
        AddFromFile.setOnAction(event->{
			new ProcessProcesses(2);
		((Node) event.getSource()).getScene().getWindow().hide();
        });
        
    }
}
