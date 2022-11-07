package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @Test
    void Test(){
        AbstractWorldMap mapa = new GrassField(10);
        Animal owca=new Animal(mapa,new Vector2d(4,6));
        Animal kon = new Animal(mapa, new Vector2d(5,7));
        Animal krowa = new Animal(mapa,new Vector2d(1,6));
        System.out.println(mapa.place(owca));
        System.out.println(mapa.place(kon));
        System.out.println(mapa.place(krowa));
        System.out.println(mapa.animals);
        String[] args = {"f", "f", "b", "r", "l", "r"};
        MoveDirection[] directions=OptionParser.parse(args);
        int animal=0;
        for(MoveDirection ruch:directions){
            mapa.animals.get(animal).move(ruch);
            animal=(animal+1)%3;
        }

        assertEquals(krowa.getPosition(),new Vector2d(1,5));
        assertEquals(kon.getPosition(),new Vector2d(5,8));
        assertEquals(owca.getPosition(),new Vector2d(4,7));
        krowa.move(MoveDirection.BACKWARD);
        krowa.move(MoveDirection.BACKWARD);
        assertEquals(krowa.getPosition(),new Vector2d(-1,5));
        System.out.println(mapa.toString());
    }

}