package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import DataContainer.Obshchak;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RemoveNumController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField index;

    @FXML
    private Button remove;

    @FXML
    void initialize() {
   
    	remove.setOnAction(event->{
    		    
    		if(index.getText().equals("")==false)
    		{
    			if(Integer.parseInt(index.getText())<=0||Integer.parseInt(index.getText())>Obshchak.List.size())
    				JOptionPane.showMessageDialog(null, "Видалення елементу якого неіснує неможливе","Offender", 1);
    			else {
    			Obshchak.List.removeNode(Integer.parseInt(index.getText()));
                JOptionPane.showMessageDialog(null, "Процес видалення ","Offender", 1);
    			}
                ((Node) event.getSource()).getScene().getWindow().hide();
    		}
    		
    		
    	   });
    	

    }
}
