package Controller;


import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import DataContainer.Obshchak;
import PoliceFile.PoliceFile;
import helper.Helper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Node;


public class SortController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="DateOfLastImprisonment"
    private Button DateOfLastImprisonment; // Value injected by FXMLLoader

    @FXML // fx:id="Name"
    private Button Name; // Value injected by FXMLLoader

    @FXML // fx:id="Lastname"
    private Button Lastname; // Value injected by FXMLLoader

    @FXML // fx:id="Surname"
    private Button Surname; // Value injected by FXMLLoader

    @FXML // fx:id="DateOfBirth"
    private Button DateOfBirth; // Value injected by FXMLLoader

    @FXML // fx:id="DateOfLastreLease"
    private Button DateOfLastreLease; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
 
    	Lastname.setOnAction(event->{
       	 Obshchak.List.sort(new Comparator<PoliceFile>() {
       		 
	            public int compare(PoliceFile o1, PoliceFile o2) {
	               return  Helper.comparison (o1.getLastname(), o2.getLastname());
	            }
	        });
       	((Node) event.getSource()).getScene().getWindow().hide();
    	});


    	Name.setOnAction(event->{
       	 Obshchak.List.sort(new Comparator<PoliceFile>() {
	            @Override
	            public int compare(PoliceFile o1, PoliceFile o2) {
	              
	               return  Helper.comparison(o1.getName(), o2.getName()) ; 
	                
	            }
	        });
       	((Node) event.getSource()).getScene().getWindow().hide();
    	});
    	

    	Surname.setOnAction(event->{
       	 Obshchak.List.sort(new Comparator<PoliceFile>() {
	            @Override
	            public int compare(PoliceFile o1, PoliceFile o2) {
	                  return Helper.comparison(o1.getSurname(), o2.getSurname());
	            }
	        });
       	((Node) event.getSource()).getScene().getWindow().hide();
    	});


    	DateOfBirth.setOnAction(event->{
       	 Obshchak.List.sort(new Comparator<PoliceFile>() {
	            @Override
	            public int compare(PoliceFile o1, PoliceFile o2) {
	                  return Helper.comparison(o1.getDateOfBirth(), o2.getDateOfBirth());
	            }
	        });
       	((Node) event.getSource()).getScene().getWindow().hide();
    	});
    	
    	
    	DateOfLastImprisonment.setOnAction(event->{
       	 Obshchak.List.sort(new Comparator<PoliceFile>() {
	            @Override
	            public int compare(PoliceFile o1, PoliceFile o2) {
	                  return Helper.comparison(o1.getDateOfLastImprisonment(), o2.getDateOfLastImprisonment());
	            }
	        });
       	((Node) event.getSource()).getScene().getWindow().hide();
    	});

       	 
    	DateOfLastreLease.setOnAction(event->{ 
       	 Obshchak.List.sort(new Comparator<PoliceFile>() {
	            @Override
	            public int compare(PoliceFile o1, PoliceFile o2) {
	                  return Helper.comparison(o1.getDateOfLastreLease(), o2.getDateOfLastreLease());
	            }
	        });
       	((Node) event.getSource()).getScene().getWindow().hide();
        });

    }
    
    
    
 
}
