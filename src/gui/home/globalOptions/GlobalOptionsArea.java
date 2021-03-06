package gui.home.globalOptions;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class GlobalOptionsArea extends TabPane
{	
	public GlobalOptionsArea(EventInterface eventHandler)
	{
		super();
		this.eventHandler = eventHandler;
		vbox.getChildren().addAll(
				closeAllPlotsButton, closeAllTabsButton);
		for (Node node : vbox.getChildren())
		{
			Button button = (Button)node;
			if(button != null)
				button.setMinWidth(defaultWidth);
		}
		closeAllPlotsButton.setOnMouseClicked(e -> 
		{
			eventHandler.onCloseAllPlots();
		});
		closeAllTabsButton.setOnMouseClicked(e -> {
			eventHandler.onCloseAllTabs();
		});
		mainTab.setContent(vbox);
		mainTab.setClosable(false);
		getTabs().add(mainTab);

		closeAllPlotsButton.getStyleClass().add("global-button");
		closeAllTabsButton.getStyleClass().add("global-button");
		clearFavsButton.getStyleClass().add("global-button");

		closeAllPlotsButton.setOnMouseEntered(e -> closeAllPlotsButton.getStyleClass().add("global-button-hover"));
		closeAllTabsButton.setOnMouseEntered(e -> closeAllTabsButton.getStyleClass().add("global-button-hover"));
		clearFavsButton.setOnMouseEntered(e -> clearFavsButton.getStyleClass().add("global-button-hover"));

		closeAllPlotsButton.setOnMouseExited(e -> closeAllPlotsButton.getStyleClass().remove("global-button-hover"));
		closeAllTabsButton.setOnMouseExited(e -> closeAllTabsButton.getStyleClass().remove("global-button-hover"));
		clearFavsButton.setOnMouseExited(e -> clearFavsButton.getStyleClass().remove("global-button-hover"));
	}
	
	VBox vbox = new VBox();
	String mainTabTitle = "Options";
	Tab mainTab = new Tab(mainTabTitle);
	static double defaultWidth = 120;

	String closeAllPlotsLabel = "Close All Charts";
	Button closeAllPlotsButton = new Button(closeAllPlotsLabel);
	
	String clearFavsLabel = "Clear Favourites";
	Button clearFavsButton = new Button(clearFavsLabel);
	
	String closeAllTabsLabel = "Close All Tabs";
	Button closeAllTabsButton = new Button(closeAllTabsLabel);

	
	EventInterface eventHandler;
	
	public interface EventInterface
	{
		public void onCloseAllPlots();
		public void onClearFavs();
		public void onCloseAllTabs();
	}
}
