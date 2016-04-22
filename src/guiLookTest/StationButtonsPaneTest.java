package guiLookTest;

import data.Bom;
import data.StationList;
import gui.ExplorerButtonNotFav;
import gui.ExplorerPaneAllStations;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StationButtonsPaneTest extends Application
{
	public void start(Stage window) throws Exception 
	{
		//Testing the list of locations, back before there was a favourites tab
	    window.setTitle("Login");
		window.setResizable(false);
        window.setOnCloseRequest(e -> System.exit(0));
        StationList stations = Bom.getAllStations();
		ExplorerPaneAllStations listPane = new ExplorerPaneAllStations();
		listPane.createStationButtons(stations);
		
		// Basic Searching By Rad
		ObservableList<Node> buttonList = listPane.getVBox().getChildren();
		TextField searchBox = (TextField) listPane.getChildren().get(0);
		searchBox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				for(Node button: buttonList) {
					String label = ((ExplorerButtonNotFav) button).getText();
					if (label.toLowerCase().contains(newValue.toLowerCase())) {
						button.setManaged(true);
					}
					else {
						button.setManaged(false);
					}
				}
			}
		});
		
		window.setScene(new Scene(listPane));
    	window.sizeToScene();
    	window.centerOnScreen();
    	window.show();
    	
    	TextField textField;
	}
	
	public static void main(String args[])
    {
        launch(args);
    }
	
	public void handle(String text) {
		
	}

}
