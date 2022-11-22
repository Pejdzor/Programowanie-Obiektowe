package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{
    protected MapBoundary mapBoundary = new MapBoundary();
    protected Map<Vector2d,IMapElement> mapElement = new HashMap<>();
    @Override
    public String toString(){
        MapVisualizer mapVisualizer =new MapVisualizer(this);
        return mapVisualizer.draw(getLeftLow(),getRightTop());

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)) {
            if(this.objectAt(position) instanceof Animal){
                return false;
            }
        }
        return canI(position);
    }
    abstract boolean canI(Vector2d position);

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException{
        if (mapElement.containsValue(animal)){
            throw new IllegalArgumentException("Animal is already on the map");
        }
        if (mapElement.containsKey(animal.getPosition())){
            if (mapElement.get(animal.getPosition()) instanceof Animal){
                throw new IllegalArgumentException("Position "+animal.getPosition()+" is already occupied");
            }else{
                if(pleaseCheck(animal.getPosition())){
                    mapElement.put(animal.getPosition(),animal);
                    mapBoundary.add(animal.getPosition());
                    return true;
                }else{
                    throw new IllegalArgumentException("Position "+animal.getPosition()+" is out of range");
                }
            }
        }else{
            mapElement.put(animal.getPosition(),animal);
            mapBoundary.add(animal.getPosition());
            return true;
        }



    }

  abstract boolean pleaseCheck(Vector2d position);

    @Override
    public boolean isOccupied(Vector2d position) {
        if(mapElement.containsKey(position)){
            if (mapElement.get(position) instanceof Animal){
                return true;
            }
            return isSomethingThere(position);
        }
        return false;

    }
    abstract boolean isSomethingThere(Vector2d position);

    @Override
    public IMapElement objectAt(Vector2d position) {
        if(mapElement.containsKey(position)){
            if(mapElement.get(position) instanceof Animal) {
                return (Animal) mapElement.get(position);
            }else{
                return (Grass) mapElement.get(position);
            }
        }
        return null;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        if (mapElement.containsKey(oldPosition)) {
            IMapElement zwierze=mapElement.get(oldPosition);
            mapElement.remove(oldPosition);
            mapElement.put(newPosition,zwierze);
            mapBoundary.positionChanged(oldPosition, newPosition);
        }


    }
}
