package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals= new ArrayList<Animal>();
    @Override
    public String toString(){
        MapVisualizer mapVisualizer =new MapVisualizer(this);
        return mapVisualizer.draw(getLeftLow(),getRightTop());

    }
    abstract Vector2d getLeftLow();
    abstract Vector2d getRightTop();
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!(this.objectAt(position) instanceof Animal)){
            return canI(position);
        }
        return false;
    }
    abstract boolean canI(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if(!(this.objectAt(animal.getPosition()) instanceof Animal)){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal zwierzaczek:this.animals){
            if(zwierzaczek.isAt(position)){
                return true;
            }
        }
        return isGrassThere(position);
    }
    abstract boolean isGrassThere(Vector2d position);

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal zwierzaczek:this.animals){
            if(zwierzaczek.isAt(position)){
                return zwierzaczek;
            }
        }
        return checkIfObjectAt(position);
    }
    abstract Object checkIfObjectAt(Vector2d position);
}
