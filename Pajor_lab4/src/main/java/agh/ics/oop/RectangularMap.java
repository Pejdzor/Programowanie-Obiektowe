package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

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

    public String toString(){
        MapVisualizer mapVizualizer=new MapVisualizer(this);
        return mapVizualizer.draw(new Vector2d(0,0),new Vector2d(width-1,height-1));
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!this.isOccupied(position)&&position.follows(new Vector2d(0,0))&&position.precedes(new Vector2d(width-1,height-1))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(!this.isOccupied(animal.getPosition())){
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
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal zwierzaczek:this.animals){
            if(zwierzaczek.isAt(position)){
                return zwierzaczek;
            }
        }
        return null;
    }
}
