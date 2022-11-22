package agh.ics.oop;

public class Grass implements IMapElement {
    private Vector2d position;
    public Grass(Vector2d pozycja){
        this.position=pozycja;
    }
    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String getMapResource() {
        return "src/main/resources/grass.png";
    }

    public String toStringRepresentation(){
        return "Grass";
    }
    public String toString(){
        return "*";
    }
}
