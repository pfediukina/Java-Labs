package Controller;

import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SiginController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Login"
    private TextField Login; // Value injected by FXMLLoader

    @FXML // fx:id="Password"
    private TextField Password; // Value injected by FXMLLoader

    @FXML // fx:id="Sigin"
    private Button Sigin; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    	Sigin.setOnAction(event->{
    		
    		if(Login.getText().equals("Admin")==true)
    		{
    			   AnchorPane root;
    		       try {
    		           root = FXMLLoader.load(getClass().getClassLoader().getResource("Form/Main.fxml"), resources);
    		           Stage stage = new Stage();
    		           stage.setFullScreen(false);
    		           stage.setScene(new Scene(root));
    		           stage.setResizable(false);
    		           stage.show();
    		 
    		           ((Node) event.getSource()).getScene().getWindow().hide();
    		       }
    		       catch (IOException e) {
    		           e.printStackTrace();
    		       }
    		}
    		else 
    		{
    			Login.setStyle( "-fx-background-color: #ef4f4f;");
    			Password.setText(null);
    		}
    		
    	});
    	

    }
}
