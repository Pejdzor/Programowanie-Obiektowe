package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractMapElement {
    private Vector2d position=new Vector2d(2,2);
    private MapDirection orientation=MapDirection.NORTH;
    private IWorldMap map;


    private List<IPositionChangeObserver> observer = new ArrayList<>();

    void addObserver(IPositionChangeObserver observer){
        this.observer.add(observer);

    }
    void removeObserver(IPositionChangeObserver observer){
        this.observer.remove(observer);
    }

    public String toString(){
        return switch(orientation){
            case NORTH -> "^";
            case SOUTH -> "V";
            case EAST -> ">";
            case WEST -> "<";
            };

    }
    public Animal(){

    }
    public Animal(AbstractWorldMap map){
        this.map=map;
        observer.add(map);
    }
    public Animal(AbstractWorldMap map,Vector2d initial){
        this.map=map;
        this.position=initial;
        observer.add(map);
    }
    public Vector2d getPosition(){
        return this.position;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection dir){
        Vector2d moveTo=this.position;
        if (dir != null){
            switch (dir) {
                case LEFT -> this.orientation = this.orientation.previous();
                case RIGHT -> this.orientation = this.orientation.next();
                case FORWARD -> moveTo = this.position.add(this.orientation.toUnitVector());
                case BACKWARD -> moveTo = this.position.add(this.orientation.toUnitVector().opposite());
                default -> {
                }
            }
        }
        if (map.canMoveTo(moveTo) && !(moveTo.equals(this.position))){
            for (IPositionChangeObserver observ:observer){
                observ.positionChanged(this.position,moveTo);
            }
            position=moveTo;
        }
    }
}
