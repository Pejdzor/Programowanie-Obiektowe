package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.ColorFiller;
import agh.ics.oop.Grass;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    protected IMapElement mapElement;
    protected VBox graphicalElement = new VBox(4);
    protected Label label;

    public GuiElementBox(IMapElement mapElement){
        this.mapElement=mapElement;
        Image image;
        try{
            image = ImageLoader.getImage(this.mapElement.getMapResource());
        }catch(FileNotFoundException e){
            int r=0,g=0,b=0;
            if (mapElement instanceof Animal){
                r=80;
                g=100;
                b=128;
            }
            else if(mapElement instanceof Grass){
                r=0;
                g=255;
                b=30;
            }
            image = ColorFiller.generateColorImage(1,1,r,g,b,255);
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        this.label= new Label(this.mapElement.toStringRepresentation());
        this.label.setFont(Font.font(15d));

        this.graphicalElement.getChildren().add(imageView);
        this.graphicalElement.getChildren().add(label);
        this.graphicalElement.setAlignment(Pos.CENTER);
    }
    public VBox getGraphicalElement(){
        return graphicalElement;
    }

}
