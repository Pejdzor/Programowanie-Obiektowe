package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class App extends Application implements IRefreshRequiredObserver {
    private AbstractWorldMap map;
    private GridPane mapGrid;
    private Thread engineThread;
    private ThreadEngine engine;
    private List<MoveDirection> args;
    public void init() throws Exception{
        super.init();
        Parameters parameters = getParameters();
        List<String> args = parameters.getRaw();
        try {
            System.out.println(args);
            this.args = OptionParser.parse(args);
            this.map= new GrassField(10);
            Vector2d[] positions = {new Vector2d(2,5)};
           this.engine = new ThreadEngine(map,positions,1000);
           this.engine.addObserver(this);

            System.out.println(this.map);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setOnCloseRequest(e->{
            Platform.exit();
            System.exit(0);
        });
        this.mapGrid = new GridPane();

        mapGrid.setHgap(0);
        mapGrid.setVgap(0);

        VBox main = new VBox();
        TextField textField = new TextField();
        Button button = new Button("Start");
        button.setOnAction(event->{
            List<String> input = Arrays.asList(textField.getCharacters().toString().split(" "));
            List<MoveDirection> moves= OptionParser.parse(input);
            this.engine.setMoves(moves);
            this.engineThread = new Thread(this.engine);
            this.engineThread.start();
        });
        main.getChildren().addAll(textField,button);
        main.getChildren().add(mapGrid);
        createGrid(mapGrid);
        Scene scene = new Scene(main,1200,1200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

public void createGrid(GridPane mapGrid){

    Vector2d lowLeft=map.getLeftLow();
    Vector2d topRight = map.getRightTop();
    Label axisLabel = new Label("y\\x");
    GridPane.setHalignment(axisLabel, HPos.CENTER);
    mapGrid.getColumnConstraints().add(new ColumnConstraints(GuiConfig.cellWidth));
    mapGrid.getRowConstraints().add(new RowConstraints(GuiConfig.cellHeight));
    mapGrid.add(axisLabel,0,0,1,1);

    for (int i=lowLeft.y;i <=topRight.y;i++){
        Label label=new Label(Integer.toString(i));
        mapGrid.add(label,0,topRight.y-i+1,1,1);
        mapGrid.getRowConstraints().add(new RowConstraints(GuiConfig.cellHeight));
        GridPane.setHalignment(label,HPos.CENTER);
    }
    for (int i=lowLeft.x;i <=topRight.x;i++){
        Label label=new Label(Integer.toString(i));
        mapGrid.add(label,i-lowLeft.x+1,0,1,1);
        mapGrid.getColumnConstraints().add(new ColumnConstraints(GuiConfig.cellWidth));
        GridPane.setHalignment(label,HPos.CENTER);
    }
    for (int x=lowLeft.x;x<=topRight.x;x++){
        for(int y=lowLeft.y;y<=topRight.y;y++) {
            Vector2d pos = new Vector2d(x, y);
            if(!this.map.isOccupied(pos)){
                continue;
            }
            GuiElementBox element= new GuiElementBox(map.objectAt(pos));
            VBox graphicElement=element.getGraphicalElement();
            GridPane.setHalignment(graphicElement,HPos.CENTER);
            mapGrid.add(graphicElement,pos.x-lowLeft.x+1,topRight.y-pos.y+1,1,1);

        }

    }
    mapGrid.setGridLinesVisible(true);
}

    public void refresh(){
        Platform.runLater(()->{
            this.mapGrid.getChildren().clear();
            mapGrid.getRowConstraints().clear();
            mapGrid.getColumnConstraints().clear();
            mapGrid.setGridLinesVisible(false);
            this.createGrid(this.mapGrid);
        });

    }
}