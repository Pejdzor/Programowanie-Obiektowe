package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    private final int width;
    private final int height;

    private List<Animal> animals = new ArrayList<Animal>();

    public RectangularMap(int width,int height){
            this.height=height;
            this.width=width;
    }
    public List<Animal> getAnimals(){
        return this.animals;
    }

    public Vector2d getRightTop(){
        return new Vector2d(width-1,height-1);
    }
    public Vector2d getLeftLow(){
        return new Vector2d(0,0);
    }
    @Override
    public boolean canI(Vector2d position){
        if (position.follows(new Vector2d(0,0))&&position.precedes(new Vector2d(width-1,height-1))){
            return true;
        }
        return false;
    }



    @Override
    public boolean isGrassThere(Vector2d position) {
        return false;
    }

    @Override
    public Object checkIfObjectAt(Vector2d position) {
        return null;
    }
}
