package bomWeatherGui;

/**
 * Created by Pavel Nikolaev on 13/03/2016.
 */

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;



public class HomeScreen {

    private static Button BUTTON, BUTTON2,exitButton,minimize;
    private static Scene SCENE1;
    private static StackPane stackPane;
    private static Rectangle plotRect,tableRect,explorerRect ,screenSize;
    private static TextField text;
    private static ToolBar toolBar;
    private static Stage WINDOW;
    double xPos,yPos;
    private static TabPane explorerTabsPane;
    private static LineChart<Number,Number> weatherPlot;

    public void display(Stage window){

        WINDOW = window;
        Utilities util = new Utilities();

        stackPane = new StackPane();
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        int screenWidth = (int)screenSize.getWidth();
        int switchCase = 0;

        //-----------------------------------------------------------------------//

        if(screenWidth > 1919){
            switchCase = 1;
        }
        else if(screenWidth > 1439){
            switchCase = 2;
        }
        else if( screenWidth > 1279){
            switchCase = 3;
        }
        else if(screenWidth > 1023){
            switchCase = 4;
        }

        //-----------------------------------------------------------------------//

        switch(switchCase){

            case 1:SCENE1 = setSceneLarge();
                util.resizeWindowIncrease(WINDOW,1340,790,2,4);
                break;

            case 2: SCENE1 = setSceneMedHigh();
                util.resizeWindowIncrease(WINDOW,650,300,2,4);
                break;
            case 3: SCENE1 = setSceneMedLow();
                util.resizeWindowIncrease(WINDOW,600,300,2,4);
                break;
            case 4: SCENE1= setSceneLow();
                util.resizeWindowIncrease(WINDOW,500,250,2,4);
                break;
            default:SCENE1= setSceneLow();
                break;
        }

        //-----------------------------------------------------------------------//



       // Polygon poly, poly2;

       // poly= new Polygon();
       // poly.getPoints().addAll(new Double[]{
           //     0.0, 0.0,
           //     20.0, -28.0,
           //     20.0, 28.0 });


       // poly2= new Polygon();
      //  poly2.getPoints().addAll(new Double[]{
        //        -20.0, -28.0,
          //      0.0, 0.0,
          //      -20.0, 28.0 });


       // BUTTON = new Button();
       // BUTTON.setId("t1");
       // BUTTON.setShape(poly);

       // BUTTON2 = new Button();
      //  BUTTON2.setId("t2");
       // BUTTON2.setShape(poly2);

       // exit = new Button("X");
       // exit.setId("exit");
      //  exit.setMaxSize(50,25);

       // minimize = new Button("O");
      //  minimize.setId("minimize");
      //  minimize.setMaxSize(50,25);


       //Separator sp = new Separator(Orientation.VERTICAL);
       // sp.setOpacity(0);
       // sp.setMinWidth(1);

       // Separator sp2 = new Separator(Orientation.VERTICAL);
       // sp2.setOpacity(0);
       // sp2.setMinWidth(1);


       // text = new TextField();
       // text.setPromptText("Search stations");

       // minimize.setOnMouseEntered(e -> minimize.setId("minimize-h"));
       // minimize.setOnMouseExited(e -> minimize.setId("minimize"));

       // BUTTON.setOnMouseEntered(e -> BUTTON.setId("button-hover-t"));
       // BUTTON.setOnMouseExited(e -> BUTTON.setId("t1"));

        //BUTTON2.setOnMouseEntered(e -> BUTTON2.setId("t2-hover"));
       // BUTTON2.setOnMouseExited(e -> BUTTON2.setId("t2"));

       // BUTTON.toFront();
       // BUTTON2.toFront();
       // BUTTON.getStyleClass().remove("button");
       // BUTTON2.getStyleClass().remove("button");
       // BUTTON.setOpacity(0);
       // BUTTON2.setOpacity(0);

        util.print(SCENE1.getWidth());
        WindowResizeListener resizer = new WindowResizeListener(SCENE1);
        resizer.setResizeListener();

        WINDOW.setTitle("Home");
        WINDOW.setScene(SCENE1);
    }
    
    StackPane createExplorerPane()
    {
    	return null;
    }

    public void fadeIn(){
        FadeTransition fT1
                = new FadeTransition(Duration.millis(1000), BUTTON);
        fT1.setFromValue(0.0);
        fT1.setToValue(1.0);
        fT1.setDelay(Duration.millis(500));
        fT1.play();

        FadeTransition fT2
                = new FadeTransition(Duration.millis(1000), plotRect);
        fT2.setFromValue(0.0);
        fT2.setToValue(1.0);
        fT2.setDelay(Duration.millis(500));
        fT2.play();

        FadeTransition fT3
                = new FadeTransition(Duration.millis(1000), BUTTON2);
        fT3.setFromValue(0.0);
        fT3.setToValue(1.0);
        fT3.setDelay(Duration.millis(500));
        fT3.play();


        FadeTransition fT4
                = new FadeTransition(Duration.millis(1000), tableRect);
        fT4.setFromValue(0.0);
        fT4.setToValue(1.0);
        fT4.setDelay(Duration.millis(500));
        fT4.play();

              FadeTransition fT5
                = new FadeTransition(Duration.millis(1000), explorerRect);
        fT5.setFromValue(0.0);
        fT5.setToValue(1.0);
        fT5.setDelay(Duration.millis(500));
        fT5.play();

        FadeTransition fT6
                = new FadeTransition(Duration.millis(1000), toolBar);
        fT6.setFromValue(0.0);
        fT6.setToValue(1.0);
        fT6.setDelay(Duration.millis(500));
        fT6.play();

        FadeTransition fT7
                = new FadeTransition(Duration.millis(1000), explorerTabsPane);
        fT7.setFromValue(0.0);
        fT7.setToValue(1.0);
        fT7.setDelay(Duration.millis(500));
        fT7.play();

        FadeTransition fT8
                = new FadeTransition(Duration.millis(1000), weatherPlot);
        fT8.setFromValue(0.0);
        fT8.setToValue(1.0);
        fT8.setDelay(Duration.millis(500));
        fT8.play();



    }

    public void dragWindow(StackPane pane){


        pane.setOnMousePressed(e -> {
            this.xPos = WINDOW.getX() - e.getScreenX();
            this.yPos = WINDOW.getY() - e.getScreenY();
        });

        pane.setOnMouseDragged(e -> {
            WINDOW.setX(e.getScreenX() + this.xPos);
            WINDOW.setY(e.getScreenY() + this.yPos);
        });

    }
    public void dragWindow2(ToolBar bar){

        bar.setOnMousePressed(e -> {
            this.xPos = WINDOW.getX() - e.getScreenX();
            this.yPos = WINDOW.getY() - e.getScreenY();
        });

        bar.setOnMouseDragged(e -> {
            WINDOW.setX(e.getScreenX() + this.xPos);
            WINDOW.setY(e.getScreenY() + this.yPos);
        });

    }

    public Scene setSceneLarge()
    {
        StackPane rootPane = new StackPane();
        // Create Plot
        StackPane plotPane = new StackPane();
        plotRect = new Rectangle(800,350);
        weatherPlot = getChart();
        weatherPlot.setMaxSize(750,300);
        weatherPlot.setOpacity(0);
        plotRect.setArcHeight(20);
        plotRect.setArcWidth(20);
        plotRect.setOpacity(0);
        plotRect.setStroke(Color.LIGHTSLATEGRAY);
        plotRect.setFill(Color.rgb(38,38,38));
        plotRect.setStrokeWidth(2);
        plotPane.getChildren().addAll(plotRect,weatherPlot);
        plotPane.setMaxSize(800,350);
        StackPane.setAlignment(weatherPlot,Pos.CENTER);

        // Create table
        StackPane tablePane = new StackPane();
        


        tableRect = new Rectangle(800,250);
        tableRect.setArcHeight(20);
        tableRect.setArcWidth(20);
        tableRect.setOpacity(0);
        tableRect.setStroke(Color.LIGHTSLATEGRAY);
        tableRect.setFill(Color.rgb(38,38,38));
        tableRect.setStrokeWidth(2);

        tablePane.getChildren().addAll(tableRect);
        tablePane.setMaxSize(800,250);

        StackPane explorerPane = new StackPane();
        explorerRect = new Rectangle(430,625);
        explorerRect.setArcHeight(20);
        explorerRect.setArcWidth(20);
        explorerRect.setOpacity(0);
        explorerRect.setStroke(Color.LIGHTSLATEGRAY);
        explorerRect.setFill(Color.rgb(38, 38, 38));
        explorerRect.setStrokeWidth(2);
        explorerPane.getChildren().addAll(explorerRect);
        explorerPane.setMaxSize(430,635);

        explorerTabsPane = new TabPane();
        explorerTabsPane.setMaxSize(420, 615);
        explorerTabsPane.setOpacity(0);

        Tab allStationsTab = new Tab();
        allStationsTab.setText("All stations");
        StackPane allStationsPane = new StackPane();
        allStationsPane.setPrefSize(420,615);

        ScrollPane stationsScroll = new ScrollPane();
        stationsScroll.setPrefSize(420,615);
        stationsScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        TextField searchBar = new TextField();

        searchBar.setMaxSize(180,25);
        searchBar.setPromptText("Search stations");
        searchBar.setOpacity(0.9);

        allStationsPane.getChildren().addAll(stationsScroll, searchBar);
        StackPane.setMargin(searchBar, new Insets(0,210,540,0));

        // Extract this into a method called addStationButtons
        //--------------------------------------------------------------------------//
        VBox content = new VBox(5);
        stationsScroll.setContent(content);
        for (int i = 0; i < 100; i++)
        {
            ListNode node = new ListNode();
            content.getChildren().add(node);
        }
        content.setPadding(new Insets(0,0,10,0));
        //---------------------------------------------------------------------------//

        allStationsTab.setContent(allStationsPane);

        Tab favsTab = new Tab();
        favsTab.setText("Favourites");
        StackPane paneTab2 = new StackPane();

        allStationsTab.setClosable(false);
        favsTab.setClosable(false);

        explorerTabsPane.getTabs().addAll(allStationsTab,favsTab);
        explorerTabsPane.setTabMinWidth(180);
        explorerTabsPane.setTabMinHeight(35);

        explorerPane.getChildren().add(explorerTabsPane);
        StackPane.setMargin(explorerTabsPane, new Insets(2, 0, 0, 0));
        explorerPane.setPadding(new Insets(0,0,0,0));

        plotRect.setId("rect");
        plotRect.applyCss();

        tableRect.setId("rect2");
        tableRect.applyCss();

        explorerRect.setId("rect3");
        explorerRect.applyCss();

        exitButton = new Button("X");
        exitButton.setId("exit");
        exitButton.setMaxSize(50,25);

        exitButton.setOnMouseEntered(e -> exitButton.setId("exit-h"));
        exitButton.setOnMouseExited(e -> exitButton.setId("exit"));

        exitButton.setOnMousePressed(e ->  System.exit(1));

        searchBar.setOnKeyPressed(e -> {

            if (searchBar.getWidth() < 181) {
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    int i = 0;
                    double count = 0;

                    @Override
                    public void run() {


                        if (i < 300) {
                            searchBar.setMaxWidth(searchBar.getWidth() + 4);
                            StackPane.setMargin(searchBar, new Insets(0, 210 - count, 540, 0));

                        } else {
                            this.cancel();

                        }
                        i += 2;
                        count += 0.78;

                    }
                }, 0, 3);
            }

        });

        toolBar = new ToolBar(exitButton);

        toolBar.setMaxSize(1350,35);
        toolBar.setOpacity(0);

        dragWindow(rootPane);
        dragWindow2(toolBar);

        StackPane.setMargin(plotPane,new Insets(0,0,245,450));
        StackPane.setMargin(tablePane,new Insets(400,0,0,450));
        StackPane.setMargin(explorerPane,new Insets(30,830,0,0));
        StackPane.setAlignment(toolBar, Pos.TOP_CENTER);

        rootPane.setAlignment(Pos.CENTER);
        rootPane.getChildren().addAll(toolBar,plotPane,tablePane,explorerPane);

        Scene scene = new Scene(rootPane,1340,790);
        scene.setFill(Color.TRANSPARENT);

        Utilities util = new Utilities();
        util.getCss(scene);

        return scene;
    }

    public Scene setSceneMedHigh(){

        StackPane pane = new StackPane();

        VBox box = new VBox(0);
        VBox box2 = new VBox(0);
        VBox box3 = new VBox(0);

        plotRect = new Rectangle(700,300);
        plotRect.setArcHeight(20);
        plotRect.setArcWidth(20);
        plotRect.setOpacity(0);
        plotRect.setStroke(Color.LIGHTSLATEGRAY);
        plotRect.setFill(Color.rgb(38,38,38));
        plotRect.setStrokeWidth(2);

        tableRect = new Rectangle(700,200);
        tableRect.setArcHeight(20);
        tableRect.setArcWidth(20);
        tableRect.setOpacity(0);
        tableRect.setStroke(Color.LIGHTSLATEGRAY);
        tableRect.setFill(Color.rgb(38,38,38));
        tableRect.setStrokeWidth(2);

        explorerRect = new Rectangle(350,540);
        explorerRect.setArcHeight(20);
        explorerRect.setArcWidth(20);
        explorerRect.setOpacity(0);
        explorerRect.setStroke(Color.LIGHTSLATEGRAY);
        explorerRect.setFill(Color.rgb(38, 38, 38));
        explorerRect.setStrokeWidth(2);

        box.getChildren().addAll(plotRect);
        box.setMaxSize(700,300);

        box2.getChildren().addAll(tableRect);
        box2.setMaxSize(700,200);

        box3.getChildren().addAll(explorerRect);
        box3.setMaxSize(350,540);

        plotRect.setId("rect");
        plotRect.applyCss();

        tableRect.setId("rect2");
        tableRect.applyCss();

        explorerRect.setId("rect3");
        explorerRect.applyCss();

        exitButton = new Button("X");
        exitButton.setId("exit");
        exitButton.setMaxSize(50,25);

        exitButton.setOnMouseEntered(e -> exitButton.setId("exit-h"));
        exitButton.setOnMouseExited(e -> exitButton.setId("exit"));

        exitButton.setOnMousePressed(e ->
        {
            FadeTransition fadeTransition
                    = new FadeTransition(Duration.millis(500),exitButton);
            fadeTransition.setFromValue(0.5);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
            fadeTransition.setOnFinished(ex -> {
                System.exit(1);
            });
        });

        toolBar = new ToolBar(exitButton);
        toolBar.setMaxSize(1350,35);
        toolBar.setOpacity(0);

        dragWindow(pane);
        dragWindow2(toolBar);

        StackPane.setMargin(box,new Insets(0,0,210,390));
        StackPane.setMargin(box2,new Insets(370,0,0,390));
        StackPane.setMargin(box3,new Insets(30,730,0,0));
        StackPane.setAlignment(toolBar, Pos.TOP_CENTER);

        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(toolBar,box,box2,box3);

        Scene scene = new Scene(pane,1340,790);
        scene.setFill(Color.TRANSPARENT);

        Utilities util = new Utilities();
        util.getCss(scene);

        return scene;

    }

    public Scene setSceneMedLow(){

        return null;
    }

    public Scene setSceneLow(){

        return null;
    }

    public TableView getTable(){






        return null;
    }

    public LineChart<Number,Number> getChart(){

    // should be getting data from other classes

    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    //creating the chart
    final LineChart<Number,Number> lineChart =
            new LineChart<Number,Number>(xAxis,yAxis);


    //defining a series
    XYChart.Series series = new XYChart.Series();
    //populating the series with data

    series.getData().add(new XYChart.Data(1, 23));
    series.getData().add(new XYChart.Data(2, 14));
    series.getData().add(new XYChart.Data(3, 15));
    series.getData().add(new XYChart.Data(4, 24));
    series.getData().add(new XYChart.Data(5, 34));
    series.getData().add(new XYChart.Data(6, 36));
    series.getData().add(new XYChart.Data(7, 22));
    series.getData().add(new XYChart.Data(8, 45));
    series.getData().add(new XYChart.Data(9, 43));
    series.getData().add(new XYChart.Data(10, 17));
    series.getData().add(new XYChart.Data(11, 29));
    series.getData().add(new XYChart.Data(12, 25));
    series.getData().add(new XYChart.Data(12, 50));


    lineChart.getData().add(series);

    return lineChart;
}

}