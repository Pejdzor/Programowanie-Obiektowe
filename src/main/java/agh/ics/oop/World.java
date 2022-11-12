package agh.ics.oop;
import static java.lang.System.out;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class World {


    public static void main(String[] args){
        MoveDirection[] directions = OptionParser.parse(args);
        IWorldMap map = new GrassField(10);
        Animal owca=new Animal(map,new Vector2d(1,7));
        Animal pies= new Animal(map,new Vector2d(2,5));
        Animal kot = new Animal(map,new Vector2d(8,2));
        map.place(owca);
        map.place(pies);
        map.place(kot);
        MapVisualizer mapka=new MapVisualizer(map);
        out.println(mapka.draw(map.getLeftLow(),map.getRightTop()));





    }


}
