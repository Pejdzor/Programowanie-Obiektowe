package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void test() {
        IWorldMap mapa = new GrassField(10);
        Animal owca=new Animal(mapa,new Vector2d(4,6));
        Animal kon = new Animal(mapa, new Vector2d(5,7));
        Animal krowa = new Animal(mapa,new Vector2d(1,6));
        mapa.place(owca);
        mapa.place(kon);
        mapa.place(krowa);
        String[] args = {"f", "f", "b", "r", "l", "r"};
        MoveDirection[] directions=OptionParser.parse(args);
        int animal=0;
        for()
        System.out.println(mapa.toString());
    }

}