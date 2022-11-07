package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        Vector2d a=new Vector2d(2,6);
        assertEquals(a.toString(),"(2,6)");
    }

    @Test
    void precedes() {
        Vector2d a=new Vector2d(1,4);
        Vector2d b=new Vector2d(2,4);
        assertTrue(a.precedes(b));
        assertFalse(b.precedes(a));
    }

    @Test
    void follows() {
        Vector2d a=new Vector2d(1,4);
        Vector2d b=new Vector2d(2,4);
        assertTrue(b.follows(a));
        assertFalse(a.follows(b));
    }

    @Test
    void upperRight() {
        Vector2d a=new Vector2d(1,2);
        Vector2d b=new Vector2d(3,1);
        Vector2d c=new Vector2d(3,2);
        assertEquals(a.upperRight(b),c);
    }

    @Test
    void lowerLeft() {
        Vector2d a=new Vector2d(1,2);
        Vector2d b=new Vector2d(3,1);
        Vector2d c=new Vector2d(1,1);
        assertEquals(a.lowerLeft(b),c);
    }

    @Test
    void add() {
        Vector2d a=new Vector2d(1,2);
        Vector2d b=new Vector2d(3,1);
        Vector2d c=new Vector2d(4,3);
        assertEquals(a.add(b),c);
    }

    @Test
    void subtract() {
        Vector2d a=new Vector2d(1,2);
        Vector2d b=new Vector2d(3,1);
        Vector2d c=new Vector2d(2,-1);
        assertEquals(a.subtract(b),c);
    }

    @Test
    void testEquals() {
        Vector2d a=new Vector2d(1,2);
        Vector2d b=new Vector2d(3,1);
        Vector2d c=new Vector2d(1,2);
        Vector2d d=a;
        assertTrue(a.equals(d));
        assertFalse(a.equals(b));
        assertTrue(a.equals(c));
        assertTrue(c.equals(d));
    }

    @Test
    void opposite() {
        Vector2d a=new Vector2d(1,2);
        Vector2d c=new Vector2d(-1,-2);
        assertEquals(a.opposite(),c);
    }
}