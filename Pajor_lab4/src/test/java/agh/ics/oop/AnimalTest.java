package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal pies=new Animal();
    @Test
    void test(){
        // pozycja początkowa
        assertEquals("Pozycja: "+new Vector2d(2,2)+" kierunek: "+MapDirection.NORTH,pies.toString());

        // pierwsza seria ruchów
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.LEFT);
        assertEquals("Pozycja: "+new Vector2d(2,3)+" kierunek: "+MapDirection.WEST,pies.toString());

        // Test Parsera
        String[] moves = {"f f szybciej piesku r f l backward backward xd right ruchy b left forward"};
        MoveDirection[] instrukcje = OptionParser.parse(moves);
        for (MoveDirection mov:instrukcje){
            pies.move(mov);
        }
        assertEquals("Pozycja: "+new Vector2d(2,3)+" kierunek: "+MapDirection.WEST,pies.toString());

        // Blokada wyjścia za mapę
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.LEFT);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        pies.move(MoveDirection.FORWARD);
        assertEquals("Pozycja: "+new Vector2d(0,0)+" kierunek: "+MapDirection.SOUTH,pies.toString());
    }


}