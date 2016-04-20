package guiPlotsTest;

import data.Bom;
import data.Station;
import data.StationList;
import guiPlots.CurrTempPlot;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CurrTempPlotTest extends Application{
	StationList allStations;
	public static void main(String args[])
    {
        launch(args);
    }
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//Grabbing stations
		try {
			allStations = Bom.getAllStations();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		// Pick a station to test
		Station station = null;
		if (allStations != null) {
			station = allStations.get(0);
		}
		else {
			return;
		}
		
		CurrTempPlot lineChart = new CurrTempPlot(station);
		
		Scene scene  = new Scene(lineChart);
		primaryStage.setScene(scene);
        scene.getStylesheets().add(lineChart.getCssPath());
        primaryStage.show();
		
	}
}