package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;


public class App extends Application {
    private AbstractWorldMap map;
    private GridPane mapGrid;

    public void init() throws Exception{
        super.init();
        Parameters parameters = getParameters();
        List<String> args = parameters.getRaw();
        try {
            List<MoveDirection> moves = OptionParser.parse(args);
            this.map= new GrassField(10);
            System.out.println(moves);
            Vector2d[] positions = {new Vector2d(2,5),new Vector2d(1,4),new Vector2d(7,4)};
            IEngine engine = new SimulationEngine(moves,map,positions);
            engine.run();
            System.out.println(this.map);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        int cellWidth = 40;
        int cellHeight = 40;
        Vector2d lowLeft=map.getLeftLow();
        System.out.println(lowLeft);
        Vector2d topRight = map.getRightTop();
        System.out.println(topRight);
        Label axisLabel = new Label("y\\x");
        GridPane.setHalignment(axisLabel, HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
        gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
        gridPane.add(axisLabel,0,0,1,1);

        for (int i=lowLeft.y;i <=topRight.y;i++){
            Label label=new Label(Integer.toString(i));
            gridPane.add(label,0,topRight.y-i+1,1,1);
            gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
            GridPane.setHalignment(label,HPos.CENTER);
        }
        for (int i=lowLeft.x;i <=topRight.x;i++){
            Label label=new Label(Integer.toString(i));
            gridPane.add(label,i-lowLeft.x+1,0,1,1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
            GridPane.setHalignment(label,HPos.CENTER);
        }
        for (int x=lowLeft.x;x<=topRight.x;x++){
            for(int y=lowLeft.y;y<=topRight.y;y++) {
                Vector2d pos = new Vector2d(x, y);
                if(!this.map.isOccupied(pos)){
                    continue;
                }
                Object element= map.objectAt(pos);
                Label label= new Label(element.toString());
                GridPane.setHalignment(label,HPos.CENTER);
                gridPane.add(label,pos.x-lowLeft.x+1,topRight.y-pos.y+1,1,1);

            }

        }
        Scene scene = new Scene(gridPane,600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}