package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.Arrays;
import java.util.List;

public class World {


    public static void main(String[] args){

        try {
            List<MoveDirection> moves = OptionParser.parse(Arrays.asList(args));
            AbstractWorldMap mapa = new GrassField(10);
            Animal krowa= new Animal(mapa,new Vector2d(0,0));
            Animal owca= new Animal(mapa,new Vector2d(2,4));
            Animal pies= new Animal(mapa,new Vector2d(0,0));
            mapa.place(krowa);
            mapa.place(owca);
            mapa.place(pies);
            System.out.println(mapa);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        Application.launch(App.class, args);


    }


}
