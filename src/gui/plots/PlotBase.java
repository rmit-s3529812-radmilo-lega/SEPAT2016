package gui.plots;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

import org.controlsfx.control.CheckComboBox;

import data.Bom;
import data.Fio;
import data.Station;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlotBase extends GridPane
{
	public interface EventInterface
	{
		public void onRefresh(PlotBase plot);
	}
	EventInterface eventHandler = voidHandler;
	
	Station station; 
	/* So that we can overlay the same things 
	 * on each plot child class */
	static String refreshButtonLabel = "Refresh";
	Button refreshButton = new Button(refreshButtonLabel);;
	ToolBar toolBar = new ToolBar(refreshButton);
	
	String name = "";
	
	static String showOptionsLabel = "Show";
	Button showOptionsButton;
	
	private final ObservableList<String> checkComboBoxItems = FXCollections.observableArrayList();
	private final CheckComboBox<String> checkComboBox = new CheckComboBox<String>(checkComboBoxItems);
	
	public PlotBase(Station station)
	{
		super();
		this.station = station;	
		defaultInit();

		 toolBar.getItems().add(checkComboBox);
		 
		 showOptionsButton = new Button(showOptionsLabel);
		 showOptionsButton.setOnMouseClicked(e -> 
			{
				System.out.println(checkComboBox.getCheckModel().getCheckedItems());
			});
		 toolBar.getItems().add(showOptionsButton);
	}
	
	public void addCheckComboBoxOption(String option) {
		checkComboBoxItems.add(option);
	}
	
	public ObservableList<String> getCheckedItems() {
		return checkComboBox.getCheckModel().getCheckedItems();
	}
	
	public void addToolbarButton(Node node)
	{
		toolBar.getItems().add(node);
	}
	
	public void setEventHandler(EventInterface handler)
	{
		this.eventHandler = handler;
		refreshButton.setOnMouseClicked(e -> 
		{
			eventHandler.onRefresh(this);
		});
	}
	
	public void plotData()
	{
		
	}
	
	protected void setName(String name)
	{
		this.name = name;
	}
	
	public String getCssPath()
	{
		return null;
	}
	
	public Station getStation()
	{
		return station;
	}
	
	void defaultInit()
	{

		eventHandler = voidHandler;
		refreshButton = new Button(refreshButtonLabel);;
		toolBar = new ToolBar(refreshButton);
		name = "";
		refreshButton.setOnMouseEntered(e -> refreshButton.getStyleClass().add("button-hover"));
		refreshButton.setOnMouseExited(e -> refreshButton.getStyleClass().remove("button-hover"));
	}
	
	protected void assembleFrom(Node node)
	{
		add(toolBar,0,0);
		toolBar.toFront();
		add(node,0,1);
		setVgrow(node, Priority.ALWAYS);

	}
	
	protected void reassembleFrom(Node plot)
	{
		getChildren().clear();
		getChildren().add(toolBar);
		getChildren().add(plot);
		VBox.setVgrow(plot, Priority.ALWAYS);
	}
	
	protected void onRefresh()
	{
		
	}

	public String getName() 
	{
		return name;
	}

	public void fetchData(Bom bom, Fio fio)
	{
		
	}
	
	private static class VoidEventHandler implements EventInterface
	{
		@Override
		public void onRefresh(PlotBase plot)
		{
			// TODO Auto-generated method stub
			
		}
	}
	private static VoidEventHandler voidHandler = new VoidEventHandler();
}
