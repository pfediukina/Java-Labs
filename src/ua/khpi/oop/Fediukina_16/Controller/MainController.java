package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

import helper.*;
import DataContainer.*;
import PoliceFile.Date;
import PoliceFile.PoliceFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

	private ObservableList<PoliceFile> users  = FXCollections.observableArrayList();
	
    @FXML // fx:id="usersData"
    private TableView<PoliceFile> usersData; // Value injected by FXMLLoader
    
	  	@FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="Statistics"
	    private Label Statistics; // Value injected by FXMLLoader

	    @FXML // fx:id="Lastname"
	    private TableColumn<PoliceFile, String> Lastname; // Value injected by FXMLLoader

	    @FXML // fx:id="Name"
	    private TableColumn<PoliceFile, String> Name; // Value injected by FXMLLoader

	    @FXML // fx:id="Surname"
	    private TableColumn<PoliceFile, String> Surname; // Value injected by FXMLLoader

	    @FXML // fx:id="DateOfBirth"
	    private TableColumn<PoliceFile, Date> DateOfBirth; // Value injected by FXMLLoader

	    @FXML // fx:id="DateOfLastImprisonment"
	    private TableColumn<PoliceFile, Date> DateOfLastImprisonment; // Value injected by FXMLLoader

	    @FXML // fx:id="DateOfLastreLeaseі"
	    private TableColumn<PoliceFile, Date> DateOfLastreLeaseі; // Value injected by FXMLLoader

	    
	    @FXML // fx:id="DatesOfConvictions"
	    private TableColumn<PoliceFile, Date[]> DatesOfConvictions; // Value injected by FXMLLoader

	    @FXML // fx:id="AddData"
	    private Button AddData; // Value injected by FXMLLoader

	    @FXML // fx:id="show"
	    private Button show; // Value injected by FXMLLoader

	    @FXML // fx:id="UpdataData"
	    private Button UpdataData; // Value injected by FXMLLoader

	    @FXML // fx:id="LoadData"
	    private Button LoadData; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="SaveData"
	    private Button SaveData; // Value injected by FXMLLoader

	    @FXML // fx:id="Sort"
	    private Button Sort; // Value injected by FXMLLoader

	    @FXML // fx:id="RemoveNum"
	    private Button RemoveNum; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="Clear"
	    private Button Clear; // Value injected by FXMLLoader

	    @FXML // fx:id="EXIT"
	    private Button EXIT; // Value injected by FXMLLoader

	    @FXML // fx:id="Police"
	    private ImageView Police; // Value injected by FXMLLoader
    
    @FXML
    void initialize() {
         
    	/**/
   show.setOnAction(event->
   {
 
	   users.clear();
	   
	   Lastname.setCellValueFactory(new PropertyValueFactory<PoliceFile, String>("Lastname"));
       Name.setCellValueFactory(new PropertyValueFactory<PoliceFile, String>("Name"));
       Surname.setCellValueFactory(new PropertyValueFactory<PoliceFile, String>("Surname"));
       DateOfBirth.setCellValueFactory(new PropertyValueFactory<PoliceFile, Date>("DateOfBirth"));
       DateOfLastImprisonment.setCellValueFactory(new PropertyValueFactory<PoliceFile, Date>("DateOfLastImprisonment"));
       DateOfLastreLeaseі.setCellValueFactory(new PropertyValueFactory<PoliceFile, Date>("DateOfLastreLease"));
       DatesOfConvictions.setCellValueFactory(new PropertyValueFactory<PoliceFile, Date[]>("DatesOfConvictions"));


	   
 
	   	   for(var Pf:Obshchak.List)
	   {
		   
		   users.add(Pf);
	 
	   }
	   	   usersData.setItems(users);
	       Statistics.setText("Кількість злочинців: "+Obshchak.List.size());

   }); 
   ////////////////////////////////////////////////////////////////////

   AddData.setOnAction(event->{
	   AnchorPane root;
       try {
           root = FXMLLoader.load(getClass().getClassLoader().getResource("Form/WaysToAddData.fxml"), resources);
           Stage stage = new Stage();
           stage.setTitle("WaysToAddData");
           stage.setFullScreen(false);
           stage.setScene(new Scene(root));
           stage.setResizable(false);
           stage.show();
 
          // ((Node) event.getSource()).getScene().getWindow().hide();
       }
       catch (IOException e) {
           e.printStackTrace();
       }
   });
   //////////////////////////////
   UpdataData.setOnAction(event->{
	   JOptionPane.showMessageDialog(null, "Вам недоступна дана фінкція. Зверніться до адміністратора","Info", 1);
	   JOptionPane.showMessageDialog(null, "А точно, я забув. Адміністратор це ви","Info", 2);
	   JOptionPane.showMessageDialog(null, "В такому випадку зверніться до сабе.","Info", 3);
	   JOptionPane.showMessageDialog(null, "Вирішіть цю проблему та продовжіть роботу","Info", 1);
   });
   
   
////////////////////////////////////////////////////////////   
   LoadData.setOnAction(event->{
	   
	   new ProcessProcesses(3);
   });
   
   SaveData.setOnAction(event->{
	   
	   new ProcessProcesses(4);
   });
 //////////////////////////////////////////////////////////
   Sort.setOnAction(event->{
	   
	   AnchorPane root;
       try {
           root = FXMLLoader.load(getClass().getClassLoader().getResource("Form/Sort.fxml"), resources);
           Stage stage = new Stage();
           stage.setTitle("Sort");
           stage.setFullScreen(false);
           stage.setScene(new Scene(root));
           stage.setResizable(false);
           stage.show();
 
       }
       catch (IOException e) {
           e.printStackTrace();
       }
   });
   
   RemoveNum.setOnAction(event->{
	   AnchorPane root;
       try {
           root = FXMLLoader.load(getClass().getClassLoader().getResource("Form/RemoveNum.fxml"), resources);
           Stage stage = new Stage();
           stage.setTitle("Remove");
           stage.setFullScreen(false);
           stage.setScene(new Scene(root));
           stage.setResizable(false);
           stage.show();
 
          // ((Node) event.getSource()).getScene().getWindow().hide();
       }
       catch (IOException e) {
           e.printStackTrace();
       }
   });
   
   Clear.setOnAction(event->{
	   
	   Obshchak.List.clear();
	   JOptionPane.showMessageDialog(null, "Очищеня завершено","Clear", 1);
	   
   });
   
  ////////////////////////////////////////////////////////////// 
    EXIT.setOnAction(event->{
    	((Node) event.getSource()).getScene().getWindow().hide();
    });
   
   Police.setOnMouseClicked(event->{
	   JOptionPane.showMessageDialog(null, "Ви перейшли в режим бога\n Що воно таке я ще незнаю.\n Тому вітаю із ....", "Congratulations!!!", JOptionPane.WARNING_MESSAGE);
   });
    }
}