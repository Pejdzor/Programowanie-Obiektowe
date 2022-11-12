package agh.ics.oop;

public class Grass extends AbstractMapElement {
    private Vector2d position;
    public Grass(Vector2d pozycja){
        this.position=pozycja;
    }
    public Vector2d getPosition(){
        return this.position;
    }
    public String toString(){
        return "*";
    }
}
