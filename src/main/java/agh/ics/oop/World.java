package agh.ics.oop;
import static java.lang.System.out;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class World {


    public static void main(String[] args){
        MoveDirection[] directions = OptionParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        out.print(map.toString());
        GrassField pole=new GrassField(10);
        System.out.println(pole);
        for(Grass trawa:pole.grass){
            System.out.println(trawa.getPosition());
        }





    }


}
