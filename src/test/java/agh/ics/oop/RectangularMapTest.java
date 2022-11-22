package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void test() {
        try {
            String[] args = {"l", "r", "r", "f", "f", "r", "f", "r", "b", "f", "r", "l"};
            ArrayList<MoveDirection> directions = OptionParser.parse(Arrays.as(args));
            AbstractWorldMap map = new RectangularMap(10, 5);
            Vector2d[] pozycje = {new Vector2d(2, 3), new Vector2d(7, 2), new Vector2d(9, 2)};
            SimulationEngine simulationEngine = new SimulationEngine(directions, map, pozycje);
            simulationEngine.run();
            MapVisualizer mapka = new MapVisualizer(map);
            out.println(mapka.draw(map.getLeftLow(), map.getRightTop()));
            out.println(simulationEngine.pieseczki.get(0).getPosition());
            assertEquals(new Vector2d(0, 3), simulationEngine.pieseczki.get(0).getPosition());
            assertEquals(new Vector2d(8, 2), simulationEngine.pieseczki.get(1).getPosition());
            assertEquals(new Vector2d(9, 3), simulationEngine.pieseczki.get(2).getPosition());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }





    }

}