package Controller;

 
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
 
import DataContainer.Obshchak;
import PoliceFile.*;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
 


public class OffenderController {

	  @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	   @FXML // fx:id="Lastname"
	    private TextField OLastname; // Value injected by FXMLLoader

	    @FXML // fx:id="Name"
	    private TextField OName; // Value injected by FXMLLoader

	    @FXML // fx:id="Surname"
	    private TextField OSurname; // Value injected by FXMLLoader

	    @FXML // fx:id="Save"
	    private Button Save; // Value injected by FXMLLoader

	    @FXML // fx:id="Сancellation"
	    private Button Сancellation; // Value injected by FXMLLoader

	    @FXML // fx:id="DateOfBirth"
	    private DatePicker DateOfBirth; // Value injected by FXMLLoader

	    @FXML // fx:id="DateOfLastImprisonment"
	    private DatePicker DateOfLastImprisonment; // Value injected by FXMLLoader

	    @FXML // fx:id="DateOfLastreLeaseі"
	    private DatePicker DateOfLastreLeaseі; // Value injected by FXMLLoader

	    @FXML // fx:id="DatesOfConvictions"
	    private DatePicker DatesOfConvictions; // Value injected by FXMLLoader

	    @FXML // fx:id="Add"
	    private Button Add; // Value injected by FXMLLoader

	    @FXML // fx:id="AddConviction"
	    private Button AddConviction; // Value injected by FXMLLoader
         
	    /// масив дат позбалення волі
	    private Date datConvictions[]=new Date[255];
	    int index=-1;
	    
    @FXML
    void initialize() {
        
    	Сancellation.setOnAction(event->{
    		 ((Node) event.getSource()).getScene().getWindow().hide();
             JOptionPane.showMessageDialog(null, "Усі незбережені дані втрачено","Offender", 1);
    	});
///////////////////////////////////////////////////////////////////    	
    	//накопичення масиву дат
    	AddConviction.setOnAction(event->{
    		
    		if(DatesOfConvictions.getValue()==null)
    		{
    			DatesOfConvictions.setStyle( "#ef4f4f");
    		}
    		else {
    			
    		datConvictions[++index]=new Date(this.DatesOfConvictions.getValue().getDayOfMonth(),this.DatesOfConvictions.getValue().getMonthValue(),this.DatesOfConvictions.getValue().getYear());
    		DatesOfConvictions.setValue(null);
    		DatesOfConvictions.setStyle(null);
    		AddConviction.setStyle(null);
    		}
    	});
    	
  //////////////////////////////////////////////////////////////  	
    	Add.setOnAction(event->{
         
    	 	PoliceFile PF= new PoliceFile();
    	 	boolean status=true;///статус якщо помилка вводу то false та дані не будуть записані
    	 	
    	///обробник ПІБ	
    	 if(this.OLastname.getText().equals("")||Regex.Name(this.OLastname.getText())==false)   	{ 		this.OLastname.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	 else
    	 {
    	 PF.setLastname(this.OLastname.getText());
    	 OLastname.setStyle(null);
    	 }
    	
    	if(this.OName.getText().equals("")||Regex.Name(this.OName.getText())==false)   	    { 		this.OName.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	else
    	{
    	PF.setName(this.OName.getText());
    	OName.setStyle(null);
    	}
    	
    	if(this.OSurname.getText().equals("")||Regex.Name(this.OSurname.getText())==false)  	  	{ 		this.OSurname.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	else
    	{
    	PF.setSurname(this.OSurname.getText());
    	OSurname.setStyle(null);
    	}
    	
    	///обробник дати
    	if(this.DateOfBirth.getValue()==null)   	{ 		DateOfBirth.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	else {
    		PF.setDateOfBirth(new Date(this.DateOfBirth.getValue().getDayOfMonth(),this.DateOfBirth.getValue().getMonthValue(),this.DateOfBirth.getValue().getYear()));
    		DateOfBirth.setStyle( null);
    	}
    	
    	if(this.DateOfLastImprisonment.getValue()==null)  	  	{ 		DateOfLastImprisonment.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	else {
    		PF.setDateOfLastImprisonment(new Date(this.DateOfLastImprisonment.getValue().getDayOfMonth(),this.DateOfLastImprisonment.getValue().getMonthValue(),this.DateOfLastImprisonment.getValue().getYear()));
    		DateOfLastImprisonment.setStyle( null);
    	}

    	
    	if(this.DateOfLastreLeaseі.getValue()==null)  	  	{ 		DateOfLastreLeaseі.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	else {
    		PF.setDateOfLastreLease(new Date(this.DateOfLastreLeaseі.getValue().getDayOfMonth(),this.DateOfLastreLeaseі.getValue().getMonthValue(),this.DateOfLastreLeaseі.getValue().getYear()));
    		DateOfLastreLeaseі.setStyle( null);
    	}

    	///додавання масива дат
    	if(DatesOfConvictions.getValue()!=null)
		{
    		datConvictions[++index]=new Date(this.DatesOfConvictions.getValue().getDayOfMonth(),this.DatesOfConvictions.getValue().getMonthValue(),this.DatesOfConvictions.getValue().getYear());
    		DatesOfConvictions.setValue(null);
    		DatesOfConvictions.setStyle(null);
    		AddConviction.setStyle(null);
		}
    	if(this.index==-1)  	  	{ 		DatesOfConvictions.setStyle( "-fx-background-color: #ef4f4f;");AddConviction.setStyle( "-fx-background-color: #ef4f4f;")	;status=false;	}
    	else PF.setDatesOfConvictions(datConvictions,index);
    	
    	if(status == true)
    	{
    		OLastname.clear();
    		OName.clear();
    		OSurname.clear(); 
    		DateOfBirth.setValue(null);
    		DateOfLastImprisonment.setValue(null);
        	DateOfLastreLeaseі.setValue(null);
            Obshchak.List.add(PF); 
            JOptionPane.showMessageDialog(null, "Дані успашно додано","ADD", 1);
    	}
   	});
////////////////////////////////////////////////////////////////////////////////////////////////
    	Save.setOnAction(event->{
   		 
    	 	PoliceFile PF= new PoliceFile();
    	 	boolean status=true;///статус якщо помилка вводу то false та дані не будуть записані
    	 	
    	///обробник ПІБ	
    	 if(this.OLastname.getText().equals("")||Regex.Name(this.OLastname.getText())==false)   	{ 		this.OLastname.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	 else
    	 {
    	 PF.setLastname(this.OLastname.getText());
    	 OLastname.setStyle(null);
    	 }
    	
    	if(this.OName.getText().equals("")||Regex.Name(this.OName.getText())==false)   	    { 		this.OName.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	else
    	{
    	PF.setName(this.OName.getText());
    	OName.setStyle(null);
    	}
    	
    	if(this.OSurname.getText().equals("")||Regex.Name(this.OSurname.getText())==false)  	  	{ 		this.OSurname.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	else
    	{
    	PF.setSurname(this.OSurname.getText());
    	OSurname.setStyle(null);
    	}
    	
    	///обробник дати
    	if(this.DateOfBirth.getValue()==null)   	{ 		DateOfBirth.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	else {
    		PF.setDateOfBirth(new Date(this.DateOfBirth.getValue().getDayOfMonth(),this.DateOfBirth.getValue().getMonthValue(),this.DateOfBirth.getValue().getYear()));
    		DateOfBirth.setStyle( null);
    	}
    	
    	if(this.DateOfLastImprisonment.getValue()==null)  	  	{ 		DateOfLastImprisonment.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	else {
    		PF.setDateOfLastImprisonment(new Date(this.DateOfLastImprisonment.getValue().getDayOfMonth(),this.DateOfLastImprisonment.getValue().getMonthValue(),this.DateOfLastImprisonment.getValue().getYear()));
    		DateOfLastImprisonment.setStyle( null);
    	}

    	
    	if(this.DateOfLastreLeaseі.getValue()==null)  	  	{ 		DateOfLastreLeaseі.setStyle( "-fx-background-color: #ef4f4f;");	status=false;	}	
    	else {
    		PF.setDateOfLastreLease(new Date(this.DateOfLastreLeaseі.getValue().getDayOfMonth(),this.DateOfLastreLeaseі.getValue().getMonthValue(),this.DateOfLastreLeaseі.getValue().getYear()));
    		DateOfLastreLeaseі.setStyle( null);
    	}

    	///додавання масива дат
    	if(DatesOfConvictions.getValue()!=null)
		{
    		datConvictions[++index]=new Date(this.DatesOfConvictions.getValue().getDayOfMonth(),this.DatesOfConvictions.getValue().getMonthValue(),this.DatesOfConvictions.getValue().getYear());
    		DatesOfConvictions.setValue(null);
    		DatesOfConvictions.setStyle(null);
    		AddConviction.setStyle(null);
		}
    	if(this.index==-1)  	  	{ 		DatesOfConvictions.setStyle( "-fx-background-color: #ef4f4f;");AddConviction.setStyle( "-fx-background-color: #ef4f4f;")	;status=false;	}
    	else PF.setDatesOfConvictions(datConvictions,index);
    	
    	if(status == true)
    	{
 
            Obshchak.List.add(PF); 
            JOptionPane.showMessageDialog(null, "Дані успашно збережено","Offender", 1);
            ((Node) event.getSource()).getScene().getWindow().hide();
    	}
    		
   	});
    	
    }
}