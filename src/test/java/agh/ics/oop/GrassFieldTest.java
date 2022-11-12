package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @Test
    void Test(){


        AbstractWorldMap mapcia=new GrassField(10);
        Animal kot=new Animal(mapcia,new Vector2d(2,1));
        mapcia.place(kot);
        MapVisualizer rysowanka = new MapVisualizer(mapcia);
        System.out.println(rysowanka.draw(mapcia.getLeftLow(),mapcia.getRightTop()));
    }

}