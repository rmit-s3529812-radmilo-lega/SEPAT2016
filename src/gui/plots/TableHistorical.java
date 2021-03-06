package gui.plots;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import data.Bom;
import data.Fio;
import data.Station;
import data.samples.WthrSampleDaily;
import data.samples.WthrSamplesDaily;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * Created by Pavel Nikolaev on 21/04/2016.
 */


public class TableHistorical extends PlotBase
{
	private String cssPath;
	String cssFileName = "tables.css";
	TableView dataTable;
	ObservableList data;
	double tempFieldWidth = 36;
	
    public TableHistorical(Station station) 
    {
		super(station);
		setName(station.getName() + " Historical Weather");
		URL url = this.getClass().getResource(cssFileName);
        cssPath = url.toExternalForm();
		createTable();
		assembleFrom(dataTable);
	}

    public void createTable()
    {
        dataTable = new TableView<WthrSampleDaily>();

        //-------------------------------------------------------------------------------------//
        // in order to create a table you have to specify the class / type of object it is representing
        // it then automatically detects the values within a particular instance of object
        // this is done when you specify the propertyValueFactory

        TableColumn<WthrSampleDaily, LocalDate> date = new TableColumn<>("Date");
        TableColumn<WthrSampleDaily, String> maxTemp = new TableColumn<>("maxTemp");
        TableColumn<WthrSampleDaily, String> minTemp = new TableColumn<>("minTemp");
        TableColumn<WthrSampleDaily, String> temp9am = new TableColumn<>("temp9am");
        TableColumn<WthrSampleDaily, String> temp3pm = new TableColumn<>("temp3pm");

        date.setSortable(false);
        maxTemp.setSortable(false);
        minTemp.setSortable(false);
        temp3pm.setSortable(false);
        temp9am.setSortable(false);

        TableColumn<WthrSampleDaily, String> windDir9am = new TableColumn<>("windDir9am");
        TableColumn<WthrSampleDaily, String> windSpd9am = new TableColumn<>("windSpd9am");
        TableColumn<WthrSampleDaily, String> windDir3pm = new TableColumn<>("windDir3pm");
        TableColumn<WthrSampleDaily, String> windSpd3pm = new TableColumn<>("windSpd3pm");
        TableColumn<WthrSampleDaily, String> maxWindGustDir = new TableColumn<>("maxWindGustDir");
        TableColumn<WthrSampleDaily, String> maxWindGustSpd = new TableColumn<>("maxWindGustSpd");
        TableColumn<WthrSampleDaily, String> maxWindGustTime = new TableColumn<>("maxWindGustTime");
        
        windDir3pm.setSortable(false);
        windDir9am.setSortable(false);
        windSpd3pm.setSortable(false);
        windSpd9am.setSortable(false);
        maxWindGustDir.setSortable(false);
        maxWindGustSpd.setSortable(false);
        maxWindGustTime.setSortable(false);

        TableColumn<WthrSampleDaily, String> relHumidity9am = new TableColumn<>("relHumidity9am");
        TableColumn<WthrSampleDaily, String> relHumidity3pm = new TableColumn<>("relHumidity3pm");

        TableColumn<WthrSampleDaily, String> meanSeaLevelPressure9am = new TableColumn<>("meanSeaLevelPressure9am");
        TableColumn<WthrSampleDaily, String> meanSeaLevelPressure3pm = new TableColumn<>("meanSeaLevelPressure3pm");

        TableColumn<WthrSampleDaily, String> rain = new TableColumn<>("Rain");
        TableColumn<WthrSampleDaily, String> evap = new TableColumn<>("Evaporation");
        TableColumn<WthrSampleDaily, String> sun = new TableColumn<>("sun");

        relHumidity3pm.setSortable(false);
        relHumidity9am.setSortable(false);
        rain.setSortable(false);
        evap.setSortable(false);
        sun.setSortable(false);

        date.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, LocalDate>("date"));
        maxTemp.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("maxTemp"));
        minTemp.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("minTemp"));
        temp9am.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("temp9am"));
        temp3pm.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("temp3am"));

        windDir9am.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("windDir9am"));
        windDir3pm.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("windDir3pmm"));
        windSpd9am.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("windSpd9am"));
        windSpd3pm.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("windSpd3pm"));
        maxWindGustDir.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("maxWindGustDir"));
        maxWindGustSpd.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("maxWindGustSpd"));
        maxWindGustTime.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("maxWindGustTime"));

        relHumidity9am.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("relHumidity9am"));
        relHumidity3pm.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("relHumidity3pm"));

        meanSeaLevelPressure9am.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("meanSeaLevelPressure9am"));
        meanSeaLevelPressure3pm.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("meanSeaLevelPressure3pm"));

        rain.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("rain"));
        evap.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("evap"));
        sun.setCellValueFactory(new PropertyValueFactory<WthrSampleDaily, String>("sun"));


        TableColumn temp = new TableColumn("Temperature");
        TableColumn wind = new TableColumn("Wind");
        TableColumn humidity = new TableColumn("Humidity");
        TableColumn pressure = new TableColumn("Pressure");


        temp.getColumns().addAll(maxTemp, minTemp, temp9am, temp3pm);
        wind.getColumns().addAll(windDir9am, windSpd9am, windDir3pm, windSpd3pm,
                maxWindGustDir, maxWindGustSpd, maxWindGustTime);
        humidity.getColumns().addAll(relHumidity9am, relHumidity3pm);
        pressure.getColumns().addAll(meanSeaLevelPressure9am, meanSeaLevelPressure3pm);

        dataTable.getColumns().setAll(date, temp, wind, humidity, pressure);
        dataTable.setMinSize(780,450);
        dataTable.setEditable(false);

        VBox container = new VBox();
        container.setAlignment(Pos.CENTER);
        container.getChildren().add(dataTable);
        container.setMinSize(780,450);
    }
    
    @Override
	public void changeWidth(int x)
	{
		dataTable.setPrefWidth(x);
	}

	@Override
	public void changeHeight(int y)
	{
		dataTable.setPrefHeight(y);
	}
    
    @Override
	public void resize(int x, int y)
	{
		this.setPrefSize(x, y);
	}
    
    @Override 
	public void fetchData(Bom bom, Fio fio)
	{
    	// here we create a list of weather sample objects
        // each weather sample object contains data from charlton on a particular day
        // the values of each sample objects variables is automatically detected by the tableView

    	 try {
    		 List list = new ArrayList();

    	        YearMonth start = YearMonth.now().minusMonths(12);
    	        YearMonth end = YearMonth.now().plusMonths(1);

    	        WthrSamplesDaily stationData = new WthrSamplesDaily();

    	        stationData = bom.getWthrRange(station, start, end);
    	        for (WthrSampleDaily sample : stationData) {
    	            list.add(sample);
    	        }

    	        data = FXCollections.observableList(list);
         }
         catch (Exception e){
             e.printStackTrace();
         }
    	
        
	}
    
    @Override
	public void plotData(ObservableList<String> options) 
    {
    	dataTable.setItems(data);
	}
}