package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void test() {
        String[] args = {"l","r","r","f","f","r","f","r","b","f","r","l"};
        MoveDirection[] directions = OptionParser.parse(args);
        AbstractWorldMap map = new RectangularMap(10, 5);
        Vector2d[] pozycje={new Vector2d(2,3),new Vector2d(7,2),new Vector2d(4,1)};
        SimulationEngine simulationEngine =  new SimulationEngine(directions,map,pozycje);
        simulationEngine.run();
        MapVisualizer mapka=new MapVisualizer(map);
        out.println(mapka.draw(map.getLeftLow(),map.getRightTop()));
        out.println(simulationEngine.pieseczki.get(0).getPosition());
        assertEquals(new Vector2d(0,3),simulationEngine.pieseczki.get(0).getPosition());
        assertEquals(new Vector2d(8,2),simulationEngine.pieseczki.get(1).getPosition());
        assertEquals(new Vector2d(4,2),simulationEngine.pieseczki.get(2).getPosition());





    }

}